package ca.yorku.eecs3311.othello.viewcontroller.controllers;

import ca.yorku.eecs3311.othello.viewcontroller.scenes.Game;
import ca.yorku.eecs3311.othello.viewcontroller.scenes.SceneRouter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GameRouterHandler implements EventHandler<ActionEvent> {
	
	private SceneRouter router;
	public GameRouterHandler(SceneRouter router) {
		super();
		this.router = router;
	}

	@Override
	public void handle(ActionEvent arg0) {
		this.router.goTo(Game.getStaticKey());
	}

}
