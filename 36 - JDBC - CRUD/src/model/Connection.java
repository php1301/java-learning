package model;

import java.sql.SQLException;

public class Connection {
	public static void main(String[] args) {
		System.out.println("Running database test");

		Database db = new Database();
		try {
			db.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.addPerson(
				new Person("Phuctest", "Dev", AgeCategory.adult, EmploymentCategory.unemployed, false, "123", Gender.male));
		db.addPerson(
				new Person("Pham1301", "Dev", AgeCategory.senior, EmploymentCategory.employed, false, "456", Gender.male));
		db.addPerson(
				new Person("Hoang", "Dev", AgeCategory.child, EmploymentCategory.selfemployed, false, "789", Gender.male));
		try {
			db.save();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			db.load();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.disconnect();
	}
}
