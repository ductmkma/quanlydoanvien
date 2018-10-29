package com.zent.entity;

public class Unionist {
	private Long id;
	private String code;
	private String avata;
	private String name;
	private String birthday;
	private String gender;
	private String email;
	private String phone;
	private String password;
	private String home_town;
	private String provinceId;
	private String provinceName;
	private String districtId;
	private String districtName;
	private String townId;
	private String townName;
	private String village;
	private String nation;
	private String religion;
	private String academic_level;
	private String qualification;
	private String political_theory;
	private String code_unionist;
	private String day_on_unionist;
	private String address_on_unionist;
	private String competence;
	private String day_on_party;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	private Long units_id;
	private String units_name;
	private Long role_id;
	private String role_display_name;
	
	
	
	

	public Unionist() {
		super();
	}
	
	public Unionist(String code, String deleted_at) {
		super();
		this.code = code;
		this.deleted_at = deleted_at;
	}
	
	
	

	public Unionist(String code, String email, String password) {
		super();
		this.code = code;
		this.email = email;
		this.password = password;
	}
	
	

	public Unionist(String code, String avata, String name, String birthday,
			String gender, String email, String phone, String home_town,
			String provinceId, String districtId, String townId,
			String village, String nation, String religion,
			String academic_level, String qualification,
			String political_theory, String day_on_unionist,
			String address_on_unionist, String competence, String day_on_party,
			String updated_at) {
		super();
		this.code = code;
		this.avata = avata;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.home_town = home_town;
		this.provinceId = provinceId;
		this.districtId = districtId;
		this.townId = townId;
		this.village = village;
		this.nation = nation;
		this.religion = religion;
		this.academic_level = academic_level;
		this.qualification = qualification;
		this.political_theory = political_theory;
		this.day_on_unionist = day_on_unionist;
		this.address_on_unionist = address_on_unionist;
		this.competence = competence;
		this.day_on_party = day_on_party;
		this.updated_at = updated_at;
	}

	public Unionist(String code, String avata, String name, String birthday,
			String gender, String email, String phone, String home_town,
			String provinceId, String districtId, String townId, String village,
			String nation, String religion, String academic_level,
			String qualification, String political_theory,
			String code_unionist, String day_on_unionist,
			String address_on_unionist, String competence, String day_on_party,
			String created_at, Long units_id, Long role_id) {
		super();
		this.code = code;
		this.avata = avata;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.home_town = home_town;
		this.provinceId = provinceId;
		this.districtId = districtId;
		this.townId = townId;
		this.village = village;
		this.nation = nation;
		this.religion = religion;
		this.academic_level = academic_level;
		this.qualification = qualification;
		this.political_theory = political_theory;
		this.code_unionist = code_unionist;
		this.day_on_unionist = day_on_unionist;
		this.address_on_unionist = address_on_unionist;
		this.competence = competence;
		this.day_on_party = day_on_party;
		this.created_at = created_at;
		this.units_id = units_id;
		this.role_id = role_id;
	}




	public Unionist(Long id, String code, String avata, String name,
			String birthday, String gender, String email, String phone,
			String password, String home_town, String provinceId,
			String districtId, String townId, String village, String nation,
			String religion, String academic_level, String qualification,
			String political_theory, String code_unionist,
			String day_on_unionist, String address_on_unionist,
			String competence, String day_on_party, String created_at,
			String updated_at, String deleted_at, Long units_id, Long role_id) {
		super();
		this.id = id;
		this.code = code;
		this.avata = avata;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.home_town = home_town;
		this.provinceId = provinceId;
		this.districtId = districtId;
		this.townId = townId;
		this.village = village;
		this.nation = nation;
		this.religion = religion;
		this.academic_level = academic_level;
		this.qualification = qualification;
		this.political_theory = political_theory;
		this.code_unionist = code_unionist;
		this.day_on_unionist = day_on_unionist;
		this.address_on_unionist = address_on_unionist;
		this.competence = competence;
		this.day_on_party = day_on_party;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.units_id = units_id;
		this.role_id = role_id;
	}
	

