package com.example.demo.user.aspect;

import com.example.demo.user.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Pointcut("@annotation(com.example.demo.user.annotation.Log)")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(JoinPoint joinpoint){
        String log = "=============== Start Execute Method: %s, Customized content: %s ===============";
        MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();
        String customizedContent = getValueInLogAnnotation(joinpoint);
        System.out.println(String.format(log, methodSignature.getName(), customizedContent));
    }

    @After("pointCut()")
    public void after(JoinPoint joinpoint){
        String log = "=============== Ended Execute Method: %s, Customized content: %s ===============";
        MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();
        String customizedContent = getValueInLogAnnotation(joinpoint);
        System.out.println(String.format(log, methodSignature.getName(), customizedContent));
    }

    /**
     * 取得 Log Annotation value()
     * 作為客製化要印出的 Log 內容
     * @param joinpoint
     * @return String
     */
    private String getValueInLogAnnotation(JoinPoint joinpoint){
        Log logAnnotation = getAnnotation(joinpoint);
        String customizedContent = getCustomizedContent(logAnnotation);
        return customizedContent;
    }

    /**
     * 取得方法上的 Annotation
     * @param joinpoint
     * @return Log
     */
    private Log getAnnotation(JoinPoint joinpoint){
        MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();
        return methodSignature.getMethod().getAnnotation(Log.class);
    }

    /**
     * 取的客製化 Log 內容
     * @param logAnnotation
     * @return
     */
    private String getCustomizedContent(Log logAnnotation){
        return logAnnotation.value();
    }
}
