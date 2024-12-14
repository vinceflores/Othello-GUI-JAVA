package ca.yorku.eecs3311.othello.viewcontroller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import ca.yorku.eecs3311.othello.model.Othello;
import ca.yorku.eecs3311.othello.viewcontroller.player_strategies.OthelloPlayer;
import ca.yorku.eecs3311.util.FilesService;

/**
 * Logic For LoadGameFromFileHandler
 */
public class GameLoader {
	private Othello o;
	private OpponentManager om;
	private HashMap<String, OthelloPlayer> options;
	private FilesService fileService;

	public  GameLoader( Othello o, OpponentManager om, HashMap<String, OthelloPlayer> playerOptions,  FilesService fileService) {
		this.o = o;
		this.om = om; 
		this.options = playerOptions;
		this.fileService = fileService;
	}
	
	public boolean loadAGame() throws FileNotFoundException  {
		File file = fileService.selectFileToUplaod();
		if(file == null) return false;
		
		try {
		Scanner	reader = new Scanner(file);
			int i = 0; 
			OthelloPlayer player = null ;
			Othello othello = this.o.copy();
			while(reader.hasNext()) {
				if(i == 0) {
					// set opponent
					String[] key = reader.nextLine().split("\n"); 
					player = this.options.get(key[0]);
					i++;
				}else {
					String[] move = reader.nextLine().split(":");
					othello.move(Integer.parseInt(move[0]), Integer.parseInt(move[1]));
				}
			}

			this.o.set(othello);
			if(player != null ) {
				this.om.setPlayer2(player); 
			}
			
			reader.close();
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}

}
