package com.welle.design.pattern.factory;

public class ServerComputer extends Computer {

	String hdd = "";
	String ram = "";
	String cpu = "";

	public ServerComputer(String hdd, String ram, String cpu) {
		this.hdd = hdd;
		this.ram = ram;
		this.cpu = cpu;
	}

	@Override
	public void OurHDD() {
		System.out.println("ServerComputer " + hdd);
	}

	@Override
	public void OurRAM() {
		System.out.println("ServerComputer " + ram);
	}

	@Override
	public void OurCPU() {
		System.out.println("ServerComputer " + cpu);
	}

}
