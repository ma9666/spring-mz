package com.mz.exception;

/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：ServiceException   
 * @Description：  自定义服务异常
 * @author：Ma Zhen   
 * @date：2016-04-22       
 * @version
 */
public class ServiceException extends Exception {

	/**
	 * 自定义服务异常
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(String err){
		super(err);
	}
}
