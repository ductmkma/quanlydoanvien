package com.zent.entity;

public class RoleUser {
	private Long role_id;
	private String role_name;
	private String role_description;
	private String permission_name;
	
	public RoleUser() {
		super();
	}
	public RoleUser(Long role_id, String role_name, String role_description,
			String permission_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_description = role_description;
		this.permission_name = permission_name;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_description() {
		return role_description;
	}
	public void setRole_description(String role_description) {
		this.role_description = role_description;
	}
	public String getPermission_name() {
		return permission_name;
	}
	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}
	
}
