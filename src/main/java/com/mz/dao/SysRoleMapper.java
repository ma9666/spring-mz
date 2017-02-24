package com.mz.dao;

import java.util.List;

/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：SysRoleMapper   
 * @Description：   角色
 * @author：Ma Zhen   
 * @date：2016-12-1       
 * @version
 */
public interface SysRoleMapper<T> extends BaseMapper<T> {
	
	/**
	 *查询全部有效的权限
	 * @return
	 */
	public List<T> queryAllList();
	
	
	/**
	 *根据用户Id查询权限
	 * @return
	 */
	public List<T> queryByUserid(Integer userid);
}
