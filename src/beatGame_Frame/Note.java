package beatGame_Frame;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteImage = new ImageIcon(Main.class.getResource("../images/noteImage.png")).getImage();// ³ëÆ®
	int x, y;
	String noteType;

	public Note(String noteType) {
		if (noteType.equals("S")) {
			x = 295;
			y = 10;
		} else if (noteType.equals("D")) {
			x = 396;
			y = 10;
		} else if (noteType.equals("F")) {
			x = 498;
			y = 10;
		} else if (noteType.equals("J")) {
			x = 599;
			y = 10;
		} else if (noteType.equals("K")) {
			x = 700;
			y = 10;
		} else if (noteType.equals("L")) {
			x = 802;
			y = 10;
		}
		this.noteType = noteType;

//	

	}

	public void screenDraw(Graphics g) {

		g.drawImage(noteImage, x, y, null);
	}

	public void speedControl() { // 속도조절
		y += 6; // 속도 1~10 조절
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