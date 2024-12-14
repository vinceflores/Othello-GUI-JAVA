package ca.yorku.eecs3311.othello.viewcontroller.controllers;

import java.util.HashMap;

import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.viewcontroller.GameLoader;
import ca.yorku.eecs3311.othello.viewcontroller.OpponentManager;
import ca.yorku.eecs3311.othello.viewcontroller.player_strategies.OthelloPlayer;
import ca.yorku.eecs3311.othello.viewcontroller.scenes.SceneRouter;
import ca.yorku.eecs3311.util.FilesService;
import javafx.stage.Stage;

/**
 * Group of Controllers for Menu Scene
 */
public class MenuController {
	private  LoadFromFileHandler loadHandler;
	private  GameRouterHandler gameRouterHanlder;
	private  SelectOpponentHandler selectOpponentHanlder;
	
	public MenuController(
			Stage stage,
			Othello othello,
			OpponentManager om,
			HashMap<String, OthelloPlayer> options,
			FilesService fileService
	) {
		GameLoader gameLoader = new GameLoader(othello, om, options, fileService);
		SceneRouter router = new SceneRouter(stage);

		this.loadHandler = new LoadFromFileHandler(stage, gameLoader);
		this.gameRouterHanlder = new GameRouterHandler(router);
		this.selectOpponentHanlder = new SelectOpponentHandler(om, othello, options );
	}

	public LoadFromFileHandler getLoadHandler() {
		return loadHandler;
	}

	public GameRouterHandler getGameRouterHanlder() {
		return gameRouterHanlder;
	}

	public SelectOpponentHandler getSelectOpponentHanlder() {
		return selectOpponentHanlder;
	}
}
