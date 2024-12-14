package ca.yorku.eecs3311.othello.viewcontroller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ca.yorku.eecs3311.othello.model.Move;
import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.viewcontroller.player_strategies.OthelloPlayer;
import ca.yorku.eecs3311.util.FilesService;

/**
 * @author vinceflores
 */
public class GameSaver  {
	private Othello othello;
	private OpponentManager om;
	private FilesService fileService;

	public GameSaver( Othello othello, OpponentManager om, FilesService fileService ) { 
		this.othello = othello;
		this.om = om;
		this.fileService = fileService;
	}

	public boolean saveGame() {
		try {
			File file = fileService.createFile();
			if(file == null) return false;
			BufferedWriter fw = new BufferedWriter(new FileWriter(file));
			
			List<Move>  h =  this.othello.getHistory();
			String contentTobeWritten = parsedHistory(this.om.getPlayer2(), h);
			fw.write(contentTobeWritten);
			fw.close();
			return true;
		} catch (IOException e) {
			return false;
		}
		
	}

	/**
	 * Will parse the list of moves in the following fasion
	 * "row:col:player"
	 * @param history ["row:col:player",...]
	 * @return A string representation in the pattern above.
	 */
	private String parsedHistory(OthelloPlayer opponent,List<Move> h ) {
		String str = opponent.getKeyName() + "\n";

		for(int i = 0 ; i < h.size() ; i++) {
			Move move = h.get(i);
			str += move.getRow() + ":" + move.getCol();
			if(i != h.size() - 1 ){
				str += "\n";
			}
		}

		return str;
	}

}
