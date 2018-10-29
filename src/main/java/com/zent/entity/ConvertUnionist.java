package com.zent.entity;

public class ConvertUnionist {
	private Long id;
	private String code_unionist;
	private String name_unionist;
	private Long units_id_old;
	private String units_name_old;
	private Long units_id_new;
	private String units_name_new;
	private String date_in;
	private String date_out;
	private int status;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	
	public ConvertUnionist() {
		super();
	}
	
	
	
	public ConvertUnionist(String code_unionist, Long units_id_old,
			Long units_id_new, String units_name_new, String date_in,
			int status, String created_at) {
		super();
		this.code_unionist = code_unionist;
		this.units_id_old = units_id_old;
		this.units_id_new = units_id_new;
		this.units_name_new = units_name_new;
		this.date_in = date_in;
		this.status = status;
		this.created_at = created_at;
	}



	public ConvertUnionist(Long id, Long units_id_new, String units_name_new,
			String date_in, int status, String updated_at) {
		super();
		this.id = id;
		this.units_id_new = units_id_new;
		this.units_name_new = units_name_new;
		this.date_in = date_in;
		this.status = status;
		this.updated_at = updated_at;
	}
	

	public ConvertUnionist(String code_unionist, Long units_id_new,
			String updated_at) {
		super();
		this.code_unionist = code_unionist;
		this.units_id_new = units_id_new;
		this.updated_at = updated_at;
	}



	public ConvertUnionist(String date_out, int status, String updated_at) {
		super();
		this.date_out = date_out;
		this.status = status;
		this.updated_at = updated_at;
	}



	public ConvertUnionist(String code_unionist, Long units_id_old,
			Long units_id_new, String units_name_new, int status,
			String created_at) {
		super();
		this.code_unionist = code_unionist;
		this.units_id_old = units_id_old;
		this.units_id_new = units_id_new;
		this.units_name_new = units_name_new;
		this.status = status;
		this.created_at = created_at;
	}



	public ConvertUnionist(String code_unionist, String date_out, int status,
			String updated_at) {
		super();
		this.code_unionist = code_unionist;
		this.date_out = date_out;
		this.status = status;
		this.updated_at = updated_at;
	}



	public ConvertUnionist(Long id, String code_unionist, String name_unionist,
			Long units_id_old, String units_name_old, Long units_id_new,
			String units_name_new, String date_in, String date_out, int status,
			String created_at, String updated_at, String deleted_at) {
		super();
		this.id = id;
		this.code_unionist = code_unionist;
		this.name_unionist = name_unionist;
		this.units_id_old = units_id_old;
		this.units_name_old = units_name_old;
		this.units_id_new = units_id_new;
		this.units_name_new = units_name_new;
		this.date_in = date_in;
		this.date_out = date_out;
		this.status = status;
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

	public Long getUnits_id_old() {
		return units_id_old;
	}

	public void setUnits_id_old(Long units_id_old) {
		this.units_id_old = units_id_old;
	}

	public Long getUnits_id_new() {
		return units_id_new;
	}

	public void setUnits_id_new(Long units_id_new) {
		this.units_id_new = units_id_new;
	}

	public String getDate_in() {
		return date_in;
	}

	public void setDate_in(String date_in) {
		this.date_in = date_in;
	}

	public String getDate_out() {
		return date_out;
	}

	public void setDate_out(String date_out) {
		this.date_out = date_out;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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



	public String getName_unionist() {
		return name_unionist;
	}



	public void setName_unionist(String name_unionist) {
		this.name_unionist = name_unionist;
	}



	public String getUnits_name_old() {
		return units_name_old;
	}



	public void setUnits_name_old(String units_name_old) {
		this.units_name_old = units_name_old;
	}



	public String getUnits_name_new() {
		return units_name_new;
	}



	public void setUnits_name_new(String units_name_new) {
		this.units_name_new = units_name_new;
	}
	
	
	
	
	
	
}
