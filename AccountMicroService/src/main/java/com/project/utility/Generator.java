package com.project.utility;

import java.util.UUID;

public class Generator {

    public static String randomPassword() {
        String code= UUID.randomUUID().toString();
        String [] data =code.split("-");
        String newCode="";
        for(String  string :data){
            newCode+=string.charAt(0);
            newCode+=string.charAt(1);
        }
        return newCode;
    }
}
