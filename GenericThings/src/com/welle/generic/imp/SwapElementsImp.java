package com.welle.generic.imp;

import com.welle.generic.interfaces.SwapElements;

public class SwapElementsImp<T> implements SwapElements<T> {

	@Override
	public T[] swap(T[] a, int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return a;
	}
	
}
