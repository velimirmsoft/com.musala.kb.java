package com.welle.design.pattern.factory;

// we make our factory singleton, and we just produce our computers

public class ComputerFactory {

	public static enum ComputerType {
		PersonalComputer, ServerComputer
	}

	private ComputerFactory() {

	}

	public static Computer produceComputer(ComputerType type) {
		if (type == ComputerType.PersonalComputer) {
			return new PersonalComputer("1TB", "4GB", "Intel i-5");
		}
		if (type == ComputerType.ServerComputer) {
			return new ServerComputer("100TB", "16GB", "Xeon CPU");
		}
		return null;
	}

}
