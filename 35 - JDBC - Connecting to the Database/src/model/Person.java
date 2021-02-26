package model;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2499698455192276415L;
	private static int count = 0;
	private int id;
	private String name;
	private String occupation;
	private AgeCategory ageCategory;
	private EmploymentCategory empCategory;
	private boolean usCitizen;
	private String taxId;
	private Gender gender;

	public Person(String name, String occupation, AgeCategory ageCategory, EmploymentCategory empCategory,
			boolean usCitizen, String taxId, Gender gender) {
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = ageCategory;
		this.empCategory = empCategory;
		this.usCitizen = usCitizen;
		this.taxId = taxId;
		this.gender = gender;
		count++;
		this.id = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public AgeCategory getAgeCategory() {
		return ageCategory;
	}

	public void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}

	public EmploymentCategory getEmpCategory() {
		return empCategory;
	}

	public void setEmpCategory(EmploymentCategory empCategory) {
		this.empCategory = empCategory;
	}

	public boolean isUsCitizen() {
		return usCitizen;
	}

	public void setUsCitizen(boolean usCitizen) {
		this.usCitizen = usCitizen;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}


}

