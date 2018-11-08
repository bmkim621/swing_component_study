package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilePermission;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class JFileChooserEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem mntmOpen;
	private JLabel lblImg;
	private JMenuItem mntmSave;
	private JMenuItem mntmFileOpen;

	//JFileChooser => 경로만
	

	/**
	 * Create the frame.
	 */
	public JFileChooserEx() {
		initComponents();
	}
	private void initComponents() {
		setTitle("JFileChooserEx");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(this);
		mnNewMenu.add(mntmOpen);
		
		mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(this);
		mnNewMenu.add(mntmSave);
		
		mntmFileOpen = new JMenuItem("파일 읽어오기");
		mntmFileOpen.addActionListener(this);
		mnNewMenu.add(mntmFileOpen);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblImg = new JLabel("");
		contentPane.add(lblImg, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmFileOpen) {
			do_mntmFileOpen_actionPerformed(e);
		}
		if (e.getSource() == mntmSave) {
			do_mntmSave_actionPerformed(e);
		}
	}
	
	//save
	protected void do_mntmSave_actionPerformed(ActionEvent e) {
		//현재 실행 경로
		String currentDirectoryPath = System.getProperty("user.dir") + "\\backup";
		//backup폴더가 없으므로...
		File backupDir = new File(currentDirectoryPath);
		//폴더를 미리 만들어준다.
		if(!backupDir.exists()) {	//exist => boolean
			//존재하지 않으면
			backupDir.mkdir();
		}
		JFileChooser chooser = new JFileChooser(currentDirectoryPath);
		
		int ret = chooser.showSaveDialog(null);
		System.out.println("ret : " + ret);
		//X버튼 누르거나 취소 => 1, 파일 열었을 때 => 0
		if( ret != JFileChooser.APPROVE_OPTION) {	//열기버튼 말고 다른 버튼 눌렀으면
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		//경로 가져오기
		String filePath = chooser.getSelectedFile().getPath();
		//파일 이름 가져오기
		String fileName = chooser.getSelectedFile().getName();
		
		//확인
		JOptionPane.showMessageDialog(null, filePath + " : " + fileName);
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
			bw.write("김보민, 우선미, 황경수, 서동준, 김재영, 박수완, 이천희, 이준민");
			bw.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "저장 완료!");
	}
	
	//파일 읽어오기
	protected void do_mntmFileOpen_actionPerformed(ActionEvent e) {
		String currentDirectoryPath = System.getProperty("user.dir") + "\\backup";
		JFileChooser chooser = new JFileChooser(currentDirectoryPath);
		
		int ret = chooser.showSaveDialog(null);
		//X버튼 누르거나 취소 => 1, 파일 열었을 때 => 0
		if( ret != JFileChooser.APPROVE_OPTION) {	//열기버튼 말고 다른 버튼 눌렀으면
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		// 경로 가져오기
		String filePath = chooser.getSelectedFile().getPath();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line = br.readLine();
			lblImg.setText(line);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
	}
}
