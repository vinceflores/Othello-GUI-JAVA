package ca.yorku.eecs3311.othello.viewcontroller.controllers;

import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.viewcontroller.GameSaver;
import ca.yorku.eecs3311.othello.viewcontroller.MoveInvoker;
import ca.yorku.eecs3311.othello.viewcontroller.OpponentManager;
import ca.yorku.eecs3311.othello.viewcontroller.scenes.SceneRouter;
import ca.yorku.eecs3311.util.FilesService;
import javafx.stage.Stage;

/**
 * Groups the controllers for the Game Scene
 */
public class GameController {
	// Controllers
	private  MoveEvventHandler moveHandler;
	private  ResetGameHandler resetHandler;
	private  UndoHandler undoHandler;
	private  RedoHandler redoHandler;
	private  SaveToFileHandler saveHandler;
	private  MenuRouterHandler menuRouterHandler;
	
	public GameController(
			Stage stage, Othello othello, 
			OpponentManager om,
			MoveInvoker invoker,
			FilesService fileService
		) {
			GameSaver gameSaver = new GameSaver(othello, om, fileService);
		
			this.moveHandler = new MoveEvventHandler(othello, invoker);
			this.resetHandler = new ResetGameHandler(invoker);
			this.undoHandler = new UndoHandler(invoker);
			this.redoHandler = new RedoHandler(invoker);

			this.saveHandler = new SaveToFileHandler(gameSaver);
			this.menuRouterHandler = new MenuRouterHandler(new SceneRouter(stage), invoker);
		}	
	
	public MoveEvventHandler getMoveHandler() {
		return moveHandler;
	}

	public ResetGameHandler getResetHandler() {
		return resetHandler;
	}

	public UndoHandler getUndoHandler() {
		return undoHandler;
	}

	public RedoHandler getRedoHandler() {
		return redoHandler;
	}

	public SaveToFileHandler getSaveHandler() {
		return saveHandler;
	}

	public MenuRouterHandler getMenuRouterHandler() {
		return menuRouterHandler;
	}
	
}
