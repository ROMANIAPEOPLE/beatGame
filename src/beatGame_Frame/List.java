package beatGame_Frame;

public class List {
	private String startImage;// ���� ����â �̹���
	private String gameImage; // ������ �̹���
	private String startMusic; //  ����
	private String inGameImage; // ���� ������ ��ܿ� ǥ�õ� �̹���
	private String deco; //������

	public List(String startImage, String gameImage, String startMusic,String inGameImage,String deco) {
		this.startImage = startImage; //���� ǥ��
		this.gameImage = gameImage; //�ΰ��� ���
		this.startMusic = startMusic; //����
		this.inGameImage=inGameImage;//���� ������ ��ܿ� ǥ�õ� �̹���
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
