package com.zent.entity;

public class District {
	private String districtId;
	private String name;
	private String type;
	private String location;
	private String provinceId;
	
	public District() {
		super();
	}

	public District(String districtId, String name, String type,
			String location, String provinceId) {
		super();
		this.districtId = districtId;
		this.name = name;
		this.type = type;
		this.location = location;
		this.provinceId = provinceId;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	
	
}
