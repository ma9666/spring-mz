package com.mz.dao;

import java.util.List;

/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：SysMenuBtnMapper   
 * @Description：   菜单按钮
 * @author：Ma Zhen   
 * @date：2016-12-1       
 * @version
 */
public interface SysMenuBtnMapper<T> extends BaseMapper<T> {
	
	public List<T> queryByMenuid(Integer menuid);
	
	public List<T> queryByMenuUrl(String url); 
	
	public void deleteByMenuid(Integer menuid);
	
	public List<T> getMenuBtnByUser(Integer userid); 
	
	
	
	public List<T> queryByAll();
}
