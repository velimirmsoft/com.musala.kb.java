package com.welle.design.pattern.mediator;

public class UserImpl extends User {

	public UserImpl(ChatMediator med, String name) {
		// set user infos
		super(med, name);
	}

	@Override
	public void send(String msg) {
		System.out.println(this.name + ": Sending Message=" + msg);
		mediator.sendMessage(msg, this);
	}

	@Override
	public void receive(String msg) {
		System.out.println(this.name + ": Received Message:" + msg);
	}

}