package cn.mldn.test;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
public class DSDemo01 {
	public static void main(String[] args) throws Exception {
		DriverManagerDataSource dmds = new DriverManagerDataSource() ;
		dmds.setUrl("jdbc:mysql://localhost:3306/springdb");
		dmds.setDriverClassName("org.gjt.mm.mysql.Driver");
		dmds.setUsername("root");
		dmds.setPassword("************");
		DataSource source = dmds ;	// 向上转型
		System.out.println(source.getConnection());
	}
}
