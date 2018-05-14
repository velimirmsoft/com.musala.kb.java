package com.welle.generic.one;

import java.util.List;

// generic interface

public interface numOperations<T> {

	public boolean isOddNum(T num);

	// or define generic method
	// public <T> boolean isOddNumGen(T num);
	
	public T[] swap(T[] a, int i, int j);
	
	public <E> E max(List<E> list, int begin, int end);

}
