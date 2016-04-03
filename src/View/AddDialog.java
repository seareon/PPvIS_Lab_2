package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.MyAdd;

public class AddDialog extends JDialog {
	private MyFrame frame;
	
	private final JLabel FIO = new JLabel("  FIO");
	private final JLabel NUMBERGRUP = new JLabel("  Grup");
	private final JLabel SICKNESS = new JLabel("  Пропуски по болезни: ");
	private final JLabel OTHERCAUSES = new JLabel("  Пропуски по другим причинам: ");
	private final JLabel WITHOUTGOODREASON = new JLabel("  Пропуски без уважительной причины: ");
	
	private JTextField fio = new JTextField(40);
	private JTextField numberGrup = new JTextField(6);
	private JTextField sickness = new JTextField(6);
	private JTextField otherCauses = new JTextField(6);
	private JTextField withoutGoodReason = new JTextField(6);
	
	public AddDialog(MyFrame frame) {
		super(frame, "Add person", true);
		this.frame = frame;
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
	
	public JTextField getFio() {
		return fio;
	}
	
	public JTextField getNumberGrup() {
		return numberGrup;
	}
	
	public JTextField getSickness() {
		return sickness;
	}
	
	public JTextField getOtherCauses() {
		return otherCauses;
	}
	
	public JTextField getWithoutGoodReason() {
		return withoutGoodReason;
	}
	
	public MyFrame getFrame() {
		return frame;
	}
}
