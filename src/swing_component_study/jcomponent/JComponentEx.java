package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JComponentEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton b3;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComponentEx frame = new JComponentEx();
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
	public JComponentEx() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//크기(100 x, 100 y <- 모니터 상에서의 100px) 450 폭 , 300너비
		setBounds(100, 100, 260, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton b1 = new JButton("Margenta/Yellow Button");
		b1.setBackground(Color.YELLOW);
		b1.setForeground(Color.MAGENTA);
		b1.setFont(new Font("Arial", Font.ITALIC, 20));
		contentPane.add(b1);
		
		JButton b2 = new JButton("Disabled Button");
		b2.setEnabled(false);
		contentPane.add(b2);
		
		b3 = new JButton("getX(), getY()");
		b3.addActionListener(this);
		contentPane.add(b3);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b3) {
			do_btnNewButton_2_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		JComponentEx frame = (JComponentEx) b.getTopLevelAncestor();
		frame.setTitle(b.getX() + "," + b.getY());
	}
}
