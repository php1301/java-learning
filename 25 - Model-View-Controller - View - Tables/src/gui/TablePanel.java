package gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Person;

public class TablePanel extends JPanel {
	private JTable table;
	private PersonTableModel personTableModel;
	
	public TablePanel() {
		personTableModel = new PersonTableModel();
		table = new JTable(personTableModel);
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void setData(List<Person> db) {
		personTableModel.setData(db);
	}
	
	public void refresh() {
		personTableModel.fireTableDataChanged();
	}
}
