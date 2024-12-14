package ca.yorku.eecs3311.othello.viewcontroller.scenes;

import ca.yorku.eecs3311.othello.model.Othello;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class BaseScene {
	protected Stage stage;
	protected Othello othello;
	private  String KEY = "";

	public BaseScene(Stage stage, Othello othello, String key) {
		this.stage = stage;
		this.othello = othello;
		this.KEY = key;
	}

	public String getKey() {
		return this.KEY;
	}
	
	public abstract Scene createScene();
}
