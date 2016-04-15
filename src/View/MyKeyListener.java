package View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import Controller.AddAndSearchAndDelete;

public class MyKeyListener implements KeyListener {
	private MyToolBar mtb;
	
	public MyKeyListener(MyToolBar mtb) {
		this.mtb = mtb;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			JTextField jtf = mtb.getModifiedPage();
			if(AddAndSearchAndDelete.isInt(jtf.getText()) == 1) {
				mtb.setCurrentPage(Integer.parseInt(jtf.getText())); 
			}
			else {
				mtb.setCurrentPage(1);
			}
			jtf = mtb.getModifiedNamberRecords();				
			if(AddAndSearchAndDelete.isInt(jtf.getText()) == 1) {
				mtb.setCurrentNamberRecords(Integer.parseInt(jtf.getText())); 
				int countPage = mtb.getSizeTable() / mtb.getTableCurrentNamberRecords();
				if(mtb.getSizeTable() % mtb.getTableCurrentNamberRecords() > 0) {
					countPage++;
				}
				mtb.setTableMaxNumberPage(countPage);
				if(mtb.getTableCurrentPage() > mtb.getTableMaxNumberPage()) {
					mtb.setCurrentPage(mtb.getTableMaxNumberPage());
				}
				mtb.setMaxPage(mtb.getTableMaxNumberPage());
			}
			else {
				jtf.setText("" + mtb.getTableCurrentNamberRecords());
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

}
