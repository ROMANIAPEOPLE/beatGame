package beatGame_Frame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class key extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		if (BeatGame.game == null) { // ������ �������� �ƴ϶��, Ű���� �̺�Ʈ�� �������� ����.
		}

		if (e.getKeyCode() == KeyEvent.VK_S) {
			BeatGame.game.EnterdS();
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			BeatGame.game.EnterdD();
		} else if (e.getKeyCode() == KeyEvent.VK_F) {
			BeatGame.game.EnterdF();
		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			BeatGame.game.EnterdJ(); 
		} else if (e.getKeyCode() == KeyEvent.VK_K) {
			BeatGame.game.EnterdK();
		} else if (e.getKeyCode() == KeyEvent.VK_L) {
			BeatGame.game.EnterdL();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) { //�� ������

		if (BeatGame.game == null) { // ������ �������� �ƴ϶��, Ű���� �̺�Ʈ�� �������� ����.
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			BeatGame.game.ExitedS();
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			BeatGame.game.ExitedD();
		} else if (e.getKeyCode() == KeyEvent.VK_F) {
			BeatGame.game.ExitedF();
		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			BeatGame.game.ExitedJ();
		} else if (e.getKeyCode() == KeyEvent.VK_K) {
			BeatGame.game.ExitedK();
		} else if (e.getKeyCode() == KeyEvent.VK_L) {
			BeatGame.game.ExitedL();
		}
	}

}
