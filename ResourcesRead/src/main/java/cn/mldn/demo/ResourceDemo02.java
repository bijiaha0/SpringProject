package cn.mldn.demo;

import java.io.File;
import java.util.Scanner;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class ResourceDemo02 {
	public static void main(String[] args) throws Exception {
		String filePath = "E:" + File.separator + "my-lib" + File.separator + "xml" + File.separator
				+ "spring-task-4.1.xsd";
		File file = new File(filePath);
		Resource resource = new FileSystemResource(file) ;  
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
