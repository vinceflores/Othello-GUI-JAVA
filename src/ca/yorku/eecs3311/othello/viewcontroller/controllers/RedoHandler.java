package ca.yorku.eecs3311.othello.viewcontroller.controllers;

import ca.yorku.eecs3311.othello.viewcontroller.MoveInvoker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RedoHandler implements EventHandler<ActionEvent> {
	private MoveInvoker command;

	public RedoHandler(MoveInvoker command) {
		this.command = command;
	}

	@Override
	public void handle(ActionEvent arg0) {
		command.redo();
	}

}
