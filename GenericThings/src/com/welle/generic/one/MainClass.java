package com.welle.generic.one;

import java.util.Arrays;
import java.util.Collection;

// main class - to test things ...

public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("Generic Type exercise 1 ...");

		Collection<Integer> cI = Arrays.asList(1, 2, 3, 4);
		int count = ClassOne.countOddElementsInCollection(cI, new exeNumOperations());
		System.out.println("Number of odd integers = " + count);
		
		System.out.println("Our array : " + Arrays.toString(ClassOne.swapThings(cI.toArray(), 1, 2)));
		
	}

}
