package ca.yorku.eecs3311.othello.model;

import java.util.List;

import ca.yorku.eecs3311.util.Visitor;

public interface Element {
	public List<Move> accept(Visitor v);
}
