package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.TableModel;
import View.DeleteDialog;

public class MyDelete implements ActionListener {
	private DeleteDialog delete;
	
	public MyDelete(DeleteDialog delete) {
		this.delete = delete;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(TableModel.isInt(delete.getFio().getText()) == -1 && 
				TableModel.isInt(delete.getNumberGrup().getText()) == 1) {
			JOptionPane.showMessageDialog(null, "Remove" + 
				delete.getFrame().getTableModel().deleteStudentsNumberFio(delete.getFio().getText(), 
						delete.getNumberGrup().getText()) + " items.");
			delete.setVisible(false);
			delete.getFrame().setTable(delete.getFrame().getTableModel().allStudents());
		} else if(TableModel.isInt(delete.getFio().getText()) == -1 && 
				TableModel.isInt(delete.getSicknessMin().getText()) == 1 && 
				TableModel.isInt(delete.getSicknessMax().getText()) == 1 &&
				TableModel.isInt(delete.getOtherCausesMin().getText()) == 1 &&
				TableModel.isInt(delete.getOtherCausesMax().getText()) == 1 &&
				TableModel.isInt(delete.getWithoutGoodReasonMin().getText()) == 1 &&
				TableModel.isInt(delete.getWithoutGoodReasonMax().getText()) == 1) {
			JOptionPane.showMessageDialog(null, "Remove" +
				delete.getFrame().getTableModel().deleteStudentsNumberOfPasses(delete.getFio().getText(), 
						Integer.parseInt(delete.getSicknessMin().getText()), 
						Integer.parseInt(delete.getSicknessMax().getText()), 
						Integer.parseInt(delete.getOtherCausesMin().getText()), 
						Integer.parseInt(delete.getOtherCausesMax().getText()), 
						Integer.parseInt(delete.getWithoutGoodReasonMin().getText()), 
						Integer.parseInt(delete.getWithoutGoodReasonMax().getText())));
				delete.setVisible(false);
				delete.getFrame().setTable(delete.getFrame().getTableModel().allStudents());
		}else if(TableModel.isInt(delete.getFio().getText()) == -1 && !delete.getCause().equals("------")) {
			JOptionPane.showMessageDialog(null, "Remove" +
					delete.getFrame().getTableModel().deleteStudentsNumberFioKind(delete.getFio().getText(), 
							delete.getCombo().getSelectedIndex()) + " items.");
			delete.setVisible(false);
			delete.getFrame().setTable(delete.getFrame().getTableModel().allStudents());
		}
		else {
			JOptionPane.showMessageDialog
			 (null, "Can't delete student!\nCheck the entered data.", "ERROR", 
					 JOptionPane.ERROR_MESSAGE|JOptionPane.OK_OPTION);
		}
		if(delete.getFrame().getTable().getMaxNumberPage() < delete.getFrame().getTable().getCurrentPage()) {
			delete.getFrame().getTable().setCurrentPage(delete.getFrame().getTable().getMaxNumberPage());
		}
	}

}
