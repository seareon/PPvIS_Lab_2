package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import Controller.AddAndSearchAndDelete;
import Model.Student;


public class SearchDialog extends DialogTemplateSearchAndDelete {			
	private MyTable mtable = new MyTable(null);
	private MyToolBar mtb = new MyToolBar(mtable);
	private JButton search;
	private JScrollPane jsp;
	
	public SearchDialog(MyFrame frame, AddAndSearchAndDelete sad) {
		super("Search person", frame, sad);
		this.frame = frame;
		sad.setSearchDialog(this); 
		JPanel mainJP = new JPanel();
		mainJP.setLayout(new BorderLayout()); 
		jp.setLayout(new GridLayout(7,2));
		sad.setSearchDialog(this);
		
		JPanel jp2 = new JPanel();
		search = new JButton("search");
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				sad.search();
			}
		}); 
		jp2.add(search);	
		jp.add(jp2);
		jp.setMaximumSize(new Dimension(600, 300));
		
		mainJP.add(jp, BorderLayout.NORTH);
		jsp = new JScrollPane(mtable);
		mainJP.add(jsp, BorderLayout.CENTER);
		mainJP.add(mtb, BorderLayout.SOUTH);
		this.add(mainJP);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(frame);
		this.setVisible(true); 
	}
	
	public void setListTable(List<Student> ls) {
		mtable.setList(ls); 
		mtable.newTable();
	}
}
