package ca.yorku.eecs3311.othello.viewcontroller.controllers;

import ca.yorku.eecs3311.othello.viewcontroller.MoveInvoker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ResetGameHandler implements EventHandler<ActionEvent> {
	private MoveInvoker moveInvoker;

	public  ResetGameHandler(MoveInvoker moveInvoker) {
		this.moveInvoker = moveInvoker;
	}

	@Override
	public void handle(ActionEvent arg0) {
		this.moveInvoker.reset();
	}
	
}
