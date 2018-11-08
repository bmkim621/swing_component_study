package swing_component_study.jcomponent;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderChangeEventEx extends JFrame implements ActionListener, ChangeListener {

	private JPanel contentPane;
	private JButton btnOk;
	private JSlider slider;
	private JLabel lblValue;
	private JLabel lblColor;
	private JSlider sliderG;
	private JSlider sliderB;
	private JSlider sliderR;
	private JPanel pSpinner;
	private JSpinner spList;
	private JSpinner spNumber;
	private JSpinner spDate;
	private JButton btnNewButton;
	private JPanel panel;


	/**
	 * Create the frame.
	 */
	public JSliderChangeEventEx() {
		initComponents();
	}
	private void initComponents() {
		setForeground(Color.RED);
		setTitle("JSliderChangeEventEx");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 638, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 0));
		
		JPanel pBasicSlider = new JPanel();
		pBasicSlider.setBorder(new TitledBorder(null, "\uC2AC\uB77C\uC774\uB354 \uCEF4\uD3EC\uB10C\uD2B8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pBasicSlider);
		
		slider = new JSlider();
		slider.addChangeListener(this);
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		pBasicSlider.add(slider);
		
		btnOk = new JButton("슬라이더 값 확인");
		btnOk.addActionListener(this);
		pBasicSlider.add(btnOk);
		
		lblValue = new JLabel("");
		pBasicSlider.add(lblValue);
		
		JPanel pAdvanceSlider = new JPanel();
		pAdvanceSlider.setBorder(new TitledBorder(null, "\uC774\uBCA4\uD2B8\uB97C \uC801\uC6A9\uD55C \uC2AC\uB77C\uC774\uB354", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pAdvanceSlider);
		pAdvanceSlider.setLayout(new GridLayout(0, 1, 10, 0));
		
		
		
		sliderR = new JSlider();
		
		sliderR.setValue(128);
		sliderR.setForeground(Color.RED);
		sliderR.setMaximum(250);
		sliderR.setMinorTickSpacing(10);
		sliderR.setMajorTickSpacing(50);
		sliderR.setPaintTicks(true);
		sliderR.setPaintLabels(true);
		pAdvanceSlider.add(sliderR);
		
		sliderG = new JSlider();
		
		sliderG.setValue(128);
		sliderG.setForeground(Color.GREEN);
		sliderG.setMaximum(250);
		sliderG.setMinorTickSpacing(10);
		sliderG.setMajorTickSpacing(50);
		sliderG.setPaintTicks(true);
		sliderG.setPaintLabels(true);
		pAdvanceSlider.add(sliderG);
		
		sliderB = new JSlider();
		
		sliderB.setValue(128);
		sliderB.setForeground(Color.BLUE);
		sliderB.setMinorTickSpacing(10);
		sliderB.setMaximum(250);
		sliderB.setMajorTickSpacing(50);
		sliderB.setPaintTicks(true);
		sliderB.setPaintLabels(true);
		pAdvanceSlider.add(sliderB);
		
		
		lblColor = new JLabel("SLIDER EXAMPLE");
		lblColor.setOpaque(true);
		lblColor.setBackground(new Color(sliderR.getValue(), sliderG.getValue(), sliderB.getValue()));
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		pAdvanceSlider.add(lblColor);
		
		//lblColor를 먼저 달기 전에 이벤트 리스너가 있으면 바로 리스너 호출하기 때문에, 리스너는 마지막에
		sliderR.addChangeListener(this);
		sliderG.addChangeListener(this);
		sliderB.addChangeListener(this);
		
		pSpinner = new JPanel();
		contentPane.add(pSpinner);
		pSpinner.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel = new JPanel();
		pSpinner.add(panel);
		
		spList = new JSpinner();
		spList.setModel(new SpinnerListModel(new String[] {"\uC18C\uC124", "\uC7A1\uC9C0", "\uC804\uACF5\uC11C\uC801", "\uCDE8\uBBF8"}));
		panel.add(spList);
		
		spNumber = new JSpinner();
		spNumber.setModel(new SpinnerNumberModel(1, 0, 9, 1));
		panel.add(spNumber);
		
		spDate = new JSpinner();
		Calendar calendar = Calendar.getInstance();
		Date value = calendar.getTime();
		
		calendar.add(Calendar.YEAR, -50);
		Date start = calendar.getTime();
		
		calendar.add(calendar.YEAR, 100);
		Date end = calendar.getTime();
		
		spDate.setModel(new SpinnerDateModel(new Date(1541602800000L), start, end, Calendar.YEAR));
		spDate.setEditor(new JSpinner.DateEditor(spDate, "yyyy/MM/dd"));
		
		panel.add(spDate);
		
		btnNewButton = new JButton("값 가져오기");
		btnNewButton.addActionListener(this);
		pSpinner.add(btnNewButton);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			do_btnOk_actionPerformed(e);
		}
	}
	
	//슬라이더 값 확인 버튼(슬라이더 값을 가져온다.)
	protected void do_btnOk_actionPerformed(ActionEvent e) {
		//참조하는 것 JSlider => 메서드 안에 있으니까 JSlider를 필드로
		int value = slider.getValue();
		JOptionPane.showMessageDialog(null, "슬라이더의 값은 " + value);
	}
	
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == sliderR || e.getSource() == sliderG || e.getSource() == sliderB) {
			Color color = new Color(sliderR.getValue(), sliderG.getValue(), sliderB.getValue());
			lblColor.setBackground(color);
			Color fcolor = new Color(255-sliderR.getValue(), 255-sliderG.getValue(), 255-sliderB.getValue());
			lblColor.setForeground(fcolor);
		}
	}
	
	protected void do_slider_stateChanged(ChangeEvent e) {
		//setText는 String이므로 int오면 X, int오면 뒤에 "" 붙여서 문자로
		int value = slider.getValue();
		lblValue.setText(value + "");
	}
	
	//스피너 값 가져오기
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		//리스트
		String getItem = (String) spList.getValue();
		//숫자
		int getNum = (int) spNumber.getValue();
		//날짜
		Date getDate = (Date) spDate.getValue();
		//날짜 포맷
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		JOptionPane.showMessageDialog(null, "item : " + getItem + "\nNumber : " + getNum + "\nDate : " + sdf.format(getDate));
	}
}
