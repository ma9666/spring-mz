package com.mz.utils;

import java.beans.PropertyEditorSupport;
import org.springframework.util.StringUtils;

/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：MyEditor   
 * @Description：   类型转换工具类
 * @author：Ma Zhen   
 * @date：2016-04-22       
 * @version
 */
public class MyEditor extends PropertyEditorSupport  {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if(text == null ||text.equals(""))
				text = "0";
			if ( !StringUtils.hasText(text)) {
			
				setValue(null);
			}
			else {
				setValue(Integer.parseInt(text));//这句话是最重要的，他的目的是通过传入参数的类型来匹配相应的databind
			}
		}
		/**
		 * Format the Date as String, using the specified DateFormat.
		 */
		@Override
		public String getAsText() {
			
			return getValue().toString();
		}
}