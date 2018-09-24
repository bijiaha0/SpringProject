package cn.mldn.util;
import java.util.Scanner;
import org.springframework.core.io.Resource;
public class ResourceUtil {
	private Resource src ;	// 此资源将通过Spring的配置文件管理注入
	public void setSrc(Resource src) {
		this.src = src;
	}
	public void print() throws Exception {	// 直接输出资源的内容
		if (this.src.exists()) {	// 表示该资源存在
			Scanner scan = new Scanner(this.src.getInputStream()) ;
			scan.useDelimiter(" ") ;
			while (scan.hasNext()) {
				System.out.println(scan.nextLine());
			}
			scan.close(); 
		} 
	}
}
