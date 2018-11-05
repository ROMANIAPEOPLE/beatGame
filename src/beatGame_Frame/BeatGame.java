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
	// ���콺�� �������� �̹���
	private ImageIcon extiButton01 = new ImageIcon(Main.class.getResource("../images/extiButton01.jpg"));
	// �⺻ ���� �̹���
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/Bar.jpg")));
	private ImageIcon st1 = new ImageIcon(Main.class.getResource("../images/startintro.PNG"));//
	// ���ӽ��۹�ư
	private ImageIcon st2 = new ImageIcon(Main.class.getResource("../images/Start02.PNG"));
	private ImageIcon ex1 = new ImageIcon(Main.class.getResource("../images/ex01.jpg"));//
	private ImageIcon ex2 = new ImageIcon(Main.class.getResource("../images/ex02.jpg"));//
	private ImageIcon left1 = new ImageIcon(Main.class.getResource("../images/left.png"));//
	private ImageIcon left2 = new ImageIcon(Main.class.getResource("../images/left2.PNG"));//
	private ImageIcon right1 = new ImageIcon(Main.class.getResource("../images/right.PNG"));//
	private ImageIcon right2 = new ImageIcon(Main.class.getResource("../images/right2.PNG"));//

	ArrayList<List> trackList = new ArrayList<List>();
	
	private Music selectedMusic; // ���� ����(����â)
	private Image nowImage; //���� ���õ� ������ �̹���(����â)
	private int nowSelected=0;  //���� ���õ� ������ ��ȣ(0������ ����)
	
	private int mouseX, mouseY;
	private JButton leftButton = new JButton(left1);
	private JButton rightButton = new JButton(right1);
	private JButton exitButton = new JButton(extiButton01);// �ݱ� ��ư �߰�
	private JButton startButton = new JButton(st1); // ���ӽ��۹�ư
	private JButton ex = new JButton(ex1);
	private boolean isMainScreen = false;

	public BeatGame() {

		setUndecorated(true);
		setTitle("BeatGame");
		setSize(Main.SCREEN_WIDTH, Main.SCRREN_HEIGHT);
		setResizable(false); // ���� �Ұ���
		setLocationRelativeTo(null);// â�� ���߾ӿ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		trackList.add(new List("spring01.png", "spring02.png", "BTS.MP3" , "BTS,MP3")); //num =0
		trackList.add(new List("viva1.jpg", "viva02.png", "VIVA.MP3" , "VIVA,MP3")); //num=1
		
		exitButton.setBounds(1250, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� X��ư ���� �÷��� ��
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// �հ������
				exitButton.setIcon(extiButton02); // ���Ƿ� ������ �׸����� ����
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� X��ư���� �ø��� �ʾ��� ��
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // ����Ʈ��
				exitButton.setIcon(extiButton01); // �ٽ� ���Ƿ� ������ �׸����� ����
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
		startButton.setBorderPainted(false); // �׵θ� ����
		startButton.setContentAreaFilled(false); // ���� ����
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� ���ӽ��� ��ư ���� �÷��� ��
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// �հ������
				startButton.setIcon(st2);// ���콺 �÷����� ���Ƿ� ������ �׸����� ����
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� ���ӽ��� ��ư���� ġ������
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // ����Ʈ��
				startButton.setIcon(st1); // ���콺 �������� ���Ƿ� ������ �׸����� ����
			}

			@Override
			public void mousePressed(MouseEvent e) { // ���۹�ư �������� �̺�Ʈó��

				selectTrack(0);
				startButton.setVisible(false); // ��ŸƮ ��ư�� ������ ��, ��ŸƮ ��ư ����
				ex.setVisible(false); // ����������, �����ϱ� ��ư ����
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../images/maingame.jpg")).getImage();
				isMainScreen = true;

			}
		});

		add(startButton);

		ex.setBounds(40, 200, 400, 100);
		ex.setBorderPainted(false);
		ex.setContentAreaFilled(false);
		ex.setFocusPainted(false);
		ex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� X��ư ���� �÷��� ��
				ex.setCursor(new Cursor(Cursor.HAND_CURSOR));// �հ������
				ex.setIcon(ex2); // ���Ƿ� ������ �׸����� ����
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� X��ư���� �ø��� �ʾ��� ��
				ex.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // ����Ʈ��
				ex.setIcon(ex1); // �ٽ� ���Ƿ� ������ �׸����� ����
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
			public void mouseEntered(MouseEvent e) { // ���콺�� X��ư ���� �÷��� ��
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// �հ������
				leftButton.setIcon(left2); // ���Ƿ� ������ �׸����� ����
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� X��ư���� �ø��� �ʾ��� ��
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // ����Ʈ��
				leftButton.setIcon(left1); // �ٽ� ���Ƿ� ������ �׸����� ����
			}

			@Override
			public void mousePressed(MouseEvent e) {
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
			public void mouseEntered(MouseEvent e) { // ���콺�� X��ư ���� �÷��� ��
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// �հ������
				rightButton.setIcon(right2); // ���Ƿ� ������ �׸����� ����
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� X��ư���� �ø��� �ʾ��� ��
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // ����Ʈ��
				rightButton.setIcon(right1); // �ٽ� ���Ƿ� ������ �׸����� ����
			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttonRight();
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
		if (isMainScreen) {
			g.drawImage(nowImage, 420, 150, null);
		}
		paintComponents(g); // JLabel�� JFrame�� �־���
		this.repaint();
	}

	
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();
		nowImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	
	
	public void buttonRight() {
		if(nowSelected ==0) {
			nowSelected++;
			selectTrack(nowSelected);
		}

		else {
			nowSelected--;
			selectTrack(nowSelected);
		}
	}
	
	
}


