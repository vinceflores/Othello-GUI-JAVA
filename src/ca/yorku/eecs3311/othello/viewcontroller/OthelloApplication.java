package ca.yorku.eecs3311.othello.viewcontroller;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloBoard;
import ca.yorku.eecs3311.othello.viewcontroller.controllers.GameController;
import ca.yorku.eecs3311.othello.viewcontroller.controllers.MenuController;
import ca.yorku.eecs3311.othello.viewcontroller.player_strategies.GreedyPlayer;
import ca.yorku.eecs3311.othello.viewcontroller.player_strategies.HumanPlayer;
import ca.yorku.eecs3311.othello.viewcontroller.player_strategies.OthelloPlayer;
import ca.yorku.eecs3311.othello.viewcontroller.player_strategies.RandomPlayer;
import ca.yorku.eecs3311.othello.viewcontroller.scenes.Game;
import ca.yorku.eecs3311.othello.viewcontroller.scenes.Menu;
import ca.yorku.eecs3311.util.FilesService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OthelloApplication extends Application {
	// REMEMBER: To run this in the lab put 
	// --module-path "/usr/share/openjfx/lib" --add-modules javafx.controls,javafx.fxml
	// in the run configuration under VM arguments.
	// You can import the JavaFX.prototype launch configuration and use it as well.

	private static Map<String, Scene> scenes = new HashMap<>();
	
	@Override
	public void start(Stage stage) throws Exception {
		// Create and hook up the Model, View and the controller
		
		// MODEL
			Othello othello=new Othello(); // Observable
			OpponentManager oppoManager = new OpponentManager(othello); // Observable
			MoveInvoker invoker = new MoveInvoker(othello);
			LinkedHashMap<String, OthelloPlayer> options = new LinkedHashMap<>();
			options.put(HumanPlayer.keyname, new HumanPlayer(othello, OthelloBoard.P2));
			options.put(GreedyPlayer.keyname, new GreedyPlayer(othello, OthelloBoard.P2));
			options.put(RandomPlayer.keyname, new RandomPlayer(othello,  OthelloBoard.P2));	

			FilesService fileService = new FilesService(stage);

		// CONTROLLER
		// CONTROLLER->MODEL hookup

			MenuController menuController = new MenuController(
					stage, othello, oppoManager, options, fileService
			);
	
			GameController gameController = new GameController(
				stage, othello, oppoManager, invoker, fileService
			);
		
		// VIEW
		// View Layout	
		// VIEW->CONTROLLER hookup

			Menu menuView = new Menu(stage, othello,oppoManager, options, menuController );
			Game gameView = new Game(stage, othello, oppoManager, gameController);
	
		// MODEL->VIEW hookup

		   othello.attach(oppoManager);

		// SCENE
			scenes.put(gameView.getKey(), gameView.createScene());
			scenes.put(menuView.getKey(), menuView.createScene());

			stage.setTitle("Othello");
			stage.setScene(scenes.get(menuView.getKey()));
				
		// LAUNCH THE GUI
			stage.show();
	}

	public static Map<String, Scene> getscenes(){
		return scenes;
	}
	
	public static void main(String[] args) {
//		OthelloApplication view = new OthelloApplication();
		launch(args);
	}
}
