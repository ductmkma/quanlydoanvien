package com.zent.entity;

public class PermissionRole {
	private Long role_id;
	private Long permission_id;
	private String created_at;
	private String deleted_at;
	private String updated_at;
	private int status;
	
	public PermissionRole() {
		super();
	}
	
	public PermissionRole(Long role_id, Long permission_id) {
		super();
		this.role_id = role_id;
		this.permission_id = permission_id;
	}

	public PermissionRole(Long role_id, Long permission_id, String created_at,
			String deleted_at, String updated_at, int status) {
		super();
		this.role_id = role_id;
		this.permission_id = permission_id;
		this.created_at = created_at;
		this.deleted_at = deleted_at;
		this.updated_at = updated_at;
		this.status = status;
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

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
