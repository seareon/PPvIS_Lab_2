package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSearch implements ActionListener, CheckData {
	private MyFrame frame;
	private SearchDialog m = null;
	
	public ButtonSearch(MyFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(m == null) {
			m = new SearchDialog(frame);
		}
		else {
			setText(m.getTextFieldFio(), m.getTextFieldNumberGrup(), m.getTextFieldSicknessMin(), 
					m.getTextFieldSicknessMax(), m.getTextFieldOtherCausesMin(), m.getTextFieldOtherCausesMax(),
					m.getTextFieldwithoutGoodReasonMin(), m.getTextFieldSicknessMax());
			m.getCombo().setSelectedIndex(0);
			m.setListTable(null); 
			m.setVisible(true); 
		}
	}

}
