package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogTemplateSearchAndDelete extends DialogTemplate {
	protected final String [] TYPESOFPERMITS = {"------", "По болезни", "По другим причинам", 
			"Без уважительной причины"};
	protected String cause;
	
	protected JPanel jp = new JPanel();
	
	protected final JLabel KIND = new JLabel("  Kind");
	protected final JLabel SICKNESS = new JLabel("  Absences due to illness (min/max): ");
	protected final JLabel OTHERCAUSES = new JLabel("  Absences for other reasons (min/max): ");
	protected final JLabel WITHOUTGOODREASON = new JLabel("  Unexcused absence (min/max): ");
	
	protected JTextField sicknessMin = new JTextField(6);
	protected JTextField sicknessMax = new JTextField(6);
	protected JTextField otherCausesMin = new JTextField(6);
	protected JTextField otherCausesMax = new JTextField(6);
	protected JTextField withoutGoodReasonMin = new JTextField(6);
	protected JTextField withoutGoodReasonMax = new JTextField(6);
	
	JComboBox jcb = new JComboBox(TYPESOFPERMITS);
	
	DialogTemplateSearchAndDelete(String str, MyFrame mf) {
		super(str, mf);
		jp.add(FIO);
		jp.add(fio);
		jp.add(NUMBERGRUP);
		jp.add(numberGrup);
		jp.add(KIND);
		
		jcb.setMaximumSize(jcb.getPreferredSize());
		jcb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JComboBox box = (JComboBox) arg0.getSource();
				try {
					cause = (String)box.getSelectedItem();
				} catch(Exception e) {
					System.err.println("Неверно выбрана болезнь!");
				}
			}
		});
		
		jp.add(jcb);
		
		JPanel jp2 = new JPanel();
		jp.add(SICKNESS);
		jp2.add(sicknessMin);
		jp2.add(sicknessMax);
		jp.add(jp2);
		jp2 = new JPanel();
		jp.add(OTHERCAUSES);
		jp2.add(otherCausesMin);
		jp2.add(otherCausesMax);
		jp.add(jp2);
		jp2 = new JPanel();
		jp.add(WITHOUTGOODREASON);
		jp2.add(withoutGoodReasonMin);
		jp2.add(withoutGoodReasonMax);
		jp.add(jp2);
	}
	
	public String getCause() {
		return cause;
	}
	
	public String getSicknessMin() {
		return sicknessMin.getText();
	}
	
	public String getSicknessMax() {
		return sicknessMax.getText();
	}
	
	public String getOtherCausesMin() {
		return otherCausesMin.getText();
	}
	
	public String getOtherCausesMax() {
		return otherCausesMax.getText();
	}
	
	public String getWithoutGoodReasonMin() {
		return withoutGoodReasonMin.getText();
	}
	
	public String getWithoutGoodReasonMax() {
		return withoutGoodReasonMax.getText();
	}
	
	public void setSicknessMin(String str) {
		sicknessMin.setText(str);
	}
	
	public void setSicknessMax(String str) {
		sicknessMax.setText(str);
	}
	
	public void setOtherCausesMin(String str) {
		otherCausesMin.setText(str);
	}
	
	public void setOtherCausesMax(String str) {
		otherCausesMax.setText(str);
	}
	
	public void setWithoutGoodReasonMin(String str) {
		withoutGoodReasonMin.setText(str);
	}
	
	public void setWithoutGoodReasonMax(String str) {
		withoutGoodReasonMax.setText(str);
	}
	
	public JComboBox getCombo() {
		return jcb;
	}
	
	public JTextField getTextFieldSicknessMin() {
		return sicknessMin;
	}
	
	public JTextField getTextFieldSicknessMax() {
		return sicknessMax;
	}
	
	public JTextField getTextFieldOtherCausesMin() {
		return otherCausesMin;
	}
	
	public JTextField getTextFieldOtherCausesMax() {
		return otherCausesMax;
	}
	
	public JTextField getTextFieldwithoutGoodReasonMin() {
		return withoutGoodReasonMin;
	}
	
	public JTextField getTextFieldwithoutGoodReasonMax() {
		return withoutGoodReasonMax;
	}
}
