package beatGame_Frame;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteImage = new ImageIcon(Main.class.getResource("../images/noteImage.png")).getImage();// ³ëÆ®
	int x, y= 10;
	String noteType;

	public Note(String noteType) {
		if(noteType.equals("S")) {
			x=295;
		}
		else if(noteType.equals("D")) {
			x=396;
		}
		else if(noteType.equals("F")) {
			x=498;
		}
		else if(noteType.equals("J")) {
			x=599;
		}
		else if(noteType.equals("K")) {
			x=700;
		}
		else if(noteType.equals("L")) {
			x=802;
		}
		this.noteType = noteType;

//	
	

	}

	public void screenDraw(Graphics g) {

		g.drawImage(noteImage, x, y, null);
	}

	public void flow() {
		y +=3;
	}

	@Override
	public void run() {
		try {
			while (true) {
				flow();
				Thread.sleep(10);

			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
