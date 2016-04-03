package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.DeleteDialog;
import View.MyFrame;

public class buttonRemove implements ActionListener {
	private MyFrame frame;
	private DeleteDialog m = null;
	
	public buttonRemove(MyFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(m == null) {
			m = new DeleteDialog(frame);
		}
		else {
			m.getFio().setText("");
			m.getNumberGrup().setText("");
			m.getCombo().setSelectedIndex(0);
			m.getSicknessMin().setText("");
			m.getSicknessMax().setText("");
			m.getOtherCausesMin().setText("");
			m.getOtherCausesMax().setText("");
			m.getWithoutGoodReasonMin().setText("");
			m.getWithoutGoodReasonMax().setText("");
			m.setVisible(true); 
		}
	}	
}
