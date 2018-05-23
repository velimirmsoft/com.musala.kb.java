package com.welle.design.patterns.main;

import com.welle.design.pattern.adapter.SocketAdapter;
import com.welle.design.pattern.adapter.SocketAdapterImpl;
import com.welle.design.pattern.adapter.Volt;
import com.welle.design.pattern.decorator.BasicCar;
import com.welle.design.pattern.decorator.Car;
import com.welle.design.pattern.decorator.LuxuryCar;
import com.welle.design.pattern.decorator.SportsCar;

public class MainClass {

	public static void main(String[] args) {

		// Structural design patterns

		print("Adapter ...");

		// Adapter - we got two diffrent interfaces working together, in this case a
		// Volt and Socket where we have native 120v adapter and 12v and 3v adapted
		SocketAdapter sockAdapter = new SocketAdapterImpl();
		Volt v003 = sockAdapter.get_003Volt();
		Volt v012 = sockAdapter.get_012Volt();
		Volt v120 = sockAdapter.get_120Volt();
		System.out.println(v003.getVolts());
		System.out.println(v012.getVolts());
		System.out.println(v120.getVolts());

		print("Decorator ...");

		// Decorator, as the name suggests, we start from some basic implementation and
		// we move on to
		// implementing new features and new versions of our object. We inherit and
		// call previous constructors and methods with 'super'
		// keyword
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		Car luxuryCar = new LuxuryCar(new BasicCar());
		luxuryCar.assemble();
		Car allInOne = new LuxuryCar(new SportsCar(new BasicCar()));
		allInOne.assemble();

		// end
		print("done!");

	}

	public static void print(String s) {
		System.out.println("----------------------------------------");
		System.out.println(s);
		System.out.println("----------------------------------------");

	}

}
