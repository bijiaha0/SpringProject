package cn.mldn.service.proxy;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class ServiceProxy {
	// 如果要进行后续调用需要知道传递的参数，需要知道具体要调用的业务方法
	public Object arroundInvoke(ProceedingJoinPoint point) throws Throwable {
		Logger.getLogger(ServiceProxy.class).info("【*** BEFORE ***】执行参数：" + Arrays.toString(point.getArgs())); 
		// Object obj = point.proceed(point.getArgs()) ;正常操作要将用户的参数继续向后传递
		Object obj = point.proceed(new Object[] {"mldnjava"} ) ;	// 自己来处理参数内容
		Logger.getLogger(ServiceProxy.class).info("【*** AFTER ***】返回结果：" + obj);
		return true ;
	}
	
	public void beforeInvoke(Object arg) {
		Logger.getLogger(ServiceProxy.class).info("【ServiceProxy - BEFORE】在业务方法执行之前进行调用，参数内容：" + arg);
	} 
	public void throwInvoke(Exception e) {
		Logger.getLogger(ServiceProxy.class).error("【ServiceProxy - EXCEPTION】抛出异常：" + e);
	}
	public void afterInvoke() {
		Logger.getLogger(ServiceProxy.class).info("【ServiceProxy - AFTER】在业务方法执行之后进行调用。");
	}
	public void returnInvoke(Object val) {
		Logger.getLogger(ServiceProxy.class).info("【ServiceProxy - RETURNING】返回值 = " + val);
	}
}
