package cn.mldn.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.service.IMessageService;
public class TestAOP {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IMessageService msgService = ctx.getBean("messageServiceImpl", IMessageService.class);
		System.out.println(msgService.remove("101"));
	}
}
