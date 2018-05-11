package org.cloud.jlzm.domain;

import java.util.List;

public class MenuItem {
	private int menuId;
	private int pId;
	private String name;
	private String url;
	private int lv;
	private String icon;
	private List<MenuItem> children;
	public MenuItem() {
		
	}
	public List<MenuItem> getChildren() {
		return children;
	}

	public void setChildren(List<MenuItem> children) {
		this.children = children;
	}

	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	@Override
	public String toString() {
		return "MenuList [menuId=" + menuId + ", pId=" + pId + ", name=" + name
				+ ", url=" + url + "]";
	}
}
