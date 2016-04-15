package Controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Model.*;
import View.*;

public class AddAndSearchAndDelete {
	private StudentsData sd;
	
	private AddDialog addD;
	private SearchDialog searchD;
	private DeleteDialog deleteD;
	
	private final int ONE = 1;
	private final int TWO = 2;
	private final int THREE = 3;
	
	public AddAndSearchAndDelete(StudentsData sd) {
		this.sd = sd;
	}
	
	public void setAddDialog(AddDialog ad) {
		addD = ad;
	}
	
	public void setSearchDialog(SearchDialog sd) {
		searchD = sd;
	}
	
	public void setDeleteDialog(DeleteDialog dd) {
		deleteD = dd;
	}
	
	boolean checkForFioIllnessesCauses(String str1, String str2, String str3, String str4,
			String str5, String str6, String str7) {
		return AddAndSearchAndDelete.isInt(str1) == -1 && AddAndSearchAndDelete.isInt(str2) == 1 &&
				AddAndSearchAndDelete.isInt(str3) == 1 && AddAndSearchAndDelete.isInt(str4) == 1 && 
				AddAndSearchAndDelete.isInt(str5) == 1 && AddAndSearchAndDelete.isInt(str6) == 1 &&
						AddAndSearchAndDelete.isInt(str7) == 1;
	}
	
	boolean checkForFioGrup(String str1, String str2) {
		return AddAndSearchAndDelete.isInt(str1) == -1 && AddAndSearchAndDelete.isInt(str2) == 1;
	}
	
	boolean checkForFioCause(String str1, String str2) {
		return AddAndSearchAndDelete.isInt(str1) == -1 && !str2.equals("------");
	}
	
	void showOptionPanel(String str1, String str2, int n) {
		JOptionPane.showMessageDialog
		 (null, str1, str2, 
				 n|JOptionPane.OK_OPTION);
	}
	
	public void checkTheNumberOfPages(MyToolBar mtb) {
		int count = mtb.getSizeTable() / mtb.getTableCurrentNamberRecords();
		if( mtb.getSizeTable() % mtb.getTableCurrentNamberRecords() != 0) {
			count++;
		}
		if(count != mtb.getTableMaxNumberPage()) {
			mtb.setTableMaxNumberPage(count);
			mtb.setMaxPage(count);
			if(count >= mtb.getTableMaxNumberPage()) {
				mtb.setCurrentPage(count);
				mtb.getTable().newTable();
			}
		}
	}

