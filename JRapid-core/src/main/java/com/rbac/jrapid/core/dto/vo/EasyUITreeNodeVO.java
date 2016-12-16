package com.rbac.jrapid.core.dto.vo;

import java.util.List;
import java.util.Map;

public class EasyUITreeNodeVO {

	private String id;
	
	private String text;
	
	private String iconCls;
	
	private boolean checked;

	private String state;
	
	private List<EasyUITreeNodeVO> children;
	
	/**
	 * 附加属性
	 */
	private Map<String,String> attribute;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<EasyUITreeNodeVO> getChildren() {
		return children;
	}

	public void setChildren(List<EasyUITreeNodeVO> children) {
		this.children = children;
	}

	public Map<String, String> getAttribute() {
		return attribute;
	}

	public void setAttribute(Map<String, String> attribute) {
		this.attribute = attribute;
	}
		
}
