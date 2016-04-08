package View;

<<<<<<< Upstream, based on origin/master
import javax.swing.JFrame;

public class MyFrame extends JFrame {
=======
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToolBar;
>>>>>>> 3f2b4f2 v 1.0 - test.

public class MyFrame extends JFrame {
	private JMenuBar menuBar = new JMenuBar();
	private JToolBar jtb = new JToolBar();
	private JToolBar jtb2 = new JToolBar();
	private JPanel jp = new JPanel();
	private MyTable mt;
	
	MyFrame() {
		super("Table for student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		
		createMenuBar();
		setJMenuBar(menuBar);
		
		createToolBar1();
		createToolBar2();
		
		jp.setLayout(new BorderLayout());
		jp.add(jtb, BorderLayout.NORTH);
		jp.add(jtb2, BorderLayout.SOUTH);
		jp.add(/*mt*/ new JTable(), BorderLayout.CENTER);
		
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
		
		jtb.add(makeButton("open.png"));
		
		jtb.add(makeButton("save.png"));
		
		jtb.addSeparator();
		
		jtb.add(makeButton("search.png"));
		
		jtb.add(makeButton("add.png"));
		
		jtb.add(makeButton("remove.png"));
	}
	
	private void createToolBar2() {
		jtb2.setFloatable(false);
		jtb2.setRollover(true);
		Font f = new Font("Helvetica", Font.PLAIN, 14);
		
		JLabel jl = new JLabel("Page: 1/1   ");
		jl.setFont(f);
		jtb2.add(jl);
		jl = new JLabel("Total records: 0   ");
		jl.setFont(f);
		jtb2.add(jl);
		
		jtb2.add(makeButton("arrow-left.png"));
		jtb2.add(makeButton("previous.png"));
		jtb2.add(makeButton("next.png"));
		jtb2.add(makeButton("arrow-right.png"));
	}
	
	 protected JButton makeButton(String str/*, ActionListener al*/) {		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	    	JButton but = new JButton();
	    	String imgLocation = "image\\" + str;
	    	ImageIcon img = new ImageIcon(imgLocation);
	    	but.setIcon(img);
//		    but.addActionListener(al); 
		    return but;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}

}
