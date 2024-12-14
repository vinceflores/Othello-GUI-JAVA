package ca.yorku.eecs3311.othello.viewcontroller;

import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.viewcontroller.commands.CommandHistory;
import ca.yorku.eecs3311.othello.viewcontroller.commands.MoveCommand;
import ca.yorku.eecs3311.util.Command;

/**
 * Invoker for MoveCommand
 * Used by MoveEventHandler, UndoHandler, RedoHandler, ResetGameHandler, ...
 */
public class MoveInvoker {

	private CommandHistory undo;
	private CommandHistory redo;
	private Othello othello;
	
	public MoveInvoker(Othello othello) {
		this.othello = othello;
		
		this.undo = new CommandHistory();
		this.redo = new CommandHistory();
	}
	
	public void executeCommand(MoveCommand m) {
		if(m.execute()) {
			this.undo.push(m);
		}
	}
	
	public void undo() {
		if(this.undo.isEmpty()) return;
		Command com = this.undo.pop();
		this.redo.push(com);
		com.undo();
	}
	
	public void redo() {
		if(this.redo.isEmpty()) return;
		Command com = this.redo.pop();
		this.undo.push(com);
		com.redo();
	}
	
	public void reset() {
		this.othello.reset();
		this.undo.reset();
		this.redo.reset();
	}
	
}
