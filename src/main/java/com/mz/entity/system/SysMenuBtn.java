package com.mz.entity.system;

import com.mz.entity.BaseBean;



/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：SysMenuBtn   
 * @Description：   菜单按钮
 * @author：Ma Zhen   
 * @date：2016-04-22      
 * @version
 */
public class SysMenuBtn extends BaseBean {
	
	
	
	private String deleteFlag; //删除标记，与数据库字段无关 1=删除,其他不删除

		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Integer getId() {
}