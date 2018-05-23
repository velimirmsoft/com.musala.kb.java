package com.welle.design.patterns.main;

import com.welle.design.pattern.factory.Computer;
import com.welle.design.pattern.builder.*;
import com.welle.design.pattern.factory.ComputerFactory;
import com.welle.design.pattern.prototype.Employee;
import com.welle.design.pattern.singleton.GodSingletonInstance;

public class MainClass {

	public static void main(String[] args) {

		// creational design patterns

		print("Singleton ...");

		// singleton
		GodSingletonInstance god = GodSingletonInstance.getSingleGodInstance();
		god.saveHumans();
		// 2th time we init our class we just get the same instance created before this
		// call
		GodSingletonInstance god_2 = GodSingletonInstance.getSingleGodInstance();
		god_2.saveHumans();

		print("Factory ...");

		// factory pattern
		Computer c1 = ComputerFactory.produceComputer(ComputerFactory.ComputerType.PersonalComputer);
		c1.OurCPU();
		c1.OurHDD();
		c1.OurRAM();

		Computer c2 = ComputerFactory.produceComputer(ComputerFactory.ComputerType.ServerComputer);
		c2.OurCPU();
		c2.OurHDD();
		c2.OurRAM();

		print("Builder ...");

		// builder pattern
		com.welle.design.pattern.builder.Computer buildComputer = new com.welle.design.pattern.builder.Computer.ComputerBuilder(
				"1TB", "4GB", "Intel i3").setGraphicsCard().build();
		buildComputer.OurCPU();
		buildComputer.OurHDD();
		buildComputer.OurRAM();
		buildComputer.isBluetoothEnabled();
		buildComputer.isGraphicsCardEnabled();

		print("Prototype ...");

		// prototype pattern

		Employee empls = new Employee();
		empls.addEmployee("welle");
		empls.addEmployee("petko");
		empls.addEmployee("stanko");
		empls.printEmployees();
		Employee empls_clone = (Employee) empls.clone();
		empls_clone.printEmployees();

		// end
		print("done!");

	}

	public static void print(String s) {
		System.out.println("----------------------------------------");
		System.out.println(s);
		System.out.println("----------------------------------------");

	}

}
