package com.rbac.jrapid.core.dto.vo;

import java.util.Map;

/**
 * ztree树节点
 * @author fwj
 *
 */
public class ZtreeNodeVO {
	
	private String name;
	
	private boolean checked;
	
	private boolean isParent;
	
	private Integer id;
	
	/**
	 * 图标 CSS名
	 */
	private String iconSkin;
	
	private boolean isHidden;
	
	/**
	 * 是否展开
	 */
	private boolean open;
	
	private Map<String,String> attributes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIconSkin() {
		return iconSkin;
	}

	public void setIconSkin(String iconSkin) {
		this.iconSkin = iconSkin;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}
	
	
}
