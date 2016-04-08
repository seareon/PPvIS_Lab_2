package View;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.Student;
import Model.StudentsData;

public class DialogTemplate extends JDialog {
	protected MyFrame frame;
	
	protected final JLabel FIO = new JLabel("  FIO");
	protected final JLabel NUMBERGRUP = new JLabel("  Grup");
	
	protected JTextField fio = new JTextField(40);
	protected JTextField numberGrup = new JTextField(6);
	
	
	DialogTemplate(String str, MyFrame frame) {
		super(frame, str, true);
		this.frame = frame;
	}

	public String getFio() {
		return fio.getText();
	}
	
	public void setFio(String str) {
		fio.setText(str);
	}
	
	public String getNumberGrup() {
		return numberGrup.getText();
	}
	
	public void setNumberGrup(String str) {
		numberGrup.setText(str);
	}
	
	public MyFrame getFrame() {
		return frame;
	}
	
	public MyTable getTable() {
		return frame.getTable();
	}
	
	public StudentsData getStudentsData() {
		return frame.getStudentsData();
	}
	
	public void setTable(List<Student> ls) {
		frame.setTable(ls);
		frame.getTable().newTable();
	}
	
	public JTextField getTextFieldFio() {
		return fio;
	}
	
	public JTextField getTextFieldNumberGrup() {
		return numberGrup ;
	}
}
