package com.mercadolibre.consulting.utils.validators;

import com.mercadolibre.consulting.enums.ProfessionalServices;
import com.mercadolibre.consulting.enums.TurnStatus;
import com.mercadolibre.consulting.exception.exception.InvalidProfessionalServiceException;
import com.mercadolibre.consulting.exception.exception.InvalidTurnStatusException;

import java.util.Arrays;

public class TurnValidator {
    public static void turnStatusIsValidOrThrow(String status) throws InvalidTurnStatusException {
        if(!Arrays.stream(TurnStatus.class.getEnumConstants()).anyMatch(e ->e.name().equals(status)))
            throw new InvalidTurnStatusException(status);
    }

    public static TurnStatus getEnumOrThrow(String status) throws InvalidTurnStatusException {
        turnStatusIsValidOrThrow(status);
        return TurnStatus.valueOf(status);
    }
}
