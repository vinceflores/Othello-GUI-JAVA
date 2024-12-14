package ca.yorku.eecs3311.othello.viewcontroller.game_views;

import java.util.ArrayList;
import java.util.List;

import ca.yorku.eecs3311.othello.model.Move;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.model.OthelloBoard;
import ca.yorku.eecs3311.othello.viewcontroller.visitors.HintVisitor;
import ca.yorku.eecs3311.util.Observable;
import ca.yorku.eecs3311.util.Observer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * View Component for Game Scene
 */
public class OthelloBoardView extends GridPane implements Observer {
	private  Othello othelo; 
	private HintVisitor hints;
	private List<OBoardTile> tiles;

	public OthelloBoardView(Othello othello) {
		this.othelo = othello;
		this.hints = new HintVisitor(othello);
		this.setHgap(3);
		this.setVgap(5);
		
		this.setPadding(new Insets(20));
		this.setStyle("-fx-background-color:#000");

		setUpBoard();
	}

	private void setUpBoard() {
		tiles = new ArrayList<OBoardTile>();
		int dim = this.othelo.DIMENSION;

		char whosturn = this.othelo.getWhosTurn();
		List<Move> hintList = this.othelo.accept(this.hints);

		for(int i = 0 ; i < dim ; i++) {
			for (int j = 0 ; j < dim ; j++) {
				OBoardTile tile;
				char player = this.othelo.getToken(i, j);
				tile = new OBoardTile(player, i , j);
				setHints(hintList, whosturn, tile);
				tiles.add(i, tile);
				this.add(tile, j, i); // row and col are switched in javafx
			}
		}
		
	}
	
	/**
	 * Used to dynamically change the handler for all the tiles in the board
	 */
	public void setMoveHandler(EventHandler<ActionEvent> moveHandler) {
		this.tiles.forEach(t -> t.setOnAction(moveHandler));
	}

	@Override
	public void update(Observable o) {
		Othello othello = (Othello) o;
		int dim = othelo.DIMENSION;
		List<Move> hintList = othelo.accept(this.hints);

		char whosturn= othello.getWhosTurn();
		for(int i = 0 ; i< this.tiles.size() ; i++ ) {
			OBoardTile tile = this.tiles.get(i);
			char player = othelo.getToken(tile.getRow(), tile.getCol());
			tile.setTokenImageView(player);
			setHints(hintList, whosturn, tile);
		}
		
	}

	/**
	 * Show black rectangle for player P1 and white for player P2
	 * @param hintList list of possible moves for the player with turn
	 * @param whosturn the current player with utrn
	 * @param tile 	the button that the hint will be applied
	 */
	private void setHints(List<Move> hintList, char whosturn, OBoardTile tile) {
		for(Move m : hintList) {
			if(tile.getRow() == m.getRow() && tile.getCol() == m.getCol()) {
				if(whosturn == OthelloBoard.P1) {
					tile.setAsHint(Color.BLACK);
				}else if(whosturn == OthelloBoard.P2) {
					tile.setAsHint(Color.WHITE);
				}
			}
		}
	}
}


