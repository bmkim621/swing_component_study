package swing_component_study.jcomponent;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Arrays;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

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
				"학번", "이름", "국어", "영어", "수학", "총점", "평균"
			}
		));
		scrollPane.setViewportView(table);
		//0,1 컬럼은 가운데, 2~6까지 컬럼은 오른쪽
		
		//정렬, 폭 => 메서드 만들고 가변배열로 처리
		setAlignWidth();
	}
	
	//tableCellAlignment, tableSetWidth 추상메서드로 하고 setAlignWidth만 조절하면 됨.
	private void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1);
		tableCellAlignment(SwingConstants.RIGHT, 2, 3, 4, 5, 6);
		tableSetWidth(100, 200, 100, 100, 100, 150, 150);
	}
	
	//정렬
	//cell: column과 row가 만나는 영역
	private void tableCellAlignment(int align, int...idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		//Horizontal=> 수평, Center => 가운데
		dtcr.setHorizontalAlignment(align);
		
		System.out.println(Arrays.toString(idx));
		
		//column참조하기, 첫번째 column => 0, 두번째 column => 1, .. 
		TableColumnModel tcm = table.getColumnModel();
		//tcm.getColumn(0) => 0번째 column이니까 학번
		/*tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(1).setCellRenderer(dtcr);*/
		
		//반복문으로 처리하기
		//idx에는 [0,1] [2,3,4,5,6]이므로,
		//idx[i] => [0,1]중 i번째, [2,3,4,5,6]중 i번째
		for(int i = 0 ; i < idx.length ; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
		//tcm을 이용하면 총 column 개수를 알 수 있다. => tcm.getcolumnCount
	}

	//폭
	private void tableSetWidth(int...width) {
		TableColumnModel tcm = table.getColumnModel();
		
		for(int i = 0 ; i < width.length ; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}
}
