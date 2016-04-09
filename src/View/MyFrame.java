package View;

<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
import Model.*;
=======
import javax.swing.JFrame;

public class MyFrame extends JFrame JFrame implements CheckData {
>>>>>>> refs/heads/master

public class MyFrame extends JFrame implements CheckData {
	private JMenuBar menuBar = new JMenuBar();
	private JToolBar jtb = new JToolBar();
	private JPanel jp = new JPanel();
	private JScrollPane jsp;
	private StudentsData tm = new StudentsData();
	private MyChooserFile mcf = new MyChooserFile();
	private FileOperations fo = new FileOperations(tm);
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
		setMenuBar(menu, menu_item, f, null);
		
		menu_item = new JMenuItem("Save");
		setMenuBar(menu, menu_item, f, null);
		
		menuBar.add(menu);
		
		menu = new JMenu("Edit");
		menu.setFont(f);
		
		menu_item = new JMenuItem("Search person");
		setMenuBar(menu, menu_item, f, new ButtonSearch(this));
		
		menu_item = new JMenuItem("Add person");
		setMenuBar(menu, menu_item, f, new ButtonAdd(this));
		
		menu_item = new JMenuItem("Remove person");
		setMenuBar(menu, menu_item, f, new ButtonRemove(this));
		
		menuBar.add(menu);
	}
	
	private void setMenuBar(JMenu jmb,JMenuItem jmi, Font f, ActionListener al) {	
		jmi.setFont(f);
		jmi.addActionListener(al); 
		jmb.add(jmi);
	}
	
	private void createToolBar1() {
		jtb.setFloatable(false);
		jtb.setRollover(true);
		
		jtb.add(makeButton("open.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String str = mcf.choosFile("Open");
				fo.openFile(str);
				mtable.newTable();
				checkTheNumberOfPages(mtb);
			}
		}));
		
		jtb.add(makeButton("save.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = mcf.choosFile("Save");
				fo.saveFile(str);
				mtable.newTable();
			}
		}));
		
		jtb.addSeparator();
		
		jtb.add(makeButton("search.png", new ButtonSearch(this)));
		
		jtb.add(makeButton("add.png", new ButtonAdd(this)));
		
		jtb.add(makeButton("remove.png", new ButtonRemove(this)));
	}
	
	 static JButton makeButton(String str, ActionListener al) {		
	    	JButton but = new JButton();
	    	String imgLocation = "image\\" + str;
	    	ImageIcon img = new ImageIcon(imgLocation);
	    	but.setIcon(img);
		    but.addActionListener(al); 
		    return but;
	    }
	 
	public StudentsData getStudentsData() {
			return tm;
		}
	
	public void setTable(List<Student> newL) {
		mtable.setList(newL); 
	}
	
	public MyTable getTable() {
		return mtable;
	}
	
	public MyToolBar getToolBar() {
		return mtb;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}
}
