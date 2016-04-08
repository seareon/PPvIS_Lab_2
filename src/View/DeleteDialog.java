package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;


public class DeleteDialog extends DialogTemplateSearchAndDelete {	
	JButton del;
	
	public DeleteDialog(MyFrame frame) {
		super("Delete person", frame);
		this.frame = frame;
		jp.setLayout(new GridLayout(6,2));		
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
}
