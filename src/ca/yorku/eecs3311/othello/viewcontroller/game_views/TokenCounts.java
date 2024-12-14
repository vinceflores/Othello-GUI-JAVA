package ca.yorku.eecs3311.othello.viewcontroller.game_views;


import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloBoard;
import ca.yorku.eecs3311.util.Observable;
import ca.yorku.eecs3311.util.Observer;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
/**
 * View Component for Game Scene
 */
public class TokenCounts extends VBox implements Observer {
	private Othello othello;
	
	private String p1Label;
	private String p2Label;
	
	private Text tokensForP1;
	private Text tokensForP2;

	public TokenCounts(Othello othello, String p1Label, String p2Label) {
		this.othello = othello;
		this.p1Label = p1Label;
		this.p2Label = p2Label;

		this.tokensForP1 = new Text(p1Label + "= " + othello.getCount(OthelloBoard.P1));
		this.tokensForP2 = new Text(p2Label + "= " + othello.getCount(OthelloBoard.P2));
		
		this.tokensForP1.setTextAlignment(TextAlignment.LEFT);
		this.tokensForP2.setTextAlignment(TextAlignment.LEFT);
		
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);

		this.getChildren().addAll(
			this.tokensForP1,
			this.tokensForP2 
		);
	}

	@Override
	public void update(Observable o) {
		this.tokensForP1.setText(p1Label  + "= " + this.othello.getCount(OthelloBoard.P1));
		this.tokensForP2.setText(p2Label  + "= " + this.othello.getCount(OthelloBoard.P2));
	}
	
}
