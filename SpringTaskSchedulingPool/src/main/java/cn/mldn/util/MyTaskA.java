package cn.mldn.util;

import java.text.SimpleDateFormat;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class MyTaskA { // 不需要去继承任何的父类
	@Scheduled(fixedRate=2000) 
	public void runJob() {
		System.out.println("【MyTaskA - 当前日期时间】" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date()));
	}
}
