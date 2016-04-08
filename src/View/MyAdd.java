package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Controller.SearchAndDelete;
import Model.StudentsData;

public class MyAdd implements ActionListener, CheckData {
	private AddDialog add;
	private SearchAndDelete sad;
	
	public MyAdd(AddDialog add) {
		this.add = add;
		sad = new SearchAndDelete(add.getFrame().getStudentsData());		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {		
		// TODO Auto-generated method stub
		if(checkForFioIllnessesCauses(add.getFio(), add.getNumberGrup(), add.getSickness(), add.getOtherCauses(),
				add.getWithoutGoodReason())) {
			sad.addStudent(add.getFio(), add.getNumberGrup(), add.getSickness(), 
					add.getOtherCauses(), add.getWithoutGoodReason());
			add.setTable(sad.allStudents()); 
			add.setVisible(false);		
		}
		else {
			showOptionPanel("Can't add student!\nCheck the entered data.", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		checkTheNumberOfPages(add.getFrame().getToolBar());
	}
}
