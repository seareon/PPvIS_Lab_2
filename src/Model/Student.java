package Model;

public class Student {
	private String fio;
	private String numberGrup;
	private int truancy�[] = {0, 0, 0};
	
	public Student(String fio, String numberGrup, int sickness, int otherCauses, int withoutGoodReason) {
		this.fio = fio;
		this.numberGrup = numberGrup;
		truancy�[0] = sickness;
		truancy�[1] = otherCauses;
		truancy�[2] = withoutGoodReason;
	}
	
	Student(String fio, String numberGrup, String sickness, String otherCauses, String withoutGoodReason) {
		this.fio = fio;
		this.numberGrup = numberGrup;
		truancy�[0] = Integer.parseInt(sickness);
		truancy�[1] = Integer.parseInt(otherCauses);
		truancy�[2] = Integer.parseInt(withoutGoodReason);
	}	
	
	public String getFIO() {
		return fio;
	}
	
	public String getGrup() {
		return numberGrup;
	}
	
	public int getNumbertSickness() {
		return truancy�[0];
	}
	
	public int getNumberOtherCauses() {
		return truancy�[1];
	}
	
	public int getNumberWithoutGoodReason() {
		return truancy�[2];
	}
}
