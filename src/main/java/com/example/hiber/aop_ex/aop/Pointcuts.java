package com.example.hiber.aop_ex.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* com.example.hiber.aop_ex.service.BookService.get*(..))")
    public void allGetMethods(){

    }
    @Pointcut("execution(* com.example.hiber.aop_ex.service.BookService.add*(..))")
    public void allAddMethods(){

    }

}
