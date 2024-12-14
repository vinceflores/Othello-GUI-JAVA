package ca.yorku.eecs3311.othello.viewcontroller.player_strategies;

import ca.yorku.eecs3311.othello.model.Othello;

public class HumanPlayer extends OthelloPlayer {
	public static final String keyname = "Human";

	public HumanPlayer(Othello othello, char playerToken) {
		super(othello, playerToken);
		this.keyName = "Human";
	}

	@Override
	public String getKeyName() {
		return this.keyName;
	}

	@Override
	public void onPlayersTurn() {
		// do nothing, and wait for GUI interaction
	}

}
