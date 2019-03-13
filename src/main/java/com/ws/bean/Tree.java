/** 
 * <pre>项目名称:zuoye11_29a 
 * 文件名称:Tree.java 
 * 包名:com.jk.ws.pojo 
 * 创建日期:2018年11月29日下午4:41:10 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.ws.bean;

import java.io.Serializable;
import java.util.List;

/** 
 * <pre>项目名称：zuoye11_29a    
 * 类名称：Tree    
 * 类描述：    
 * 创建人：王帅  
 * 创建时间：2018年11月29日 下午4:41:10    
 * 修改人：王帅  
 * 修改时间：2018年11月29日 下午4:41:10    
 * 修改备注：       
 * @version </pre>    
 */
public class Tree implements Serializable {
	private static final long serialVersionUID = 8395790841582308064L;
	private Integer id;
	private String text;
	private Integer pid;
	
	private String url;

	private  String iconCls;
	private  String state;
	
	private  Boolean checked;
	private List<Tree> children;
	
	
	
	
	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Tree> getChildren() {
		return children;
	}

	public void setChildren(List<Tree> children) {
		this.children = children;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
