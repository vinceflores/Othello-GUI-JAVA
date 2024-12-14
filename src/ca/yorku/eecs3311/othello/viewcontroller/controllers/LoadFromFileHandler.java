package ca.yorku.eecs3311.othello.viewcontroller.controllers;

import java.io.FileNotFoundException;

import ca.yorku.eecs3311.othello.viewcontroller.GameLoader;
import ca.yorku.eecs3311.othello.viewcontroller.scenes.Game;
import ca.yorku.eecs3311.othello.viewcontroller.scenes.SceneRouter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class LoadFromFileHandler  implements EventHandler<ActionEvent>{ 
	private GameLoader loader; 
	private SceneRouter router;
	public LoadFromFileHandler(Stage stage, GameLoader  loader) {
		this.loader = loader;
		this.router = new SceneRouter(stage);
	}

	@Override
	public void handle(ActionEvent arg0) {
		try {
			if( this.loader.loadAGame())
				this.router.goTo(Game.getStaticKey());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
