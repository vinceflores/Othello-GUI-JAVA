package ca.yorku.eecs3311.othello.viewcontroller.controllers;

import ca.yorku.eecs3311.othello.model.Move;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.viewcontroller.MoveInvoker;
import ca.yorku.eecs3311.othello.viewcontroller.commands.MoveCommand;
import ca.yorku.eecs3311.othello.viewcontroller.game_views.OBoardTile;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveEvventHandler implements EventHandler<ActionEvent> {
	private MoveInvoker invoker;
	private Othello othello;
	
	public MoveEvventHandler(Othello othello, MoveInvoker invoker) {
		super();
		this.othello = othello;
		this.invoker = invoker;
	}

	@Override
	public void handle(ActionEvent event) {
		OBoardTile source=(OBoardTile)event.getSource();
		if(!source.isDisabled()) {
			Move move = new Move(source.getRow(), source.getCol());
			this.invoker.executeCommand(new MoveCommand(othello, move));
		}
	}
		
}
