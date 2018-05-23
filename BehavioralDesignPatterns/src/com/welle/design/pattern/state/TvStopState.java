package com.welle.design.pattern.state;

public class TvStopState implements State {

	@Override
	public void doAction() {
		System.out.println("State STOP!");
	}

}
