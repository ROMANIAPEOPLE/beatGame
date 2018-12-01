package beatGame_Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

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
//	private String titleName;
	private String musicName; // 실행중인 노래 제목
	private Music gameMusic;
	ArrayList<Note> List2 = new ArrayList<Note>();

	public InGameScreen(String musicName) { // 현재 실행중인 게임에 대한 정보를 담는 생성자
		this.musicName = musicName;
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
//		g.setFont(new Font("볼드", Font.BOLD, 30));
//		g.setColor(Color.BLACK);  추후 안내멘트 구현

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
		gameMusic.close(); // 이전으로 돌아갔을 때 음악을 멈추게 하기 위한 메소드
	}

	@Override
	public void run() {
		flowNote();
	}

	Random random = new Random();
	// random.nextInt(6);
	String[] keySort = { "S", "D", "F", "J", "K", "L" };
	// 200 간격으로 for문 설정
	// 0~5 랜덤 생성 keySort[random] 으로 뿌려줌

	public void flowNote() {
		System.out.println("flow실행");
		beatTime[] beat = null;
		beatTime[] beat2 = null;
		if (musicName.equals("BTS.MP3")) {
			beat = new beatTime[] { new beatTime(800, "S"), new beatTime(4500, "D"), new beatTime(9000, "F"),
					new beatTime(13000, "J"), new beatTime(15000, "K"), new beatTime(15000, "L"),
					new beatTime(15300, "K"), new beatTime(15300, "L"), new beatTime(15600, "K"),
					new beatTime(15600, "L"), new beatTime(17000, "S"), new beatTime(17200, "D"),
					new beatTime(17400, "S"), new beatTime(17600, "D"), new beatTime(18600, "K"),
					new beatTime(18800, "J"), new beatTime(19000, "D"), new beatTime(19200, "S"),
					new beatTime(19400, "D"), new beatTime(19600, "S"), new beatTime(19800, "F"),
					new beatTime(20000, "K"), new beatTime(20200, "J"), new beatTime(20400, "L"),
					new beatTime(20600, "K"), new beatTime(20800, "S"), new beatTime(21200, "D"),
					new beatTime(21400, "F"), new beatTime(21600, "S"), new beatTime(21800, "D"),
					new beatTime(22000, "F"), new beatTime(22400, "J"), new beatTime(22600, "K"),
					new beatTime(22800, "L"), new beatTime(23000, "J"), new beatTime(23200, "K"),
					new beatTime(23400, "L"), new beatTime(23600, "S"), new beatTime(23800, "K"),
					new beatTime(24000, "L"), new beatTime(24200, "L"), new beatTime(24400, "L"),
					new beatTime(24600, "L"), new beatTime(24800, "L"), new beatTime(25000, "L"),
					new beatTime(25200, "L"), new beatTime(25400, "L"), new beatTime(25600, "L"),
					new beatTime(25800, "L"), new beatTime(26000, "L"), new beatTime(26200, "K"),
					new beatTime(26400, "K"), new beatTime(26600, "K"), new beatTime(26800, "K"),
					new beatTime(27000, "K"), new beatTime(27200, "K"), new beatTime(27400, "K"),
					new beatTime(27600, "L"), new beatTime(27800, "L"), new beatTime(28000, "L"),
					new beatTime(28200, "L"), new beatTime(28400, "L"), new beatTime(28600, "S"),
					new beatTime(28800, "D"), new beatTime(29000, "F"), new beatTime(29200, "D"),
					new beatTime(29400, "D"), new beatTime(29600, "D"), new beatTime(29800, "D"),
					new beatTime(30000, "D"), new beatTime(30200, "K"), new beatTime(30400, "K"),
					new beatTime(30600, "K"), new beatTime(30800, "L"), new beatTime(31000, "K"),
					new beatTime(31200, "J"), new beatTime(31400, "K"), new beatTime(31600, "L"),
					new beatTime(31800, "S"), new beatTime(32000, "K"), new beatTime(32200, "D"),
					new beatTime(32400, "L"), new beatTime(32600, "D"), new beatTime(32800, "S"),
					new beatTime(33000, "F"), new beatTime(33200, "L"), new beatTime(33400, "S"),
					new beatTime(33600, "D"), new beatTime(33800, "F"), new beatTime(34000, "K"),
					new beatTime(34300, "S"), new beatTime(34500, "D"), new beatTime(34700, "K"),
					new beatTime(34900, "J"), new beatTime(35100, "L"), new beatTime(35300, "D"),
					new beatTime(35500, "S"), new beatTime(35700, "S"), new beatTime(35900, "F"),
					new beatTime(36100, "J"), new beatTime(36300, "K"), new beatTime(36500, "J"),
					new beatTime(36700, "K"), new beatTime(36900, "L"), new beatTime(37100, "D"),
					new beatTime(37300, "S"), new beatTime(37500, "F"), new beatTime(37700, "D"),
					new beatTime(37900, "S"), new beatTime(38100, "K"), new beatTime(38300, "J"),
					new beatTime(38500, "L"), new beatTime(38700, "K"), new beatTime(38900, "D"),
					new beatTime(39100, "S"), new beatTime(39300, "F"), new beatTime(39500, "D"),
					new beatTime(39700, "D"), new beatTime(39900, "S"), new beatTime(40100, "J"),
					new beatTime(40300, "K"), new beatTime(40500, "D"), new beatTime(40700, "S"),
					new beatTime(40900, "K"), new beatTime(41100, "L"), new beatTime(41300, "D"),
					new beatTime(41500, "S"), new beatTime(41700, "D"), new beatTime(41900, "F"),
					new beatTime(42100, "K"), new beatTime(42300, "S"), new beatTime(42300, "K"),
					new beatTime(42500, "L"), new beatTime(42700, "S"), new beatTime(42900, "F"),
					new beatTime(43300, "J"), new beatTime(43500, "D"), new beatTime(43700, "D"),
					new beatTime(43900, "K"), new beatTime(44100, "S"), new beatTime(44300, "L"),
					new beatTime(44500, "S"), new beatTime(44700, "D"), new beatTime(44900, "L"),
					new beatTime(45100, "D"), new beatTime(45300, "S"), new beatTime(45500, "D"),
					new beatTime(45700, "F"), new beatTime(45900, "D"), new beatTime(46100, "J"),
					new beatTime(46300, "J"), new beatTime(46500, "L"), new beatTime(46700, "S"),
					new beatTime(46900, "K"), new beatTime(47100, "J"), new beatTime(47300, "S"),
					new beatTime(47500, "D"), new beatTime(47700, "J"), new beatTime(47900, "J"),
					new beatTime(48100, "S"), new beatTime(48300, "J"), new beatTime(48500, "K"),
					new beatTime(48700, "D"), new beatTime(48900, "J"), new beatTime(49100, "S"),
					new beatTime(49300, "S"), new beatTime(49500, "S"), new beatTime(49700, "F"),
					new beatTime(49900, "J"), new beatTime(50100, "D"), new beatTime(50300, "F"),
					new beatTime(50500, "J"), new beatTime(50700, "J"), new beatTime(50900, "F"),
					new beatTime(51100, "L"), new beatTime(51300, "F"), new beatTime(51500, "F"),
					new beatTime(51600, "S"), new beatTime(51700, "D"), new beatTime(51800, "F"),
					new beatTime(51900, "J"), new beatTime(52000, "K"), new beatTime(52100, "L"),
					new beatTime(52500, "D"), new beatTime(52800, "F"), new beatTime(53100, "F"),
					new beatTime(53400, "L"), new beatTime(53600, "S"), new beatTime(53800, "K"),
					new beatTime(54000, "L"), new beatTime(54200, "D"), new beatTime(54500, "J"),
					new beatTime(54800, "L"), new beatTime(55100, "F"), new beatTime(55400, "L"),
					new beatTime(55700, "D"), new beatTime(56000, "D"), new beatTime(56300, "L"),
					new beatTime(56600, "K"), new beatTime(56900, "S"), new beatTime(57200, "J"),
					new beatTime(57500, "J"), new beatTime(57800, "D"), new beatTime(58100, "F"),
					new beatTime(58300, "J"), new beatTime(58500, "K"), new beatTime(58700, "S"),
					new beatTime(58900, "J"), new beatTime(59100, "J"), new beatTime(59300, "D"),
					new beatTime(59600, "K"), new beatTime(59800, "L"), new beatTime(60000, "F"),
					new beatTime(60200, "S"), new beatTime(60400, "F"), new beatTime(60600, "D"),
					new beatTime(60900, "S"), new beatTime(61200, "F"), new beatTime(61500, "J"),
					new beatTime(61800, "D"), new beatTime(62100, "K"), new beatTime(62400, "L"),
					new beatTime(62700, "S"), new beatTime(63000, "D"), new beatTime(63300, "F"),
					new beatTime(63600, "D"), new beatTime(63800, "J"), new beatTime(63800, "D"),
					new beatTime(63800, "S"), new beatTime(64100, "K"), new beatTime(64300, "J"),
					new beatTime(64600, "L"), new beatTime(64900, "S"), new beatTime(65200, "D"),
					new beatTime(65500, "S"), new beatTime(65800, "J"), new beatTime(66100, "J"),
					new beatTime(66400, "K"), new beatTime(66700, "S"), new beatTime(67000, "F"),
					new beatTime(67300, "D"), new beatTime(67600, "L"), new beatTime(67900, "D"),
					new beatTime(68200, "S"), new beatTime(68500, "J"), new beatTime(68800, "S"),
					new beatTime(69100, "D"), new beatTime(69400, "F"), new beatTime(69700, "K"),
					new beatTime(70000, "S"), new beatTime(70300, "D"), new beatTime(70600, "L"),
					new beatTime(70900, "D"), new beatTime(71200, "S"), new beatTime(71500, "F"),
					new beatTime(71800, "K"), new beatTime(72100, "J"), new beatTime(72400, "S"),
					new beatTime(72700, "L"), new beatTime(73000, "K"), new beatTime(73300, "D"),
					new beatTime(73600, "S"), new beatTime(73900, "J"), new beatTime(74400, "D"),
					new beatTime(74600, "J"), new beatTime(74800, "S"), new beatTime(75000, "K"),
					new beatTime(75300, "S"), new beatTime(75600, "F"), new beatTime(75900, "K"),
					new beatTime(76200, "L"), new beatTime(76500, "K"), new beatTime(76800, "S"),
					new beatTime(77100, "F"), new beatTime(77400, "K"), new beatTime(77700, "K"),
					new beatTime(78000, "L"), new beatTime(78300, "D"), new beatTime(78600, "S"),
					new beatTime(78900, "F"), new beatTime(79200, "F"), new beatTime(79500, "F"),
					new beatTime(79800, "J"), new beatTime(80100, "K"), new beatTime(80400, "L"),
					new beatTime(80700, "K"), new beatTime(81000, "D"), new beatTime(81300, "S"),
					new beatTime(81800, "F"), new beatTime(82300, "K"), new beatTime(82700, "S"),
					new beatTime(83000, "D"), new beatTime(83300, "J"), new beatTime(83600, "L"),
					new beatTime(83900, "J"), new beatTime(84400, "S"), new beatTime(84900, "D"),
					new beatTime(85200, "F"), new beatTime(85500, "F"), new beatTime(85800, "F"),
					new beatTime(86100, "S"), new beatTime(86300, "K"), new beatTime(86600, "J"),
					new beatTime(86900, "F"), new beatTime(87200, "L"), new beatTime(87500, "J"),
					new beatTime(87800, "D"), new beatTime(88000, "K"), new beatTime(88200, "J"),
					new beatTime(88500, "S"), new beatTime(88700, "D"), new beatTime(89000, "F"),
					new beatTime(89300, "D"), new beatTime(89500, "S"), new beatTime(89800, "J"),
					new beatTime(90100, "L"), new beatTime(90300, "D"), new beatTime(90700, "S"),
					new beatTime(91000, "K"), new beatTime(91300, "J"), new beatTime(91600, "J"),
					new beatTime(92000, "L"), new beatTime(92300, "S"), new beatTime(92600, "D"),
					new beatTime(92900, "S"), new beatTime(93300, "F"), new beatTime(93600, "J"),
					new beatTime(93900, "L"), new beatTime(94200, "K"), new beatTime(94500, "J"),
					new beatTime(94800, "D"), new beatTime(95100, "J"), new beatTime(95400, "J"),
					new beatTime(95700, "L"), new beatTime(96000, "J"), new beatTime(96300, "S"),
					new beatTime(96600, "D"), new beatTime(96800, "S"), new beatTime(97000, "F"),
					new beatTime(97300, "K"), new beatTime(97600, "J"), new beatTime(97900, "L"),
					new beatTime(98200, "D"), new beatTime(98500, "L"), new beatTime(98700, "S"),
					new beatTime(99000, "F"), new beatTime(100200, "D"), new beatTime(100600, "J"),
					new beatTime(101000, "K"), new beatTime(101400, "S"), new beatTime(101800, "J"),
					new beatTime(102200, "D"), new beatTime(102500, "L"), new beatTime(102700, "J"),
					new beatTime(103000, "K"), new beatTime(103300, "D"), new beatTime(103600, "S"),
					new beatTime(103800, "L"), new beatTime(104100, "D"), new beatTime(104300, "S"),
					new beatTime(104500, "J"), new beatTime(104800, "K"), new beatTime(105100, "S"),
					new beatTime(105500, "K"), new beatTime(105700, "J"), new beatTime(106000, "D"),
					new beatTime(106300, "S"), new beatTime(106400, "L"), new beatTime(106600, "J"),
					new beatTime(106900, "S"), new beatTime(107300, "D"), new beatTime(107900, "K"),
					new beatTime(108200, "L"), new beatTime(108500, "J"), new beatTime(108800, "D"),
					new beatTime(109100, "S"), new beatTime(109400, "K"), new beatTime(109700, "J"),
					new beatTime(110000, "D"), new beatTime(110300, "S"), new beatTime(110600, "L"),
					new beatTime(110900, "J"), new beatTime(111200, "K"), new beatTime(111500, "S"),
					new beatTime(111800, "F"), new beatTime(112100, "J"), new beatTime(112400, "L"),
					new beatTime(112700, "D"), new beatTime(113000, "S"), new beatTime(113300, "F"),
					new beatTime(113600, "K"), new beatTime(113900, "K"), new beatTime(114200, "F"),
					new beatTime(114500, "L"), new beatTime(114800, "S"), new beatTime(115100, "F"),
					new beatTime(115400, "S"), new beatTime(115700, "F"), new beatTime(116000, "D"),
					new beatTime(116300, "K"), new beatTime(116600, "L"), new beatTime(116900, "D"),
					new beatTime(117200, "K"), new beatTime(117500, "F"), new beatTime(117800, "J"),
					new beatTime(118100, "S"), new beatTime(118400, "D"), new beatTime(118700, "S"),
					new beatTime(118900, "F"), new beatTime(119200, "L"), new beatTime(110600, "K"),
					new beatTime(111200, "S"), new beatTime(111200, "F"), new beatTime(111200, "K"),
					new beatTime(111600, "D"), new beatTime(111600, "J"), new beatTime(111600, "L"),
					new beatTime(111800, "F"), new beatTime(112000, "K"), new beatTime(112200, "S"),
					new beatTime(112400, "L"), new beatTime(112700, "S"), new beatTime(112700, "D"),
					new beatTime(112700, "F"), new beatTime(112700, "J"), new beatTime(112700, "K"),
					new beatTime(112700, "L"), };
		
		
		} else if (musicName.equals("VIVA.MP3")) {
			beat2 = new beatTime[10000];
			int i = 0;
			for (int t = 1000; t < 150000; t += 200) {
				beat2[i] = new beatTime(t, keySort[random.nextInt(6)]);
				i++;
			}

		}

		gameMusic.start();
		System.out.println("gameMusic 시작");

		if (musicName.equals("BTS.MP3")) {
			for (int i = 0; i < beat.length;) {
				if (beat[i].getTimeReader() <= gameMusic.getTime()) { //
					System.out.println("실행됨"); // 이부분이 실행 됐다 안됐다 함
					Note note = new Note(beat[i].getNoteSort());
					note.start();
					List2.add(note);
					i++;

				}
			}
		} else if (musicName.equals("VIVA.MP3")) {
			for (int i = 0; i < beat2.length;) {
				if (beat2[i].getTimeReader() <= gameMusic.getTime()) { //
					System.out.println("실행됨"); // 이부분이 실행 됐다 안됐다 함
					Note note = new Note(beat2[i].getNoteSort());
					note.start();
					List2.add(note);
					i++;

				}
			}
		}
	}
}
