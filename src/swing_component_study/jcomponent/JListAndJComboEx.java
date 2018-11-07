package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

public class JListAndJComboEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfName;
	private JList<String> listName;
	private List<String> listArrayListNames;
	//이미지
	String imagesPath = System.getProperty("user.dir")+"\\images\\fruits\\";
	private ImageIcon [] image = {
								new ImageIcon(imagesPath + "apple.jpg"),
								new ImageIcon(imagesPath + "banana.jpg"),
								new ImageIcon(imagesPath + "cherry.jpg"),
								new ImageIcon(imagesPath + "kiwi.jpg"),
								new ImageIcon(imagesPath + "mango.jpg"),
								new ImageIcon(imagesPath + "pear.jpg")
								};
	private JLabel imgLabel = new JLabel();
	private JComboBox<String> cmb3;

	/**
	 * Launch the aw Runnable() {
			public void run() {
				try {
					JListAndJComboEx frame = new JListAndJComboEx();
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
	public JListAndJComboEx() {
		listArrayListNames = new ArrayList<String>();
		initComponents();
	}
	private void initComponents() {
		setTitle("JList And JComboBox");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 914, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 10, 0));
		
		JPanel pJList = new JPanel();
		pJList.setBorder(new TitledBorder(null, "JList", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pJList);
		pJList.setLayout(new GridLayout(0, 3, 10, 0));
		
		//과일

		JList<String> list = new JList<>(/*fruits*/);
		list.setListData(getStringData());
		pJList.add(list);
		
		//이미지
		JList listImg = new JList();
		listImg.setListData(getImgIcons());
		pJList.add(listImg);
		
		JPanel pInputList = new JPanel();
		pJList.add(pInputList);
		pInputList.setLayout(new BorderLayout(0, 0));
		
		Panel pInputName = new Panel();
		pInputList.add(pInputName, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("이름 입력 후 <Enter>키");
		lblNewLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String selectedName = listName.getSelectedValue();
				int selectedIndex = listName.getSelectedIndex();
				JOptionPane.showMessageDialog(null, "선택한 이름은 " + selectedName + "\n선택한 이름의 위치는 " + selectedIndex);
			}
			
		});
		pInputName.add(lblNewLabel);
		
		tfName = new JTextField();
		tfName.addActionListener(this);
		pInputName.add(tfName);
		tfName.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		pInputList.add(scrollPane, BorderLayout.CENTER);
		
		listName = new JList();
		scrollPane.setViewportView(listName);
		
		JPanel pJCombo = new JPanel();
		pJCombo.setBorder(new TitledBorder(null, "JComboBox", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pJCombo);
		pJCombo.setLayout(new GridLayout(0, 2, 10, 10));
		
		JPanel subPjcombo1 = new JPanel();
		pJCombo.add(subPjcombo1);
		
		String[] strArr1 = {"Apple", "Banana", "Cherry"};
		//WindowBuilder에서 보이게 하기 위해서 DefaultcomboBoxModel
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(strArr1);
		JComboBox<String> cmb1 = new JComboBox<>(model);
	
		subPjcombo1.add(cmb1);
		
		String[] strArr2 = {"김보민", "우선미", "황경수", "이준민"};
		JComboBox<String> cmb2 = new JComboBox<>();
		
		//반복문으로 하거나 defaultComboBoxModel로 처리
		for(int i = 0 ; i < strArr2.length ; i++) {
			cmb2.addItem(strArr2[i]);
		}
		
		//setSelected => 창 띄웠을 때 default값
		//-1: 기본값이 선택되지 않도록
		cmb2.setSelectedIndex(-1);
		
		//cmb2 클릭할 때마다 액션 리스너 호출
		cmb2.addActionListener(new ActionListener() {
			//cmb2에 선택된 것 가져오기.
			@Override
			public void actionPerformed(ActionEvent e) {
				//cmb2에는 String이 있으니까
				String name = (String) cmb2.getSelectedItem();
				//선택된 위치 => 인덱스는 Int
				int index = cmb2.getSelectedIndex();
				JOptionPane.showMessageDialog(null, index + "번째 선택된 이름 " + name);
			}
		});
		subPjcombo1.add(cmb2);
		
		JPanel subPjcombo2 = new JPanel();
		pJCombo.add(subPjcombo2);
		subPjcombo2.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel panel = new JPanel();
		subPjcombo2.add(panel);
		
		
		
		//콤보박스
		String[] strArr3 = {"apple", "banana", "cherry", "kiwi", "mango", "pear"};
		DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<>(strArr3);
		cmb3 = new JComboBox<>(model1);
		
		//-1: 기본값이 선택되지 않도록
		cmb3.setSelectedIndex(-1);
				
		cmb3.addActionListener(this);
	
		panel.add(cmb3);
		
		imgLabel = new JLabel("");
		subPjcombo2.add(imgLabel);
	}
	
	//이미지
	private Object[] getImgIcons() {
		String imgPath = System.getProperty("user.dir") + "\\images\\";
		ImageIcon[] icons = new ImageIcon[] {
				new ImageIcon(imgPath + "icon1.png"),
				new ImageIcon(imgPath + "icon2.png"),
				new ImageIcon(imgPath + "icon3.png"),
				new ImageIcon(imgPath + "icon4.png")
		};
		return icons;
}
	//과일
	private String[] getStringData() {
		return new String[] {"Apple", "Banana", "Kiwi", "Mango", "Pear", "Peach", "Berry", "Strawberry", "Blackberry"};
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmb3) {
			do_cmb3_actionPerformed(e);
		}
		if (e.getSource() == tfName) {
			do_tfName_actionPerformed(e);
		}
	}
	
	protected void do_tfName_actionPerformed(ActionEvent e) {
		listArrayListNames.add(tfName.getText().trim());
		listName.setListData(new Vector<>(listArrayListNames));
		tfName.setText("");
		tfName.requestFocus();
	}
	
	//콤보박스 눌렀을 때
	protected void do_cmb3_actionPerformed(ActionEvent e) {
		int index = cmb3.getSelectedIndex();
		imgLabel.setIcon(image[index]);
	}
}
