package ca.yorku.eecs3311.othello.viewcontroller.player_strategies;

import ca.yorku.eecs3311.othello.model.Move;
import ca.yorku.eecs3311.othello.model.Othello;

public abstract class OthelloPlayer {
	protected char playerToken;
	protected Othello othello;
	protected String keyName;
	public OthelloPlayer(Othello othello, char playerToken) {
		this.playerToken = playerToken;
		this.othello =othello;
	}
		
	public void setPlayerToken(char playerToken) {
		this.playerToken = playerToken;
	}

	public char getPlayerToken() {
		return this.playerToken;
	}
	
	public abstract String getKeyName();
	public abstract void onPlayersTurn();
}
