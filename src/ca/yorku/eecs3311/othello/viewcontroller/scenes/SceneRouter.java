package ca.yorku.eecs3311.othello.viewcontroller.scenes;

import ca.yorku.eecs3311.othello.viewcontroller.OthelloApplication;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Logic for switching between scenes
 * e.g. Menu to Game and vice versa
 */
public class SceneRouter  implements Router{
	private Stage s;
	public SceneRouter(Stage s) {
		this.s = s;
	}

	@Override
	public void goTo(String key) {
		this.s.setScene(OthelloApplication.getscenes().get(key));
	}

}
