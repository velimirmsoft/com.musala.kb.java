package com.welle.design.pattern.state;

public class TvStartState implements State {

	@Override
	public void doAction() {
		System.out.println("State ON!");
	}

}
