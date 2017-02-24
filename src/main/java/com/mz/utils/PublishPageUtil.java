package com.mz.utils;

//import java.io.File;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：PublishPageUtil   
 * @Description：   出版页面的工具类
 * @author：Ma Zhen   
 * @date：2016-04-22       
 * @version
 */
public class PublishPageUtil {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext(
			new String[]{"com/wei/ssi/conf/spring/*.xml"}); 
	
	private final static String  FILE_DIR_PATH = PathUtil.getRootPath();//获取项目部署根目录  如：F:\openwork\mn606\WebRoot

	public static void main(String[] args) {
//		createIndex();
	}
}
