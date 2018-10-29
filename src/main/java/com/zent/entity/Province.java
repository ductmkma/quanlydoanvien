package com.zent.entity;

public class Province {
	private String provinceId;
	private String name;
	private String type;
	
	public Province() {
		super();
	}

	public Province(String provinceId, String name, String type) {
		super();
		this.provinceId = provinceId;
		this.name = name;
		this.type = type;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
