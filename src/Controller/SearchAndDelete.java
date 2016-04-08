package Controller;

import java.util.ArrayList;
import java.util.List;
import Model.Student;
import Model.StudentsData;

public class SearchAndDelete {
	StudentsData sd;
	List<Student> list;
	private final int ONE = 1;
	private final int TWO = 2;
	private final int THREE = 3;
	
	public SearchAndDelete(StudentsData sd) {
		this.sd = sd;
		list = sd.allStudents();
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
	
	public void clear() {
		list.clear();
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
			if(s.getFIO().equals(fio) && ((kind == ONE && s.getNumbertSickness() != 0) ||
					(kind == TWO && s.getNumberOtherCauses() != 0) ||
					(kind == THREE && s.getNumberWithoutGoodReason() != 0)) ) {
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
		List<Student> ls = searchStudentsNumberFio(fio, grup);
		list.removeAll(ls);
		return ls.size();
	}
	
	public int deleteStudentsNumberFioKind(String fio, int kind) {
		List<Student> ls = searchStudentsNumberFioKind(fio, kind);
		list.removeAll(ls);
		return ls.size();
	}
	
	public int deleteStudentsNumberOfPasses(String fio, int sicknessMin, int sicknessMax, 
			int numberOtherCausesMin, int numberOtherCausesMax, int numberWithoutGoodReasonMin, 
			int numberWithoutGoodReasonMax) { 
		List<Student> ls = searchStudentsNumberOfPasses(fio, sicknessMin, sicknessMax, numberOtherCausesMin,
				numberOtherCausesMax, numberWithoutGoodReasonMin, numberWithoutGoodReasonMax);
		list.removeAll(ls);
		return ls.size();
	}
	
	static public int isInt(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		boolean myNamber = false;
		boolean myChar = false;
		for(int indexChar = 0; indexChar < str.length(); indexChar++) {
			if(str.charAt(indexChar) >= '0' && str.charAt(indexChar) <= '9') {
				myNamber= true;
			}
			else if((str.charAt(indexChar) >= 'A' && str.charAt(indexChar) <= 'Z') || (str.charAt(indexChar) >= 'À' && str.charAt(indexChar) <= 'ß') ||
					(str.charAt(indexChar) >= 'a' && str.charAt(indexChar) <= 'z') || (str.charAt(indexChar) >= 'à' && str.charAt(indexChar) <= 'ÿ') ||
					str.charAt(indexChar) == ' ' || str.charAt(indexChar) == '-'){
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
