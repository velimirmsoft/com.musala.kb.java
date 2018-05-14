package com.welle.generic.imp;

import java.util.Collection;

import com.welle.generic.interfaces.CountOddNumbers;

public class CountOddNumbersImp<T> implements CountOddNumbers<T> {

	// here we define a generic method

	public static <T> int countOddElementsInCollection(Collection<T> c, CountOddNumbers<T> check) {
		int x = 0;
		for (T element : c) {
			if (check.isOddNum(element)) {
				x++;
			}
		}
		return x;
	}

	@Override
	public boolean isOddNum(T num) {
		int x = ((Number) num).intValue();
		if (x % 2 == 0)
			return true;
		return false;
	}

	/*
	 * @Override public <E> E max(List<E> list, int begin, int end) { E maxElem =
	 * list.get(begin); for (++begin; begin < end; ++begin) if (((Integer)
	 * maxElem).compareTo((Integer) list.get(begin)) < 0) maxElem = list.get(begin);
	 * return maxElem; }
	 */

}
