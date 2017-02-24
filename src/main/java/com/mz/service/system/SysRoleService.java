package com.mz.service.system;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.dao.SysRoleMapper;
import com.mz.entity.system.SysRole;
import com.mz.entity.system.SysRoleRel;
import com.mz.entity.system.SysRoleRel.RelType;
import com.mz.service.BaseService;


/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：SysRoleService   
 * @Description：   系统角色
 * @author：Ma Zhen   
 * @date：2016-12-1       
 * @version
 */
@Service("sysRoleService")
public class SysRoleService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(SysRoleService.class);
	
	@Autowired
	private SysRoleRelService<SysRoleRel> sysRoleRelService;
	
	/**
	 * 添加角色&菜单关系
	 */
	public void addRoleMenuRel(Integer roleId,Integer[] menuIds) throws Exception{
		if(roleId == null ||  menuIds == null || menuIds.length < 1 ){ 
			return;
		}
		for(Integer menuid :menuIds ){ 
			SysRoleRel rel = new SysRoleRel();
			rel.setRoleId(roleId);
			rel.setObjId(menuid);
			rel.setRelType(RelType.MENU.key);
			sysRoleRelService.add((SysRoleRel)rel);
		}
	}
		
	/**
	 * 添加角色&菜单关系
	 */
	public void addRoleBtnRel(Integer roleId,Integer[] btnIds) throws Exception{
		if(roleId == null ||  btnIds == null || btnIds.length < 1 ){ 
			return;
		}
		for(Integer btnid : btnIds ){ 
			SysRoleRel rel = new SysRoleRel();
			rel.setRoleId(roleId);
			rel.setObjId(btnid);
			rel.setRelType(RelType.BTN.key);
			sysRoleRelService.add(rel);
		}
	}
		
	
	/**
	 * 添加
	 * @param role
	 * @param menuIds
	 * @throws Exception
	 */
	public void add(SysRole role,Integer[] menuIds,Integer[] btnIds) throws Exception {
		super.add((T)role);
		addRoleMenuRel(role.getId(),menuIds);
		addRoleBtnRel(role.getId(),btnIds);
	}

	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(Integer[] ids) throws Exception {
		super.delete(ids);
		for(Integer id : ids){
			//清除关联关系
			sysRoleRelService.deleteByRoleId(id);
		}
	}

	/**
	 * 修改
	 * @param role
	 * @param menuIds
	 * @throws Exception
	 */
	public void update(SysRole role,Integer[] menuIds,Integer[] btnIds) throws Exception {
		super.update((T)role);
		//清除关联关系
		sysRoleRelService.deleteByRoleId(role.getId(),RelType.MENU.key);
		sysRoleRelService.deleteByRoleId(role.getId(),RelType.BTN.key);
		addRoleMenuRel(role.getId(),menuIds);
		addRoleBtnRel(role.getId(),btnIds);
	}

	
	/**
	 *查询全部有效的权限
	 * @return
	 */
	public List<T> queryAllList(){
		return getMapper().queryAllList();
	}

	

	/**
	 *查询全部有效的权限
	 * @return
	 */
	public List<T> queryByUserid(Integer userid){
		return getMapper().queryByUserid(userid);
	}

	@Autowired
    private SysRoleMapper<T> mapper;

		
	public SysRoleMapper<T> getMapper() {
		return mapper;
	}

}
