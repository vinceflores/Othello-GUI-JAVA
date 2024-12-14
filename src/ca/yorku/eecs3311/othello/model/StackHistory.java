package ca.yorku.eecs3311.othello.model;

import java.util.List;

import javafx.util.Pair;

public interface StackHistory<T> {
	public T pop();
	public T push(T o);
	public T peek();
	public void reset();
	public boolean isEmpty();
	public int size();
	public List<T> getHistory();
}
