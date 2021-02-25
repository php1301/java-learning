package gui;
import java.util.EventObject;

public class FormEvent extends EventObject {

//	source raiseEvent - this case is FormPanel - okBtn
	// store information
	private String name;
	private String occupation;
	private int ageCategory;
	private String empCategory;
	private boolean usCitizen;
	private String taxId;
	private String gender;

	// constructor de lay data
	public FormEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	// constructor de truyen data
	public FormEvent(Object source, String name, String occupation, int ageCategory, String empCategory,
			boolean usCitizen, String taxId, String gender) {
		super(source);
		// TODO Auto-generated constructor stub
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = ageCategory;
		this.empCategory = empCategory;
		this.usCitizen = usCitizen;
		this.taxId = taxId;
		this.gender = gender;
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

	public int getAgeCateogry() {
		return ageCategory;
	}

	public String getEmpCategory() {
		return empCategory;
	}

	public boolean getIsUsCitizen() {
		return usCitizen;
	}

	public String getTaxId() {
		return taxId;
	}

	public String getGender() {
		return gender;
	}

}