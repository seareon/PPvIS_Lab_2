package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import Controller.*;
import Model.Student;
import Model.TableModel;

public class MyFrame extends JFrame {
	private JMenuBar menuBar = new JMenuBar();
	private JToolBar jtb = new JToolBar();
	private JPanel jp = new JPanel();
	private JScrollPane jsp;
	private TableModel tm = new TableModel();
	private MyTable mtable = new MyTable(tm.allStudents());
	private MyToolBar mtb = new MyToolBar(mtable);
	
	MyFrame() {
		super("Table for student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100, 700);
		setLocationRelativeTo(null);
		
		createMenuBar();
		setJMenuBar(menuBar);
		
		createToolBar1();
		
		jsp = new JScrollPane(mtable);
		
		jp.setLayout(new BorderLayout());
		jp.add(jtb, BorderLayout.NORTH);
		jp.add(mtb, BorderLayout.SOUTH);
		jp.add(jsp, BorderLayout.CENTER);
		add(jp);
		this.setVisible(true);
	}
	
	private void createMenuBar() {
		Font f = new Font("Helvetica", Font.PLAIN, 14);
		
		JMenu menu = new JMenu("File");
		menu.setFont(f);
		
		JMenuItem menu_item = new JMenuItem("Open");
		setMenuBar(menu, menu_item, f);
		
		menu_item = new JMenuItem("Save");
		setMenuBar(menu, menu_item, f);
		
		menuBar.add(menu);
		
		menu = new JMenu("Edit");
		menu.setFont(f);
		
		menu_item = new JMenuItem("Search person");
		setMenuBar(menu, menu_item, f);
		
		menu_item = new JMenuItem("Add person");
		setMenuBar(menu, menu_item, f);
		
		menu_item = new JMenuItem("Remove person");
		setMenuBar(menu, menu_item, f);
		
		menuBar.add(menu);
	}
	
	private void setMenuBar(JMenu jmb,JMenuItem jmi, Font f/*, ActionListener al*/) {	//!!!!!!!!!!!!!!!!!!!!!!!
		jmi.setFont(f);
//		jmi.addActionListener(al); 
		jmb.add(jmi);
	}
	
	private void createToolBar1() {
		jtb.setFloatable(false);
		jtb.setRollover(true);
		
		jtb.add(makeButton("open.png", null));
		
		jtb.add(makeButton("save.png", null));
		
		jtb.addSeparator();
		
		jtb.add(makeButton("search.png", new buttonSearch(this)));
		
		jtb.add(makeButton("add.png", new buttonAdd(this)));
		
		jtb.add(makeButton("remove.png", new buttonRemove(this)));
	}
	
	 static JButton makeButton(String str, ActionListener al) {		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	    	JButton but = new JButton();
	    	String imgLocation = "image\\" + str;
	    	ImageIcon img = new ImageIcon(imgLocation);
	    	but.setIcon(img);
		    but.addActionListener(al); 
		    return but;
	    }
	 
	public TableModel getTableModel() {
			return tm;
		}
	
	public void setTable(List<Student> newL) {
		mtable.setList(newL); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}
}
