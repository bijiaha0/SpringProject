package cn.mldn.test;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.service.IDeptService;
import cn.mldn.vo.Dept;
public class TestMessageService {
	private static ApplicationContext ctx = null ;
	static {	// 静态代码块优先于所有的代码执行，目的是为了静态属性初始化
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void testDeptConstructor() {
		Dept vo = new Dept() ;
		vo.setDeptno(10);
		vo.setDname("开发部");
		vo.setLoc("北京");
		IDeptService deptService = ctx.getBean("deptServiceImpl",IDeptService.class) ;
		Logger.getLogger(TestMessageService.class).info(deptService.add(vo));  
	}
}
