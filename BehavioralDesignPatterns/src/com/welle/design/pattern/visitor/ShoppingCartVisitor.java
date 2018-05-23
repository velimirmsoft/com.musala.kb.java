package com.welle.design.pattern.visitor;

public interface ShoppingCartVisitor {

	int visit(Book book);

	int visit(Food food);

}
