package cn.mldn.demo;

import java.util.Scanner;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

public class ResourceDemo01 {
	public static void main(String[] args) throws Exception {
		String info = "www.mldnjava.cn www.mldn.cn" ;
		Resource resource = new ByteArrayResource(info.getBytes()) ;
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
