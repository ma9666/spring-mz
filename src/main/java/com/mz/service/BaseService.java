package com.mz.service;

import java.util.List;

import com.mz.dao.BaseMapper;
import com.mz.entity.BaseBean;

/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：BaseService   
 * @Description：   service基础类
 * @author：Ma Zhen   
 * @date：2016-12-1       
 * @version
 */
public abstract class BaseService<T>{
	
	public abstract BaseMapper<T> getMapper();

	
	public void add(T t)  throws Exception{
		getMapper().add(t);
	}
	
	public void update(T t)  throws Exception{
		getMapper().update(t);
	}
	
	
	public void updateBySelective(T t){
		getMapper().updateBySelective(t);
	}
	
	public void delete(Object... ids) throws Exception{
		if(ids == null || ids.length < 1){
			return;
		}
		for(Object id : ids ){
			getMapper().delete(id);
		}
	}
	
	public int queryByCount(BaseBean model)throws Exception{
		return getMapper().queryByCount(model);
	}
	
	public List<T> queryByList(BaseBean model) throws Exception{
		Integer rowCount = queryByCount(model);
		model.getPager().setRowCount(rowCount);
		return getMapper().queryByList(model);
	}

	public T queryById(Object id) throws Exception{
		return getMapper().queryById(id);
	}
}
