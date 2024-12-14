package ca.yorku.eecs3311.util;

public interface Command {
	public boolean execute();
	public void undo();
	public void redo();
}
