package View;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.Student;

public class MyTable extends JPanel{ 
	private JLabel veiwTable = new JLabel();	
	private String table;
	private List<Student> l;
	
	private int numberPage = 0;
	private int maxNumberPage = 1;
	private int numberOfRecords = 10;
	
	MyTable(List<Student> ls) {
		super();
		l = ls;
		newTable();
		add(veiwTable);
		this.setSize((int) veiwTable.getBounds().getWidth(), (int) veiwTable.getBounds().getHeight());
	}
	
	public void newTable() {
		createHead();
		if(l != null) {
			for(int i = 0; i < l.size(); i++) {
				if((i > numberPage * numberOfRecords - 1) && 
						(i <= numberPage * numberOfRecords + numberOfRecords - 1)) {
					table += "<tr>" + "<td>" + l.get(i).getFIO() + "</td>" + "<td>" + l.get(i).getGrup() + "</td><td>" +
					l.get(i).getNumbertSickness() + "</td>" + "<td>" + l.get(i).getNumberOtherCauses() + "</td><td>" +
					l.get(i).getNumberWithoutGoodReason() + "</td>" + "<td>" + 
					(l.get(i).getNumbertSickness() + l.get(i).getNumberOtherCauses() 
							+ l.get(i).getNumberWithoutGoodReason()) + "</td></tr>";
				}
			}
		}
		table += "</table></html>";
		veiwTable.setText(table);
	}
	
	void createHead() {
		table = "<html><table border=1 cellpadding=10 width=744px>" ;
		table += "<tr>";
		table += "<td rowspan=2 ALIGN=center width=75%><font face=ТverdanaТ size = 5>‘»ќ студента</td>" 
		+ "<td rowspan=2 ALIGN=center><font face=ТverdanaТ size = 5>√руппа</td>" 
		+ "<td colspan=4 ALIGN=center><font face=ТverdanaТ size = 5>„исло пропусков зан€тий за год</td></tr>";
		table += "<tr>";
		table += "<td ALIGN=center><font face=ТverdanaТ size = 5>ѕо болезни</td>" 
		+ "<td ALIGN=center><font face=ТverdanaТ size = 5>ѕо другим причинам</td>" 
		+ "<td ALIGN=center><font face=ТverdanaТ size = 5>Ѕез уважительной причины</td>" 
		+ "<td ALIGN=center><font face=ТverdanaТ size = 5>»того</td></tr>";
	}
	
	public void setList(List<Student> newL) {
		l = newL;
		newTable();
	}
	
	public List<Student> getList() {
		return l;
	}
	
	public void setNumberOfRecords(int n) {
		numberOfRecords = n;
		newTable();
	}
	
	public int getCurrentPage() {
		return numberPage + 1;
	}
	
	public int getCurrentNamberRecords() {
		return numberOfRecords;
	}
	
	public int setCurrentPage(int n) {		// проблема!
		n--;
		if(n >= 0 && n <= maxNumberPage) {
			numberPage = n;
		}
		newTable();
		if(numberPage == 0) {
			return 1;
		}
		return numberPage + 1;
	}
	
	public int setCurrentNamberRecords(int n) {
		if(n > 0) {
			numberOfRecords = n;
		}
		newTable();
		return  numberOfRecords;
	}
	
	public void setMaxNumberPage(int n) {
		if(n > 0) {
			maxNumberPage = n;
		}
		else {
			maxNumberPage = 1;
		}
	}
	
	public int getMaxNumberPage() {
		return maxNumberPage;
	}
}
