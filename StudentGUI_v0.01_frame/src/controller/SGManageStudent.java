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
import java.util.Scanner;

public class SGManageStudent {
	
	private static final String TEMP_DIR = "temp_data.dat";
	private static final String STUDENT_DIR = "student_data.dat";

	private ArrayList<SGStudent> stds;
	private Scanner keyIn;
	
	public SGManageStudent() {
		stds = new ArrayList<>();
		
		load();
	}
	
	public void registerStudent(String name, String studentId, int kor, int eng, int math) {
		stds.add(new SGStudent(name, studentId, kor, eng, math));
		System.out.println("등록되었습니다.");
		save(STUDENT_DIR);
	}
	
	public void searchStudent(String studentId) {
		SGStudent s = search(studentId);
		
		if(s != null) {
			System.out.println("----------검색 결과----------");
			System.out.println(s.toString());
		} else {
			System.out.println("찾는 학번의 학생이 존재하지 않습니다.");
		}
	}
	
	public void deleteStudent(String studentId) {
		File file = new File(STUDENT_DIR);
		
		SGStudent s = search(studentId);
		
		if(s != null) {
			System.out.println("----------학생 삭제----------");
			stds.remove(s);
			
			save(TEMP_DIR);
			
			file.delete();
			file = new File(TEMP_DIR);
			file.renameTo(new File(STUDENT_DIR));
		} else {
			System.out.println("찾는 학번의 학생이 존재하지 않습니다.");
		}
	}
	
//	private void changeFileName() {
//		File file = new File(TEMP_DIR);
//		
//		file.renameTo(new File(""))
//	}
	
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
	
	public ArrayList<SGStudent> printStudent(int select) {
		if(select == 0) {
			System.out.println("----------성적순 출력----------");
			Collections.sort(stds);
			for(SGStudent s : stds) {
				System.out.println(s.toString());
			}
		} else if (select == 1) {
			System.out.println("----------학번순 출력----------");
			Collections.sort(stds, new Comparator<SGStudent>() {
				@Override
				public int compare(SGStudent o1, SGStudent o2) {
					return o1.getStudentId().compareTo(o2.getStudentId());
				}
			});
			
			for(SGStudent s : stds) {
				System.out.println(s.toString());
			}
		}
		
		return stds;
	}
	
	public void modifyStudent(String target, String name, String studentId, int kor, int eng, int math) {
		File file = new File(STUDENT_DIR);
		
		SGStudent student = search(target);
		
		modify(student, name, studentId, kor, eng, math);
		
		if(student != null) {
			System.out.println("----------학생 수정----------");
			
			save(TEMP_DIR);
			
			file.delete();
			file = new File(TEMP_DIR);
			file.renameTo(new File(STUDENT_DIR));
		} else {
			System.out.println("찾는 학번의 학생이 존재하지 않습니다.");
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
