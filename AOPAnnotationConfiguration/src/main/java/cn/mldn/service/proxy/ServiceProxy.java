package cn.mldn.service.proxy;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class ServiceProxy {
	@Around("execution(* cn.mldn.service..*.*(..))")
	public Object arroundInvoke(ProceedingJoinPoint point) throws Throwable {
		Logger.getLogger(ServiceProxy.class).info("【*** BEFORE ***】执行参数：" + Arrays.toString(point.getArgs())); 
		// Object obj = point.proceed(point.getArgs()) ;正常操作要将用户的参数继续向后传递
		Object obj = point.proceed(new Object[] {"mldnjava"} ) ;	// 自己来处理参数内容
		Logger.getLogger(ServiceProxy.class).info("【*** AFTER ***】返回结果：" + obj);
		return true ;
	} 
	@Before(value="execution(* cn.mldn.service..*.*(..)) and args(id)",argNames="id")
	public void beforeInvoke(Object arg) {
		Logger.getLogger(ServiceProxy.class).info("【ServiceProxy - BEFORE】在业务方法执行之前进行调用，参数内容：" + arg);
	} 
	@AfterThrowing(value="execution(* cn.mldn.service..*.*(..))",throwing="e",argNames="e")
	public void throwInvoke(Exception e) {
		Logger.getLogger(ServiceProxy.class).error("【ServiceProxy - EXCEPTION】抛出异常：" + e);
	}
	@After("execution(* cn.mldn.service..*.*(..))")
	public void afterInvoke() {
		Logger.getLogger(ServiceProxy.class).info("【ServiceProxy - AFTER】在业务方法执行之后进行调用。");
	}
	@AfterReturning(value="execution(* cn.mldn.service..*.*(..))",returning="n",argNames="n")
	public void returnInvoke(Object val) {
		Logger.getLogger(ServiceProxy.class).info("【ServiceProxy - RETURNING】返回值 = " + val);
	}
}
