package com.zent.entity;

public class BonuosDiscipline {
	private Long id;
	private int type;
	private String code_unionist;
	private Long units_id;
	private String content;
	private String date;
	private String number_decision;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	
	public BonuosDiscipline() {
		super();
	}
	public BonuosDiscipline(int type, String code_unionist, Long units_id,
			String content, String date, String number_decision,
			String created_at) {
		super();
		this.type = type;
		this.code_unionist = code_unionist;
		this.units_id = units_id;
		this.content = content;
		this.date = date;
		this.number_decision = number_decision;
		this.created_at = created_at;
	}
	public BonuosDiscipline(Long id, int type, String code_unionist,
			Long units_id, String content, String date, String number_decision,
			String created_at, String updated_at, String deleted_at) {
		super();
		this.id = id;
		this.type = type;
		this.code_unionist = code_unionist;
		this.units_id = units_id;
		this.content = content;
		this.date = date;
		this.number_decision = number_decision;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNumber_decision() {
		return number_decision;
	}

	public void setNumber_decision(String number_decision) {
		this.number_decision = number_decision;
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
