package Model;

import java.util.ArrayList;
import java.util.List;

public class TableModel {
	List<Student> list;
	
	public TableModel() {
		list = new ArrayList<>();
	}
	
	public void addStudent(String fio, String numberGrup, int sickness, int otherCauses, int withoutGoodReason) {
		list.add(new Student(fio, numberGrup, sickness, otherCauses, withoutGoodReason));
	}		
	
	public void addStudent(String fio, String numberGrup, String sickness, String otherCauses, 
			String withoutGoodReason) {
		list.add(new Student(fio, numberGrup, Integer.parseInt(sickness), Integer.parseInt(otherCauses),
				Integer.parseInt(withoutGoodReason)));
	}
	
	public List<Student> allStudents() {
		return list;
	}
	
	public int getSize() {
		return list.size();
	}
	
	public List<Student> searchStudentsNumberFio(String fio, String grup) {
		List<Student> temp = new ArrayList<>();
		for(Student s : list) {
			if(s.getFIO().equals(fio) && s.getGrup().equals(grup)) 
			{
				temp.add(s);
			}
		}
		return temp;
	}
	
	public List<Student> searchStudentsNumberFioKind(String fio, int kind) {
		List<Student> temp = new ArrayList<>();
		for(Student s : list) {
			if(s.getFIO().equals(fio) && ((kind == 1 && s.getNumbertSickness() != 0) ||
					(kind == 2 && s.getNumberOtherCauses() != 0) ||
					(kind == 3 && s.getNumberWithoutGoodReason() != 0)) ) {
				temp.add(s);
			}
		}
		return temp;
	}
	
	public List<Student> searchStudentsNumberOfPasses(String fio, int sicknessMin, int sicknessMax, 
			int numberOtherCausesMin, int numberOtherCausesMax, int numberWithoutGoodReasonMin, 
			int numberWithoutGoodReasonMax) {
		List<Student> temp = new ArrayList<>();
		for(Student s : list) {
			if(s.getFIO().equals(fio) && s.getNumbertSickness() >= sicknessMin && 
					s.getNumbertSickness() <= sicknessMax && 
					s.getNumberOtherCauses() >= numberOtherCausesMin &&
					s.getNumberOtherCauses() <= numberOtherCausesMax &&
					s.getNumberWithoutGoodReason() >= numberWithoutGoodReasonMin &&
					s.getNumberWithoutGoodReason() <= numberWithoutGoodReasonMax) {
				temp.add(s);
			}
		}
		return temp;
	}
	
	public int deleteStudentsNumberFio(String fio, String grup) {
		int counter = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getFIO().equals(fio) && list.get(i).getGrup().equals(grup)) {
				list.remove(i--);
				counter++;
			}
		}
		return counter;
	}
	
	public int deleteStudentsNumberFioKind(String fio, int kind) {
		int counter = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getFIO().equals(fio) && ((kind == 1 && list.get(i).getNumbertSickness() != 0) ||
							(kind == 2 && list.get(i).getNumberOtherCauses() != 0) ||
							(kind == 3 && list.get(i).getNumberWithoutGoodReason() != 0))) {
				list.remove(i--);
				counter++;
			}
		}
		return counter;
	}
	
	public int deleteStudentsNumberOfPasses(String fio, int sicknessMin, int sicknessMax, 
			int numberOtherCausesMin, int numberOtherCausesMax, int numberWithoutGoodReasonMin, 
			int numberWithoutGoodReasonMax) { 
		int counter = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getFIO().equals(fio) && list.get(i).getNumbertSickness() >= sicknessMin && 
					list.get(i).getNumbertSickness() <= sicknessMax && 
					list.get(i).getNumberOtherCauses() >= numberOtherCausesMin &&
					list.get(i).getNumberOtherCauses() <= numberOtherCausesMax &&
					list.get(i).getNumberWithoutGoodReason() >= numberWithoutGoodReasonMin &&
					list.get(i).getNumberWithoutGoodReason() <= numberWithoutGoodReasonMax) {
				list.remove(i--);
				counter++;
			}
		}
		return counter;
	}
	
	static public int isInt(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		boolean myNamber = false;
		boolean myChar = false;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				myNamber= true;
			}
			else if((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= 'À' && str.charAt(i) <= 'ß') ||
					(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'à' && str.charAt(i) <= 'ÿ')){
				myChar = true;
			}
			else {
				return 0;
			}
		}	
		if(myChar && myNamber) {
			return 0;
		}
		if(myChar) {
			return -1;
		}
		return 1;
	}
}
