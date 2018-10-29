package com.zent.entity;

public class Permission {
	private Long id;
	private String name;
	private String display_name;
	private String description;
	private String created_at;
	private String update_at;
	private String deleted_at;
	
	public Permission() {
		super();
	}

	public Permission(Long id, String name, String display_name,
			String description, String created_at, String update_at,
			String deleted_at) {
		super();
		this.id = id;
		this.name = name;
		this.display_name = display_name;
		this.description = description;
		this.created_at = created_at;
		this.update_at = update_at;
		this.deleted_at = deleted_at;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}

	public String getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}
	
	
	
}
