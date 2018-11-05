package beatGame_Frame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class BeatGame extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon(Main.class.getResource("../images/Main(Title).jpg")).getImage();
	private Image spring01 = new ImageIcon(Main.class.getResource("../images/spring01.png")).getImage();
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
	private JButton leftButton = new JButton(left1);
	private JButton rightButton = new JButton(right1);
	private JButton exitButton = new JButton(extiButton01);// 닫기 버튼 추가
	private int mouseX, mouseY;
	private JButton startButton = new JButton(st1); //게임시작버튼
	private JButton ex = new JButton(ex1);
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

		
		startButton.setBounds(40, 400, 400, 100);
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
				
				Music selectedMusic = new Music("BTS.MP3", true);
				selectedMusic.start();
				startButton.setVisible(false); // 스타트 버튼을 눌렀을 때, 스타트 버튼 삭제
				ex.setVisible(false); // 마찬가지로, 종료하기 버튼 삭제
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				background=new ImageIcon(Main.class.getResource("../images/maingame.jpg")).getImage();
				isMainScreen=true;
				
			}
		});

		add(startButton);
		
		ex.setBounds(40, 500, 400, 100);
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
				//왼쪽 버튼 이벤트
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
			//오른쪽 버튼 이벤트
			}
		});

		add(rightButton);
	}
		

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCRREN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen) {
			g.drawImage(spring01,420,150,null);
		}
		paintComponents(g); // JLabel을 JFrame에 넣어줌
		this.repaint();
	}
}
