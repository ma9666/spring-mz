package com.mz.utils;

/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：ColumnData   
 * @Description：   基础列工具类
 * @author：Ma Zhen   
 * @date：2016-04-22       
 * @version
 */
public class ColumnData {

	private String columnName;
	private String dataType;
	private String columnComment;
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getColumnComment() {
		return columnComment;
	}
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	} 
}
