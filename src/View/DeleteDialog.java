package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import Controller.AddAndSearchAndDelete;


public class DeleteDialog extends DialogTemplateSearchAndDelete {	
	JButton del;
	
	public DeleteDialog(MyFrame frame, AddAndSearchAndDelete sad) {
		super("Delete person", frame, sad);
		this.frame = frame;
		sad.setDeleteDialog(this); 
		jp.setLayout(new GridLayout(6,2));		
		this.add(jp,BorderLayout.CENTER);
		jp = new JPanel();
		del = new JButton("delete");
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sad.delete();
			}
		});
		jp.add(del);
		
		this.add(jp,BorderLayout.SOUTH);
		this.setSize(600, 300);
		this.setLocationRelativeTo(frame);
		this.setVisible(true); 
	}
}
