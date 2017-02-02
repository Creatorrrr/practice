package controller;
import java.sql.SQLException;
import java.util.ArrayList;

import constants.SGConstants;
import constants.SGConstants.EOrderItems;
import jdbc.SGStoreDB;

public class SGManageStudent {
	
//	private static final String TEMP_DIR = "temp_data.dat";
//	private static final String STUDENT_DIR = "student_data.dat";

//	private ArrayList<SGStudent> stds;
	
	SGStoreDB storeDB;
	
	public SGManageStudent() {
		storeDB = new SGStoreDB();
		
//		stds = new ArrayList<>();
//		
//		load();
	}
	
//	public ArrayList<SGStudent> getStudentList() {
//		return stds;
//	}
	
	public boolean registerStudent(String name, String studentId, int kor, int eng, int math) {
		try {
			storeDB.insertStudent(new SGStudent(name, studentId, kor, eng, math));
			System.out.println("��� ����");
			return true;
		} catch (SQLException e) {
			System.out.println("��� ����");
		}
		return false;
	}
	
	public ArrayList<SGStudent> searchStudent(String studentId, EOrderItems order) {
		ArrayList<SGStudent> searchedList = new ArrayList<>();
		
		try {
			storeDB.selectStudent(studentId, order);
			System.out.println("�˻� ����");
			return searchedList;
		} catch (SQLException e) {
			System.out.println("�˻� ����");
		}
		return null;
	}
	
	public boolean deleteStudent(String studentId) {
		try {
			storeDB.deleteStudent(studentId);
			System.out.println("���� ����");
			return true;
		} catch (SQLException e) {
			System.out.println("���� ����");
		}
		return false;
	}
	
//	private void save(String dir) {
//		ObjectOutputStream fout = null;
//		
//		try {
//			fout = new ObjectOutputStream(new FileOutputStream(dir));
//			
//			fout.writeObject(stds);
//			fout.flush();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(fout != null) fout.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	private void load() {
//		
//		ObjectInputStream fin = null;
//		
//		try {
//			fin = new ObjectInputStream(new FileInputStream(STUDENT_DIR));
//			
//			stds = (ArrayList<SGStudent>)fin.readObject();
//			
//		} catch (FileNotFoundException e) {
//			System.out.println("��ϵ� �л� ������ �������� �ʽ��ϴ�.");
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(fin != null) fin.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
//	private SGStudent search(String studentId) {
//		for(SGStudent s : stds) {
//			if(s.getStudentId().equals(studentId)) {
//				return s;
//			}
//		}
//		return null;
//	}
	
//	public void sortStudent(int select) {
//		if(select == ESortOptionItems.SORT_BY_SCORE.ordinal()) {
//			Collections.sort(stds);
//		} else if (select == ESortOptionItems.SORT_BY_ID.ordinal()) {
//			Collections.sort(stds, new Comparator<SGStudent>() {
//				@Override
//				public int compare(SGStudent o1, SGStudent o2) {
//					return o1.getStudentId().compareTo(o2.getStudentId());
//				}
//			});
//		}
//	}
	
	public int modifyStudent(String targetId, String name, String studentId, int kor, int eng, int math) {
		try {
			storeDB.updateStudent(new SGStudent(name, studentId, kor, eng, math), targetId);
			System.out.println("���� ����");
			return SGConstants.TRUE;
		} catch (SQLException e) {
			System.out.println("���� ����");
		}
		return SGConstants.FALSE;
	}
	
//	private void modify(SGStudent student, String name, String studentId, int kor, int eng, int math) {
//		student.setName(name);
//		student.setStudentId(studentId);
//		student.setKor(kor);
//		student.setEng(eng);
//		student.setMath(math);
//	}
}
