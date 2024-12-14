package ca.yorku.eecs3311.othello.viewcontroller.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ca.yorku.eecs3311.othello.model.StackHistory;
import ca.yorku.eecs3311.util.Command;

public class CommandHistory implements StackHistory<Command> {
	private  Stack<Command> history = new Stack<Command>();

	@Override
	public Command pop() {
		return history.pop();
	}

	@Override
	public Command push(Command o) {
		return this.history.push(o);
	}

	@Override
	public Command peek() {
		return this.history.peek();
	}

	@Override
	public void reset() {
		this.history.clear();
	}

	@Override
	public boolean isEmpty() {
		return this.history.empty();
	}

	@Override
	public int size() {
		return this.history.size();
	}

	@Override
	public List<Command> getHistory() {
		List<Command> list  = new ArrayList<>();
		for(Command t : this.history) {
			list.add(t);
		}
		return list;
	}

}
