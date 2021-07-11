package com.linkTracker.exception.exception;

public class LinkInvalidException extends Exception{
    public LinkInvalidException(String idLink) {
        super("The link with the id "+idLink+" is invalid");
    }
}
