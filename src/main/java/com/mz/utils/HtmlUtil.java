package com.mz.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.mz.utils.json.JSONUtil;

/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：HtmlUtil   
 * @Description：   数据转换
 * @author：Ma Zhen   
 * @date：2016-04-22       
 * @version
 */
public class HtmlUtil {
	
	/**
	 * 
	 * @param response
	 * @param jsonStr
	 * @Description: 输出json格式
	 * @author： Ma Zhen
	 * @createTime： 2016-04-22
	 */
	public static void writerJson(HttpServletResponse response,String jsonStr) {
			writer(response,jsonStr);
	}
	
	public static void writerJson(HttpServletResponse response,Object object){
			try {
				response.setContentType("application/json");
				writer(response,JSONUtil.toJSONString(object));
			} catch (JSONException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * 
	 * @param response
	 * @param htmlStr
	 * @Description: 输出HTML代码
	 * @author： Ma Zhen
	 * @createTime： 2016-04-22
	 */
	public static void writerHtml(HttpServletResponse response,String htmlStr) {
		writer(response,htmlStr);
	}
	
	private static void writer(HttpServletResponse response,String str){
		try {
			StringBuffer result = new StringBuffer();
			//设置页面不缓存
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out= null;
			out = response.getWriter();
			out.print(str);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
