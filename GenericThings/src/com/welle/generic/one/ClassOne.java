package com.welle.generic.one;

import java.util.Collection;

// Write a generic method to count the number of elements in a collection that have a specific property 
// (for example, odd integers, prime numbers, palindromes).

public class ClassOne {

	// here we define a generic method

	public static <T> int countOddElementsInCollection(Collection<T> c, isOdd<T> check) {
		int x = 0;
		for (T element : c) {
			if (check.isOddNum(element)) {
				x++;
			}
		}
		return x;
	}

}