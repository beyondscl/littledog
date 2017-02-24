package com.dog.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/2/22.
 */
@Aspect
@Service
public class logAop {
    private Log log = LogFactory.getLog(logAop.class);

    @Before("execution(* com.dog..*Service.*(..))")
    public void insertLogToDb(JoinPoint joinPoint) {
        Object[] o = joinPoint.getArgs();
        System.out.println("开始切入记录日志，参数个数为:"+o.length);
    }
}
