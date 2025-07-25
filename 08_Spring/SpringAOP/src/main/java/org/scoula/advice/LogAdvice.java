package org.scoula.advice;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Log4j2
@Component
public class LogAdvice {

    @Before("execution(* org.scoula.sample.service.SampleService*.*(..))")
    public void logBefore(){
        log.info("================");
    }

    @Before("execution(* org.scoula.sample.service.SampleService*.doAdd(String, String))&& args(str1,str2)")
    public void logBefore2(String str1,String str2){
        log.info("str1: "+str1);
        log.info("str2: "+str2);
    }



}
