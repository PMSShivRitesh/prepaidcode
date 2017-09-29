package com.airwire;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
@Aspect

@Component
public class AirwireAspect {

	/*@Before("execution(* com.airwire.service.impl.*.(..))")
	public void getNameAdvice(){
		System.out.println("Executing Advice on getName()");
	}*/
	
	@Before("execution(* getPrepaidCode(..))")
	public void getAllAdvice(JoinPoint joinPoint){
		
		/*String name = authentication.getName();
		System.out.println("User Name : "+name);
		joinPoint.*/
		System.out.println("User :Before running loggingAdvice on method="+joinPoint.toString());
		System.out.println("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));
	}
}