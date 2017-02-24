/**
 * 页面公共组件
 */
CommonComboBox = {

	comboBoxInstance : function(id, url) {
		$("#" + id).combobox({
			url : url,
			valueField : 'id',
			textField : 'text'
		});
	},

	setComboBoxValue : function(id, value) {
		$("#" + id).combobox('setValue', value);
	},

	reloadComboBox : function(id, url) {
		$("#" + id).combobox('reload', url);
	},

	// 类型
	adTypeComboBox : function(id, value) {
		var url = 'jsp/easyuiDemo/adtype.json';
		this.comboBoxInstance(id, url);
	},

	// 广告主
	adVernoComboBox : function(id, value) {
		var url = 'jsp/easyuiDemo/adverno.json';
		this.comboBoxInstance(id, url);
	},

	// 数据字典
	// 参数id为页面控件id，value为数据字典类别编码
	dictionaryComboBox : function(id, value) {
		$('#' + id).combobox({
			url : webPath + 'mvc/dictionary/getDicData',
			valueField : 'keyvalue',
			textField : 'keyname',
			panelHeight : 'auto',
			queryParams : {
				"key" : value
			}
		});
		
		
	},

	
	//可按参数查询的导流位下拉框。参数格式为：{'key':'value'}
	params_Location_codeComboBox : function(id,param) {
		var param=eval("("+param+")");
		$('#' + id).combobox({
			url : webPath + 'mvc/adLocationCode/getGuideauthByParams',
			panelWidth:180,
			queryParams: param,
			valueField : 'adlocationcode',
			textField : 'guidedetailname'
		});
	},

	PlatDictionaryComboBoxInstance :function(id,keyvalue){
		var url = 'mvc/dictionary/getDicData';
		$("#"+id).combobox({     
			url:url, 
			valueField:'keyvalue',    
			textField:'keyname',
			queryParams:{
             	"keyvalue":keyvalue     
		    }
		}); 
	},
	/**
	 * 用于状态渲染
	 * @param value
	 * @returns {String}
	 */
	formatterStatus : function(value) {
		if (value == 1) {
			return '<span style="color:green;">有效</span>';
		} else {
			return '<span style="color:red;">无效</span>';
		}
	},
	
	
	formatterGender : function(value) {
		if (value == 1) {
			return '<span style="color:green;">女</span>';
		} else {
			return '<span style="color:red;">男</span>';
		}
	}

}





/**
 * 菜单页面按钮权限控制  by mazhen 2016.12.1
 */
buttonPermission = {

	// 菜单页面按钮权限控制方法
	getEasyUiButtonPermission: function(url){
		$.ajax({
			type: "post",
			url: webPath + '/getActionBtn.shtml',
			data: {"url":menuUrl},
			dataType: "json",
			success: function(data){
				if(data.allType!=true){
					//判断按钮权限
					//$("#btnPanel .easyui-linkbutton").each(function(){
						//var buttonId=$(this).attr("id");
						$(data.types).each(function(i,item){
							var code =item;
							$("#btnPanel .easyui-linkbutton").each(function(){
								var buttonId=$(this).attr("id");
								if(code==buttonId){
									$("#"+buttonId).show();
								}
							});
							/* if(this.functionCode==buttonId && this.status==true){
								$("#"+buttonId).hide();
							} */
						});
					//});
				}else{
					$("#btnPanel .easyui-linkbutton").each(function(){
						$("#"+$(this).attr("id")).show();
					});
				}
			},
			error:function(data){
				$.messager.alert('提示',data.msg);
			}
		});
	}
}

/**
 * 格式化去日期（含时间）
 */
DateFormatCommon = {
	
	// 时间戳转换成时间字符串
	formatterDateTimes : function(datetime) {
		
		var time = new Date(datetime);
		var y = time.getFullYear();
		var m = time.getMonth()+1;
		var d = time.getDate();
		var h = time.getHours();
		var mm = time.getMinutes();
		var s = time.getSeconds();
		return y+'-'+tiemConvert(m)+'-'+tiemConvert(d)+' '+tiemConvert(h)+':'+tiemConvert(mm)+':'+tiemConvert(s);
	}
}
//时间转换js内部调用- 勿动
function tiemConvert(m){return m<10?'0'+m:m }	