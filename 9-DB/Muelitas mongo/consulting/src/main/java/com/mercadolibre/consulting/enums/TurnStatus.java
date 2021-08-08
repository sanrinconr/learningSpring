package com.mercadolibre.consulting.enums;

import com.mercadolibre.consulting.exception.exception.InvalidTurnStatusException;

import java.util.Arrays;

public enum TurnStatus {
    FINISHED,
    CANCELLED,
    PENDING,
    REPROGRAMMED;

    public static TurnStatus getEnumOrThrow(String status) throws InvalidTurnStatusException {
        if (status == null) throw new InvalidTurnStatusException("UNRECOGNIZED");
        if (Arrays.stream(TurnStatus.class.getEnumConstants()).noneMatch(e -> e.name().equals(status)))
            throw new InvalidTurnStatusException(status);
        return TurnStatus.valueOf(status);
    }
}
