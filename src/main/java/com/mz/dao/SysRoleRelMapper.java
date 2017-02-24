package com.mz.dao;

import java.util.List;

import com.mz.entity.system.SysRoleRel;


/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：SysRoleRelMapper   
 * @Description：   角色关系
 * @author：Ma Zhen   
 * @date：2016-12-1       
 * @version
 */
public interface SysRoleRelMapper<T> extends BaseMapper<T> {
	
	public void deleteByRoleId(java.util.Map<String, Object> param);
	
	public void deleteByObjId(java.util.Map<String, Object> param);
	
	
	public List<SysRoleRel> queryByRoleId(java.util.Map<String, Object> param);
	
	
	public List<SysRoleRel> queryByObjId(java.util.Map<String, Object> param);
	
	
}