	public void add() {				
		if(AddAndSearchAndDelete.isInt(addD.getFio()) == -1 && AddAndSearchAndDelete.isInt(addD.getNumberGrup()) == 1 
				&& AddAndSearchAndDelete.isInt(addD.getSickness()) == 1 && 
				AddAndSearchAndDelete.isInt(addD.getOtherCauses()) == 1 && 
				AddAndSearchAndDelete.isInt(addD.getWithoutGoodReason()) == 1) {
			addStudent(addD.getFio(), addD.getNumberGrup(), addD.getSickness(), 
					addD.getOtherCauses(), addD.getWithoutGoodReason());
			addD.setTable(allStudents()); 
			addD.setVisible(false);		
		}
		else {
			showOptionPanel("Can't add student!\nCheck the entered data.", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		checkTheNumberOfPages(addD.getFrame().getToolBar());
	} 
	
	public void search() {				
		if(checkForFioGrup(searchD.getFio(), searchD.getNumberGrup())) {
			searchD.setListTable(searchStudentsNumberFio(searchD.getFio(), searchD.getNumberGrup()));
		} else if(checkForFioIllnessesCauses(searchD.getFio(),searchD.getSicknessMin(), 
						searchD.getSicknessMax(), searchD.getOtherCausesMin(), searchD.getOtherCausesMax(),
						searchD.getWithoutGoodReasonMin(), searchD.getWithoutGoodReasonMax())) {
			searchD.setListTable(searchStudentsNumberOfPasses(
					searchD.getFio(), Integer.parseInt(searchD.getSicknessMin()), 
					Integer.parseInt(searchD.getSicknessMax()), 
					Integer.parseInt(searchD.getOtherCausesMin()), 
					Integer.parseInt(searchD.getOtherCausesMax()), 
					Integer.parseInt(searchD.getWithoutGoodReasonMin()), 
					Integer.parseInt(searchD.getWithoutGoodReasonMax())));
		} else if(checkForFioCause(searchD.getFio(),searchD.getCause())) {
			searchD.setListTable(searchStudentsNumberFioKind(searchD.getFio(), searchD.getCombo().getSelectedIndex()));
		} else {
			showOptionPanel("Can't search student!\nCheck the entered data.", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void delete() {
		if(checkForFioGrup(deleteD.getFio(), deleteD.getNumberGrup())) {
			JOptionPane.showMessageDialog(null, "Remove" + 
				deleteStudentsNumberFio(deleteD.getFio(), deleteD.getNumberGrup()) + " items.");
			deleteD.setVisible(false);
			deleteD.setTable(allStudents());
		} else if(checkForFioIllnessesCauses(deleteD.getFio(),deleteD.getSicknessMin(), 
				deleteD.getSicknessMax(), deleteD.getOtherCausesMin(), deleteD.getOtherCausesMax(),
				deleteD.getWithoutGoodReasonMin(), deleteD.getWithoutGoodReasonMax())) {
			JOptionPane.showMessageDialog(null, "Remove" +
				deleteStudentsNumberOfPasses(deleteD.getFio(), Integer.parseInt(deleteD.getSicknessMin()), 
						Integer.parseInt(deleteD.getSicknessMax()), Integer.parseInt(deleteD.getOtherCausesMin()), 
						Integer.parseInt(deleteD.getOtherCausesMax()), 
						Integer.parseInt(deleteD.getWithoutGoodReasonMin()), 
						Integer.parseInt(deleteD.getWithoutGoodReasonMax())));
				deleteD.setVisible(false);
				deleteD.setTable(allStudents());
		}else if(checkForFioCause(deleteD.getFio(),deleteD.getCause())) {
			JOptionPane.showMessageDialog(null, "Remove" +
					deleteStudentsNumberFioKind(deleteD.getFio(), 
							deleteD.getCombo().getSelectedIndex()) + " items.");
			deleteD.setVisible(false);
			deleteD.setTable(allStudents());
		}
		else {
			showOptionPanel("Can't delete student!\nCheck the entered data.", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		checkTheNumberOfPages(deleteD.getFrame().getToolBar());
	}

	public void addStudent(String fio, String numberGrup, String sickness, String otherCauses, 
			String withoutGoodReason) {
		sd.addStudent(fio, numberGrup, Integer.parseInt(sickness), Integer.parseInt(otherCauses),
				Integer.parseInt(withoutGoodReason));
	}
	
	public List<Student> allStudents() {
		return sd.allStudents();
	}
	
	public void clear() {
		sd.clear();
	}
	
	public List<Student> searchStudentsNumberFio(String fio, String grup) {
		List<Student> temp = new ArrayList<>();
		for(Student s : sd.allStudents()) {
			if(s.getFIO().equals(fio) && s.getGrup().equals(grup)) 
			{
				temp.add(s);
			}
		}
		return temp;
	}
	
	public List<Student> searchStudentsNumberFioKind(String fio, int kind) {
		List<Student> temp = new ArrayList<>();
		for(Student s : sd.allStudents()) {
			if(s.getFIO().equals(fio) && ((kind == ONE && s.getNumbertSickness() != 0) ||
					(kind == TWO && s.getNumberOtherCauses() != 0) ||
					(kind == THREE && s.getNumberWithoutGoodReason() != 0)) ) {
				temp.add(s);
			}
		}
		return temp;
	}
	
	public List<Student> searchStudentsNumberOfPasses(String fio, int sicknessMin, int sicknessMax, 
			int numberOtherCausesMin, int numberOtherCausesMax, int numberWithoutGoodReasonMin, 
			int numberWithoutGoodReasonMax) {
		List<Student> temp = new ArrayList<>();
		for(Student s : sd.allStudents()) {
			if(s.getFIO().equals(fio) && s.getNumbertSickness() >= sicknessMin && 
					s.getNumbertSickness() <= sicknessMax && 
					s.getNumberOtherCauses() >= numberOtherCausesMin &&
					s.getNumberOtherCauses() <= numberOtherCausesMax &&
					s.getNumberWithoutGoodReason() >= numberWithoutGoodReasonMin &&
					s.getNumberWithoutGoodReason() <= numberWithoutGoodReasonMax) {
				temp.add(s);
			}
		}
		return temp;
	}
	
	public int deleteStudentsNumberFio(String fio, String grup) {
		List<Student> ls = searchStudentsNumberFio(fio, grup);
		sd.removeAll(ls);
		return ls.size();
	}
	
	public int deleteStudentsNumberFioKind(String fio, int kind) {
		List<Student> ls = searchStudentsNumberFioKind(fio, kind);
		sd.removeAll(ls);
		return ls.size();
	}
	
	public int deleteStudentsNumberOfPasses(String fio, int sicknessMin, int sicknessMax, 
			int numberOtherCausesMin, int numberOtherCausesMax, int numberWithoutGoodReasonMin, 
			int numberWithoutGoodReasonMax) { 
		List<Student> ls = searchStudentsNumberOfPasses(fio, sicknessMin, sicknessMax, numberOtherCausesMin,
				numberOtherCausesMax, numberWithoutGoodReasonMin, numberWithoutGoodReasonMax);
		sd.removeAll(ls);
		return ls.size();
	}
	
	public void setText(JTextField ... jte) {
		for(int i = 0; i < jte.length; i++) {
			jte[i].setText(""); 
		}
	}
	
	public void pressAdd() {
		setText(addD.getTextFieldFio(), addD.getTextFieldNumberGrup(), addD.getTextFieldSickness(),
				addD.getTextFieldOtherCauses(), addD.getTextFieldWithoutGoodReason());
		addD.setVisible(true);
	}
	
	public void pressRemove() {
		setText(deleteD.getTextFieldFio(), deleteD.getTextFieldNumberGrup(), deleteD.getTextFieldSicknessMin(), 
				deleteD.getTextFieldSicknessMax(), deleteD.getTextFieldOtherCausesMin(), 
				deleteD.getTextFieldOtherCausesMax(), deleteD.getTextFieldwithoutGoodReasonMin(), 
				deleteD.getTextFieldSicknessMax());
		deleteD.getCombo().setSelectedIndex(0);
		deleteD.setVisible(true); 
	}
	
	public void pressSearch() {
		setText(searchD.getTextFieldFio(), searchD.getTextFieldNumberGrup(), searchD.getTextFieldSicknessMin(), 
				searchD.getTextFieldSicknessMax(), searchD.getTextFieldOtherCausesMin(), 
				searchD.getTextFieldOtherCausesMax(), searchD.getTextFieldwithoutGoodReasonMin(), 
				searchD.getTextFieldSicknessMax());
		searchD.getCombo().setSelectedIndex(0);
		searchD.setListTable(null); 
		searchD.setVisible(true); 
	}
	
	static public int isInt(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		boolean myNamber = false;
		boolean myChar = false;
		for(int indexChar = 0; indexChar < str.length(); indexChar++) {
			if(str.charAt(indexChar) >= '0' && str.charAt(indexChar) <= '9') {
				myNamber= true;
			}
			else if((str.charAt(indexChar) >= 'A' && str.charAt(indexChar) <= 'Z') || 
					(str.charAt(indexChar) >= 'À' && str.charAt(indexChar) <= 'ß') ||
					(str.charAt(indexChar) >= 'a' && str.charAt(indexChar) <= 'z') || 
					(str.charAt(indexChar) >= 'à' && str.charAt(indexChar) <= 'ÿ') ||
					str.charAt(indexChar) == ' ' || str.charAt(indexChar) == '-'){
				myChar = true;
			}
			else {
				return 0;
			}
		}	
		if(myChar && myNamber) {
			return 0;
		}
		if(myChar) {
			return -1;
		}
		return 1;
	}
}
