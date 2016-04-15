package Model;

import java.util.ArrayList;
import java.util.List;

public class StudentsData {
	List<Student> list;
	
	public StudentsData() {
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
	
	public void clear() {
		list.clear();
	}
	
	public void removeAll(List<Student> ls) {
		list.removeAll(ls);
	}
}
