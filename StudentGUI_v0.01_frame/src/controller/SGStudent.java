package controller;
import java.io.Serializable;

import constants.SGConstants.ELabelItems;

public class SGStudent implements Comparable<SGStudent>, Serializable{

	private String name;
	private String studentId;
	private int kor, eng, math;
	
	private double avg;
	private int total;
	
	public SGStudent() {}
	
	public SGStudent(String name, String studentId, int kor, int eng, int math) {
		this.name = name;
		this.studentId = studentId;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		calculateScore();
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentId() {
		return this.studentId;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
		calculateScore();
	}
	
	public int getKor() {
		return this.kor;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
		calculateScore();
	}
	
	public int getEng() {
		return this.eng;
	}
	
	public void setMath(int math) {
		this.math = math;
		calculateScore();
	}
	
	public int getMath() {
		return this.math;
	}
	
	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	private void calculateScore() {
		total = kor + eng + math;
		avg = (double)total / 3;
	}
	
	public String[] getArray() {
		String[] arr = new String[ELabelItems.values().length];
		
		arr[0] = name;
		arr[1] = studentId;
		arr[2] = "" + kor;
		arr[3] = "" + eng;
		arr[4] = "" + math;
		arr[5] = "" + total;
		arr[6] = String.format("%.2f", avg);
		
		return arr;
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + "\t학번 : " + studentId + "\t국어 : " + kor + "\t영어 : " + eng + "\t수학 : " + math;
	}

	@Override
	public int compareTo(SGStudent o) {
		
		if(total < o.getTotal()) {
			return 1;
		} else if (total > o.getTotal()) {
			return -1;
		} else {
			return 0;
		}
	}
}
