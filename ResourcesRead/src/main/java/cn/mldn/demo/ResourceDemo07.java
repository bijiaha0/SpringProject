package cn.mldn.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.util.ResourceUtil;

public class ResourceDemo07 {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ResourceUtil ru = ctx.getBean("resourceUtil", ResourceUtil.class);
		ru.print(); 
	}
}
