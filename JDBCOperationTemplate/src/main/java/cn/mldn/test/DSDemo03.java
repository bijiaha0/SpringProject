package cn.mldn.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DSDemo03 {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jt = ctx.getBean("jdbcTemplate", JdbcTemplate.class); 
		String sql = "INSERT INTO news(title,pubdate,note) VALUES (?,?,?)" ;
		int len = jt.update(sql, "放学啦",new Date(),"骗你的。") ;
		System.out.println(len);
	}
}
