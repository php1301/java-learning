package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import java.sql.Connection;

public class Database {
	private List<Person> people;
	private Connection con;

	public Database() {
		people = new LinkedList<Person>();
	}

	public void connect() throws Exception {
		if (con != null)
			return;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new Exception("Driver not found");
		}

		String url = "jdbc:mysql://localhost:3306/swingtest";
		con = DriverManager.getConnection(url, "root", "pinodien");
		System.out.println("Connected" + con);
	}

	public void disconnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Can't close connection");
			}
		}
	}

	public void save() {
		String checkSql = "select count(*) as count from person where id=?";
		String insertSql = "insert into person(id, name, occupation, age, employment_status, tax_id, us_citizen, gender) values(?, ?, ?, ?, ?, ?, ?, ?)";
		String updateSql = "update person set name=?, occupation=?, age=?, employment_status=?, tax_id=?, us_citizen=?, gender=? where id=?";
		try {
			PreparedStatement checkStatement = con.prepareStatement(checkSql);
			PreparedStatement insertStatement = con.prepareStatement(insertSql);
			PreparedStatement updateStatement = con.prepareStatement(updateSql);
			for (Person person : people) {
				int id = person.getId();
				String name = person.getName();
				String occupation = person.getOccupation();
				AgeCategory age = person.getAgeCategory();
				EmploymentCategory empCat = person.getEmpCategory();
				String tax = person.getTaxId();
				boolean isUs = person.isUsCitizen();
				Gender gender = person.getGender();

				checkStatement.setInt(1, id);
				ResultSet checkResult = checkStatement.executeQuery();
				checkResult.next();
//				lay column 1
				int count = checkResult.getInt(1);
				if (count == 0) {
					System.out.println("Inserting person");
					int col = 1;
					insertStatement.setInt(col++, id);
					insertStatement.setString(col++, name);
					insertStatement.setString(col++, occupation);
					insertStatement.setString(col++, age.name());
					insertStatement.setString(col++, empCat.name());
					insertStatement.setString(col++, tax);
					insertStatement.setBoolean(col++, isUs);
					insertStatement.setString(col++, gender.name());

					insertStatement.executeUpdate();

				} else {
					System.out.println("Updating person with ID " + id);
					int col = 1;
					updateStatement.setString(col++, name);
					updateStatement.setString(col++, occupation);
					updateStatement.setString(col++, age.name());
					updateStatement.setString(col++, empCat.name());
					updateStatement.setString(col++, tax);
					updateStatement.setBoolean(col++, isUs);
					updateStatement.setString(col++, gender.name());
					updateStatement.setInt(col++, id);

					updateStatement.executeUpdate();
				}
				System.out.println("Count for person with ID " + id + " is" + count);
			}
			insertStatement.close();
			updateStatement.close();
			checkStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void load() throws SQLException {
		people.clear();
		String sql = "Select * from person order by id";
		Statement selectStatement = con.createStatement();
		ResultSet results = selectStatement.executeQuery(sql);

		while (results.next()) {
			int id = results.getInt("id");
			String name = results.getString("name");
			String occupation = results.getString("occupation");
			String age = results.getString("age");
			String emp = results.getString("employment_status");
			String tax = results.getString("tax_id");
			boolean isUs = results.getBoolean("us_citizen");
			String gender = results.getString("gender");
			Person person = new Person(id, name, occupation, AgeCategory.valueOf(age), EmploymentCategory.valueOf(emp), isUs,
					tax, Gender.valueOf(gender));
			people.add(person);
			System.out.println(person);
		}
		results.close();
		selectStatement.close();
	}

	public void addPerson(Person p) {
		people.add(p);
	}

	public void removePerson(int index) {
		people.remove(index);
	}

	public List<Person> getPeople() {
		return Collections.unmodifiableList(people);
	}

	public void saveToFile(File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		Person[] persons = people.toArray(new Person[people.size()]);

		oos.writeObject(persons);
		oos.close();
	}

	public void loadFromFile(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);

		try {
			Person[] persons = (Person[]) ois.readObject();
			people.clear();
			people.addAll(Arrays.asList(persons));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ois.close();
	}
}
