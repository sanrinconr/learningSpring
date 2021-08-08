package com.mercadolibre.consulting.unit.service;

import com.mercadolibre.consulting.DTO.turn.response.TurnResponseDTO;
import com.mercadolibre.consulting.dataGenerators.patient.PatientGenerator;
import com.mercadolibre.consulting.dataGenerators.professional.ProfessionalGenerator;
import com.mercadolibre.consulting.dataGenerators.turn.TurnsGenerator;
import com.mercadolibre.consulting.enums.ProfessionalServices;
import com.mercadolibre.consulting.enums.TurnStatus;
import com.mercadolibre.consulting.exception.exception.*;
import com.mercadolibre.consulting.model.PatientModel;
import com.mercadolibre.consulting.model.ProfessionalModel;
import com.mercadolibre.consulting.model.TurnModel;
import com.mercadolibre.consulting.repository.TurnRepository;
import com.mercadolibre.consulting.service.PatientService;
import com.mercadolibre.consulting.service.ProfessionalService;
import com.mercadolibre.consulting.service.TurnService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TurnServiceTest {
    @Mock
    TurnRepository turnRepository;
    @Mock
    PatientService patientService;
    @Mock
    ProfessionalService professionalService;

    TurnService turnService;
    final ModelMapper modelMapper = new ModelMapper();

    @BeforeEach
    void initUseCase() {
        turnService = new TurnService(modelMapper,turnRepository, patientService, professionalService);
    }

    /**
     * Generate a new turn with the premise that the doctor dont't have previous turns in this day
     * @throws PatientNotExistsException
     * @throws NoProfessionalFoundException
     * @throws InvalidProfessionalServiceException
     */
    @Test
    public void generateTurnNoPreviousTurns() throws PatientNotExistsException, NoProfessionalFoundException, InvalidProfessionalServiceException, NotProfessionalServicePassedException {

        when(professionalService.selectRandomProfessional(any(ProfessionalServices.class))).thenReturn(ProfessionalGenerator.generateOne(ProfessionalServices.GENERAL));
        when(patientService.getPatientById(anyString())).thenReturn(PatientGenerator.generateOne());
        when(turnRepository.save(any(TurnModel.class))).thenReturn(null);

        TurnResponseDTO turnResponseDTO = turnService.generateTurn("1",ProfessionalServices.GENERAL.toString());
        Assertions.assertEquals("PENDING",turnResponseDTO.getStatus());
        Assertions.assertEquals("Camila",turnResponseDTO.getProfessional().getName());

    }
    /**
     * Generate a new turn with the premise that the doctor have previous turns in this day
     * @throws PatientNotExistsException
     * @throws NoProfessionalFoundException
     * @throws InvalidProfessionalServiceException
     */
    @Test
    public void generateTurn() throws PatientNotExistsException, NoProfessionalFoundException, InvalidProfessionalServiceException, NotProfessionalServicePassedException {
        ProfessionalModel professionalModel = ProfessionalGenerator.generateOne(ProfessionalServices.GENERAL);
        PatientModel  patientModel = PatientGenerator.generateOne();
        List<TurnModel> oldTurns = TurnsGenerator.generateListOldTurnsOfProfessional(professionalModel);

        when(professionalService.selectRandomProfessional(professionalModel.getService())).thenReturn(professionalModel);
        when(patientService.getPatientById(anyString())).thenReturn(patientModel);
        when(turnRepository.save(any(TurnModel.class))).thenReturn(null);
        when(turnRepository.getPendientTurnsOfProfessional(professionalModel.getDni()))
                .thenReturn(oldTurns);

        TurnResponseDTO turnResponseDTO = turnService.generateTurn("1",ProfessionalServices.GENERAL.toString());
        Assertions.assertEquals("PENDING",turnResponseDTO.getStatus());
        Assertions.assertEquals("Camila",turnResponseDTO.getProfessional().getName());

    }

    @Test
    public void getAllTurns() throws InvalidTurnStatusException {
        ProfessionalModel professionalModel = ProfessionalGenerator.generateOne(ProfessionalServices.GENERAL);
        List<TurnModel> oldTurns = TurnsGenerator.generateListOldTurnsOfProfessional(professionalModel);

        when(turnRepository.findAllByStatus(any(TurnStatus.class))).thenReturn(oldTurns);

        List<TurnResponseDTO> turns = turnService.getAllTurns("PENDING");
        Assertions.assertEquals(oldTurns.get(0).getProfessionalModel().getName(), turns.get(0).getProfessional().getName());
        Assertions.assertEquals(oldTurns.size(), turns.size());
    }
    @Test
    public void getAllTurnsBadStatus() throws InvalidTurnStatusException {
        ProfessionalModel professionalModel = ProfessionalGenerator.generateOne(ProfessionalServices.GENERAL);
        List<TurnModel> oldTurns = TurnsGenerator.generateListOldTurnsOfProfessional(professionalModel);

        try {
            List<TurnResponseDTO> turns = turnService.getAllTurns("BADSTATUS");
            Assertions.fail();
        } catch (InvalidTurnStatusException e) {
            Assertions.assertEquals("The turn with status BADSTATUS not exists", e.getMessage());
        }
    }

    @Test
    public void getAllTurnsOfADoctor() throws NoProfessionalFoundException, InvalidTurnStatusException {
        ProfessionalModel professional = ProfessionalGenerator.generateOne(ProfessionalServices.GENERAL);
        List<TurnModel> turns = TurnsGenerator.generateListOldTurnsOfProfessional(professional);
        when(professionalService.findProfessional(anyString(), anyString())).thenReturn(professional);
        when(turnRepository.getAllTurnsOfProfessionalStatus(professional.getDni(), "PENDING")).thenReturn(TurnsGenerator.generateListOldTurnsOfProfessional(professional));

        List<TurnResponseDTO> out = turnService.getAllTurnsOfADoctor(professional.getName(), professional.getLast_name(), "PENDING");
        Assertions.assertEquals(turns.get(0).getProfessionalModel().getName(), out.get(0).getProfessional().getName());
    }

    @Test
    public void getAllTurnsOfADoctorBadEntry1() throws NoProfessionalFoundException, InvalidTurnStatusException {
        ProfessionalModel professional = ProfessionalGenerator.generateOne(ProfessionalServices.GENERAL);
        try {
            List<TurnResponseDTO> out = turnService.getAllTurnsOfADoctor(null, professional.getLast_name(), "PENDING");
            Assertions.fail();
        } catch (NoProfessionalFoundException e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void getAllTurnsOfADoctorBadEntry2() throws NoProfessionalFoundException, InvalidTurnStatusException {
        ProfessionalModel professional = ProfessionalGenerator.generateOne(ProfessionalServices.GENERAL);
        try {
            List<TurnResponseDTO> out = turnService.getAllTurnsOfADoctor(professional.getName(), professional.getLast_name(), null);
            Assertions.fail();
        } catch (InvalidTurnStatusException e) {
            Assertions.assertTrue(true);
        }
    }
}
