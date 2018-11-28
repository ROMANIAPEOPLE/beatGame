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
	private Image gameTitle = new ImageIcon(Main.class.getResource("../images/gameTitle.png")).getImage();
	private Image line = new ImageIcon(Main.class.getResource("../images/Line.png")).getImage();// 판정라인
	private Image divisionLine = new ImageIcon(Main.class.getResource("../images/divisionLine.png")).getImage();
	private String titleName;
	private String musicName; // 실행중인 노래 제목
	private Music gameMusic;
	ArrayList<Note> List2 = new ArrayList<Note>();
	public InGameScreen(String titleName, String musicTitle) { // 현재 실행중인 게임에 대한 정보를 담는 생성자
		this.titleName = titleName;
		this.musicName = musicTitle;
		gameMusic = new Music(this.musicName, false); // isLoop(반복)을 false값으로 지정.

	}

	public void screenDraw(Graphics g) {

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
		g.drawImage(gameTitle, 0, 660, null);
		g.setFont(new Font("볼드", Font.BOLD, 30));
		g.setColor(Color.BLACK);
		g.drawString(titleName, 20, 700);

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
		gameMusic.close(); //이전으로 돌아갔을 때 음악을 멈추게 하기 위한 메소드
	}

	@Override
	public void run() {
		flowNote();
	}

	public void flowNote() {
		System.out.println("flow실행");
		beatTime[] beat = null;
		if (musicName.equals("BTS.MP3")) {
			beat = new beatTime[] { new beatTime(800, "S"), new beatTime(4500, "D"), new beatTime(9000, "F"),
					new beatTime(13000, "J"), new beatTime(15000, "K"), new beatTime(15000, "L"),
					new beatTime(15300, "K"), new beatTime(15300, "L"), new beatTime(15600, "K"),
					new beatTime(15600, "L"), new beatTime(17000, "S"), new beatTime(17200, "D"),
					new beatTime(17400, "S"), new beatTime(17600, "D"), // 다
					new beatTime(18600, "K"), new beatTime(18800, "J"), new beatTime(19000, "D"),
					new beatTime(19200, "S"), new beatTime(19400, "D"), new beatTime(19600, "S"),
					new beatTime(19800, "F"), new beatTime(20000, "K"), new beatTime(20200, "J"),
					new beatTime(20400, "L"), new beatTime(20600, "K"), new beatTime(20800, "S"), // 다
					new beatTime(21200, "D"), // 너
					new beatTime(21400, "F"), new beatTime(21600, "S"), new beatTime(21800, "D"),
					new beatTime(22000, "F"), new beatTime(22400, "J"), new beatTime(22600, "K"),
					new beatTime(22800, "L"), new beatTime(23000, "J"), new beatTime(23200, "K"),
					new beatTime(23400, "L"), new beatTime(23600, "S"), new beatTime(23800, "K"),
					new beatTime(24000, "L"), new beatTime(24200, "L"), // 너
					new beatTime(24400, "L"), // 희
					new beatTime(24600, "L"), new beatTime(24800, "L"), new beatTime(25000, "L"),
					new beatTime(25200, "L"), new beatTime(25400, "L"), new beatTime(25600, "L"),
					new beatTime(25800, "L"), new beatTime(26000, "L"), new beatTime(26200, "K"),
					new beatTime(26400, "K"), new beatTime(26600, "K"), new beatTime(26800, "K"),
					new beatTime(27000, "K"), new beatTime(27200, "K"), new beatTime(27400, "K"),
					new beatTime(27600, "L"), new beatTime(27800, "L"), new beatTime(28000, "L"),
					new beatTime(28200, "L"), new beatTime(28400, "L"), // 나는
					new beatTime(28600, "S"), new beatTime(28800, "D"), new beatTime(29000, "F"),
					new beatTime(29200, "D"), new beatTime(29400, "D"), new beatTime(29600, "D"),
					new beatTime(29800, "D"), new beatTime(30000, "D"), new beatTime(30200, "K"),
					new beatTime(30400, "K"), new beatTime(30600, "K"), new beatTime(30800, "L"),
					new beatTime(31000, "K"), new beatTime(31200, "J"), new beatTime(31400, "K"),
					new beatTime(31600, "L"), new beatTime(31800, "S"), new beatTime(32000, "K"),
					new beatTime(32200, "D"), new beatTime(32400, "L"), new beatTime(32600, "D"),
					new beatTime(32800, "S"), new beatTime(33000, "F"), new beatTime(33200, "L"),
					new beatTime(33400, "S"), new beatTime(33600, "D"), new beatTime(33800, "F"),
					new beatTime(34000, "K"), new beatTime(34300, "S"), //
					new beatTime(34500, "D"), new beatTime(34700, "K"), new beatTime(34900, "J"),
					new beatTime(35100, "L"), new beatTime(35300, "D"), new beatTime(35500, "S"),
					new beatTime(35700, "S"), new beatTime(35900, "F"), new beatTime(36100, "J"),
					new beatTime(36300, "K"), new beatTime(36500, "J"), new beatTime(36700, "K"),
					new beatTime(36900, "L"), new beatTime(37100, "D"), new beatTime(37300, "S"),
					new beatTime(37500, "F"), new beatTime(37700, "D"), new beatTime(37900, "S"),
					new beatTime(38100, "K"), new beatTime(38300, "J"), new beatTime(38500, "L"),
					new beatTime(38700, "K"), new beatTime(38900, "D"), new beatTime(39100, "S"),
					new beatTime(39300, "F"), new beatTime(39500, "D"), new beatTime(39700, "D"),
					new beatTime(39900, "S"), new beatTime(40100, "J"), new beatTime(40300, "K"),
					new beatTime(40500, "D"), new beatTime(40700, "S"), new beatTime(40900, "K"),
					new beatTime(41100, "L"), new beatTime(41300, "D"), new beatTime(41500, "S"),
					new beatTime(41700, "D"), new beatTime(41900, "F"), new beatTime(42100, "K"),
					new beatTime(42300, "S"), new beatTime(42300, "K"),// 설국열차
					new beatTime(42500, "L"),
					new beatTime(42700, "L"),
					new beatTime(42900, "L"),
					new beatTime(43300, "L"),
					new beatTime(43500, "L"),
					new beatTime(43700, "L"),
					new beatTime(43900, "L"),
					new beatTime(44100, "L"),
					new beatTime(44300, "L"),
					new beatTime(44500, "L"),
					new beatTime(44700, "L"),
					new beatTime(44900, "L"),
					new beatTime(45100, "L"),
					new beatTime(45300, "L"),
					new beatTime(45500, "L"),
					new beatTime(45700, "L"),
					new beatTime(45900, "L"),
					new beatTime(46100, "L"),
					new beatTime(46300, "L"),
					new beatTime(46500, "L"),
					new beatTime(46700, "L"),
					new beatTime(46900, "L"),
					new beatTime(47100, "L"),
					new beatTime(47300, "L"),
					new beatTime(47500, "L"),
					new beatTime(47700, "L"),
					new beatTime(47900, "L"),
					new beatTime(48100, "L"),
					new beatTime(48300, "L"),
					new beatTime(48500, "L"),
					new beatTime(48700, "L"),
					new beatTime(48900, "L"),
					new beatTime(49100, "L"),
					new beatTime(49300, "L"),
					new beatTime(49500, "L"),
					new beatTime(49700, "L"),
					new beatTime(49900, "L"),
					new beatTime(50100, "L"),
					new beatTime(50300, "L"),
					new beatTime(50500, "L"),
					new beatTime(50700, "L"),
					new beatTime(50900, "L"),
					new beatTime(51100, "L"),
					new beatTime(51300, "L"),
					new beatTime(51500, "L"),
					new beatTime(51600, "S"),//
					new beatTime(51700, "D"),
					new beatTime(51800, "F"),
					new beatTime(51900, "J"),
					new beatTime(52000, "K"),
					new beatTime(52100, "L"),//프렌
			};
		} else if (musicName.equals("coldPlay-Viva La Vida")) {
			beat = new beatTime[] { new beatTime(1000, "S"), };
		}
		
		
		gameMusic.start();
		System.out.println("gameMusic 시작");

		for (int i = 0; i < beat.length;) {
			if (beat[i].getTime() <= gameMusic.getTime()) { //
				System.out.println("실행됨"); // 이부분이 실행 됐다 안됐다 함
				Note note = new Note(beat[i].getNoteSort());
				note.start();
				List2.add(note);
				i++;


			}
		}
	}
}
