package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Controller.SearchAndDelete;
import Model.StudentsData;

public class MySearch implements ActionListener, CheckData {
	private SearchDialog search;
	private SearchAndDelete sad;

	public MySearch(SearchDialog search) {
		this.search = search;
		sad = new SearchAndDelete(search.getFrame().getStudentsData());

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(checkForFioGrup(search.getFio(), search.getNumberGrup())) {
			search.setListTable(sad.searchStudentsNumberFio(search.getFio(), search.getNumberGrup()));
		} else if(checkForFioIllnessesCauses(search.getFio(),search.getSicknessMin(), 
						search.getSicknessMax(), search.getOtherCausesMin(), search.getOtherCausesMax(),
						search.getWithoutGoodReasonMin(), search.getWithoutGoodReasonMax())) {
			search.setListTable(sad.searchStudentsNumberOfPasses(
					search.getFio(), Integer.parseInt(search.getSicknessMin()), 
					Integer.parseInt(search.getSicknessMax()), 
					Integer.parseInt(search.getOtherCausesMin()), 
					Integer.parseInt(search.getOtherCausesMax()), 
					Integer.parseInt(search.getWithoutGoodReasonMin()), 
					Integer.parseInt(search.getWithoutGoodReasonMax())));
		} else if(checkForFioCause(search.getFio(),search.getCause())) {
			search.setListTable(sad.searchStudentsNumberFioKind(search.getFio(), search.getCombo().getSelectedIndex()));
		} else {
			showOptionPanel("Can't search student!\nCheck the entered data.", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
