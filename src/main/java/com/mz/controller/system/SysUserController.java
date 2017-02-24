package com.mz.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.mz.controller.BaseController;
import com.mz.entity.BaseBean.DELETED;
import com.mz.entity.BaseBean.STATE;
import com.mz.entity.system.SysMenu;
import com.mz.entity.system.SysRole;
import com.mz.entity.system.SysRoleRel;
import com.mz.entity.system.SysUser;
import com.mz.exception.ServiceException;
import com.mz.service.system.SysRoleService;
import com.mz.service.system.SysUserService;
import com.mz.utils.HtmlUtil;
import com.mz.utils.MethodUtil;
import com.mz.utils.SessionUtils;

/**
 * 
 * @ProjectName ：后台管理系统   
 * @ClassName：SysUserController  
 * @Description：    用户控制类
 * @author：Ma Zhen   
 * @date：2016-12-1       
 * @version
 */
@Controller
@RequestMapping("/sysUser") 
public class SysUserController extends BaseController{
	
	private final static Logger log= Logger.getLogger(SysUserController.class);
	
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private SysUserService<SysUser> sysUserService; 
	
	// Servrice start
	@Autowired(required=false) 
	private SysRoleService<SysRole> sysRoleService; 
	/**
	 * ilook 首页
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(SysUser model,HttpServletRequest request) throws Exception{
	  
	  ModelAndView mav = new ModelAndView("/view/sys/sysUser");
		List<SysUser> dataList = sysUserService.queryByList(model);
		//设置页面数据
		mav.addObject("dataList", dataList);
		return mav;
	}
	
	
	/**
	 * json 列表页面
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  dataList(SysUser model,HttpServletResponse response) throws Exception{
		List<SysUser> dataList = sysUserService.queryByList(model);
		for(SysUser user: dataList){
			List<SysRole> list = sysRoleService.queryByUserid(user.getId());
			user.setRoleStr(rolesToStr(list));
		}
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 角色列表转成字符串
	 * @param list
	 * @return
	 */
	private String rolesToStr(List<SysRole> list){
		if(list == null || list.isEmpty()){
			return null;
		}
		StringBuffer str = new StringBuffer();
		for(int i=0;i<list.size();i++){
			SysRole role = list.get(i);
			str.append(role.getRoleName());
			if((i+1) < list.size()){
				str.append(",");
			}
		}
		return str.toString();
	}
	
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public void save(SysUser bean,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = new HashMap<String,Object>();
		int count = sysUserService.getUserCountByEmail(bean.getEmail());
		if(bean.getId() == null){
			if(count > 0){
				throw new ServiceException("用户已存在.");
			}
			bean.setDeleted(DELETED.NO.key);
			bean.setPwd(MethodUtil.MD5(bean.getNpwd()));
			sysUserService.add(bean);
		}else{
			if(count > 1){
				throw new ServiceException("用户已存在.");
			}
			bean.setPwd(MethodUtil.MD5(bean.getNpwd()));
			sysUserService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id,HttpServletResponse response) throws Exception{
		Map<String,Object> context = new HashMap<String, Object>();
		SysUser bean  = sysUserService.queryById(id);
		if(bean  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	@RequestMapping("/delete")
	public void delete(Integer[] id,HttpServletResponse response) throws Exception{
		sysUserService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
	
	
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/updatePwd")
	public void updatePwd(Integer id,String oldPwd,String newPwd,HttpServletRequest request,HttpServletResponse response) throws Exception{
		boolean isAdmin = SessionUtils.isAdmin(request); //是否超级管理员
		SysUser bean  = sysUserService.queryById(id);
		if(bean.getId() == null || DELETED.YES.key == bean.getDeleted()){
			sendFailureMessage(response, "Sorry ,User is not exists.");
			return;
		}
		if(StringUtils.isBlank(newPwd)){
			sendFailureMessage(response, "Password is required.");
			return;
		}
		//不是超级管理员，匹配旧密码
		if(!isAdmin && !MethodUtil.ecompareMD5(oldPwd,bean.getPwd())){
			sendFailureMessage(response, "Wrong old password.");
			return;
		}
		bean.setPwd(MethodUtil.MD5(newPwd));
		sysUserService.update(bean);
		sendSuccessMessage(response, "保存成功~");
	}
	

	
	/**
	 * 用户授权页面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userRole") 
	public ModelAndView  userRole(HttpServletRequest request) throws Exception{
	  ModelAndView mav = new ModelAndView("/view/sys/sysUserRole");
		return mav;
	}
	
	/**
	 * 用户授权列表
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/userList") 
	public void  userList(SysUser model,HttpServletResponse response) throws Exception{
		model.setState(STATE.ENABLE.key);
		dataList(model, response);
	}

	/**
	 * 查询用户信息
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getUser") 
	public void getUser(Integer id,HttpServletResponse response)  throws Exception{
		Map<String,Object>  context = new HashMap<String, Object>();
		SysUser bean  = sysUserService.queryById(id);
		if(bean  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		Integer[] roleIds = null;
		List<SysRoleRel>  roles  =sysUserService.getUserRole(bean.getId());
		if(roles != null){
			roleIds = new Integer[roles.size()];
			int i = 0;
			for(SysRoleRel rel : roles ){
				roleIds[i] = rel.getRoleId();
				i++;
			}
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", bean.getId());
		data.put("email", bean.getEmail());
		data.put("roleIds", roleIds);
		context.put(SUCCESS, true);
		context.put("data", data);
		HtmlUtil.writerJson(response, context);
		
	}
	
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/addUserRole")
	public void addUserRole(Integer id,Integer roleIds[],HttpServletResponse response) throws Exception{
		sysUserService.addUserRole(id, roleIds);
		sendSuccessMessage(response, "保存成功");
	}
}
