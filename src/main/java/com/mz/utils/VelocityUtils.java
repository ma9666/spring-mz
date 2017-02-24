package com.mz.utils;

import org.apache.velocity.VelocityContext;

/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：VelocityUtils   
 * @Description：   
 * @author：Ma Zhen   
 * @date：2016-04-22       
 * @version
 */
public class VelocityUtils{
	
	public static VelocityContext getContext(){
		VelocityContext context = new VelocityContext();
		context.put("PathUtil", new PathUtil());
		context.put("DateUtil", new DateUtil());
		context.put("StringUtil", new StringUtil());
		context.put("basePath", PathUtil.getBasePath());
		return context;
	}
	
}

