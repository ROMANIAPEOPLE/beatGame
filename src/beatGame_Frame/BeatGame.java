package beatGame_Frame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BeatGame extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon(Main.class.getResource("../images/Main(Title).jpg")).getImage();
	private Image viva01 = new ImageIcon(Main.class.getResource("../images/viva01.png")).getImage();
	private ImageIcon extiButton02 = new ImageIcon(Main.class.getResource("../images/extiButton02.jpg"));
	// 마우스가 닿을떄의 이미지
	private ImageIcon extiButton01 = new ImageIcon(Main.class.getResource("../images/extiButton01.jpg"));
	// 기본 종료 이미지
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/Bar.jpg")));
	private ImageIcon st1 = new ImageIcon(Main.class.getResource("../images/startintro.PNG"));//
	// 게임시작버튼
	private ImageIcon st2 = new ImageIcon(Main.class.getResource("../images/Start02.PNG"));
	private ImageIcon ex1 = new ImageIcon(Main.class.getResource("../images/ex01.jpg"));//
	private ImageIcon ex2 = new ImageIcon(Main.class.getResource("../images/ex02.jpg"));//
	private ImageIcon left1 = new ImageIcon(Main.class.getResource("../images/left.png"));//
	private ImageIcon left2 = new ImageIcon(Main.class.getResource("../images/left2.PNG"));//
	private ImageIcon right1 = new ImageIcon(Main.class.getResource("../images/right.PNG"));//
	private ImageIcon right2 = new ImageIcon(Main.class.getResource("../images/right2.PNG"));//
	private ImageIcon mainStart01 = new ImageIcon(Main.class.getResource("../images/mainStart01.jpg"));//
	private ImageIcon mainStart02 = new ImageIcon(Main.class.getResource("../images/mainStart02.jpg"));//
	private ImageIcon mainBack = new ImageIcon(Main.class.getResource("../images/barbar.Png"));//
	private ImageIcon mainBackEnter = new ImageIcon(Main.class.getResource("../images/barbar.Png"));//
	private ImageIcon note = new ImageIcon(Main.class.getResource("../images/Node.Png"));// 노트
	private ImageIcon noteLine = new ImageIcon(Main.class.getResource("../images/NoteLine.Png"));// 구분선
	private ImageIcon gameTitle = new ImageIcon(Main.class.getResource("../images/gameTitle.Png"));// 게임노래 제목
	private ImageIcon line = new ImageIcon(Main.class.getResource("../images/Line.Png"));//판정라인
	
	
	ArrayList<List> List = new ArrayList<List>();

	private Music selectedMusic; // 현재 음악(메인창)
	private Image nowImage; // 현재 선택된 음악의 이미지(메인창)
	private int nowSelected = 0; // 현재 선택된 음악의 번호(0번부터 시작)

	private int mouseX, mouseY;
	private JButton leftButton = new JButton(left1);
	private JButton rightButton = new JButton(right1);
	private JButton exitButton = new JButton(extiButton01);// 닫기 버튼 추가
	private JButton startButton = new JButton(st1); // 게임시작버튼
	private JButton ex = new JButton(ex1);
	private JButton mainStart = new JButton(mainStart01);
	private JButton mainBackButton = new JButton(mainBack);
	private JButton firstBackButton = new JButton(mainBack);
	
	private boolean isMainScreen = false;

	public BeatGame() {

		setUndecorated(true);
		setTitle("BeatGame");
		setSize(Main.SCREEN_WIDTH, Main.SCRREN_HEIGHT);
		setResizable(false); // 수정 불가능
		setLocationRelativeTo(null);// 창을 정중앙에
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		ImageIcon img = new ImageIcon(("viva02.png"));
		img = new ImageIcon(img.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH));
		List.add(new List("spring01.png", "spring02.jpg", "BTS.MP3", "BTS,MP3")); // num =0
		List.add(new List("viva1.jpg", "viva02.jpg", "VIVA.MP3", "VIVA,MP3")); // num=1
		exitButton.setBounds(1250, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스를 X버튼 위에 올렸을 때
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 손가락모양
				exitButton.setIcon(extiButton02); // 임의로 지정한 그림으로 변경
			}
			@Override
			public void mouseExited(MouseEvent e) { // 마우스를 X버튼에서 올리지 않았을 때
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 디폴트값
				exitButton.setIcon(extiButton01); // 다시 임의로 지정한 그림으로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});

		add(exitButton);

		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}

		});

		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

		startButton.setBounds(40, 100, 400, 100);
		startButton.setBorderPainted(false); // 테두리 제거
		startButton.setContentAreaFilled(false); // 여백 제거
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스를 게임시작 버튼 위에 올렸을 때
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 손가락모양
				startButton.setIcon(st2);// 마우스 올렸을때 임의로 지정한 그림으로 변경
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스를 게임시작 버튼에서 치웠을때
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 디폴트값
				startButton.setIcon(st1); // 마우스 내렸을때 임의로 지정한 그림으로 변경
			}

			@Override
			public void mousePressed(MouseEvent e) { // 시작버튼 눌렀을때 이벤트처리
				mainScreen();

			}
		});

		add(startButton);

		ex.setBounds(40, 200, 400, 100);
		ex.setBorderPainted(false);
		ex.setContentAreaFilled(false);
		ex.setFocusPainted(false);
		ex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스를 X버튼 위에 올렸을 때
				ex.setCursor(new Cursor(Cursor.HAND_CURSOR));// 손가락모양
				ex.setIcon(ex2); // 임의로 지정한 그림으로 변경
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스를 X버튼에서 올리지 않았을 때
				ex.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 디폴트값
				ex.setIcon(ex1); // 다시 임의로 지정한 그림으로 변경
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});

		add(ex);

		leftButton.setVisible(false);
		leftButton.setBounds(420, 540, 64, 64);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스를 X버튼 위에 올렸을 때
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 손가락모양
				leftButton.setIcon(left2); // 임의로 지정한 그림으로 변경
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스를 X버튼에서 올리지 않았을 때
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 디폴트값
				leftButton.setIcon(left1); // 다시 임의로 지정한 그림으로 변경
			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttonLeft();
			}
		});

		add(leftButton);

		rightButton.setVisible(false);
		rightButton.setBounds(800, 540, 64, 64);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스를 X버튼 위에 올렸을 때
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 손가락모양
				rightButton.setIcon(right2); // 임의로 지정한 그림으로 변경
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스를 X버튼에서 올리지 않았을 때
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 디폴트값
				rightButton.setIcon(right1); // 다시 임의로 지정한 그림으로 변경
			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttonRight();
			}
		});
		add(rightButton);

		mainStart.setVisible(false);
		mainStart.setBounds(510, 620, 250, 70);
		mainStart.setBorderPainted(false);
		mainStart.setContentAreaFilled(false);
		mainStart.setFocusPainted(false);
		mainStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스를 X버튼 위에 올렸을 때
				mainStart.setCursor(new Cursor(Cursor.HAND_CURSOR));// 손가락모양
				mainStart.setIcon(mainStart02); // 임의로 지정한 그림으로 변경
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스를 X버튼에서 올리지 않았을 때
				mainStart.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 디폴트값
				mainStart.setIcon(mainStart01); // 다시 임의로 지정한 그림으로 변경
			}

			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected);
			}
		});

		add(mainStart);

