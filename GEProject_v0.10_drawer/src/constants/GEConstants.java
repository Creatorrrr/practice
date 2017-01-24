package constants;

import java.awt.Color;

public class GEConstants {
// 메인 프레임 
	
	 public static final String MAINFRAME_TITLE = "그림판 ver-1.0";
	 public static final int MAINFRAME_WIDTH = 500;
	 public static final int MAINFRAME_HEIGHT = 800;

// 메뉴
	 
	 public enum EFileMenuItems {
		 새파일, 열기, 저장, 다른이름으로저장, 종료
	 }
	 
	 public enum EEditMenuItems {
		 복사, 잘라내기, 삭제, 붙이기, 그룹, 그룹해제
	 }
	 
	 public enum EColorMenuItems {
		 선색, 선색지우기, 면색, 면색지우기
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
