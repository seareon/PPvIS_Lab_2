package View;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyChooserFile {
	private String file = "";
	
	String choosFile(String str) {
		JFileChooser jfc = new JFileChooser();
		jfc.setAcceptAllFileFilterUsed (false);
		jfc.setFileFilter(new FileNameExtensionFilter(".mtxml", "mtxml"));
		if (jfc.showDialog(null, str) == JFileChooser.APPROVE_OPTION) {
			if (str.equals("Open"))
				file = jfc.getSelectedFile().getPath();
			else
				file = jfc.getSelectedFile()  + ".mtxml";
		}
		return file;
	}
	
	public String getFileName() {		
		return file;
	} 
}
