package ca.yorku.eecs3311.util;

import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class FilesService implements FileWorker {
	private Stage stage;
	private String selectedFileName;

	public FilesService(Stage stage) {
		this.stage = stage;
		this.selectedFileName = "";
	}
	
	/**
	 * Opens a file chooser window, allow user to select file name 
	 * and saves the name of the file created for later
	 * @return a File object of the created file
	 */
	@Override
	public File createFile() {
		FileChooser fc  = FileChooserSingleton.getInstance();
		fc.setInitialFileName(selectedFileName != "" ? selectedFileName: "othellogame.txt");
		File file =  fc.showSaveDialog(this.stage);
		if(file != null) {
			this.selectedFileName = file.getName();
		}
		return file;
	}

	@Override
	public File selectFileToUplaod() {
		FileChooser fc = FileChooserSingleton.getInstance();// TODO call singleton
		fc.setSelectedExtensionFilter(new ExtensionFilter("text", "txt"));
		File file = fc.showOpenDialog(this.stage);
		return file;
	}

}
