package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Student;
import Model.StudentsData;

public class AddDialog extends DialogTemplate {	
	protected final JLabel SICKNESS = new JLabel("  Пропуски по болезни: ");
	protected final JLabel OTHERCAUSES = new JLabel("  Пропуски по другим причинам: ");
	protected final JLabel WITHOUTGOODREASON = new JLabel("  Пропуски без уважительной причины: ");
	
	protected JTextField sickness = new JTextField(6);
	protected JTextField otherCauses = new JTextField(6);
	protected JTextField withoutGoodReason = new JTextField(6);
	
	public AddDialog(MyFrame frame) {
		super("Add person", frame);
		JPanel jp = new JPanel(); 
		jp.setLayout(new GridLayout(5,2));
		jp.add(FIO);
		jp.add(fio);
		jp.add(NUMBERGRUP);
		jp.add(numberGrup);
		jp.add(SICKNESS);
		jp.add(sickness);
		jp.add(OTHERCAUSES);
		jp.add(otherCauses);
		jp.add(WITHOUTGOODREASON);
		jp.add(withoutGoodReason);
		this.setLayout(new BorderLayout());
		this.add(jp,BorderLayout.CENTER);
		JButton add = new JButton("Add");
		add.addActionListener(new MyAdd(this));
		jp = new JPanel();
		jp.add(add);
		this.add(jp, BorderLayout.SOUTH); 
		setResizable (false);
		this.setSize(600, 300);
		this.setLocationRelativeTo(frame);
		this.setVisible(true); 
	}
	
	public String getSickness() {
		return sickness.getText();
	}
	
	public String getOtherCauses() {
		return otherCauses.getText();
	}
	
	public String getWithoutGoodReason() {
		return withoutGoodReason.getText();
	}
	
	public void setSickness(String str) {
		sickness.setText(str);
	}
	
	public void setOtherCauses(String str) {
		otherCauses.setText(str);
	}
	
	public void setWithoutGoodReason(String str) {
		withoutGoodReason.setText(str);
	}
}
