package com.zent.entity;

public class PermissionRoleUnitonist {
	private Long id;
	private Long role_id;
	private Long permission_id;
	
	public PermissionRoleUnitonist() {
		super();
	}

	public PermissionRoleUnitonist(Long id, Long role_id, Long permission_id) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.permission_id = permission_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public Long getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(Long permission_id) {
		this.permission_id = permission_id;
	}
	
	
}
