package beatGame_Frame;

public class List {
	private String startImage;// ���� ����â �̹���
	private String gameImage; // ������ �̹���
	private String gameMusic; // ���ӿ��ִ� ����
	private String startMusic; // ���� ����â ����
	private String gameName;// ������������

	public List(String startImage, String gameImage, String startMusic, String gameMusic, String gameName) {
		super();
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.gameName = gameName;
		
	}

	public String getGameImage() {
		return gameImage;
	}

	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}

	public String getStartImage() {
		return startImage;
	}

	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}

	public String getGameMusic() {
		return gameMusic;
	}

	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}

	public String getStartMusic() {
		return startMusic;
	}

	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}


}
