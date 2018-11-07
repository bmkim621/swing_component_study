package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class RadioBtnEventEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtn1;
	private JLabel imageLabel = new JLabel();
	String imagesPath = System.getProperty("user.dir")+"\\images\\fruits\\";
	private ImageIcon [] image = {
								new ImageIcon(imagesPath + "apple.jpg"),
								new ImageIcon(imagesPath + "pear.jpg"),
								new ImageIcon(imagesPath + "cherry.jpg")
								};
	private JRadioButton rdbtn2;
	private JRadioButton rdbtn3;
	
	

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioBtnEventEx frame = new RadioBtnEventEx();
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
	public RadioBtnEventEx() {
		initComponents();
	}
	private void initComponents() {
		setTitle("라디오버튼 Item Event 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, BorderLayout.NORTH);
		
		rdbtn1 = new JRadioButton("사과");
		//선택되기 전에 ItemListener 불러 와야 됨.
		rdbtn1.addItemListener(this);
		rdbtn1.setSelected(true);
		rdbtn1.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtn1);
		panel.add(rdbtn1);
		
		rdbtn2 = new JRadioButton("배");
		rdbtn2.addItemListener(this);
		rdbtn2.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtn2);
		panel.add(rdbtn2);
		
		rdbtn3 = new JRadioButton("체리");
		rdbtn3.addItemListener(this);
		rdbtn3.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtn3);
		panel.add(rdbtn3);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		contentPane.add(imageLabel, BorderLayout.CENTER);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == rdbtn3) {
			do_rdbtn3_itemStateChanged(e);
		}
		if (e.getSource() == rdbtn2) {
			do_rdbtn2_itemStateChanged(e);
		}
		if (e.getSource() == rdbtn1) {
			do_rdbtn1_itemStateChanged(e);
		}
	}
	
	//사과
	protected void do_rdbtn1_itemStateChanged(ItemEvent e) {
		imageLabel.setIcon(image[0]);
	}
	protected void do_rdbtn2_itemStateChanged(ItemEvent e) {
		imageLabel.setIcon(image[1]);
	}
	protected void do_rdbtn3_itemStateChanged(ItemEvent e) {
		imageLabel.setIcon(image[2]);
	}
}
