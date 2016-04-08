package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.*;

public class ButtonAdd implements ActionListener, CheckData {
	private MyFrame frame;
	private AddDialog m = null;
	
	public ButtonAdd(MyFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(m == null) {
			m = new AddDialog(frame);
		}
		else {
			setText(m.getTextFieldFio(), m.getTextFieldNumberGrup());
			m.setSickness("");
			m.setOtherCauses("");
			m.setWithoutGoodReason("");
			m.setVisible(true); 
		}
	}
}
