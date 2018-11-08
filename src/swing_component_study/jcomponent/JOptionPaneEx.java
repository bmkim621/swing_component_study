package swing_component_study.jcomponent;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class JOptionPaneEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public JOptionPaneEx() {
		initComponents();
	}
	private void initComponents() {
		setTitle("JOptionPaneEx");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "ShowInputDialog", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 1, 0, 0));
		
		btnNewButton = new JButton("Input");
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "ShowConfirmDialog", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 1, 0, 0));
		
		JButton button = new JButton("New button");
		panel_1.add(button);
		
		JButton button_1 = new JButton("New button");
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("New button");
		panel_1.add(button_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "ShowMessageDialog", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 1, 0, 0));
		
		JButton button_3 = new JButton("New button");
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("New button");
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("New button");
		panel_2.add(button_5);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		String[] selectionValues = {"가", "나", "다"};
		Object res = JOptionPane.showInputDialog(null, "showInputdialog", "Title", JOptionPane.INFORMATION_MESSAGE, null, selectionValues, selectionValues[2]);
	}
}
