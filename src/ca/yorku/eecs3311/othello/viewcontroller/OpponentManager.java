package ca.yorku.eecs3311.othello.viewcontroller;

import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloBoard;
import ca.yorku.eecs3311.othello.viewcontroller.player_strategies.HumanPlayer;
import ca.yorku.eecs3311.othello.viewcontroller.player_strategies.OthelloPlayer;
import ca.yorku.eecs3311.util.Observable;
import ca.yorku.eecs3311.util.Observer;


/**
 * Model for OthelloPlayer VS OthelloPlayer Strategy
 * Context for strategy pattern 
 */
public class OpponentManager extends Observable implements Observer{
	private Othello othello; 
	private OthelloPlayer player1;
	private OthelloPlayer player2; 
	private OthelloPlayer playerWithTurn;
	
	public  OpponentManager(Othello othello) { 
		this.othello = othello;
		this.player1 = new HumanPlayer(othello, OthelloBoard.P1);
		this.player2 = new HumanPlayer(othello, OthelloBoard.P1);
		this.playerWithTurn = this.player1;
	}
	
	public OthelloPlayer getPlayer1() {
		return this.player1;
	}

	public void setPlayer1(OthelloPlayer player1) {
		this.player1 = player1;
		this.notifyObservers();	
	}

	public OthelloPlayer getPlayer2() {
		return this.player2;
	}
	
	/**
	 * This is to be used by a comboBox  or GUI to select which opponent.
	 * @param player2
	 */
	public void setPlayer2(OthelloPlayer player2) {
		this.player2 = player2;
		this.notifyObservers();
	}

	public OthelloPlayer getPlayerWithTurn() {
		return this.playerWithTurn;
	}
		
	@Override
	public void update(Observable o) {
		char wt = this.othello.getWhosTurn();
		setWhosTurn(wt);
		this.playerWithTurn.onPlayersTurn();
	}

	private void setWhosTurn(char wt) {
		if(wt == OthelloBoard.P1) {
			this.playerWithTurn = this.player1;
		}else if(wt == OthelloBoard.P2) {
			this.playerWithTurn = this.player2;
		}
	}
	
}
