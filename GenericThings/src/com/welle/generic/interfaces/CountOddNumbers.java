package com.welle.generic.interfaces;

// generic interface

public interface CountOddNumbers<T> {

	public boolean isOddNum(T num);

	// or define generic method
	// public <T> boolean isOddNumGen(T num);
	// public <E> E max(List<E> list, int begin, int end);

}
