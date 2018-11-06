package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class JCheckBoxItemEventEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JLabel sumLabel;
	private int sum;
	private JCheckBox chckbx1;
	private JCheckBox chckbx2;
	private JCheckBox chckbx3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckBoxItemEventEx frame = new JCheckBoxItemEventEx();
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
	public JCheckBoxItemEventEx() {
		initComponents();
	}
	private void initComponents() {
		setTitle("체크박스와 ItemEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 10, 10));
		
		JLabel JLabel = new JLabel("사과 100원, 배 500원, 체리 20000원");
		JLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(JLabel);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		chckbx1 = new JCheckBox("사과");
		chckbx1.addItemListener(this);
		panel.add(chckbx1);
		
		chckbx2 = new JCheckBox("배");
		chckbx2.addItemListener(this);
		panel.add(chckbx2);
		
		chckbx3 = new JCheckBox("체리");
		chckbx3.addItemListener(this);
		chckbx3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(chckbx3);
		
		sumLabel = new JLabel("현재 0원 입니다.");
		sumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(sumLabel);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == chckbx3) {
			do_chckbx3_itemStateChanged(e);
		}
		if (e.getSource() == chckbx2) {
			do_chckbx2_itemStateChanged(e);
		}
		if (e.getSource() == chckbx1) {
			do_chckbxNewCheckBox_itemStateChanged(e);
		}
	}
	
	//사과
	protected void do_chckbxNewCheckBox_itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			sum += 100;
		} else {
			sum -= 100;
		}
		sumLabel.setText("현재 " + sum + "원 입니다.");
	}
	
	//배
	protected void do_chckbx2_itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			sum += 500;
		} else {
			sum -= 500;
		}
		sumLabel.setText("현재 " + sum + "원 입니다.");
	}
	
	//체리
	protected void do_chckbx3_itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			sum += 20000;
		} else {
			sum -= 20000;
		}
		sumLabel.setText("현재 " + sum + "원 입니다.");
	}
}
