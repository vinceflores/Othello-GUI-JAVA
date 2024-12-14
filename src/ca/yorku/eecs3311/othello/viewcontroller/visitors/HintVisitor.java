package ca.yorku.eecs3311.othello.viewcontroller.visitors;

import java.util.ArrayList;
import java.util.List;

import ca.yorku.eecs3311.othello.model.Move;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloBoard;
import ca.yorku.eecs3311.util.Visitor;

public class HintVisitor implements Visitor {
	private Othello othello;

	public  HintVisitor(Othello othello) {
		this.othello = othello;
	}

	@Override
	public List<Move> visit(OthelloBoard board) {
		return getPossibleMoves(this.othello.getWhosTurn(), board);
	}
	
	/**
	 * 
	 * @param player OthelloBoard.player={P1, P2, EMPTY}
	 * @param board  OthelloBoard
	 * @return	The list of possible moves for the player whose turn it is to move.
	 */
	public List<Move> getPossibleMoves(char player, OthelloBoard board){
		int dim = board.getDimension();
		List<Move> possibleMoves = new ArrayList<>();
		
		for (int row = 0; row < dim; row++) {
			for (int col = 0; col < dim; col++) {
				for (int drow = -1; drow <= 1; drow++) {
					for (int dcol = -1; dcol <= 1; dcol++) {	
						char p = board.hasMove(row, col, drow, dcol);
						if(p == player && p != OthelloBoard.EMPTY) {
							possibleMoves.add(new Move(row, col));
						}
					}
				}
			}
		}
		return possibleMoves;
	}	
	
}
