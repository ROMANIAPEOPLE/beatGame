package beatGame_Frame;

public class beatTime {

	private int time;
	private String noteSort; //

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getNoteSort() {
		return noteSort;
	}

	public void setNoteSort(String noteSort) {
		this.noteSort = noteSort;
	}

	public beatTime(int time, String noteSort) {
		super();
		this.time = time;
		this.noteSort = noteSort;

	}

}
