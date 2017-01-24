package constants;

import java.awt.Color;

public class GEConstants {
// ���� ������ 
	
	 public static final String MAINFRAME_TITLE = "�׸��� ver-1.0";
	 public static final int MAINFRAME_WIDTH = 500;
	 public static final int MAINFRAME_HEIGHT = 800;

// �޴�
	 
	 public enum EFileMenuItems {
		 ������, ����, ����, �ٸ��̸���������, ����
	 }
	 
	 public enum EEditMenuItems {
		 ����, �߶󳻱�, ����, ���̱�, �׷�, �׷�����
	 }
	 
	 public enum EColorMenuItems {
		 ����, ���������, ���, ��������
	 }
	 
	 public enum EToolbarButtons {
		 Select, Rectangle, Ellipse, Line, Polygon
	 }
	 
	 public enum EState {
		 Idle, TwoPointsDrawing, NPointsDrawing
	 }
	 
// Select(AnchorList)
	 public static final int ANCHOR_W = 6;
	 public static final int ANCHOR_H = 6;
	 public static final int RR_OFFSET = 40;
	 
	 public static final Color ANCHOR_LINECOLOR = Color.BLUE;
	 public static final Color ANCHOR_FILLCOLOR = Color.PINK;
	 
	 public enum EAnchorTypes {
		 NW, NN, NE, WW, WE, SW, SS, SE, RR, NONE
	 }
}
