package com.welle.generic.one;

import java.util.Arrays;
import java.util.Collection;

// main class - to test things ...

public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("Generic Type exercise 1 ...");

		Collection<Integer> cI = Arrays.asList(1, 2, 3, 4);
		int count = ClassOne.countOddElementsInCollection(cI, new checkOdd());
		System.out.println("Number of odd integers = " + count);
		
	}

}
