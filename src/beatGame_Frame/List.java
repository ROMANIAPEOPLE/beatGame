package beatGame_Frame;

public class List {
	private String startImage;// ���� ����â �̹���
	private String gameImage; // ������ �̹���
	private String startMusic; //  ����
	private String inGameImage; // ���� ������ ��ܿ� ǥ�õ� �̹���

	public List(String startImage, String gameImage, String startMusic,String inGameImage) {
		super();
		this.startImage = startImage; //���� ǥ��
		this.gameImage = gameImage; //�ΰ��� ���
		this.startMusic = startMusic; //����
		this.inGameImage=inGameImage;//���� ������ ��ܿ� ǥ�õ� �̹���
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


}
