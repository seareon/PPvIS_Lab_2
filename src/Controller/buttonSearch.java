package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.AddDialog;
import View.MyFrame;
import View.SearchDialog;

public class buttonSearch implements ActionListener {
	private MyFrame frame;
	private SearchDialog m = null;
	
	public buttonSearch(MyFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(m == null) {
			m = new SearchDialog(frame);
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
			m.getTable().setList(null); 
			m.setVisible(true); 
		}
	}

}
