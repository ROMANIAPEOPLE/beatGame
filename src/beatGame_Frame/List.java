package beatGame_Frame;

public class List {
	private String startImage;// 게임 선택창 이미지
	private String gameImage; // 게임중 이미지
	private String startMusic; //  음악
	private String inGameImage; // 게임 오른쪽 상단에 표시될 이미지
	private String deco; //사용안함

	public List(String startImage, String gameImage, String startMusic,String inGameImage,String deco) {
		this.startImage = startImage; //게임 표지
		this.gameImage = gameImage; //인게임 배경
		this.startMusic = startMusic; //음악
		this.inGameImage=inGameImage;//게임 오른쪽 상단에 표시될 이미지
		this.deco= deco;
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


	public String getStartMusic() {
		return startMusic;
	}

	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	
	public String getInGameImage() {
		return inGameImage;
	}
	
	public void setInGameImage(String inGameImage) {
		this.inGameImage=inGameImage;
	}
	public String getDeco() {
		return deco;
	}
	
	public void setDeco(String deco) {
		this.deco=deco;
	}


}
