package com.welle.generic.one;

import java.util.Collection;
import java.util.List;

public class NumOperationsImp implements numOperations<Integer> {

	// here we define a generic method

	public static <T> int countOddElementsInCollection(Collection<T> c, numOperations<T> check) {
		int x = 0;
		for (T element : c) {
			if (check.isOddNum(element)) {
				x++;
			}
		}
		return x;
	}

	public static <T> T[] swapThings(T[] a, int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return a;
	}

	@Override
	public boolean isOddNum(Integer num) {
		if (num % 2 == 0)
			return true;
		return false;
	}

	@Override
	public <T> T[] swap(T[] a, int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return a;
	}

	@Override
	public <E> E max(List<E> list, int begin, int end) {

		E maxElem = list.get(begin);

		for (++begin; begin < end; ++begin)
			if (((Integer) maxElem).compareTo((Integer) list.get(begin)) < 0)
				maxElem = list.get(begin);
		return maxElem;

	}

}
