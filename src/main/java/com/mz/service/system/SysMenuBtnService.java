package com.mz.service.system;

import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.dao.SysMenuBtnMapper;
import com.mz.service.BaseService;


/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：SysMenuBtnService   
 * @Description：   菜单按钮
 * @author：Ma Zhen   
 * @date：2016-12-1       
 * @version
 */
@Service("sysMenuBtnService")
public class SysMenuBtnService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(SysMenuBtnService.class);
	
	public List<T> queryByAll(){
		return getMapper().queryByAll();
	}
	
	
	
	public List<T> queryByMenuid(Integer menuid){
		return getMapper().queryByMenuid(menuid);
	}
	
	public List<T> queryByMenuUrl(String url){
		return getMapper().queryByMenuUrl(url);
	}
	
	public void deleteByMenuid(Integer menuid){
		getMapper().deleteByMenuid(menuid);
	}
	
	public List<T> getMenuBtnByUser(Integer userid){
		return getMapper().getMenuBtnByUser(userid);
	}

	@Autowired
    private SysMenuBtnMapper<T> mapper;

		
	public SysMenuBtnMapper<T> getMapper() {
		return mapper;
	}

}
