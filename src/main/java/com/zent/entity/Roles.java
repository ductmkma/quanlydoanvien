package com.zent.entity;

public class Roles {
	private Long id;
	private String name;
	private String display_name;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	private String description;
	
	public Roles() {
		super();
	}
	
	public Roles(String name, String display_name, String created_at,
			String description) {
		super();
		this.name = name;
		this.display_name = display_name;
		this.created_at = created_at;
		this.description = description;
	}

	public Roles(Long id, String name, String display_name, String updated_at,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.display_name = display_name;
		this.updated_at = updated_at;
		this.description = description;
	}

	public Roles(Long id, String name, String display_name, String created_at,
			String updated_at, String deleted_at, String description) {
		super();
		this.id = id;
		this.name = name;
		this.display_name = display_name;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.description = description;
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

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	
	
	
}
