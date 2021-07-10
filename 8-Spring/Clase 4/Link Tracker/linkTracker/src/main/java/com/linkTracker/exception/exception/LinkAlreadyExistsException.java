package com.linkTracker.exception.exception;

public class LinkAlreadyExistsException extends Exception{
    public LinkAlreadyExistsException(String url, String name) {
        super("Link with url " + url + " and name " + name + " already exists");
    }
}
