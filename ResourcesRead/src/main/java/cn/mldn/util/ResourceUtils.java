package cn.mldn.util;
import org.springframework.core.io.Resource;
public class ResourceUtils {
	private Resource src[]; // 此资源将通过Spring的配置文件管理注入
	public void setSrc(Resource[] src) {
		this.src = src;
	}
	public void print() throws Exception { // 直接输出资源的内容
		for (int x = 0; x < this.src.length; x++) {
//			if (this.src[x].exists()) { // 表示该资源存在
//				Scanner scan = new Scanner(this.src[x].getInputStream());
//				scan.useDelimiter(" ");
//				while (scan.hasNext()) {
//					System.out.println(scan.nextLine());
//				}
//				scan.close();
//			}
//			System.out.println("**********************************");
			System.out.println("*** " + this.src[x].getFilename());
		}
	}
}
