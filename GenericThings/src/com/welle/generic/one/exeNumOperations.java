package com.welle.generic.one;

import java.util.List;

public class exeNumOperations implements numOperations<Integer> {

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
