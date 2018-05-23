package com.welle.design.pattern.adapter;

// we create socket plug as one in real life -> 120v

public class Socket {

	public Volt getVolt() {
		return new Volt(120);
	}

}
