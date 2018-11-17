package beatGame_Frame;

public class List {
	private String startImage;// 게임 선택창 이미지
	private String gameImage; // 게임중 이미지
	private String gameMusic; // 게임에있는 음악
	private String startMusic; // 게임 선택창 음악
	private String gameName;// 게임음악제목

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
