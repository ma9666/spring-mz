package com.mz.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.mz.exception.ServiceException;

/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：FormValidate   
 * @Description：   数据验证工具类
 * @author：Ma Zhen   
 * @date：2016-04-22       
 * @version
 */
public class FormValidate {
	
	/**
	 * 参数验证
	 * @param value
	 * @param msg
	 * @throws ServiceException 
	 */
	public static void validNull(String value,String msg) throws ServiceException{
		if(StringUtils.isBlank(value)){
			throw new ServiceException(msg);
		}
	} 
	
	/**
	 * 判断字符串长度
	 * @param value
	 * @param minLen
	 * @param maxLen
	 * @param msg
	 * @throws ServiceException
	 */
	public static void  validLen(String value,Integer minLen,Integer maxLen,String msg) throws ServiceException{
		int len =StringUtils.isNotBlank(value) ? value.length(): 0; 
		if( len < minLen ||  len > maxLen){
			throw new ServiceException(msg);
		}
	}
	
	/**
	 * 验证是否数字
	 * @param value
	 * @param minLen
	 * @param maxLen
	 * @param msg
	 * @throws ServiceException
	 */
	public static void  validNumber(String value,String msg) throws ServiceException{
		if(!NumberUtils.isNumber(value)){
			throw new ServiceException(msg);
		}
	}
		
	
	/**
	 * 验证是否int 数字
	 * @param value
	 * @param minLen
	 * @param maxLen
	 * @param msg
	 * @throws ServiceException
	 */
	public static void  validInt(String value,String msg) throws ServiceException{
		try{
			Integer.parseInt(value);
		}catch(Exception e){
			throw new ServiceException(msg);
		}
	}
	
	
	
	/**
	 * 验证是否Float 数字
	 * @param value
	 * @param minLen
	 * @param maxLen
	 * @param msg
	 * @throws ServiceException
	 */
	public static void  validFloat(String value,String msg) throws ServiceException{
		try{
			Float.parseFloat(value);
		}catch(Exception e){
			throw new ServiceException(msg);
		}
	}
}
