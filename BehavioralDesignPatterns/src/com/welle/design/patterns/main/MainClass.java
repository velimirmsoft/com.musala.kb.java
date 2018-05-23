package com.welle.design.patterns.main;

import com.welle.design.pattern.chain.ATMDispenseChain;
import com.welle.design.pattern.chain.Currency;
import com.welle.design.pattern.iterator.Channel;
import com.welle.design.pattern.iterator.ChannelCollection;
import com.welle.design.pattern.iterator.ChannelCollectionImpl;
import com.welle.design.pattern.iterator.ChannelIterator;
import com.welle.design.pattern.iterator.ChannelTypeEnum;
import com.welle.design.pattern.mediator.ChatMediator;
import com.welle.design.pattern.mediator.ChatMediatorImpl;
import com.welle.design.pattern.mediator.User;
import com.welle.design.pattern.mediator.UserImpl;
import com.welle.design.pattern.state.State;
import com.welle.design.pattern.state.TvContext;
import com.welle.design.pattern.state.TvStartState;
import com.welle.design.pattern.state.TvStopState;
import com.welle.design.pattern.strategy.CompressStrategy;
import com.welle.design.pattern.strategy.RarCompresion;
import com.welle.design.pattern.strategy.ZipCompresion;
import com.welle.design.pattern.template.BasicHouse;
import com.welle.design.pattern.template.BuildHouse;
import com.welle.design.pattern.template.UnfinishedHouse;
import com.welle.design.pattern.visitor.Book;
import com.welle.design.pattern.visitor.Food;
import com.welle.design.pattern.visitor.Item;
import com.welle.design.pattern.visitor.ShoppingCartVisitor;
import com.welle.design.pattern.visitor.ShoppingCartVisitorImpl;

public class MainClass {

	public static void main(String[] args) {

		// Behavioral design patterns

		print("Template ...");

		// template pattern
		BuildHouse house = new BasicHouse();
		house.buildHouse();
		BuildHouse house_2 = new UnfinishedHouse();
		house_2.buildHouse();

		print("Mediator ...");

		// Mediator pattern
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "Pankaj");
		User user2 = new UserImpl(mediator, "Lisa");
		User user3 = new UserImpl(mediator, "Saurabh");
		User user4 = new UserImpl(mediator, "David");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		user1.send("Hi All");

		print("Chain ...");

		// Chain pattern
		ATMDispenseChain atmDispenser = new ATMDispenseChain();
		atmDispenser.c1.dispense(new Currency(150));
		atmDispenser.c1.dispense(new Currency(30));
		atmDispenser.c1.dispense(new Currency(230));

		print("Strategy ...");

		// Strategy pattern

		CompressStrategy cFile = new CompressStrategy();
		cFile.setStrategyForCompressing(new ZipCompresion());
		cFile.getStrategy().prepareFile();
		cFile.getStrategy().CompressFileAsap();

		cFile.setStrategyForCompressing(new RarCompresion());
		cFile.getStrategy().prepareFile();
		cFile.getStrategy().CompressFileAsap();

		print("State ...");

		// State pattern
		TvContext tv = new TvContext();
		State tvStartState = new TvStartState();
		State tvStopState = new TvStopState();
		tv.setState(tvStartState);
		tv.doAction();
		tv.setState(tvStopState);
		tv.doAction();

		print("Visitor ...");

		// Visitor pattern
		Item[] items = new Item[] { new Book(20, "1234"), new Book(100, "5678"), new Food(10, 2, "Banana"),
				new Food(5, 5, "Apple") };
		ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
		int sum = 0;
		for (Item item : items) {
			sum = sum + item.accept(visitor);
		}
		System.out.println("Total Cost = " + sum);

		print("Iterator ...");

		// Iterator pattern = Iterable + iterator + hasNext, next ...
		ChannelCollection channels = new ChannelCollectionImpl();
		channels.addChannel(new Channel(98.5, ChannelTypeEnum.ENGLISH));
		channels.addChannel(new Channel(99.5, ChannelTypeEnum.HINDI));
		channels.addChannel(new Channel(100.5, ChannelTypeEnum.FRENCH));
		channels.addChannel(new Channel(101.5, ChannelTypeEnum.ENGLISH));
		channels.addChannel(new Channel(102.5, ChannelTypeEnum.HINDI));
		channels.addChannel(new Channel(103.5, ChannelTypeEnum.FRENCH));
		channels.addChannel(new Channel(104.5, ChannelTypeEnum.ENGLISH));
		channels.addChannel(new Channel(105.5, ChannelTypeEnum.HINDI));
		channels.addChannel(new Channel(106.5, ChannelTypeEnum.FRENCH));
		ChannelIterator baseIterator = channels.iterator(ChannelTypeEnum.ALL);
		while (baseIterator.hasNext()) {
			Channel c = baseIterator.next();
			System.out.println(c.toString());
		}

		// end
		print("done!");

	}

	public static void print(String s) {
		System.out.println("----------------------------------------");
		System.out.println(s);
		System.out.println("----------------------------------------");

	}

}
