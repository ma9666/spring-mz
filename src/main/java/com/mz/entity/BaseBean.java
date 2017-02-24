package com.mz.entity;

import org.apache.commons.lang.StringUtils;

import com.mz.utils.Pager;



/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：BaseBean   
 * @Description：   基础类
 * @author：Ma Zhen   
 * @date：2016-04-22       
 * @version
 */
public class BaseBean {
	
	 /**
	  * 状态枚举
	  * @author lu
	  *
	  */
	 public static enum STATE {
		 	ENABLE(0, "可用"), DISABLE(1,"禁用");
			public int key;
			public String value;
			private STATE(int key, String value) {
				this.key = key;
				this.value = value;
			}
			public static STATE get(int key) {
				STATE[] values = STATE.values();
				for (STATE object : values) {
					if (object.key == key) {
						return object;
					}
				}
				return null;
			}
		}
	 	
	 	/**
	 	 * 删除枚举
	 	 * @author lu
	 	 *
	 	 */
	 	public static enum DELETED {
			NO(0, "未删除"), YES(1,"已删除");
			public int key;
			public String value;
			private DELETED(int key, String value) {
				this.key = key;
				this.value = value;
			}
			public static DELETED get(int key) {
				DELETED[] values = DELETED.values();
				for (DELETED object : values) {
					if (object.key == key) {
						return object;
					}
				}
				return null;
			}
		}
	 	
	 	
	 	private Integer page = 1;
	  
	  private Integer rows =10;
	  
	  private String sort;
	  
	  private String order;

	  
	  /**
	   * 分页导航
	   */
	  private Pager pager = new Pager();
	  
	  public Pager getPager() {
	    pager.setPageId(getPage());
	    pager.setPageSize(getRows());
	    String orderField="";
	    if(StringUtils.isNotBlank(sort)){
	      orderField = sort;
	    }
	    if(StringUtils.isNotBlank(orderField) && StringUtils.isNotBlank(order)){
	      orderField +=" "+ order;
	    }
	    pager.setOrderField(orderField);
	    return pager;
	  }

	  public void setPager(Pager pager) {
	    this.pager = pager;
	  }

	  public Integer getPage() {
	    return page;
	  }

	  public void setPage(Integer page) {
	    this.page = page;
	  }

	  public Integer getRows() {
	    return rows;
	  }

	  public void setRows(Integer rows) {
	    this.rows = rows;
	  }

	  public String getSort() {
	    return sort;
	  }

	  public void setSort(String sort) {
	    this.sort = sort;
	  }

	  public String getOrder() {
	    return order;
	  }

	  public void setOrder(String order) {
	    this.order = order;
	  }
	
}
