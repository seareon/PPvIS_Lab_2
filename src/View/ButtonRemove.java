package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonRemove implements ActionListener, CheckData {
	private MyFrame frame;
	private DeleteDialog m = null;
	
	public ButtonRemove(MyFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(m == null) {
			m = new DeleteDialog(frame);
		}
		else {
			setText(m.getTextFieldFio(), m.getTextFieldNumberGrup(), m.getTextFieldSicknessMin(), 
					m.getTextFieldSicknessMax(), m.getTextFieldOtherCausesMin(), m.getTextFieldOtherCausesMax(),
					m.getTextFieldwithoutGoodReasonMin(), m.getTextFieldSicknessMax());
			m.getCombo().setSelectedIndex(0);
			m.setVisible(true); 
		}
	}	
}
