package ca.yorku.eecs3311.othello.viewcontroller.game_views;

import ca.yorku.eecs3311.othello.viewcontroller.OpponentManager;
import ca.yorku.eecs3311.util.Observable;
import ca.yorku.eecs3311.util.Observer;
import javafx.scene.text.Text;

/**
 * View Component to Game Scene
 * Human VS Human, Human VS Greedy, Human VS Random
 */
public class GameTypeView extends Text implements Observer {

	public GameTypeView(String opponent) {
		this.setText("Human VS " + opponent);
		this.setId("text"); // css id, for styling
	}

	@Override
	public void update(Observable o) {
		OpponentManager om = (OpponentManager) o;
		this.setText("Human VS " + om.getPlayer2().getKeyName());
	}

}
