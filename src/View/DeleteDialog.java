package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.MyDelete;

public class DeleteDialog extends JDialog {
	private MyFrame frame;
	private final String [] TYPESOFPERMITS = {"------", "�� �������", "�� ������ ��������", "��� ������������ �������"};
	private String cause;
	
	private final JLabel FIO = new JLabel("  FIO");
	private final JLabel NUMBERGRUP = new JLabel("  Grup");
	private final JLabel KIND = new JLabel("  Kind");
	private final JLabel SICKNESS = new JLabel("  Absences due to illness (min/max): ");
	private final JLabel OTHERCAUSES = new JLabel("  Absences for other reasons (min/max): ");
	private final JLabel WITHOUTGOODREASON = new JLabel("  Unexcused absence (min/max): ");
	
	private JTextField fio = new JTextField(40);
	private JTextField numberGrup = new JTextField(6);
	private JTextField sicknessMin = new JTextField(6);
	private JTextField sicknessMax = new JTextField(6);
	private JTextField otherCausesMin = new JTextField(6);
	private JTextField otherCausesMax = new JTextField(6);
	private JTextField withoutGoodReasonMin = new JTextField(6);
	private JTextField withoutGoodReasonMax = new JTextField(6);
	
	JComboBox jcb = new JComboBox(TYPESOFPERMITS);
	
	JButton del;
	
	public DeleteDialog(MyFrame frame) {
		super(frame, "Delete person", true);
		this.frame = frame;
		JPanel jp = new JPanel(); 
		jp.setLayout(new GridLayout(6,2));
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
					System.err.println("������� ������� �������!");
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
		
		this.add(jp,BorderLayout.CENTER);
		
		jp = new JPanel();
		del = new JButton("delete");
		del.addActionListener(new MyDelete(this));
		jp.add(del);
		
		this.add(jp,BorderLayout.SOUTH);
		this.setSize(600, 300);
		this.setLocationRelativeTo(frame);
		this.setVisible(true); 
	}
	
	public JTextField getFio() {
		return fio;
	}
	
	public JTextField getNumberGrup() {
		return numberGrup;
	}
	
	public String getCause() {
		return cause;
	}
	
	public MyFrame getFrame() {
		return frame;
	}
	
	public JTextField getSicknessMin() {
		return sicknessMin;
	}
	
	public JTextField getSicknessMax() {
		return sicknessMax;
	}
	
	public JTextField getOtherCausesMin() {
		return otherCausesMin;
	}
	
	public JTextField getOtherCausesMax() {
		return otherCausesMax;
	}
	
	public JTextField getWithoutGoodReasonMin() {
		return withoutGoodReasonMin;
	}
	
	public JTextField getWithoutGoodReasonMax() {
		return withoutGoodReasonMax;
	}
	
	public JComboBox getCombo() {
		return jcb;
	}
}
