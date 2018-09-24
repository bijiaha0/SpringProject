package cn.mldn.demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.util.ResourceUtils;
public class ResourceDemo08 {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ResourceUtils ru = ctx.getBean("resourceUtils", ResourceUtils.class);
		ru.print(); 
	}
}
