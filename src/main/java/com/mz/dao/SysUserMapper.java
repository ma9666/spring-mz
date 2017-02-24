package com.mz.dao;

import com.mz.entity.system.SysUser;

/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：SysUserMapper   
 * @Description：   系统用户
 * @author：Ma Zhen   
 * @date：2016-12-1       
 * @version
 */
public interface SysUserMapper<T> extends BaseMapper<T> {
	
	/**
	 * 检查登录
	 * @param email
	 * @param pwd
	 * @return
	 */
	public T queryLogin(SysUser model);
	
	
	/**
	 * 查询邮箱总数，检查是否存在
	 * @param email
	 * @return
	 */
	public int getUserCountByEmail(String email);
}
