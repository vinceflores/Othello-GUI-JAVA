package ca.yorku.eecs3311.othello.viewcontroller.controllers;



import ca.yorku.eecs3311.othello.viewcontroller.GameSaver;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class SaveToFileHandler implements EventHandler<ActionEvent> {
	private GameSaver saver;

	public SaveToFileHandler(GameSaver saver) {
		this.saver = saver;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		this.saver.saveGame();
	}

}
