package com.welle.design.patterns.main;

import com.welle.design.pattern.adapter.SocketAdapter;
import com.welle.design.pattern.adapter.SocketAdapterImpl;
import com.welle.design.pattern.adapter.Volt;
import com.welle.design.pattern.bridge.CircleShape;
import com.welle.design.pattern.bridge.GreenColor;
import com.welle.design.pattern.bridge.RedColor;
import com.welle.design.pattern.bridge.TriangleShape;
import com.welle.design.pattern.composite.Circle;
import com.welle.design.pattern.composite.Drawing;
import com.welle.design.pattern.composite.Shape;
import com.welle.design.pattern.composite.Triangle;
import com.welle.design.pattern.decorator.BasicCar;
import com.welle.design.pattern.decorator.Car;
import com.welle.design.pattern.decorator.LuxuryCar;
import com.welle.design.pattern.decorator.SportsCar;
import com.welle.design.pattern.facade.HelperFacade;
import com.welle.design.pattern.flyweight.DrawingClient;

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

		print("Facade ...");

		// Facade pattern
		// generating MySql HTML report and Oracle PDF report using Facade
		HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, "testTable");
		HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, "testTable");

		print("Flyweight ...");

		// Flyweight pattern

		DrawingClient d = new DrawingClient(500, 600);
		d.drawThings();

		print("Composite ...");

		// Composite - the idea is to have 'part whole hierarchy'
		Drawing dSpahes = new Drawing();

		Shape sC = new Circle();
		Shape sT = new Triangle();
		dSpahes.addShape(sC);
		dSpahes.addShape(sT);
		dSpahes.draw("RED");

		print("Bridge ...");

		// Bridge pattern - the point of this pattern is to decouple
		// interfaces, as show in this example, we decouple two interfaces
		com.welle.design.pattern.bridge.Shape circleShape = new CircleShape(new RedColor());
		circleShape.sayMyShapeAndColor();

		com.welle.design.pattern.bridge.Shape triangleShape = new TriangleShape(new GreenColor());
		triangleShape.sayMyShapeAndColor();

		// end
		print("done!");

	}

	public static void print(String s) {
		System.out.println("----------------------------------------");
		System.out.println(s);
		System.out.println("----------------------------------------");

	}

}
