package com.linkTracker.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkModelTest {
    @Test
    public void calculateMD5(){
        String out = LinkModel.generateID("A nam","A url",null);
        out = out.substring(0,5);
        Assertions.assertEquals("bc37f", out);
    }
}
