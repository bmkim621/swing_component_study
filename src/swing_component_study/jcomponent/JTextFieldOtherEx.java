package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class JTextFieldOtherEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfId;
	private JPasswordField pfPwd;
	private JPasswordField pfPwd2;
	private JTextField tfDate;
	private JButton btnOk;
	private JLabel lblConfirm;	//지역변수에서 필드로 선언(lblConfirm 사용하기 위해)
	private JFormattedTextField ftDate;
	private JTextArea textArea;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTextFieldOtherEx frame = new JTextFieldOtherEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public JTextFieldOtherEx() throws ParseException {
		initComponents();
	}
	private void initComponents() throws ParseException {
		setTitle("JField");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pContent = new JPanel();
		pContent.setBorder(new TitledBorder(null, "TextField \uC0AC\uC6A9 \uC608", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pContent, BorderLayout.NORTH);
		pContent.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblId = new JLabel("ID :");
		pContent.add(lblId);
		
		tfId = new JTextField();
		pContent.add(tfId);
		
		JLabel lblPw = new JLabel("PASSWORD :");
		pContent.add(lblPw);
		
		pfPwd = new JPasswordField();
		pContent.add(pfPwd);
		
		JLabel lblPassword = new JLabel("PASSWORD 확인");
		pContent.add(lblPassword);
		
		pfPwd2 = new JPasswordField();
		pContent.add(pfPwd2);
		
		JPanel pBlank = new JPanel();
		pContent.add(pBlank);
		
		lblConfirm = new JLabel("");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setForeground(Color.RED);
		pContent.add(lblConfirm);
		
		JLabel lblDate = new JLabel("DATE :");
		pContent.add(lblDate);
		
		MaskFormatter mf = new MaskFormatter("####-##-##");
		mf.setPlaceholderCharacter('_');
		ftDate = new JFormattedTextField(mf);
		ftDate.setValue(LocalDate.now());
		pContent.add(ftDate);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		pContent.add(btnOk);
		
		btnCancel = new JButton("초기화");
		btnCancel.addActionListener(this);
		pContent.add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		
		if (e.getSource() == btnOk) {
			
			do_btnOk_actionPerformed(e);
		}
	}
	protected void do_btnOk_actionPerformed(ActionEvent e) {
		//검사
		try {
			validCheck();
			
			//예외 안 뜨는 경우
			String pwd1 = new String(pfPwd.getPassword());
			String pwd2 = new String(pfPwd2.getPassword());
			
			if(pwd1.equals(pwd2)) {
				lblConfirm.setText("일치");
			} else {
				lblConfirm.setText("불일치");
			}
			
			//id입력값 가져오기
			String message = String.format("id = %s%n"
					+ "passwd1 = %s%n"
					+ "passwd2 = %s%n"
					+ "date = %s%n", tfId.getText().trim(), pwd1, pwd2, ftDate.getText());
			
			textArea.append(message);
			//포커스를 선택해야 selectAll 가능
			//id
			tfId.requestFocus();
			tfId.selectAll();

			textArea.setCaretPosition(textArea.getDocument().getLength());
			
		} catch (Exception e1) {
			//예외 발생하는 경우
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}	
	}
	
	//초기화버튼
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		tfId.setText("");
		pfPwd.setText("");
		pfPwd2.setText("");
		lblConfirm.setText("");
		ftDate.setValue(LocalDate.now());
		tfId.requestFocus();
	}
	
	//검사
	private void validCheck() throws Exception {
		//
		if(tfId.getText().equals("")) {
			throw new Exception("ID가 비어있습니다.");
		}
		
		//tfPwd, tfPwd2를 가져올 수 없기 때문에
		String pwd1 = new String(pfPwd.getPassword());
		String pwd2 = new String(pfPwd2.getPassword());
		
		//비밀번호
		if(pwd1.equals("")) {
			throw new Exception("PASSWORD가 비어있습니다.");
		}
		
		//비밀번호 확인
		if(pwd2.equals("")) {
			throw new Exception("PASSWORD 확인이 비어있습니다.");
		}
	}
}
