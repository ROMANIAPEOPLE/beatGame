package beatGame_Frame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
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
//	private Image methodBackGround = new ImageIcon(Main.class.getResource("../images/methodBackGround.jpg")).getImage();
//	private Image viva01 = new ImageIcon(Main.class.getResource("../images/viva01.png")).getImage();
//	private Image note = new ImageIcon(Main.class.getResource("../images/Note.png")).getImage();// 노트
//	private Image noteLine = new ImageIcon(Main.class.getResource("../images/NoteLine.png")).getImage();// 구분선
//	private Image gameTitle = new ImageIcon(Main.class.getResource("../images/gameTitle.png")).getImage();
//	private Image line = new ImageIcon(Main.class.getResource("../images/Line.png")).getImage();// 판정라인
//	private Image divisionLine = new ImageIcon(Main.class.getResource("../images/divisionLine.png")).getImage();
	private Image inMethod = new ImageIcon(Main.class.getResource("../images/inMethodButton.png")).getImage();
	private ImageIcon extiButton02 = new ImageIcon(Main.class.getResource("../images/extiButton02.jpg"));
	// 마우스가 닿을의 이미지
	private ImageIcon extiButton01 = new ImageIcon(Main.class.getResource("../images/extiButton01.jpg"));
	// 기본 종료 이미지
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/Bar.jpg")));
	private ImageIcon st1 = new ImageIcon(Main.class.getResource("../images/startintro.PNG"));//
	// 게임시작버튼
	private ImageIcon methodBasic = new ImageIcon(Main.class.getResource("../images/methodButton01.png"));
	private ImageIcon methodEnter = new ImageIcon(Main.class.getResource("../images/methodButton02.png"));
	private ImageIcon st2 = new ImageIcon(Main.class.getResource("../images/Start02.PNG"));
	private ImageIcon ex1 = new ImageIcon(Main.class.getResource("../images/ex01.jpg"));//
	private ImageIcon ex2 = new ImageIcon(Main.class.getResource("../images/ex02.jpg"));//
	private ImageIcon left1 = new ImageIcon(Main.class.getResource("../images/left.png"));//
	private ImageIcon left2 = new ImageIcon(Main.class.getResource("../images/left2.PNG"));//
	private ImageIcon right1 = new ImageIcon(Main.class.getResource("../images/right.PNG"));//
	private ImageIcon right2 = new ImageIcon(Main.class.getResource("../images/right2.PNG"));//
	private ImageIcon mainStart01 = new ImageIcon(Main.class.getResource("../images/mainStart01.jpg"));//
	private ImageIcon mainStart02 = new ImageIcon(Main.class.getResource("../images/mainStart02.jpg"));//
	private ImageIcon mainBack = new ImageIcon(Main.class.getResource("../images/mainBackButton01.png"));//
	private ImageIcon mainBackEnter = new ImageIcon(Main.class.getResource("../images/mainBackButton02.png"));//
	private ImageIcon lastExit1 = new ImageIcon(Main.class.getResource("../images/temp1.png"));//
	private ImageIcon lastExit2 = new ImageIcon(Main.class.getResource("../images/temp2.png"));//
	private Music selectedMusic; // 현재 음악(메인창)
	private Image nowImage; // 현재 선택된 음악의 이미지(메인창)
	private Image nowImageInGame;// 게임진행창에 들어갈 이미지
	public int musicNumber = 0; // 현재 선택된 음악의 번호(0번부터 시작)
//	private Image nowImageDeco;// 사용안함(악보)
	
	
	private int mouseX, mouseY;
	private JButton lastOut = new JButton(lastExit1); //마지막 창에서 처음으로 돌아오는 버튼
	private JButton leftButton = new JButton(left1);
	private JButton rightButton = new JButton(right1);
	private JButton exitButton = new JButton(extiButton01);// 닫기 버튼 추가
	private JButton startButton = new JButton(st1); // 게임시작버튼
	private JButton ex = new JButton(ex1);
	private JButton mainStart = new JButton(mainStart01);
	private JButton mainBackButton = new JButton(mainBack);
	private JButton firstBackButton = new JButton(mainBack);
	private JButton methodButton = new JButton(methodBasic);
