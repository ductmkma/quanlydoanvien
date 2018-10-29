package com.zent.entity;

public class Town {
	private String townId;
	private String name;
	private String type;
	private String location;
	private String districtId;
	
	public Town() {
		super();
	}

	public Town(String townId, String name, String type, String location,
			String districtId) {
		super();
		this.townId = townId;
		this.name = name;
		this.type = type;
		this.location = location;
		this.districtId = districtId;
	}

	public String getTownId() {
		return townId;
	}

	public void setTownId(String townId) {
		this.townId = townId;
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

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
	
	
	
}
