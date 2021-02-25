package controller;

import gui.FormEvent;
import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Gender;
import model.Person;

public class Controller {
	Database db = new Database();

	public void addPerson(FormEvent e) {
		String name = e.getName();
		String occupation = e.getOccupation();
		int ageCatId = e.getAgeCateogry();
		String empCat = e.getEmpCategory();
		String gender = e.getGender();
//		textPanel.appendText(name + ": " + occupation + "- ageCat " + ageCat + " Employment" + empCat
//				+ " Gender" + gender + "\n");

		// resolve ENUM
		AgeCategory ageCategory = null;
		switch (ageCatId) {
		case 0:
			ageCategory = ageCategory.child;
			break;
		case 1:
			ageCategory = ageCategory.adult;
			break;
		case 2:
			ageCategory = ageCategory.senior;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + ageCatId);
		}

		EmploymentCategory empCategory = null;

		if (empCat.equals("employed")) {
			empCategory = empCategory.employed;
		}
		if (empCat.equals("self-employed")) {
			empCategory = empCategory.selfemployed;
		}
		if (empCat.equals("unemployed")) {
			empCategory = empCategory.unemployed;
		} else {
			empCategory = empCategory.other;
			System.out.println(empCat);
		}

		Gender genderCat = null;
		if (gender.equals("male")) {
			genderCat = genderCat.male;
		}
		if (gender.equals("female")) {
			genderCat = genderCat.female;
		}

		Person person = new Person(name, occupation, ageCategory, empCategory, false, gender, null);

	}
}
