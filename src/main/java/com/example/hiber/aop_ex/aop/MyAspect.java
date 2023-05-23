package com.example.hiber.aop_ex.aop;


import com.example.hiber.aop_ex.entity.Book;
import com.example.hiber.aop_ex.util.CustomResponse;
import com.example.hiber.aop_ex.util.CustomStatus;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MyAspect {
    @Around("Pointcuts.allAddMethods()")
    public Object aroundAddingAdvice(ProceedingJoinPoint joinPoint){
        MethodSignature methodSignature=(MethodSignature)joinPoint.getSignature();
        Book book=null;
        if(methodSignature.getName().equals("addBook")){
            Object[] arguments=joinPoint.getArgs();
            for(Object arg: arguments){
                if(arg instanceof Book){
                    book=(Book) arg;
                    log.info("Попытка добавить книгу с названием {}",book.getTitle());
                }
            }
        }
        Object result=null;
        try {
            result=joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(),e);
            result= new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }
        log.info("Добавляем книгу {}",book.getTitle());
        return result;

    }

    @Around("Pointcuts.allGetMethods()")
    public Object aroundGettingAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String title = null;

        if (methodSignature.getName().equals("getAll")) {
            log.info("Попытка получить все книги");
        } else if (methodSignature.getName().equals("getBookByTitle")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object arg : arguments) {
                if (arg instanceof String) {
                    title = (String) arg;
                    log.info("Пытаемся получить книгу с названием {}", title);
                }
            }
        }

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            result = new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }

        if (methodSignature.getName().equals("getAll")) {
            log.info("Все книги получены");
        } else if (methodSignature.getName().equals("getBookByTitle")) {
            log.info("Книга с названием {} получена", title);
        }

        return result;
    }
}