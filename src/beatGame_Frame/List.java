package beatGame_Frame;

public class List {
	private String startImage;// ���� ����â �̹���
	private String gameImage; // ������ �̹���
	private String gameMusic; // ���ӿ��ִ� ����
	private String startMusic; // ���� ����â ����
	private String titleName;// ������������

	public List(String startImage, String gameImage, String startMusic, String gameMusic, String titleName) {
		super();
		this.startImage = startImage; //���� ǥ��
		this.gameImage = gameImage; //�ΰ��� ���
		this.startMusic = startMusic; // ���� ����â ����
		this.gameMusic = gameMusic; //�ΰ��� ����
		this.titleName = titleName; //�� ����
		
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
	public String gettitleName() {
		return titleName;
	}

	public void settitleName(String titleName) {
		this.titleName = titleName;
	}


}
