package ca.yorku.eecs3311.othello.viewcontroller.player_strategies;

import ca.yorku.eecs3311.othello.model.Move;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.PlayerRandom;

public class RandomPlayer extends OthelloPlayer implements Computer {
	private PlayerRandom player;
	public static final String keyname = "Random";

	public RandomPlayer(Othello othello,char playerToken) {
		super(othello, playerToken);
		this.keyName = "Random";
		this.player = new PlayerRandom(othello, playerToken);
	}

	@Override
	public void move() {
		Move randMove = this.player.getMove();
		int row =randMove.getRow(); 
		int col =randMove.getCol(); 
		this.othello.move(row,col);
	}

	@Override
	public String getKeyName() {
		return this.keyName;
	}

	@Override
	public void onPlayersTurn() {
		this.move();
	}

}
