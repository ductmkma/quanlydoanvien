package com.zent.entity;

public class InputMoney {
	private Long id;
	private String code;
	private String content;
	private Long money;
	private String sender;
	private String date;
	private Long units_id;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	
	public InputMoney() {
		super();
	}
	
	public InputMoney(Long id, String deleted_at) {
		super();
		this.id = id;
		this.deleted_at = deleted_at;
	}

	public InputMoney(Long id, String content, Long money, String sender,
			String date, String updated_at) {
		super();
		this.id = id;
		this.content = content;
		this.money = money;
		this.sender = sender;
		this.date = date;
		this.updated_at = updated_at;
	}

	public InputMoney(String code, String content, Long money, String sender,
			String date, Long units_id, String created_at) {
		super();
		this.code = code;
		this.content = content;
		this.money = money;
		this.sender = sender;
		this.date = date;
		this.units_id = units_id;
		this.created_at = created_at;
	}

	public InputMoney(Long id, String code, String content, Long money,
			String sender, String date, Long units_id, String created_at,
			String updated_at, String deleted_at) {
		super();
		this.id = id;
		this.code = code;
		this.content = content;
		this.money = money;
		this.sender = sender;
		this.date = date;
		this.units_id = units_id;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getUnits_id() {
		return units_id;
	}

	public void setUnits_id(Long units_id) {
		this.units_id = units_id;
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
