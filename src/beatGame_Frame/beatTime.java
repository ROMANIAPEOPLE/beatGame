package beatGame_Frame;

public class beatTime {

	private int timeReader;
	private String noteSort; //

	public beatTime(int timeReader, String noteSort) {
		super();
		this.timeReader = timeReader;
		this.noteSort = noteSort;

	}
	
	
	public int getTimeReader() {
		return timeReader;
	}

	public void seTtimeReader(int timeReader) {
		this.timeReader = timeReader;
	}

	public String getNoteSort() {
		return noteSort;
	}

	public void setNoteSort(String noteSort) {
		this.noteSort = noteSort;
	}

	

}
