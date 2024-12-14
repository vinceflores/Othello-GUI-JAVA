package ca.yorku.eecs3311.util;

import javafx.stage.FileChooser;

public class FileChooserSingleton {
	private static final FileChooser filechooser = new FileChooser();
	private FileChooserSingleton() {}
	public  static FileChooser getInstance() {
		return FileChooserSingleton.filechooser;
	}
}