package cn.mldn.util;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;	
@Component	// 必须标记出此为一个Spring管理的JavaBean类 
public class MyTaskB { // 不需要去继承任何的父类
	@Scheduled(cron="0 * * * * ?")	// 设置每秒一触发 
	public void runJob() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		System.out.println("【MyTaskB - 当前日期时间】" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date()));
	}
}
