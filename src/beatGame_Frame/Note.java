package beatGame_Frame;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteImage = new ImageIcon(Main.class.getResource("../images/noteImage.png")).getImage();// ≥Î∆Æ
	int x, y= 605 - 1000 / 9*5;
	String noteName;

	public Note(int x) {
		this.x = x;
//		this.y = y;
	

	}

	public void screenDraw(Graphics g) {

		g.drawImage(noteImage, x, y, null);
	}

	public void flow() {
		y += 5;
	}

	@Override
	public void run() {
		try {
			while (true) {
				flow();
				Thread.sleep(100);

			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
