package cn.mldn.demo;

import java.util.Scanner;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class ResourceDemo06 {
	public static void main(String[] args) throws Exception {
		ResourceLoader loader = new DefaultResourceLoader() ;
		Resource resource = loader.getResource("classpath:applicationContext.xml") ; 
		
		if (resource.exists()) {	// 表示该资源存在
			// Resource的父接口InputStreamResource只提供有getInputStream()方法，所以这个时候最好的读取使用Scanner
			Scanner scan = new Scanner(resource.getInputStream()) ;
			scan.useDelimiter(" ") ;
			while (scan.hasNext()) {
				System.out.println(scan.nextLine());
			}
			scan.close(); 
		}
	}
}


