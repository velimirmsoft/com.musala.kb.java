package com.welle.design.pattern.chain;

public class ATMDispenseChain {

	public DispenseChain c1;

	public ATMDispenseChain() {

		// initialize the chain
		this.c1 = new Dispanse50();
		DispenseChain c2 = new Dispanse10();

		// set the chain of responsibility
		c1.setNextChain(c2);

	}

}
