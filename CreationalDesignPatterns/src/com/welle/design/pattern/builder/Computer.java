package com.welle.design.pattern.builder;

// here  we demonstrate builder design pattern

public class Computer {

	// required parameters
	private String hdd = "";
	private String ram = "";
	private String cpu = "";

	// optional parameters
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;

	private Computer(ComputerBuilder computer) {
		this.hdd = computer.hdd;
		this.ram = computer.ram;
		this.cpu = computer.cpu;
		this.isBluetoothEnabled = computer.isBluetoothEnabled;
		this.isGraphicsCardEnabled = computer.isGraphicsCardEnabled;
	}

	public void OurHDD() {
		System.out.println("Computer " + hdd);
	}

	public void OurRAM() {
		System.out.println("Computer " + ram);
	}

	public void OurCPU() {
		System.out.println("Computer " + cpu);
	}

	public void isGraphicsCardEnabled() {
		System.out.println("isGraphicsCardEnabled " + isGraphicsCardEnabled);
	}

	public void isBluetoothEnabled() {
		System.out.println("isBluetoothEnabled " + isBluetoothEnabled);
	}

	// builder class
	public static class ComputerBuilder {

		public String hdd = "";
		public String ram = "";
		public String cpu = "";

		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;

		public ComputerBuilder(String hdd, String ram, String cpu) {
			this.hdd = hdd;
			this.ram = ram;
			this.cpu = cpu;
		}

		public ComputerBuilder setBluetooth() {
			this.isBluetoothEnabled = true;
			return this;
		}

		public ComputerBuilder setGraphicsCard() {
			this.isGraphicsCardEnabled = true;
			return this;
		}

		public Computer build() {
			return new Computer(this);
		}

	}

}
