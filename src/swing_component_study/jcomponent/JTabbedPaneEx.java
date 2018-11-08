package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class JTabbedPaneEx extends JFrame {

	private JPanel contentPane;
	private String imgPath;

	/**
	 * Create the frame.
	 */
	public JTabbedPaneEx() {
		imgPath = System.getProperty("user.dir") + "\\images\\";
		initComponents();
	}
	private void initComponents() {
		setTitle("JTabbedPaneEx");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JLabel lblTab1 = new JLabel(new ImageIcon(imgPath + "img1.jpg") );
		tabbedPane.addTab("tab 1", null, lblTab1, "슈퍼맨");
		
		JLabel lblTab2 = new JLabel(new ImageIcon(imgPath + "img2.jpg") );
		tabbedPane.addTab("tab 2", null, lblTab2, "원더우먼");
		
		TblPanel panel = new TblPanel();
		tabbedPane.addTab("tab 3", null, panel, "테이블");
	}

}
