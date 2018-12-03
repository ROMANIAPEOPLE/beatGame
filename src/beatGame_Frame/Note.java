package beatGame_Frame;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteImage = new ImageIcon(Main.class.getResource("../images/noteImage.png")).getImage();// ³ëÆ®
	private Image noteImage2 = new ImageIcon(Main.class.getResource("../images/noteImage.png")).getImage();//
	int x, y;
	String noteSort;
	boolean noteFade;

	public Note(String noteSort) {
		if (noteSort.equals("S")) {
			x = 295;
			y = 10;
		} else if (noteSort.equals("D")) {
			x = 396;
			y = 10;
		} else if (noteSort.equals("F")) {
			x = 498;
			y = 10;
		} else if (noteSort.equals("J")) {
			x = 599;
			y = 10;
		} else if (noteSort.equals("K")) {
			x = 700;
			y = 10;
		} else if (noteSort.equals("L")) {
			x = 802;
			y = 10;
		}
		this.noteSort = noteSort;

//	

	}

	public void screenDraw(Graphics g) {
//		if (y > 660) { //임시
//			g.drawImage(noteImage2, x, y, null); //임시
			g.drawImage(noteImage, x, y, null);
	}

	public void speedControl() { // 속도조절
		y += 6; // 속도 1~10 조절

		if (y == 660) {
			System.out.println("Good");
		}
	}

	@Override
	public void run() {
		while (true) {
			speedControl();
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}