//	private JButton mainBackButton2 = new JButton(mainBack);  (사용X)
	private boolean isGameScreen = false; // 게임화면
	private boolean isMainScreen = false; // 메인화면
	private boolean isMethodScreen = false; // 게임방법 화면
	public static InGameScreen game;

	ArrayList<List> List = new ArrayList<List>();

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
		addKeyListener(new key()); // 키보드 이벤트처리
		List.add(new List("spring01.png", "spring02.jpg", "BTS.MP3", "springO.png", "BTSP2.PNG")); // num
		List.add(new List("viva1.jpg", "viva02.jpg", "VIVA.MP3", "vivaP.jpg", "vivaP.jpg")); // num=1
		ImageIcon img = new ImageIcon(("viva02.png"));
		img = new ImageIcon(img.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH));

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
				gameScreen(musicNumber);

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

		lastOut.setVisible(false);
		lastOut.setBounds(1000,500 , 170, 70);
		lastOut.setBorderPainted(false);
		lastOut.setContentAreaFilled(false);
		lastOut.setFocusPainted(false);
		lastOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스를 X버튼 위에 올렸을 때
				lastOut.setCursor(new Cursor(Cursor.HAND_CURSOR));// 손가락모양
				lastOut.setIcon(lastExit2); // 임의로 지정한 그림으로 변경
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스를 X버튼에서 올리지 않았을 때
				lastOut.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 디폴트값
				lastOut.setIcon(lastExit1); // 다시 임의로 지정한 그림으로 변경
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lastOutEvent();
			}
		});

		add(lastOut);
		
		
		
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ	
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

		methodButton.setVisible(false);
		methodButton.setBounds(20, 70, 230, 70);
		methodButton.setBorderPainted(false);
		methodButton.setContentAreaFilled(false);
		methodButton.setFocusPainted(false);
		methodButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스를 X버튼 위에 올렸을 때
				methodButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 손가락모양
				methodButton.setIcon(methodEnter); // 임의로 지정한 그림으로 변경
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스를 X버튼에서 올리지 않았을 때
				methodButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 디폴트값
				methodButton.setIcon(methodBasic); // 다시 임의로 지정한 그림으로 변경
			}

			@Override
			public void mousePressed(MouseEvent e) {
				methodScreen();
			}
		});

		add(methodButton);
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
		if (isGameScreen == true) {
			game.screenDraw(g);
			g.drawImage(nowImageInGame, 920, 60, null);
//			g.drawImage(nowImageDeco, 10, 150,null);
			g.setFont(new Font("볼드", Font.BOLD, 30));
			g.setColor(Color.BLACK);
			if (musicNumber == 0) {
				g.drawString("난이도 ★★★☆☆", 20, 700);
			}
			else {
				g.drawString("난이도 ★★★★★", 20, 700);
			}
		}

		if (isMethodScreen) {
			g.drawImage(inMethod, 200, 100, null);
		}

		paintComponents(g); // JLabel을 JFrame에 넣어줌
		this.repaint();
	}

	public void nowList(int musicNumber) { // 현재 메인화면에서 실행중인 곡의 정보
		if (selectedMusic != null) // 음악이 실행중이라면
			selectedMusic.close(); // 음악을 멈춤
		nowImage = new ImageIcon(Main.class.getResource("../images/" + List.get(musicNumber).getStartImage()))
				.getImage(); //셀렉창 게임 정보 이미지
		nowImageInGame = new ImageIcon(Main.class.getResource("../images/" + List.get(musicNumber).getInGameImage()))
				.getImage(); // 게임 안에 노래 타이틀을 표시하는 이미지
//		nowImageDeco = new ImageIcon(Main.class.getResource("../images/" + List.get(musicNumber).getDeco()))
//				.getImage(); 사용X
		selectedMusic = new Music(List.get(musicNumber).getStartMusic(), true); //셀렉창 노래
		selectedMusic.start();
	}

	public void methodScreen() {
		if (selectedMusic != null) {
			selectedMusic.close();
		}
		background = new ImageIcon(Main.class.getResource("../images/methodBackGround.jpg")).getImage();
		isMainScreen = false;
		isGameScreen = false;
		;
		isMethodScreen = true;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		mainStart.setVisible(false);
		methodButton.setVisible(false);
		mainBackButton.setVisible(true);
		lastOut.setVisible(false);
	}

	public void mainScreen() {

		startButton.setVisible(false); // 스타트 버튼을 눌렀을 때, 스타트 버튼 삭제
		ex.setVisible(false); // 마찬가지로, 종료하기 버튼 삭제
		isMainScreen = true;
		background = new ImageIcon(Main.class.getResource("../images/maingame.jpg")).getImage();
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		mainStart.setVisible(true);
		methodButton.setVisible(true);
		firstBackButton.setVisible(true);
		nowList(0);
	}

	public void gameScreen(int musicNumber) {
		if (selectedMusic != null) {
			selectedMusic.close();
		}
		isMainScreen = false;
		isGameScreen = true;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		mainStart.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + List.get(musicNumber).getGameImage()))
				.getImage(); //게임창 배경
		methodButton.setVisible(false);
		mainBackButton.setVisible(true); // 게임시작화면에만 이전으로 버튼이 나타남
		lastOut.setVisible(true);
		game = new InGameScreen(List.get(musicNumber).getStartMusic());
		game.start(); // Game 클래스의 스레드를 실행
		setFocusable(true);
	}

	public void mainBack() {
		isMainScreen = true;
		leftButton.setVisible(true);// 왼쪽 버튼 보이게
		rightButton.setVisible(true);// 오른쪽 버튼 보이게
		mainStart.setVisible(true); // 게임시작 버튼 보이게
		background = new ImageIcon(Main.class.getResource("../images/maingame.jpg")).getImage();
		// 배경화면 다시 바꿔주고
		mainBackButton.setVisible(false); // 이전으로 버튼 삭제
		methodButton.setVisible(true);
		nowList(musicNumber);// 다시 현재 곡리스트의 번호를 재생함
		isGameScreen = false;
		isMethodScreen = false;
		lastOut.setVisible(false);
		game.close();
	}
	
	public void lastOutEvent() {
		isMainScreen=false;
		isGameScreen=false;
		isMethodScreen=false;
		background = new ImageIcon(Main.class.getResource("../images/Main(Title).jpg")).getImage();
		mainBackButton.setVisible(false);
		startButton.setVisible(true);
		ex.setVisible(true);
		lastOut.setVisible(false);
		game.close();
		
	}

//	public void firtBack() {    (게임 처음화면으로 가는 버튼 불필요)
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
		if (musicNumber == 0) {
			musicNumber++;
			nowList(musicNumber);
		}

		else {
			musicNumber--;
			nowList(musicNumber);
		}
	}

	public void buttonLeft() { // 게임메인화면 왼쪽 버튼 활성화
		if (musicNumber == 1) {
			musicNumber--;
			nowList(musicNumber);
		} else {
			musicNumber++;
			nowList(musicNumber);
		}
	}

}
