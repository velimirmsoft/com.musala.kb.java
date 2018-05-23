package com.welle.design.pattern.factory;

public class PersonalComputer extends Computer {

	String hdd = "";
	String ram = "";
	String cpu = "";

	public PersonalComputer(String hdd, String ram, String cpu) {
		this.hdd = hdd;
		this.ram = ram;
		this.cpu = cpu;
	}

	@Override
	public void OurHDD() {
		System.out.println("PersonalComputer " + hdd);
	}

	@Override
	public void OurRAM() {
		System.out.println("PersonalComputer " + ram);
	}

	@Override
	public void OurCPU() {
		System.out.println("PersonalComputer " + cpu);
	}

}
