package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JButtonEx extends JFrame {

	private JPanel contentPane;

/*	*//**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JButtonEx frame = new JButtonEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public JButtonEx() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 272, 181);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//★프로그램이 실행된 경로(진짜 진짜 중요!!)★
		String imagesPath = System.getProperty("user.dir")+"\\images\\";
		ImageIcon normalIcon = new ImageIcon(imagesPath + "normalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon(imagesPath + "rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon(imagesPath + "pressedIcon.gif");
		
		JButton btn = new JButton("call~~", normalIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		
		contentPane.add(btn, BorderLayout.CENTER);
	}

}
