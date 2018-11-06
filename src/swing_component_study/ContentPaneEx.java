package swing_component_study;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContentPaneEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnOK;
	//Rename에서 be Field로 설정했기 때문에
	private JButton btnClose;
	private JButton btnCancel;

	/**
	 * Create the frame.
	 */
	public ContentPaneEx() {
		setTitle("ContentPane과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnOK = new JButton("OK");
		//클릭하는 순간  implements ActionListener에 의해 actionPerformed를 수행하게 된다.
		btnOK.addActionListener(this);	//this => ContentPaneEx 인데 기준이 AddActionListener. 부모는? implements의 ActionListner임.	
		contentPane.add(btnOK);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);	//this니까 ok인지 cancel인지 모름. 그래서 아래에서 나눠준 것!
		contentPane.add(btnCancel);
		
		btnClose = new JButton("Close");
		contentPane.add(btnClose);
		
		//창을 보이게 한다.
//		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		
		if (e.getSource() == btnCancel) {	//cancel일 때 수행
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnOK) {	//OK버튼
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}
}
