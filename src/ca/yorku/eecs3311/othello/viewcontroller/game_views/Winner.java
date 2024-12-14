package ca.yorku.eecs3311.othello.viewcontroller.game_views;

import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloBoard;
import ca.yorku.eecs3311.util.Observable;
import ca.yorku.eecs3311.util.Observer;
import javafx.scene.text.Text;
/**
 * View Component for Game Scene
 */
public class Winner extends Text implements Observer {

	public  Winner() {
		this.setId("text"); // for css
	}

	@Override
	public void update(Observable o) {
		Othello othello = (Othello) o;
		if(othello.isGameOver()) {
			char winner = othello.getWinner();
			if(winner == OthelloBoard.P1) {
				this.setText("Winner is Black");
			}else if(winner == OthelloBoard.P2) {
				this.setText("Winner is White");
			}
		}else {
			this.setText("");
		}
	}
	
}
