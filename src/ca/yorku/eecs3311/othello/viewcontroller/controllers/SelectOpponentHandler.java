package ca.yorku.eecs3311.othello.viewcontroller.controllers;

import java.util.HashMap;

import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.viewcontroller.OpponentManager;
import ca.yorku.eecs3311.othello.viewcontroller.player_strategies.OthelloPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

public class SelectOpponentHandler implements EventHandler<ActionEvent> {
	private OpponentManager opponentManager;
	public HashMap<String, OthelloPlayer> options;

	public SelectOpponentHandler(OpponentManager controler, Othello othello, HashMap<String, OthelloPlayer> options) {
		this.opponentManager = controler;
		this.options = options;
	}

	@Override
	public void handle(ActionEvent event) {
		ComboBox source = (ComboBox) event.getSource();
		this.opponentManager.setPlayer2(
			this.options.get(source.getValue())
		);
	}
}
