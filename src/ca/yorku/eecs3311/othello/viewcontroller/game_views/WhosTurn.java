package ca.yorku.eecs3311.othello.viewcontroller.game_views;

import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloBoard;
import ca.yorku.eecs3311.util.Observable;
import ca.yorku.eecs3311.util.Observer;
import javafx.scene.text.Text;
/**
 * View Component for Game Scene
 */
public class WhosTurn extends Text  implements Observer{
	public WhosTurn(String label) {
		super(label);
		this.setId("text"); // for css because its not inheriting Text
	}
	
	@Override
	public void update(Observable o) { 
		Othello othello = (Othello) o;
		if(othello.isGameOver()) {
			this.setText("Game Over");
			return;
		}

		char whosTurn = othello.getWhosTurn();
		if(whosTurn == OthelloBoard.P1) {
			this.setText("Black's turn");
		}else if(whosTurn == OthelloBoard.P2) {
			this.setText("White's turn");
		}
	}
	
}
