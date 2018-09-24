package cn.mldn.test;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DSDemo02 {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml") ;
		DataSource source = ctx.getBean("dataSource",DataSource.class) ;	// 向上转型
		System.out.println(source.getConnection());
	}
}
