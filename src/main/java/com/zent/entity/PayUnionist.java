package com.zent.entity;

public class PayUnionist {
	private Long unionist_id;
	private int month;
	private int status;
	private int year;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	
	public PayUnionist() {
		super();
	}

	public PayUnionist(Long unionist_id, int month, int status, int year,
			String created_at) {
		super();
		this.unionist_id = unionist_id;
		this.month = month;
		this.status = status;
		this.year = year;
		this.created_at = created_at;
	}

	public PayUnionist(Long unionist_id, int month, int status, int year,
			String created_at, String updated_at) {
		super();
		this.unionist_id = unionist_id;
		this.month = month;
		this.status = status;
		this.year = year;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public PayUnionist(Long unionist_id, int month, int status, int year,
			String created_at, String updated_at, String deleted_at) {
		super();
		this.unionist_id = unionist_id;
		this.month = month;
		this.status = status;
		this.year = year;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}

	public Long getUnionist_id() {
		return unionist_id;
	}

	public void setUnionist_id(Long unionist_id) {
		this.unionist_id = unionist_id;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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
	
	
	
	
}
