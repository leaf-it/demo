package com.cotyledon.vo;

import org.springframework.stereotype.Component;


public class DemoVO {
    private  String authCode;
    private String authDesc;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
    public  String getAuthDesc(){
        return  authDesc;
    }

    public void setAuthDesc(String authDesc) {
        this.authDesc = authDesc;
    }
}
