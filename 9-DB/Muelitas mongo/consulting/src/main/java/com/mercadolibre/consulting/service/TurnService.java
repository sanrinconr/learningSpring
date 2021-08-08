package com.mercadolibre.consulting.service;

import com.mercadolibre.consulting.DTO.turn.response.TurnResponseDTO;
import com.mercadolibre.consulting.enums.ProfessionalServices;
import com.mercadolibre.consulting.enums.TurnStatus;
import com.mercadolibre.consulting.exception.exception.*;
import com.mercadolibre.consulting.model.PatientModel;
import com.mercadolibre.consulting.model.ProfessionalModel;
import com.mercadolibre.consulting.model.TurnModel;
import com.mercadolibre.consulting.repository.TurnRepository;
import com.mercadolibre.consulting.utils.validators.ProfessionalValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurnService {
    private final ModelMapper modelMapper;
    private final TurnRepository turnRepository;
    private final PatientService patientService;
    private final ProfessionalService professionalService;

    public TurnService(ModelMapper modelMapper, TurnRepository turnRepository, PatientService patientService, ProfessionalService professionalService) {
        this.modelMapper = modelMapper;
        this.turnRepository = turnRepository;
        this.patientService = patientService;
        this.professionalService = professionalService;
    }

    /**
     * Exposed to the controller
     *
     * Generate a new turn for a patient thaat want a service
     *
     * @param patientId dni of the patient
     * @param serviceStr Service that the patient want, only the enum ProfessionalServices is valid
     * @return A turn
     * @throws PatientNotExistsException If patient  not exists
     * @throws InvalidProfessionalServiceException If the service is invalid
     * @throws NoProfessionalFoundException If no one professional have this service
     */
    public TurnResponseDTO generateTurn(String patientId, String serviceStr) throws PatientNotExistsException, InvalidProfessionalServiceException, NoProfessionalFoundException, NotProfessionalServicePassedException {
        if(serviceStr == null) throw new NotProfessionalServicePassedException();
        //Validate and parse to enum
        ProfessionalValidator.serviceIsValidOrThrow(serviceStr);
        ProfessionalServices service = ProfessionalServices.valueOf(serviceStr);

        ProfessionalModel professional = professionalService.selectRandomProfessional(service);
        PatientModel patientModel = patientService.getPatientById(patientId);
        TurnModel lastTurn = this.getLastTurn(professional.getDni());
        TurnModel newTurn = TurnModel.builder().patientModel(patientModel).professionalModel(professional).status(TurnStatus.PENDING).build();
        //If the doctor dont have turns, assign new turn at the current moment
        if(lastTurn == null){
            LocalDateTime now = LocalDateTime.now();
            newTurn.setF_entry(now);
            newTurn.setF_out(now.plusMinutes(30));
        }else{
            //2 minutes of break
            newTurn.setF_entry(lastTurn.getF_out().plusMinutes(2));
            newTurn.setF_out(lastTurn.getF_out().plusMinutes(32));
        }
        turnRepository.save(newTurn);
        return modelMapper.map(newTurn, TurnResponseDTO.class);
    }
    private TurnModel getLastTurn(String dniProfessional){
        List<TurnModel> turnModelsProfessional = turnRepository.getPendientTurnsOfProfessional(dniProfessional);
        if (turnModelsProfessional.size() == 0) return null;
        return turnModelsProfessional.stream().max(Comparator.comparing(TurnModel::getF_out)).get();
    }

    public List<TurnResponseDTO> getAllTurns(String statusStr) throws InvalidTurnStatusException {
        TurnStatus status = TurnStatus.getEnumOrThrow(statusStr);
        List<TurnModel> models = turnRepository.findAllByStatus(status);
        return models.stream().map(model -> modelMapper.map(model, TurnResponseDTO.class)).collect(Collectors.toList());
    }

    public List<TurnResponseDTO> getAllTurnsOfADoctor(String name, String last_name, String status) throws NoProfessionalFoundException, InvalidTurnStatusException {
        if (name == null || last_name == null)
            throw new NoProfessionalFoundException("Name or last_name of the professional is not passed");
        TurnStatus turnStatus = TurnStatus.getEnumOrThrow(status);
        ProfessionalModel professional = professionalService.findProfessional(name, last_name);
        List<TurnModel> turnModels = turnRepository.getAllTurnsOfProfessionalStatus(professional.getDni(), turnStatus.toString());
        return turnModels.stream().map(model -> modelMapper.map(model, TurnResponseDTO.class)).collect(Collectors.toList());
    }
}
