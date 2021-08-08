package com.mercadolibre.consulting.service;

import com.mercadolibre.consulting.DTO.patient.request.CreatePatientDTO;
import com.mercadolibre.consulting.exception.exception.PatientNotExistsException;
import com.mercadolibre.consulting.model.PatientModel;
import com.mercadolibre.consulting.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    private final ModelMapper modelMapper;
    private final PatientRepository patientRepository;

    public PatientService(ModelMapper modelMapper, PatientRepository patientRepository) {
        this.modelMapper = modelMapper;
        this.patientRepository = patientRepository;
    }

    public void createNewPatient(CreatePatientDTO createPatientDTO){
        PatientModel model = modelMapper.map(createPatientDTO, PatientModel.class);
        patientRepository.save(model);
    }

    //Util methods


    public PatientModel getPatientById(String id) throws PatientNotExistsException {
       Optional<PatientModel> model  =  patientRepository.findById(id);
       if(model.isEmpty()) throw new PatientNotExistsException(id);
       return model.get();
    }
}
