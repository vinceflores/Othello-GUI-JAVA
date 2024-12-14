package ca.yorku.eecs3311.othello.viewcontroller.game_views;

import ca.yorku.eecs3311.othello.model.OthelloBoard;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * View component for OthellObaordView
 * The view for MoveEventHandler
 */
public class OBoardTile extends Button  {
	private static final Integer TileWidth = 50;	

	private char player;
	private int row;
	private int col;

	int width = 50;
	
	public OBoardTile(char player, int row , int col) {
		this.player = player;
		this.row = row;
		this.col = col;
		this.getStyleClass().add("othello-board-tile");

		this.setStyle("-fx-background-color: #006400;"); 
		this.setMaxSize( 50, 50);
		this.setMinSize(50, 50);
		setTokenImageView(player); 
	}
	
	public int getRow() {
		return this.row;
	}

	public int getCol() {
		return this.col;
	}

	/**
	 * Sets the token image to either P1=blue, P2=red, or EMPTY=while/blank
	 * 
	 * 
	 * @param player is {P1, P2, EMPTY}
	 * 
	 * Pre: if this.player == player, no need to change
	 * 
	 */
	public void setTokenImageView(char player) {

		if(player == OthelloBoard.P1) {
			this.setGraphic(new Circle(20, Color.BLACK));
		}else if(player == OthelloBoard.P2) {
			this.setGraphic(new Circle(20, Color.WHITE));
		}else {
			this.setGraphic(null);
		}
	}
	
	/**
	 * Sets the image to be a hint tile
	 */
	public void setAsHint(Paint paint) {
		if(this.player != OthelloBoard.EMPTY) return;
		
		Canvas canvas = new Canvas(TileWidth - 10, TileWidth -10);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(paint);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		this.setGraphic(canvas);
	}
}
