package ca.yorku.eecs3311.othello.viewcontroller.scenes;

import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.viewcontroller.OpponentManager;
import ca.yorku.eecs3311.othello.viewcontroller.controllers.GameController;
import ca.yorku.eecs3311.othello.viewcontroller.game_views.GameTypeView;
import ca.yorku.eecs3311.othello.viewcontroller.game_views.OthelloBoardView;
import ca.yorku.eecs3311.othello.viewcontroller.game_views.TokenCounts;
import ca.yorku.eecs3311.othello.viewcontroller.game_views.WhosTurn;
import ca.yorku.eecs3311.othello.viewcontroller.game_views.Winner;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Game extends BaseScene {
	private static final String key = "Game";
	private GameController gameController;
	private  OpponentManager om;

	public Game(
			Stage stage,
			Othello othello,
			OpponentManager om,
			GameController gameController
	) {
		super(stage, othello, key);
		this.gameController = gameController;
		this.om = om;
	}

	@Override
	public Scene createScene() {

		// VIEW COMPONENTS
		OthelloBoardView boardView = new OthelloBoardView(othello);
		
		TokenCounts tokenCounts = new TokenCounts(othello, "Black", "White");

		WhosTurn whosturn = new WhosTurn("Black's turn");
		Winner winner = new Winner();
		GameTypeView gameTypeView = new GameTypeView(this.om.getPlayer2().getKeyName());
		
		Button resetButton = new Button("Reset Game");
		Button undoButton = new Button("Undo"); 
		Button redoButton = new Button("Redo"); 
		Button saveButton = new Button("Save to file");
		
		Button menuButton = new Button("Menu");

		//LAYOUT
		VBox routing = new VBox();
		routing.setAlignment(Pos.BOTTOM_CENTER);
		routing.getChildren().addAll(menuButton);

		VBox controls = new VBox();
		controls.setSpacing(10);
		controls.setPadding(new Insets(20));
		controls.setAlignment(Pos.TOP_CENTER);
		controls.getChildren().addAll(
			resetButton, saveButton,
			routing
		);
			
		HBox undo_redo = new HBox();
		undo_redo.setPrefHeight(80);
		undo_redo.setAlignment(Pos.CENTER_RIGHT);
		undo_redo.getChildren().addAll( undoButton, redoButton );
		
		HBox game_details = new HBox();
		game_details.setAlignment(Pos.CENTER_LEFT);
		game_details.setSpacing(30);
		game_details.getChildren().addAll(tokenCounts , undo_redo, whosturn, winner);
		
		VBox game = new VBox();
		game.getChildren().addAll(
			boardView,
			gameTypeView,
			game_details
		);
		
		HBox layout =  new HBox();
		layout.setPadding(new Insets(10));
		layout.setPrefSize(900, 600);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(
			controls,
			game
		);
		
		// VIEW -> Controller
		boardView.setMoveHandler(this.gameController.getMoveHandler());

		resetButton.setOnAction(this.gameController.getResetHandler());	
		undoButton.setOnAction(this.gameController.getUndoHandler());
		redoButton.setOnAction(this.gameController.getRedoHandler());
		saveButton.setOnAction(this.gameController.getSaveHandler());
		menuButton.setOnAction(this.gameController.getMenuRouterHandler());

		// VIEW -> MODEL
		this.othello.attach(boardView);
		this.othello.attach(tokenCounts);
		this.othello.attach(whosturn);
		this.othello.attach(winner);

		this.om.attach(gameTypeView);
		
		// SCENE
		Scene scene = new Scene(layout);
		scene.getStylesheets().add(getClass()
		.getResource("styles.css")		
		.toExternalForm()
		);

		return scene;
	}
	
	public static String getStaticKey() {
		return key;
	}
	
}
