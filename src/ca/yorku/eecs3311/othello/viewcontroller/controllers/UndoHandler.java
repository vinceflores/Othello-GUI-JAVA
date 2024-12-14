package ca.yorku.eecs3311.othello.viewcontroller.controllers;

import ca.yorku.eecs3311.othello.viewcontroller.MoveInvoker;
import ca.yorku.eecs3311.othello.viewcontroller.commands.MoveCommand;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UndoHandler  implements EventHandler<ActionEvent> {
//	private MoveUCommand m;
//	public UndoHandler(MoveUCommand m) {
//		this.m = m;
//	}
	private MoveInvoker m;
	public UndoHandler(MoveInvoker m ) {
		this.m = m;
	}

	@Override
	public void handle(ActionEvent arg0) {
		m.undo();
	}

}
