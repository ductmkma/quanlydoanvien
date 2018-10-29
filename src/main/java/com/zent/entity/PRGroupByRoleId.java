package com.zent.entity;

public class PRGroupByRoleId {
	private Long role_id;
	private String role_display_name;
	private String role_description;
	
	public PRGroupByRoleId() {
		super();
	}

	public PRGroupByRoleId(Long role_id, String role_display_name,
			String role_descrition) {
		super();
		this.role_id = role_id;
		this.role_display_name = role_display_name;
		this.role_description = role_description;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public String getrole_display_name() {
		return role_display_name;
	}

	public void setrole_display_name(String role_display_name) {
		this.role_display_name = role_display_name;
	}

	public String getRole_description() {
		return role_description;
	}

	public void setRole_descrition(String role_description) {
		this.role_description = role_description;
	}
	
	
}
