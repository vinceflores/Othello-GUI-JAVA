package ca.yorku.eecs3311.othello.viewcontroller.player_strategies;

import ca.yorku.eecs3311.othello.model.Move;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.PlayerGreedy;

public class GreedyPlayer extends OthelloPlayer implements Computer {
	public static final String keyname = "Greedy";
	private PlayerGreedy player;
	public GreedyPlayer(Othello othello,char playerToken) {
		super(othello, playerToken);
		this.keyName = "Greedy";
		this.player = new PlayerGreedy(othello, playerToken);
	}

	@Override
	public void move() {
		Move greedyMove = this.player.getMove(); 
		int row = greedyMove.getRow();
		int col = greedyMove.getCol();
		this.othello.move(row, col);
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
