package ca.yorku.eecs3311.othello.viewcontroller.commands;

import ca.yorku.eecs3311.othello.model.Move;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.util.Command;

/**
 * Move Command, used by controller MoveEventHandler 
 */
public class MoveCommand implements Command {
	public Othello othello;
	private Othello undoCopy;
	private Othello redoCopy;
	private Move curr;
	
	public MoveCommand(Othello othello, Move m) {
		this.othello = othello;
		this.undoCopy = othello.copy();
		this.redoCopy = null;
		this.curr = m;
	}

	public MoveCommand  setMoves(int row, int col) {
		this.curr = new Move(row, col);
		return this;
	}
	
	@Override
	public boolean execute() {
		if(this.curr == null) return false;
		return this.othello.move(this.curr.getRow(), this.curr.getCol());
	}

	@Override
	public void undo() {
		this.redoCopy = this.othello.copy();
		this.othello.set(undoCopy.copy());
	}

	@Override
	public void redo() {
		this.undoCopy = this.othello.copy();
		this.othello.set(this.redoCopy.copy());
	}

}
