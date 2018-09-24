package cn.mldn.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.mldn.service.IMessageService;
public class TestMessage {
	public static void main(String[] args) {
		// 加载applicationContext.xml文件，同时表示Spring容器启动
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 取得在applicationContext.xml文件中配置的“msg”对象，并且设置其为IMessageService接口类型
		IMessageService msgService = ctx.getBean("msg",IMessageService.class) ;
		System.out.println(msgService.getInfo());
	}
}
   