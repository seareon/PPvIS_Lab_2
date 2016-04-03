package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.*;

public class buttonAdd implements ActionListener {
	private MyFrame frame;
	private AddDialog m = null;
	
	public buttonAdd(MyFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(m == null) {
			m = new AddDialog(frame);
		}
		else {
			m.getFio().setText("");
			m.getNumberGrup().setText("");
			m.getSickness().setText("");
			m.getOtherCauses().setText("");
			m.getWithoutGoodReason().setText("");
			m.setVisible(true); 
		}
	}
}
