package com.mercadolibre.consulting.service;

import com.mercadolibre.consulting.enums.ProfessionalServices;
import com.mercadolibre.consulting.exception.exception.InvalidProfessionalServiceException;
import com.mercadolibre.consulting.exception.exception.NoProfessionalFoundException;
import com.mercadolibre.consulting.model.ProfessionalModel;
import com.mercadolibre.consulting.model.TurnModel;
import com.mercadolibre.consulting.repository.ProfessionalRepository;
import com.mercadolibre.consulting.utils.validators.ProfessionalValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ProfessionalService {
    private final ModelMapper modelMapper;
    private final ProfessionalRepository professionalRepository;

    public ProfessionalService(ModelMapper modelMapper, ProfessionalRepository professionalRepository) {
        this.modelMapper = modelMapper;
        this.professionalRepository = professionalRepository;
    }

    public ProfessionalModel selectRandomProfessional(ProfessionalServices service) throws NoProfessionalFoundException {
        List<ProfessionalModel> professionalModels = professionalRepository.findAllProfessionalsByService(service);
        if(professionalModels.size() == 0) throw new NoProfessionalFoundException("No professionals for service: "+service);
        return selectRandomProfessional(professionalModels);
    }

    private static ProfessionalModel selectRandomProfessional(List<ProfessionalModel> arr){
        Random r=new Random();
        int randomNumber=r.nextInt(arr.size());
        return arr.get(randomNumber);
    }

}
