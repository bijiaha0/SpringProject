package cn.mldn.test;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.mldn.service.IMessageService;
import cn.mldn.vo.Dept;
import cn.mldn.vo.Emp;
import junit.framework.TestCase;
public class TestMessageService {
	private static ApplicationContext ctx = null ;
	static {	// 静态代码块优先于所有的代码执行，目的是为了静态属性初始化
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void testGetInfo() {
		IMessageService msgService = ctx.getBean("msg", IMessageService.class);
		Logger.getLogger(TestMessageService.class).info(msgService.getInfo());
		TestCase.assertEquals(msgService.getInfo(), "www.mldn.cn");
	}
	@Test
	public void testEmpAndDept() {
		Emp emp = ctx.getBean("emp",Emp.class) ;
		Logger.getLogger(TestMessageService.class).info(emp); 
	}
	@Test
	public void testDeptConstructor() {
		Dept dept = ctx.getBean("dept",Dept.class) ;
		Logger.getLogger(TestMessageService.class).info(dept); 
	}
}
