package com.musala.kb.main;

import com.musala.kb.generala.game.GeneralaGame;
import com.musala.kb.generala.game.imp.GeneralaGameImp;

public class SingeletonGeneralaGame {

	private static GeneralaGame game = null;

	protected SingeletonGeneralaGame() {}

	public static GeneralaGame getInstanceOfGame() {
		if (game == null) {
			game = new GeneralaGameImp();
		}
		return game;
	}

}
