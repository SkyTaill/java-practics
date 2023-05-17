package com.example.hiber.aop_ex.util;

import java.util.Collection;

public class CustomResponse<T> {
    private int code;
    private String message;
    private Collection<T> responseList;

    public CustomResponse(Collection<T> response,CustomStatus customStatus){
        this.code=customStatus.getCode();
        this.message=customStatus.getMessage();
        this.responseList=response;
    }

}