	public Unionist(Long id, String code, String avata, String name,
			String birthday, String gender, String email, String phone,
			String password, String home_town, String provinceId,
			String provinceName, String districtId, String districtName,
			String townId, String townName, String village, String nation,
			String religion, String academic_level, String qualification,
			String political_theory, String code_unionist,
			String day_on_unionist, String address_on_unionist,
			String competence, String day_on_party, String created_at,
			String updated_at, String deleted_at, Long units_id,
			String units_name, Long role_id, String role_display_name) {
		super();
		this.id = id;
		this.code = code;
		this.avata = avata;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.home_town = home_town;
		this.provinceId = provinceId;
		this.provinceName = provinceName;
		this.districtId = districtId;
		this.districtName = districtName;
		this.townId = townId;
		this.townName = townName;
		this.village = village;
		this.nation = nation;
		this.religion = religion;
		this.academic_level = academic_level;
		this.qualification = qualification;
		this.political_theory = political_theory;
		this.code_unionist = code_unionist;
		this.day_on_unionist = day_on_unionist;
		this.address_on_unionist = address_on_unionist;
		this.competence = competence;
		this.day_on_party = day_on_party;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.units_id = units_id;
		this.units_name = units_name;
		this.role_id = role_id;
		this.role_display_name = role_display_name;
	}

	public Unionist(String code, String name, String email, String created_at,
			Long role_id, String role_display_name) {
		super();
		this.code = code;
		this.name = name;
		this.email = email;
		this.created_at = created_at;
		this.role_id = role_id;
		this.role_display_name = role_display_name;
	}
	

	public Unionist(Long id, Long role_id) {
		super();
		this.id = id;
		this.role_id = role_id;
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
	public String getAvata() {
		return avata;
	}
	public void setAvata(String avata) {
		this.avata = avata;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHome_town() {
		return home_town;
	}
	public void setHome_town(String home_town) {
		this.home_town = home_town;
	}
	
	public String getProvinceId() {
		return provinceId;
	}


	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}


	public String getDistrictId() {
		return districtId;
	}
	


	public String getRole_display_name() {
		return role_display_name;
	}

	public void setRole_display_name(String role_display_name) {
		this.role_display_name = role_display_name;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}


	public String getTownId() {
		return townId;
	}


	public void setTownId(String townId) {
		this.townId = townId;
	}


	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getAcademic_level() {
		return academic_level;
	}
	public void setAcademic_level(String academic_level) {
		this.academic_level = academic_level;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getPolitical_theory() {
		return political_theory;
	}
	public void setPolitical_theory(String political_theory) {
		this.political_theory = political_theory;
	}
	public String getCode_unionist() {
		return code_unionist;
	}
	public void setCode_unionist(String code_unionist) {
		this.code_unionist = code_unionist;
	}
	public String getDay_on_unionist() {
		return day_on_unionist;
	}
	public void setDay_on_unionist(String day_on_unionist) {
		this.day_on_unionist = day_on_unionist;
	}
	public String getAddress_on_unionist() {
		return address_on_unionist;
	}
	public void setAddress_on_unionist(String address_on_unionist) {
		this.address_on_unionist = address_on_unionist;
	}
	public String getCompetence() {
		return competence;
	}
	public void setCompetence(String competence) {
		this.competence = competence;
	}
	public String getDay_on_party() {
		return day_on_party;
	}
	public void setDay_on_party(String day_on_party) {
		this.day_on_party = day_on_party;
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
	public Long getUnits_id() {
		return units_id;
	}
	public void setUnits_id(Long units_id) {
		this.units_id = units_id;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public String getUnits_name() {
		return units_name;
	}

	public void setUnits_name(String units_name) {
		this.units_name = units_name;
	}


	public String getProvinceName() {
		return provinceName;
	}


	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}


	public String getDistrictName() {
		return districtName;
	}


	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}


	public String getTownName() {
		return townName;
	}


	public void setTownName(String townName) {
		this.townName = townName;
	}

	
	
	
	
	
	
}
