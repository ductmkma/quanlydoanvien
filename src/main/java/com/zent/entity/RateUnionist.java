package com.zent.entity;

public class RateUnionist {
	private Long id;
	private String code_unionist;
	private Long units_id;
	private String year;
	private int rate_id;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	
	public RateUnionist() {
		super();
	}
	
	public RateUnionist(String code_unionist, Long units_id, String year,
			int rate_id, String created_at) {
		super();
		this.code_unionist = code_unionist;
		this.units_id = units_id;
		this.year = year;
		this.rate_id = rate_id;
		this.created_at = created_at;
	}
	

	public RateUnionist(String code_unionist, String year, int rate_id,
			String updated_at) {
		super();
		this.code_unionist = code_unionist;
		this.year = year;
		this.rate_id = rate_id;
		this.updated_at = updated_at;
	}

	public RateUnionist(Long id, String code_unionist, Long units_id,
			String year, int rate_id, String created_at, String updated_at,
			String deleted_at) {
		super();
		this.id = id;
		this.code_unionist = code_unionist;
		this.units_id = units_id;
		this.year = year;
		this.rate_id = rate_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode_unionist() {
		return code_unionist;
	}

	public void setCode_unionist(String code_unionist) {
		this.code_unionist = code_unionist;
	}

	public Long getUnits_id() {
		return units_id;
	}

	public void setUnits_id(Long units_id) {
		this.units_id = units_id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getRate_id() {
		return rate_id;
	}

	public void setRate_id(int rate_id) {
		this.rate_id = rate_id;
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
