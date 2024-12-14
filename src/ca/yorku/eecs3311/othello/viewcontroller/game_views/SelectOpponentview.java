package ca.yorku.eecs3311.othello.viewcontroller.game_views;

import ca.yorku.eecs3311.othello.viewcontroller.OpponentManager;
import ca.yorku.eecs3311.util.Observable;
import ca.yorku.eecs3311.util.Observer;
import javafx.scene.control.ComboBox;

/**
 * View for Select Opponent for Menu Scene
 */
public class SelectOpponentview extends ComboBox<String> implements Observer {
	private OpponentManager om;
	
	public SelectOpponentview(OpponentManager om) {
		this.om = om;
	}
	
	@Override
	public void update(Observable o) {
		this.getSelectionModel()
			.select(this.om.getPlayer2().getKeyName());
	}

}
