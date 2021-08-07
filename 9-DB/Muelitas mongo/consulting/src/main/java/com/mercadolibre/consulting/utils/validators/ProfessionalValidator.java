package com.mercadolibre.consulting.utils.validators;

import com.mercadolibre.consulting.enums.ProfessionalServices;
import com.mercadolibre.consulting.exception.exception.InvalidProfessionalServiceException;

import java.util.Arrays;

public class ProfessionalValidator {
    public static void serviceIsValidOrThrow(String service) throws InvalidProfessionalServiceException {
        if(!Arrays.stream(ProfessionalServices.class.getEnumConstants()).anyMatch(e ->e.name().equals(service)))
            throw new InvalidProfessionalServiceException(service);
    }
}
