package com.welle.generic.main;

import java.util.Arrays;
import java.util.Collection;

import com.welle.generic.one.NumOperationsImp;

// main class - to test things ...

public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("Generic Type exercises ...");

		Collection<Integer> cI = Arrays.asList(1, 2, 3, 4);
		int count = NumOperationsImp.countOddElementsInCollection(cI, new NumOperationsImp());
		System.out.println("Number of odd integers = " + count);
		
		System.out.println("Our array : " + Arrays.toString(NumOperationsImp.swapThings(cI.toArray(), 1, 2)));
		
	}

}
