package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class JComponentMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComponentMain frame = new JComponentMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JComponentMain() {
		initComponents();
	}
	private void initComponents() {
		setTitle("모든 JCompponent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 10));
		
		btn1 = new JButton("JButtonEx");
		btn1.addActionListener(this);
		contentPane.add(btn1);
		
		btn2 = new JButton("JCheckBoxItemEventEx");
		btn2.addActionListener(this);
		contentPane.add(btn2);
		
		btn3 = new JButton("JComponentEx");
		btn3.addActionListener(this);
		contentPane.add(btn3);
		
		btn4 = new JButton("JLabelEx");
		btn4.addActionListener(this);
		contentPane.add(btn4);
		
		btn5 = new JButton("JListAndJComboEx");
		btn5.addActionListener(this);
		contentPane.add(btn5);
		
		btn6 = new JButton("JTextFieldOtherEx");
		btn6.addActionListener(this);
		contentPane.add(btn6);
		
		btn7 = new JButton("RadioBtnEventEx");
		btn7.addActionListener(this);
		contentPane.add(btn7);
		
		btn8 = new JButton("JSliderChangeEventEx");
		btn8.addActionListener(this);
		contentPane.add(btn8);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn8) {
			showframe(new JSliderChangeEventEx());
		}
		if (e.getSource() == btn7) {
			showframe(new RadioBtnEventEx());
		}
		if (e.getSource() == btn6) {
			//예외처리 
			try {
				showframe(new JTextFieldOtherEx());
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "error");
			}
		}
		if (e.getSource() == btn5) {
			showframe(new JListAndJComboEx());
		}
		if (e.getSource() == btn4) {
			showframe(new JLabelEx());
		}
		if (e.getSource() == btn3) {
			showframe(new JComponentEx());
		}
		if (e.getSource() == btn2) {
			showframe(new JCheckBoxItemEventEx());
		}
		if (e.getSource() == btn1) {
			showframe(new JButtonEx());
		}
	}
		
	private void showframe(JFrame frame) {
		frame.setVisible(true);
	}

	//버튼6 JTextFieldOtherEx
	protected void do_btn6_actionPerformed(ActionEvent e) throws ParseException {
	}
}
