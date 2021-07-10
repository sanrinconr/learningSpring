package com.linkTracker.exception.exception;

public class LinkNotExistException extends Exception{
    public LinkNotExistException(String linkID) {
        super("The link with ID: "+linkID+" not exist (you included the password of the link?");
    }
}
