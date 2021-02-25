package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Person;

public class TablePanel extends JPanel {
	private JTable table;
	private PersonTableModel personTableModel;
	private JPopupMenu popup;
	
	public TablePanel() {
		personTableModel = new PersonTableModel();
		table = new JTable(personTableModel);
		popup = new JPopupMenu();
		
		JMenuItem removeItem = new JMenuItem("Delete Row");
		popup.add(removeItem);
		
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				// chon row - set UI
				table.getSelectionModel().setSelectionInterval(row, row);;
				// TODO Auto-generated method stub
				if(e.getButton() == MouseEvent.BUTTON3) {
					popup.show(table, e.getX(), e.getY());
				}
			}
			
		});
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
		
//		Xoa row
		removeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
			}
		});
	}
	
	public void setData(List<Person> db) {
		personTableModel.setData(db);
	}
	
	public void refresh() {
		personTableModel.fireTableDataChanged();
	}
}