//		firstBackButton.setVisible(false);
//		firstBackButton.setBounds(20, 50, 230, 70);
//		firstBackButton.setBorderPainted(false);
//		firstBackButton.setContentAreaFilled(false);
//		firstBackButton.setFocusPainted(false);
//		firstBackButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) { // 마우스를 X버튼 위에 올렸을 때
//				firstBackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 손가락모양
//				firstBackButton.setIcon(mainBackEnter); // 임의로 지정한 그림으로 변경
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) { // 마우스를 X버튼에서 올리지 않았을 때
//				firstBackButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 디폴트값
//				firstBackButton.setIcon(mainBack); // 다시 임의로 지정한 그림으로 변경
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				firtBack();
//			}
//		});
//
//		add(firstBackButton);

		mainBackButton.setVisible(false);
		mainBackButton.setBounds(20, 50, 230, 70);
		mainBackButton.setBorderPainted(false);
		mainBackButton.setContentAreaFilled(false);
		mainBackButton.setFocusPainted(false);
		mainBackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스를 X버튼 위에 올렸을 때
				mainBackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 손가락모양
				mainBackButton.setIcon(mainBackEnter); // 임의로 지정한 그림으로 변경
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스를 X버튼에서 올리지 않았을 때
				mainBackButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 디폴트값
				mainBackButton.setIcon(mainBack); // 다시 임의로 지정한 그림으로 변경
			}

			@Override
			public void mousePressed(MouseEvent e) {
				mainBack();
			}
		});

		add(mainBackButton);
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCRREN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if (isMainScreen) {
			g.drawImage(nowImage, 420, 150, null);
		}
		paintComponents(g); // JLabel을 JFrame에 넣어줌
		this.repaint();
	}

	public void nowList(int nowSelected) { // 현재 메인화면에서 실행중인 곡의 정보
		if (selectedMusic != null) // 음악이 실행중이라면
			selectedMusic.close(); // 음악을 멈춤
		nowImage = new ImageIcon(Main.class.getResource("../images/" + List.get(nowSelected).getStartImage()))
				.getImage();
		selectedMusic = new Music(List.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}

	public void mainScreen() {

		startButton.setVisible(false); // 스타트 버튼을 눌렀을 때, 스타트 버튼 삭제
		ex.setVisible(false); // 마찬가지로, 종료하기 버튼 삭제
		isMainScreen = true;
		background = new ImageIcon(Main.class.getResource("../images/maingame.jpg")).getImage();
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		mainStart.setVisible(true);
		firstBackButton.setVisible(true);

		nowList(0);
	}

	public void gameStart(int nowSelected) {
		if (selectedMusic != null) {
			selectedMusic.close();
		}
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		mainStart.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + List.get(nowSelected).getGameImage()))
				.getImage();
		mainBackButton.setVisible(true); // 게임시작화면에만 이전으로 버튼이 나타남
		nowList(nowSelected);
	}

	public void mainBack() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		mainStart.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/maingame.jpg")).getImage();
		mainBackButton.setVisible(false);
		nowList(nowSelected);// 다시 현재 곡리스트의 번호를 재생함
	}

//	public void firtBack() {    (게임 처음화면으로 가는 버튼은 불필요)
//		isMainScreen = false;
//		leftButton.setVisible(false);
//		rightButton.setVisible(false);
//		mainStart.setVisible(false);
//		firstBackButton.setVisible(false);
//		background = new ImageIcon(Main.class.getResource("../images/Main(Title).jpg")).getImage();
//		startButton.setVisible(true);
//		ex.setVisible(true);
//		if(selectedMusic !=null) {
//			selectedMusic.close();
//		}
//		
//	}

	public void buttonRight() { // 게임메인화면 오른쪽 버튼 활성화
		if (nowSelected == 0) {
			nowSelected++;
			nowList(nowSelected);
		}

		else {
			nowSelected--;
			nowList(nowSelected);
		}
	}

	public void buttonLeft() { // 게임메인화면 왼쪽 버튼 활성화
		if (nowSelected == 1) {
			nowSelected--;
			nowList(nowSelected);
		} else {
			nowSelected++;
			nowList(nowSelected);
		}
	}

}
