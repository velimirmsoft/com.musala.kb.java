package com.welle.design.pattern.adapter;

public class SocketAdapterImpl extends Socket implements SocketAdapter {

	@Override
	public Volt get_120Volt() {
		return getVolt();
	}

	@Override
	public Volt get_012Volt() {
		Volt v = getVolt();
		return new Volt(v.getVolts() / 10);
	}

	@Override
	public Volt get_003Volt() {
		Volt v = getVolt();
		return new Volt(v.getVolts() / 40);
	}

}
