package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Person;

public class PersonTableModel extends AbstractTableModel {
	private List<Person> db;
	private String[] colNames = { "ID", "Name", "Occupation", "Gender", "TaxId", "EmpCategory", "AgeCategory" };

	public PersonTableModel() {
		// TODO Auto-generated constructor stub
	}

	public void setData(List<Person> db) {
		this.db = db;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return db.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Person person = db.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return person.getId();
		case 1:
			return person.getName();
		case 2:
			return person.getOccupation();
		case 3:
			return person.getGender();
		case 4:
			return person.getTaxId();
		case 5:
			return person.getEmpCategory();
		case 6:
			return person.getAgeCategory();
		}
		return null;
	}

}
