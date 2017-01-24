package ui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.SGConstants.ELabelItems;

public class SGModifyInterface extends JDialog {
	
	private JTextField[] textField;

	public SGModifyInterface() {
		setModal(true);	// 대화상자 실행 시 상위 프레임 조작 불가하도록 설정
		
		setLayout(new GridLayout(6, 2, 10, 10));
		
		textField = new JTextField[ELabelItems.values().length];
		
		for(ELabelItems e : ELabelItems.values()) {
			int p = e.ordinal();
			textField[p] = new JTextField();
			add(new JLabel(e.name()));
			add(textField[p]);
		}
		
		add(new JButton("수정"));
		add(new JButton("취소"));
	}

	public void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
