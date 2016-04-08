package View;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.SearchAndDelete;

public interface CheckData {
	default boolean checkForFioGrup(String str1, String str2) {
		return SearchAndDelete.isInt(str1) == -1 && SearchAndDelete.isInt(str2) == 1;
	}
	
	default boolean checkForFioIllnessesCauses(String str1, String str2, String str3, String str4,
			String str5, String str6, String str7) {
		return SearchAndDelete.isInt(str1) == -1 && SearchAndDelete.isInt(str2) == 1 &&
				SearchAndDelete.isInt(str3) == 1 && SearchAndDelete.isInt(str4) == 1 && 
				SearchAndDelete.isInt(str5) == 1 && SearchAndDelete.isInt(str6) == 1 &&
				SearchAndDelete.isInt(str7) == 1;
	}
	
	default boolean checkForFioCause(String str1, String str2) {
		return SearchAndDelete.isInt(str1) == -1 && !str2.equals("------");
	}
	
	default void showOptionPanel(String str1, String str2, int n) {
		JOptionPane.showMessageDialog
		 (null, str1, str2, 
				 n|JOptionPane.OK_OPTION);
	}
	
	default boolean checkForFioIllnessesCauses(String str1, String str2, String str3, String str4, String str5) {
		return SearchAndDelete.isInt(str1) == -1 && SearchAndDelete.isInt(str2) == 1 && 
				SearchAndDelete.isInt(str3) == 1 && SearchAndDelete.isInt(str4) == 1 && 
						SearchAndDelete.isInt(str5) == 1;
	}
	
	default void checkTheNumberOfPages(MyToolBar mtb) {
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
	
	default void setText(JTextField ... jte) {
		for(int i = 0; i < jte.length; i++) {
			jte[i].setText(""); 
		}
	}
}
