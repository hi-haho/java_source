package pack7GUI;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

// 간단한 메모장 만들기
public class Ex49Memojang extends JFrame implements ActionListener {

	private JTextArea txtMemo = new JTextArea("", 10, 30);
	private String copyText; // 복사한 문자열 잠시 보관용

	private JMenuItem mnuNew, mnuSave, mnuOpen, mnuExit;
	private JMenuItem mnuCopy, mnuPaste, mnuCut, mnuDel, mnuFontSize;
	private JMenuItem mnuAbout, mnuEtc1, mnuEtc2;

	private JPopupMenu popup; // 팝업 메뉴용
	private JMenuItem m_white, m_blue, m_yellow;

	public Ex49Memojang() {
		super("메모장");

		initLayout();
		menuLayout();

		setBounds(200, 200, 400, 350);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { // 무명 클래스여서 this를 지정해줘야한다.
				int close = JOptionPane.showConfirmDialog(Ex49Memojang.this, "종료하시겠습니까?", "종료",
						JOptionPane.YES_NO_OPTION); // 내부 무명클래스에서는 클래스명을 넣어줘야한다.

				switch (close) {
				case JOptionPane.YES_OPTION:
					System.exit(0);
					break;
				case JOptionPane.NO_OPTION:
					break;
				}
			}
		});
	}

	private void initLayout() {
		JScrollPane scroollpane = new JScrollPane(txtMemo); // 스크롤바 생김
		txtMemo.setFont(new Font("돋음", Font.PLAIN, 16));
		add("Center", scroollpane);
	}

	private void menuLayout() {
		JMenuBar menuBar = new JMenuBar(); // 메뉴바

		JMenu mnuFile = new JMenu("파일"); // 주메뉴
		mnuNew = new JMenuItem("새문서");
		mnuOpen = new JMenuItem("열기..."); // ... > 사용자 배려
		mnuSave = new JMenuItem("저장...");
		mnuExit = new JMenuItem("종료");
		mnuFile.add(mnuNew);
		mnuFile.add(mnuOpen);
		mnuFile.add(mnuSave);
		mnuFile.addSeparator(); // 구분선 : 같은 성격끼리 묶어야한다.
		mnuFile.add(mnuExit); // 메뉴에 부메뉴 등록

		JMenu mnuEdit = new JMenu("편집");
		mnuCopy = new JMenuItem("복사(c)");
		mnuCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		mnuPaste = new JMenuItem("붙여넣기");
		mnuCut = new JMenuItem("잘라내기");
		mnuDel = new JMenuItem("삭제");
		mnuFontSize = new JMenuItem("글꼴 크기...");
		mnuEdit.add(mnuCopy);
		mnuEdit.add(mnuPaste);
		mnuEdit.add(mnuCut);
		mnuEdit.add(mnuDel);
		mnuEdit.addSeparator(); // 구분선
		mnuEdit.add(mnuFontSize);

		JMenu mnuShow = new JMenu("보기");
		mnuAbout = new JMenuItem("메모장이란..");
		mnuEtc1 = new JMenuItem("계산기");
		mnuEtc2 = new JMenuItem("카페");
		mnuShow.add(mnuAbout);
		mnuShow.addSeparator(); // 구분선
		mnuShow.add(mnuEtc1);
		mnuShow.add(mnuEtc2);

		menuBar.add(mnuFile); // 메뉴바에 주메뉴 등록
		menuBar.add(mnuEdit);
		menuBar.add(mnuShow);

		setJMenuBar(menuBar); // JFrame에 메뉴바 등록

		// 메뉴에 리스너 달기 > actionPerformed()넘어간다.
		mnuNew.addActionListener(this);
		mnuSave.addActionListener(this);
		mnuOpen.addActionListener(this);
		mnuExit.addActionListener(this);
		mnuCopy.addActionListener(this);
		mnuPaste.addActionListener(this);
		mnuCut.addActionListener(this);
		mnuDel.addActionListener(this);
		mnuFontSize.addActionListener(this);
		mnuAbout.addActionListener(this);
		mnuEtc1.addActionListener(this);
		mnuEtc2.addActionListener(this);

		// 팝업 메뉴
		popup = new JPopupMenu();
		JMenu menuColor = new JMenu("색 선택");
		m_white = new JMenuItem("하양");
		m_blue = new JMenuItem("파랑");
		m_yellow = new JMenuItem("노랑");
		menuColor.add(m_white);
		menuColor.add(m_blue);
		menuColor.add(m_yellow);

		m_white.addActionListener(this);
		m_blue.addActionListener(this);
		m_yellow.addActionListener(this);
		popup.add(menuColor);
		txtMemo.add(popup); // txtMemo에 팝업 추가

		txtMemo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				/*
				 * //마우스 오른쪽 버튼 클릭시 해당 지점에 팝업 띄우기 if(e.getModifiers() ==
				 * MouseEvent.BUTTON3_MASK) { popup.show(txtMemo,e.getX(),e.getY()); };
				 */
				if ((e.getModifiersEx() & MouseEvent.BUTTON3_DOWN_MASK) == MouseEvent.BUTTON3_DOWN_MASK) {
					popup.show(txtMemo, e.getX(), e.getY());
				}

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println(e.getActionCommand());
		// System.out.println(e.getSource());
		if (e.getSource() == mnuNew) { // 새문서
			txtMemo.setText(""); // 덮어쓰기
			setTitle("제목 없음");
		} else if (e.getSource() == mnuOpen) { // 열기
			// 파일 열기을 위한 경로명과 파일명 얻기는 os지원 창을 사용
			FileDialog dialog = new FileDialog(this, "열기", FileDialog.LOAD);
			dialog.setDirectory("."); // 현재 디렉토리
			dialog.setVisible(true);
			if (dialog.getFile() == null)
				return;
			String dfName = dialog.getDirectory() + dialog.getFile();

			try {
				BufferedReader reader = new BufferedReader(new FileReader(dfName));
				txtMemo.setText("");
				String line = "";
				while ((line = reader.readLine()) != null) {
					txtMemo.append(line + "\n");
				}
				reader.close();
				setTitle(dialog.getFile() + " - 메모장");
			} catch (Exception e2) {
				System.out.println(e2.getMessage()); // 개발자용
				JOptionPane.showMessageDialog(this, e2.getMessage(), "에러", JOptionPane.WARNING_MESSAGE); // 사용자용
			}

		} else if (e.getSource() == mnuSave) { // 저장
			// 파일 저장을 위한 경로명과 파일명 얻기는 os지원 창을 사용
			FileDialog dialog = new FileDialog(this, "저장", FileDialog.SAVE);
			dialog.setDirectory("."); // 현재 디렉토리
			dialog.setVisible(true);
			if (dialog.getFile() == null)
				return;
			String dfName = dialog.getDirectory() + dialog.getFile();
//			System.out.println("dfName " + dfName);

			try {
				// BufferedWriter writer = new BufferedWriter(new FileWriter("c:/work/a.txt"));
				// 윈도우 타입으로 경로 지정 방식 : "c:\\work\\a.txt"
				BufferedWriter writer = new BufferedWriter(new FileWriter(dfName));
				writer.write(txtMemo.getText());
				writer.close();
				setTitle(dialog.getFile() + " - 메모장");

			} catch (Exception e2) {
				System.out.println(e2.getMessage()); // 개발자
				JOptionPane.showMessageDialog(this, e2.getMessage(), "에러", JOptionPane.WARNING_MESSAGE); // 사용자
			}

		} else if (e.getSource() == mnuExit) { // 나가기
			int close = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION); // 내부
																											// 무명클래스에서는
																											// 클래스명을
																											// 넣어줘야한다.

			switch (close) {
			case JOptionPane.YES_OPTION:
				System.exit(0);
				break;
			case JOptionPane.NO_OPTION:
				break;
			}

		} else if (e.getSource() == mnuCopy) { // 복사
//			System.out.println(txtMemo.getSelectedText()); //지정된 범위만 복사된다.
			copyText = txtMemo.getSelectedText();

		} else if (e.getSource() == mnuPaste) { // 붙여넣기
//			txtMemo.setText(copyText); //전체가 날라간다.
			int position = txtMemo.getCaretPosition(); // 커서가 있는 위치에 있음
			txtMemo.insert(copyText, position);

		} else if (e.getSource() == mnuCut) { // 잘라내기
			copyText = txtMemo.getSelectedText();

			// copyText에 저장된 부분은 txtMemo에서 지움
			int start = txtMemo.getSelectionStart();
			int end = txtMemo.getSelectionEnd();
			txtMemo.replaceRange("", start, end);

		} else if (e.getSource() == mnuDel) { // 삭제 (범위지정)

			int start = txtMemo.getSelectionStart();
			int end = txtMemo.getSelectionEnd();
			txtMemo.replaceRange("", start, end);

		} else if (e.getSource() == mnuFontSize) { // 글꼴크기
			String fontSize = JOptionPane.showInputDialog(this, "글꼴 크기: ", "16"); // 기본값 16

			if (fontSize != null) {
				try {
					int fSize = Integer.parseInt(fontSize);
					if (fSize == 0) {
						JOptionPane.showMessageDialog(null, "다시 입력하세요");
						return;
					}
					txtMemo.setFont(new Font(txtMemo.getFont().getName(), txtMemo.getFont().getStyle(), fSize));
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(this, "글꼴 크기를 정확히 입력하세요.");
				}
			}

		} else if (e.getSource() == mnuAbout) { // 메모장이란..
			new Ex49MemoAbout(this); // 모달은 다음 코드 진행을 안한다.
			System.out.println("About 호출 후 상황"); // modal과 modaless 구분(포커스)

		} else if (e.getSource() == mnuEtc1) { // 계산기
			// exe (실행파일) 실행하기
			try {
				Runtime runtime = Runtime.getRuntime();
				runtime.exec("calc.exe");
			} catch (Exception e2) {
				JOptionPane.showConfirmDialog(this, e2.getMessage());
			}

		} else if (e.getSource() == mnuEtc2) { // 기타2
			// 브라우저 실행하기
			try {
				String url = "https://cafe.daum.net/flowlife";
				// deskTop 지원 확인
				/*
				 * Desktop 클래스는 Java 응용 프로그램 URI 나 파일을 처리하기 위해 기본 등록된 관련 응용 프로그램을 실행 할 수 있습니다.
				 * 지원하는 기능은 아래와 같습니다. 1. 기본 브라우저를 통해서 URL 전시 2. 메일 클라이언트 실행 3. 기본 응용프로그램을 통해서
				 * 파일을 열거나 편집
				 */
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop(); // 싱클톤이다.
					if (desktop.isSupported(Desktop.Action.BROWSE)) { // 포함관계이다.
						// URI는 문자열, 특정 리소스를 의미
						desktop.browse(new URI(url));
					} else {
						JOptionPane.showConfirmDialog(this, "브라우저 지원을 안한다.");
					}
				}
			} catch (Exception e2) {
				JOptionPane.showConfirmDialog(this, e2.getMessage());
			}
		}else if (e.getSource() == m_white) { // 팝업 메누
			txtMemo.setBackground(Color.WHITE);
		}else if (e.getSource() == m_blue) { // 팝업 메누
			txtMemo.setBackground(Color.blue);
		}else if (e.getSource() == m_yellow) { // 팝업 메누
			txtMemo.setBackground(Color.YELLOW);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex49Memojang();
	}

}
