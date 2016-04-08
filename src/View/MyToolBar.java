package View;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class MyToolBar extends JToolBar{
	private JLabel page = new JLabel("Page: "); 
	private JLabel records  = new JLabel("The number of records per page: ");
	private JLabel allPage = new JLabel("/ 1");
	
	private JTextField currentRecordsOnPage = new JTextField(3);
	private JTextField currentPage = new JTextField(3);
	
	private Font f = new Font("Helvetica", Font.PLAIN, 14);
	
	private MyTable mt;
	
	MyToolBar(MyTable mt) {
		this.mt = mt;
		setFloatable(false);
		this.setLayout(new FlowLayout());
		page.setFont(f); 
		add(page);
		currentPage.setFont(f);
		currentPage.setText("1");
		currentPage.addKeyListener(new MyKeyListener(this));
		add(currentPage);
		allPage.setFont(f);
		add(allPage);
		
		addSeparator();
		addSeparator();
		addSeparator();
		
		add(MyFrame.makeButton("arrow-left.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mt.setCurrentPage(1);
				currentPage.setText("1");
			}
		}));
		add(MyFrame.makeButton("previous.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(mt.getCurrentPage() != 1) {
					mt.setCurrentPage(mt.getCurrentPage() - 1);
					currentPage.setText("" + mt.getCurrentPage());
				}
			}
		}));
		add(MyFrame.makeButton("next.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(mt.getCurrentPage() != mt.getMaxNumberPage()) {
					mt.setCurrentPage(mt.getCurrentPage() + 1);
					currentPage.setText("" + mt.getCurrentPage());
				}
			}
		}));
		add(MyFrame.makeButton("arrow-right.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mt.setCurrentPage(mt.getMaxNumberPage());
				currentPage.setText("" + mt.getMaxNumberPage());
			}
		}));
		
		addSeparator();
		addSeparator();
		addSeparator();
		
		records.setFont(f);
		add(records);
		currentRecordsOnPage.setFont(f);
		currentRecordsOnPage.setText("" + mt.getCurrentNamberRecords()); 
		add(currentRecordsOnPage);
		currentRecordsOnPage.addKeyListener(new MyKeyListener(this));
	}
	
	public void setMaxPage(int n) {		// похоже на чушь
		allPage.setText("/ " + n); 
	}
	
	public JTextField getModifiedPage() {
		return currentPage;
	}
	
	public JTextField getModifiedNamberRecords() {
		return currentRecordsOnPage;
	}
	
	public void setCurrentPage(int n) {
			currentPage.setText("" + mt.setCurrentPage(n));
	}
	
	public void setCurrentNamberRecords(int n) {
		currentRecordsOnPage.setText("" + mt.setCurrentNamberRecords(n)); 
	}
	
	public MyTable getTable() {
		return mt;
	}
	
	public int getSizeTable() {
		return mt.getTableSize();
	}
	
	public int getTableCurrentNamberRecords() {
		return mt.getCurrentNamberRecords();
	}
	
	public void setTableMaxNumberPage(int n) {
		mt.setMaxNumberPage(n);
	}
	
	public int getTableCurrentPage() {
		return mt.getCurrentPage();
	}
	
	public int getTableMaxNumberPage() {
		return mt.getMaxNumberPage();
	}
}
