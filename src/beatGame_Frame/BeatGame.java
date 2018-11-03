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
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/Main(Title).jpg")).getImage();
	private ImageIcon extiButton02 = new ImageIcon(Main.class.getResource("../images/extiButton02.jpg"));
	// 마우스가 닿을떄의 이미지
	private ImageIcon extiButton01 = new ImageIcon(Main.class.getResource("../images/extiButton01.jpg"));
	// 기본 종료 이미지
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/Bar.jpg")));

	private JButton exitButton = new JButton(extiButton01);// 닫기 버튼 추가
	private int mouseX, mouseY;

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

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCRREN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g); // JLabel을 JFrame에 넣어줌
		this.repaint();
	}
}
