package swing_component_study.jcomponent;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TblPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TblPanel() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{1, "김보민", 90, 90, 90, 270, 90},
				{2, "우선미", 90, 90, 90, 270, 90},
				{3, "박수완", 90, 90, 90, 270, 90},
			},
			new String[] {
				"학번", "이름", "국어 점수", "영어 점수", "수학 점수", "총점", "평균"
			}
		));
		scrollPane.setViewportView(table);
	}

}
