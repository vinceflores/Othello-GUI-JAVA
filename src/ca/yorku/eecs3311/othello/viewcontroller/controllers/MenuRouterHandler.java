package ca.yorku.eecs3311.othello.viewcontroller.controllers;

import ca.yorku.eecs3311.othello.viewcontroller.MoveInvoker;
import ca.yorku.eecs3311.othello.viewcontroller.scenes.Menu;
import ca.yorku.eecs3311.othello.viewcontroller.scenes.SceneRouter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuRouterHandler implements EventHandler<ActionEvent> {
	private SceneRouter router;
	private MoveInvoker invoker;
	public MenuRouterHandler(SceneRouter router, MoveInvoker invoker) {
		this.router = router;
		this.invoker = invoker;
	}

	@Override
	public void handle(ActionEvent event) {
		this.router.goTo(Menu.getStaticKey());
		this.invoker.reset();
	}
}
