package com.zent.entity;

public class Units {
	private long id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String createdAt;
	private String updatedAt;
	private String deletedAt;
	private long parentId;
	private int typeUnit;

	public Units() {
		super();
	}

	

	public Units(long parentId, int typeUnit) {
		super();
		this.parentId = parentId;
		this.typeUnit = typeUnit;
	}



	public Units(long id, String deletedAt) {
		super();
		this.id = id;
		this.deletedAt = deletedAt;
	}

	public Units(long id,String name, String address, String phone, String email,
			String updatedAt, int typeUnit) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.updatedAt = updatedAt;
		this.typeUnit = typeUnit;
	}



	public Units(String name, String address, String phone, String email,
			String createdAt, long parentId,int typeUnit) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.createdAt = createdAt;
		this.parentId = parentId;
		this.typeUnit = typeUnit;
	}

	

	public Units(long id, String name, String address, String phone,
			String email, String createdAt, String updatedAt, String deletedAt,
			long parentId, int typeUnit) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.parentId = parentId;
		this.typeUnit = typeUnit;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}



	public String getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}



	public String getDeletedAt() {
		return deletedAt;
	}



	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}



	public long getParentId() {
		return parentId;
	}



	public void setParentId(long parentId) {
		this.parentId = parentId;
	}



	public int getTypeUnit() {
		return typeUnit;
	}



	public void setTypeUnit(int typeUnit) {
		this.typeUnit = typeUnit;
	}
	


	

}
