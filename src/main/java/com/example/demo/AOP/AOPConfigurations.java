package com.example.demo.AOP;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AOPConfigurations {

    @Before("generalPointCut()")
    public void beforeMethodFirstAdvice(JoinPoint joinPoint) {
        String functionName = joinPoint.getSignature().getName();
        String arguments = Arrays.toString(joinPoint.getArgs());
        System.out.printf("First Advice Called {%s}, arguments: {%s}\n", functionName, arguments);
    }

    @Before("generalPointCut()")
    public void beforeMethodSecondAdvice(JoinPoint joinPoint) {
        String functionName = joinPoint.getSignature().getName();
        String arguments = Arrays.toString(joinPoint.getArgs());
        System.out.printf("Second Advice Called {%s}, arguments: {%s}\n", functionName, arguments);
    }

    @Pointcut("execution(* com.example.demo.CRUD.BlogService.*find*(..))")
    public void generalPointCut() {
    }

    @AfterReturning(pointcut = "generalPointCut()", returning = "returnedObject")
    public void afterReturningAdvice(Object returnedObject) {
        System.out.println("afterReturningAdvice called, returned value:- " + returnedObject);
    }

    @Pointcut("execution(* com.example.demo.CRUD.controller..*.*(..))")
    public void controllerExceptionHandlerPointCut() {
    }

    // uncomment for GLobal exception Handling CATCHING
//	@Around("controllerExceptionHandlerPointCut()")
//	public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
//		Object valueToReturn = null;
//		try {
//			System.out.println("Before Advice Proceeds...");
//			valueToReturn = proceedingJoinPoint.proceed();
//			System.out.println("After Advice Done");
//		} catch (Exception e) {
//			System.out.println("GENERIC EXCEPTION using @AROUND:" + e.getMessage());
////			return error(e, HttpStatus.NOT_FOUND);
//		} catch (Throwable t) {
//			t.printStackTrace();
//		}
//		return valueToReturn;
//	}

//	private ResponseEntity<String> error(final Exception exception, final HttpStatus httpStatus) {
//		final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
//		return new ResponseEntity<>(message, httpStatus);
//	}
}
