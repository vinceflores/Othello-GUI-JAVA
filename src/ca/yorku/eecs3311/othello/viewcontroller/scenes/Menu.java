package ca.yorku.eecs3311.othello.viewcontroller.scenes;

import java.util.HashMap;

import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.viewcontroller.OpponentManager;
import ca.yorku.eecs3311.othello.viewcontroller.controllers.MenuController;
import ca.yorku.eecs3311.othello.viewcontroller.game_views.SelectOpponentview;
import ca.yorku.eecs3311.othello.viewcontroller.player_strategies.OthelloPlayer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Creates the Menu Scene
 */
public class Menu extends BaseScene {
	private static final String key = "Menu";
	private HashMap<String, OthelloPlayer> options;
	private OpponentManager om;

	// Controllers 
	private MenuController menuController  ;
	
	public Menu(Stage stage, Othello othello, OpponentManager om,  HashMap<String, OthelloPlayer> options, MenuController menuController) {
		super(stage, othello, key);
		this.om = om;
		this.options = options;
		this.menuController = menuController;
	}

	@Override
	public Scene createScene() {
		
		// Components
		Text title  = new Text("Othello Game");
		title.setFont(Font.font(86));
		Text author = new Text("by vinceflores");
		Text selectOpponentText = new Text("Select Opponent:");

		SelectOpponentview selectOpponent = new SelectOpponentview(this.om);
		this.options.keySet().forEach(e -> selectOpponent.getItems().add(e));

		Button loadButton = new Button("Load Game");
		Button startButton = new Button("Start Game");

		// VIEW -> Controller
		
		loadButton.setOnAction(this.menuController.getLoadHandler());
		startButton.setOnAction(this.menuController.getGameRouterHanlder());
		selectOpponent.setOnAction(this.menuController.getSelectOpponentHanlder());
		selectOpponent.setPromptText("Select Opponent");
		selectOpponent.getSelectionModel().select(0);	
		selectOpponent.setPrefWidth(200);	
		
		// LAYOUT
		VBox TitleSection = new VBox();
		TitleSection.setSpacing(2);
		TitleSection.setAlignment(Pos.CENTER);
		TitleSection.getChildren().addAll(title, author);
		
		HBox selectOp = new HBox();
		selectOp.setAlignment(Pos.CENTER);
		selectOp.setSpacing(10);
		selectOp.getChildren().addAll(selectOpponentText, selectOpponent);
		
		HBox buttonMenu  = new HBox();
		buttonMenu.setSpacing(10);
		buttonMenu.setAlignment(Pos.CENTER);
		buttonMenu.getChildren().addAll(
			loadButton, startButton
		);
		
		VBox layout = new VBox();
		layout.setSpacing(10);
		layout.setPrefSize(900, 600);
		
		layout.getChildren().addAll(
			TitleSection,
			selectOp,
			buttonMenu
		);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		scene.getStylesheets().add(getClass()
				.getResource("styles.css")		
				.toExternalForm()
		);	
		
		//  MODEL -> VIEW 
		this.om.attach(selectOpponent);	

		return scene;
	}
	
	public static String getStaticKey() {
		return key;
	}
	
}
