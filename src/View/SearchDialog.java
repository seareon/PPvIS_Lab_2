package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import Model.Student;


public class SearchDialog extends DialogTemplateSearchAndDelete {			
	private MyTable mtable = new MyTable(null);
	private MyToolBar mtb = new MyToolBar(mtable);
	private JButton search;
	private JScrollPane jsp;
	
	public SearchDialog(MyFrame frame) {
		super("Search person", frame);
		this.frame = frame;
		JPanel mainJP = new JPanel();
		mainJP.setLayout(new BorderLayout()); 
		jp.setLayout(new GridLayout(7,2));

		
		JPanel jp2 = new JPanel();
		search = new JButton("search");
		search.addActionListener(new MySearch(this));
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
