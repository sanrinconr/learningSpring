package com.linkTracker.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.DigestUtils;

import java.sql.Timestamp;
import java.util.Date;

@Getter @Setter @NoArgsConstructor
public class LinkModel {
    private String name;
    private String url;
    private String password;
    private int timesClicked;
    private Timestamp creationTime;
    private String status;
    private String id;

    public LinkModel(String name, String url, String password) {
        this.name = name;
        this.url = url;
        this.password = password;
        this.timesClicked = 0;
        this.creationTime = new Timestamp(new Date().getTime());
        this.status = "VALID";
        this.id = LinkModel.generateID(this.name, this.url,this.password);
    }

    public static String generateID(String name, String url, String password){
        String toHash = name+url;
        if(password != null) toHash += password;

       String md5Hex = DigestUtils.md5DigestAsHex(toHash.getBytes()).toLowerCase();
        return md5Hex.substring(0,5);
    }
}
