package ca.yorku.eecs3311.util;

import java.util.List;

import ca.yorku.eecs3311.othello.model.Move;
import ca.yorku.eecs3311.othello.model.OthelloBoard;

public interface Visitor {
	public List<Move> visit(OthelloBoard board); 
}
