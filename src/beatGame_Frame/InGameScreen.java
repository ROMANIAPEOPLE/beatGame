package beatGame_Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class InGameScreen extends Thread { // 키보드 이벤트 리스너가 정상 작동하기 위해 쓰레드를 상속받음
	private Image noteLineS = new ImageIcon(Main.class.getResource("../images/NoteLine.png")).getImage();// 구분선
	private Image noteLineD = new ImageIcon(Main.class.getResource("../images/NoteLine.png")).getImage();// 구분선
	private Image noteLineF = new ImageIcon(Main.class.getResource("../images/NoteLine.png")).getImage();// 구분선
	private Image noteLineJ = new ImageIcon(Main.class.getResource("../images/NoteLine.png")).getImage();// 구분선
	private Image noteLineK = new ImageIcon(Main.class.getResource("../images/NoteLine.png")).getImage();// 구분선
	private Image noteLineL = new ImageIcon(Main.class.getResource("../images/NoteLine.png")).getImage();// 구분선
	private Image noteLine02 = new ImageIcon(Main.class.getResource("../images/NoteLine(sample).png")).getImage();// 구분선
																													// Enterd
	private Image gameTitle = new ImageIcon(Main.class.getResource("../images/gameTitle.png")).getImage();
	private Image line = new ImageIcon(Main.class.getResource("../images/Line.png")).getImage();// 판정라인
	private Image divisionLine = new ImageIcon(Main.class.getResource("../images/divisionLine.png")).getImage();

	private String titleName;
	private String musicTitle;
	private Music gameMusic;
	ArrayList<Note> List2 = new ArrayList<Note>();

	public InGameScreen(String titleName, String musicTitle) {
		this.titleName = titleName;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false); // isLoop(반복)을 false값으로 지정.
		gameMusic.start();
	}

	public void screenDraw(Graphics g) {

		g.drawImage(gameTitle, 0, 660, null);
		g.drawImage(noteLineS, 295, 30, null);
		g.drawImage(divisionLine, 294, 30, null);
		g.drawImage(divisionLine, 394, 30, null);
		g.drawImage(noteLineD, 397, 30, null);
		g.drawImage(divisionLine, 495, 30, null);
		g.drawImage(noteLineF, 498, 30, null);
		g.drawImage(divisionLine, 598, 30, null);
		g.drawImage(noteLineJ, 602, 30, null);
		g.drawImage(divisionLine, 698, 30, null);
		g.drawImage(noteLineK, 702, 30, null);
		g.drawImage(divisionLine, 800, 30, null);
		g.drawImage(noteLineL, 804, 30, null);
		g.setFont(new Font("볼드", Font.BOLD, 30));
		g.setColor(Color.BLACK);
		g.drawString(titleName, 20, 700);
		for (int i = 0; i < List2.size(); i++) {
			Note note = List2.get(i);
			note.screenDraw(g);
		}

		g.setColor(Color.WHITE);
		g.setFont(new Font("볼드", Font.BOLD, 30));
		g.drawString("S", 338, 640);
		g.drawString("D", 440, 640);
		g.drawString("F", 540, 640);
		g.drawString("J", 640, 640);
		g.drawString("K", 740, 640);
		g.drawString("L", 840, 640);
		g.drawImage(line, 0, 605, null);

	}

	public void EnterdS() {
		noteLineS = new ImageIcon(Main.class.getResource("../images/NoteLine(sample).png")).getImage();
	}

	public void ExitedS() {
		noteLineS = new ImageIcon(Main.class.getResource("../images/NoteLine.png")).getImage();
	}

	public void EnterdD() {
		noteLineD = new ImageIcon(Main.class.getResource("../images/NoteLine(sample).png")).getImage();
	}

	public void ExitedD() {
		noteLineD = new ImageIcon(Main.class.getResource("../images/NoteLine.png")).getImage();
	}

	public void EnterdF() {
		noteLineF = new ImageIcon(Main.class.getResource("../images/NoteLine(sample).png")).getImage();
	}

	public void ExitedF() {
		noteLineF = new ImageIcon(Main.class.getResource("../images/NoteLine.png")).getImage();
	}

	public void EnterdJ() {
		noteLineJ = new ImageIcon(Main.class.getResource("../images/NoteLine(sample).png")).getImage();
	}

	public void ExitedJ() {
		noteLineJ = new ImageIcon(Main.class.getResource("../images/NoteLine.png")).getImage();
	}

	public void EnterdK() {
		noteLineK = new ImageIcon(Main.class.getResource("../images/NoteLine(sample).png")).getImage();
	}

	public void ExitedK() {
		noteLineK = new ImageIcon(Main.class.getResource("../images/NoteLine.png")).getImage();
	}

	public void EnterdL() {
		noteLineL = new ImageIcon(Main.class.getResource("../images/NoteLine(sample).png")).getImage();
	}

	public void ExitedL() {
		noteLineL = new ImageIcon(Main.class.getResource("../images/NoteLine.png")).getImage();
	}

	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	@Override
	public void run() {
		flowNote();
	}

	public void flowNote() {
		beatTime[] beat = { new beatTime(1000, "S"), new beatTime(2000, "D"), new beatTime(3000, "F"),
				new beatTime(4000, "J"), new beatTime(5000, "K"), new beatTime(6000, "L"), };

		
		int i = 0;
		while (true) {
			if (beat[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beat[i].getNoteSort());
				note.start();
				List2.add(note);
				i++;
			}
		}
//		List2.add(new Note(295,120));
//		List2.add(new Note(396,580));
//		List2.add(new Note(498,500));
//		List2.add(new Note(599,325));
//		List2.add(new Note(700,305));
//		List2.add(new Note(802,305));

	}

}
