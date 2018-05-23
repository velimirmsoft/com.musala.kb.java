package com.welle.design.pattern.visitor;

public interface Item {

	public int accept(ShoppingCartVisitor visitor);
}
