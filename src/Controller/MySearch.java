package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.TableModel;
import View.SearchDialog;

public class MySearch implements ActionListener {
	private SearchDialog search;

	public MySearch(SearchDialog search) {
		this.search = search;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(TableModel.isInt(search.getFio().getText()) == -1 && 
				TableModel.isInt(search.getNumberGrup().getText()) == 1) {
			search.getTable().setList(search.getFrame().getTableModel().searchStudentsNumberFio(
					search.getFio().getText(), search.getNumberGrup().getText()));
		} else if(TableModel.isInt(search.getFio().getText()) == -1 && 
				TableModel.isInt(search.getSicknessMin().getText()) == 1 && 
				TableModel.isInt(search.getSicknessMax().getText()) == 1 &&
				TableModel.isInt(search.getOtherCausesMin().getText()) == 1 &&
				TableModel.isInt(search.getOtherCausesMax().getText()) == 1 &&
				TableModel.isInt(search.getWithoutGoodReasonMin().getText()) == 1 &&
				TableModel.isInt(search.getWithoutGoodReasonMax().getText()) == 1) {
			search.getTable().setList(search.getFrame().getTableModel().searchStudentsNumberOfPasses(
					search.getFio().getText(), Integer.parseInt(search.getSicknessMin().getText()), 
					Integer.parseInt(search.getSicknessMax().getText()), 
					Integer.parseInt(search.getOtherCausesMin().getText()), 
					Integer.parseInt(search.getOtherCausesMax().getText()), 
					Integer.parseInt(search.getWithoutGoodReasonMin().getText()), 
					Integer.parseInt(search.getWithoutGoodReasonMax().getText())));
		} else if(TableModel.isInt(search.getFio().getText()) == -1 && !search.getCause().equals("------")) {
			search.getTable().setList(search.getFrame().getTableModel().searchStudentsNumberFioKind(
					search.getFio().getText(), search.getCombo().getSelectedIndex()));
		} else {
			JOptionPane.showMessageDialog
			 (null, "Can't search student!\nCheck the entered data.", "ERROR", 
					 JOptionPane.ERROR_MESSAGE|JOptionPane.OK_OPTION);
		}
	}

}
