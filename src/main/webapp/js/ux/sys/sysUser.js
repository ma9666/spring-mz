$package('YiYa.sysUser');
YiYa.sysUser = function(){
	var _box = null;
	var _this = {
		updatePwdAction:'updatePwd.do',
		editPwdForm:function(){
			return $("#pwdForm");
		},
		editPwdWin:function(){
			return $("#edit-pwd-win");
		},
		savePwd:function(){
			if(_this.editPwdForm().form('validate')){
				_this.editPwdForm().attr('action',_this.updatePwdAction);
				YiYa.saveForm(_this.editPwdForm(),function(data){
					_this.editPwdWin().dialog('close');
				});
			 }
		},
		initForm:function(){
			//修改密码
			_this.editPwdWin().find("#btn-pwd-submit").click(function(){
				alert();
				_this.savePwd();
			});
			_this.editPwdWin().find("#btn-pwd-close").click(function(){	
				$.messager.confirm('Confirm','Are you sure you want close Window?',function(r){  
				    if (r){  
				     	_this.editPwdWin().dialog('close');
				    }  
				});
			});
		},
		config:{
  			dataGrid:{
  				title:'SiteType List',
	   			url:'dataList.do',
	   			columns:[[
						{field:'id',checkbox:true},
						{field:'email',title:'Email',width:120,sortable:true},
						{field:'nickName',title:'NickName',width:80,sortable:true},
						{field:'state',title:'State',width:80,align:'center',sortable:true,styler:function(value,row,index){
							if(value == 1){
							  return 'color:red;';  
							}
						},
						formatter:function(value,row,index){
							if(value == 0){
								return "可用";
							}
							if(value == 1){
								return "禁用";
							}
						}},
						{field:'createTime',title:'CreateTime',width:120,sortable:true},
						{field:'loginCount',title:'Login Count',align:'right',width:80,sortable:true},
						{field:'loginTime',title:'LoginTime',width:120,sortable:true}
				]],
				toolbar:[
					{id:'btnadd',text:'Add',btnType:'add'},
					{id:'btnedit',text:'Edit',btnType:'edit'},
					{id:'btndelete',text:'Delete',btnType:'remove'}
				]
			}
		},
		init:function(){
			_this.initForm();
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

$(function(){
	YiYa.sysUser.init();
});		
