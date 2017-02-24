package com.mz.dao;

import java.util.List;

import com.mz.entity.BaseBean;

/**
 * 
 * @ProjectName ：后台管理系统   
 * @ClassName：BaseMapper 
 * @Description：   dao层基础类
 * @author：Ma Zhen   
 * @date：2016-12-1       
 * @version
 */
public interface BaseMapper<T> {

	
	public void add(T t);
	
	
	public void update(T t);
	
	
	public void updateBySelective(T t); 	
	
	public void delete(Object id);
	

	public int queryByCount(BaseBean model);
	
	public List<T> queryByList(BaseBean model);
	
	
	public T queryById(Object id);
}
