package cn.mldn.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class DSDemo04 {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jt = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		KeyHolder key = new GeneratedKeyHolder(); // 这个类可以取得增长后的ID
		String sql = "INSERT INTO news(title,pubdate,note) VALUES (?,?,?)";
		jt.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, "好好学习");
				ps.setDate(2, new java.sql.Date(new Date().getTime()));
				ps.setString(3, "天天向上");
				return ps;
			} 
		}, key);
		int len = jt.update(sql, "放学啦", new Date(), "骗你的。");
		System.out.println(key.getKey());
		System.out.println(len);
	}
}
