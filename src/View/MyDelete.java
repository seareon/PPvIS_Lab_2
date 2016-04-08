package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Controller.SearchAndDelete;
import Model.StudentsData;

public class MyDelete implements ActionListener, CheckData {
	private DeleteDialog delete;
	private SearchAndDelete sad;
	
	public MyDelete(DeleteDialog delete) {
		this.delete = delete;
		sad = new SearchAndDelete(delete.getFrame().getStudentsData());
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(checkForFioGrup(delete.getFio(), delete.getNumberGrup())) {
			JOptionPane.showMessageDialog(null, "Remove" + 
				sad.deleteStudentsNumberFio(delete.getFio(), delete.getNumberGrup()) + " items.");
			delete.setVisible(false);
			delete.setTable(sad.allStudents());
		} else if(checkForFioIllnessesCauses(delete.getFio(),delete.getSicknessMin(), 
				delete.getSicknessMax(), delete.getOtherCausesMin(), delete.getOtherCausesMax(),
				delete.getWithoutGoodReasonMin(), delete.getWithoutGoodReasonMax())) {
			JOptionPane.showMessageDialog(null, "Remove" +
				sad.deleteStudentsNumberOfPasses(delete.getFio(), Integer.parseInt(delete.getSicknessMin()), 
						Integer.parseInt(delete.getSicknessMax()), Integer.parseInt(delete.getOtherCausesMin()), 
						Integer.parseInt(delete.getOtherCausesMax()), Integer.parseInt(delete.getWithoutGoodReasonMin()), 
						Integer.parseInt(delete.getWithoutGoodReasonMax())));
				delete.setVisible(false);
				delete.setTable(sad.allStudents());
		}else if(checkForFioCause(delete.getFio(),delete.getCause())) {
			JOptionPane.showMessageDialog(null, "Remove" +
					sad.deleteStudentsNumberFioKind(delete.getFio(), 
							delete.getCombo().getSelectedIndex()) + " items.");
			delete.setVisible(false);
			delete.setTable(sad.allStudents());
		}
		else {
			showOptionPanel("Can't delete student!\nCheck the entered data.", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		checkTheNumberOfPages(delete.getFrame().getToolBar());
	}

}
