package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.TableModel;
import View.AddDialog;

public class MyAdd implements ActionListener {
	private AddDialog add;
	
	public MyAdd(AddDialog add) {
		this.add = add;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {		// сделать проверку на вводимые значения - цифры/буквы
		// TODO Auto-generated method stub
		if(TableModel.isInt(add.getFio().getText()) == -1 && TableModel.isInt(add.getNumberGrup().getText()) == 1 && 
				TableModel.isInt(add.getSickness().getText()) == 1 && 
				TableModel.isInt(add.getOtherCauses().getText()) == 1 && 
				TableModel.isInt(add.getWithoutGoodReason().getText()) == 1) {
			add.getFrame().getTableModel().addStudent(add.getFio().getText(), add.getNumberGrup().getText(), 
					add.getSickness().getText(), add.getOtherCauses().getText(), 
					add.getWithoutGoodReason().getText());
			add.getFrame().setTable(add.getFrame().getTableModel().allStudents());
			add.setVisible(false);		
			
		}
		else {
			 JOptionPane.showMessageDialog
			 (null, "Can't add student!\nCheck the entered data.", "ERROR", 
					 JOptionPane.ERROR_MESSAGE|JOptionPane.OK_OPTION);
		}
		if(add.getFrame().getTable().getMaxNumberPage() < add.getFrame().getTable().getCurrentPage()) {
			add.getFrame().getTable().setCurrentPage(add.getFrame().getTable().getMaxNumberPage());
		}
	}
}
