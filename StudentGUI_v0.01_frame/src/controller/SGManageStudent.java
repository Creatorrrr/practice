package controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import constants.SGConstants;
import constants.SGConstants.ESortOptionItems;

public class SGManageStudent {
	
	private static final String TEMP_DIR = "temp_data.dat";
	private static final String STUDENT_DIR = "student_data.dat";

	private ArrayList<SGStudent> stds;
	
	public SGManageStudent() {
		stds = new ArrayList<>();
		
		load();
	}
	
	public ArrayList<SGStudent> getStudentList() {
		return stds;
	}
	
	public boolean registerStudent(String name, String studentId, int kor, int eng, int math) {
		if(search(studentId) == null) {
			stds.add(new SGStudent(name, studentId, kor, eng, math));
			System.out.println("등록되었습니다.");
			save(STUDENT_DIR);
			return true;
		} else {
			System.out.println("이미 존재하는 학생입니다.");
			return false;
		}
	}
	
	public ArrayList<SGStudent> searchStudent(String studentId) {
		SGStudent s = search(studentId);
		ArrayList<SGStudent> searchedList = new ArrayList<>();
		
		if(s != null) {
			searchedList.add(s);
			return searchedList;
		} else {
			return null;
		}
	}
	
	public boolean deleteStudent(String studentId) {
		File file = new File(STUDENT_DIR);
		
		SGStudent s = search(studentId);
		
		if(s != null) {
			stds.remove(s);
			
			save(TEMP_DIR);
			
			file.delete();
			file = new File(TEMP_DIR);
			file.renameTo(new File(STUDENT_DIR));
			return true;
		} else {
			System.out.println("찾는 학번의 학생이 존재하지 않습니다.");
			return false;
		}
	}
	
	private void save(String dir) {
		ObjectOutputStream fout = null;
		
		try {
			fout = new ObjectOutputStream(new FileOutputStream(dir));
			
			fout.writeObject(stds);
			fout.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fout != null) fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void load() {
		
		ObjectInputStream fin = null;
		
		try {
			fin = new ObjectInputStream(new FileInputStream(STUDENT_DIR));
			
			stds = (ArrayList<SGStudent>)fin.readObject();
			
		} catch (FileNotFoundException e) {
			System.out.println("등록된 학생 정보가 존재하지 않습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fin != null) fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private SGStudent search(String studentId) {
		for(SGStudent s : stds) {
			if(s.getStudentId().equals(studentId)) {
				return s;
			}
		}
		return null;
	}
	
	public void sortStudent(int select) {
		if(select == ESortOptionItems.SORT_BY_SCORE.ordinal()) {
			Collections.sort(stds);
		} else if (select == ESortOptionItems.SORT_BY_ID.ordinal()) {
			Collections.sort(stds, new Comparator<SGStudent>() {
				@Override
				public int compare(SGStudent o1, SGStudent o2) {
					return o1.getStudentId().compareTo(o2.getStudentId());
				}
			});
		}
	}
	
	public int modifyStudent(String target, String name, String studentId, int kor, int eng, int math) {
		File file = new File(STUDENT_DIR);
		
		SGStudent student = search(target);
		
		if(student != null) {
			if(search(studentId) != null) {
				return SGConstants.EXIST;
			}
			
			modify(student, name, studentId, kor, eng, math);
			
			save(TEMP_DIR);
			
			file.delete();
			file = new File(TEMP_DIR);
			file.renameTo(new File(STUDENT_DIR));
			return SGConstants.TRUE;
		} else {
			System.out.println("찾는 학번의 학생이 존재하지 않습니다.");
			return SGConstants.TRUE;
		}
	}
	
	private void modify(SGStudent student, String name, String studentId, int kor, int eng, int math) {
		student.setName(name);
		student.setStudentId(studentId);
		student.setKor(kor);
		student.setEng(eng);
		student.setMath(math);
	}
}
