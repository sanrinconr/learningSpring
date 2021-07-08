package com.starwars.exception.exceptions;

public class ActorNotFoundException extends Exception{
    public ActorNotFoundException(String message) {
        super(message);
    }
}
