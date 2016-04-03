package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import Model.TableModel;
import View.MyToolBar;

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
			if(TableModel.isInt(jtf.getText()) == 1) {
				mtb.setCurrentPage(Integer.parseInt(jtf.getText())); 
			}
			else {
				mtb.setCurrentPage(1);
			}
			jtf = mtb.getModifiedNamberRecords();
			if(TableModel.isInt(jtf.getText()) == 1) {
				mtb.setCurrentNamberRecords(Integer.parseInt(jtf.getText())); 
				int countPage = mtb.getTable().getList().size() / mtb.getTable().getCurrentNamberRecords();
				if(mtb.getTable().getList().size() % mtb.getTable().getCurrentNamberRecords() > 0) {
					countPage++;
				}
				mtb.getTable().setMaxNumberPage(countPage);
				if(mtb.getTable().getCurrentPage() > mtb.getTable().getMaxNumberPage()) {
					mtb.setCurrentPage(mtb.getTable().getMaxNumberPage());
				}
				mtb.setMaxPage(mtb.getTable().getMaxNumberPage());
			}
			else {
				jtf.setText("" + mtb.getTable().getCurrentNamberRecords());
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
