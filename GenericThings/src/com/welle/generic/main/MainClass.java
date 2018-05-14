package com.welle.generic.main;

import java.util.Arrays;
import java.util.Collection;

import com.welle.generic.imp.CountOddNumbersImp;
import com.welle.generic.imp.SwapElementsImp;

// main class - to test things ...

public class MainClass {

	public static void main(String[] args) {

		System.out.println("Generic Type exercises ...");

		// testing our generic count odd numbers in array of integer things
		Collection<Integer> cI = Arrays.asList(1, 2, 3, 4);
		int count = CountOddNumbersImp.countOddElementsInCollection(cI, new CountOddNumbersImp<Integer>());
		System.out.println("Number of odd integers [integer] = " + count);

		// testing our generic count odd numbers in array of integer things
		Collection<Float> cI_float = Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f);
		count = CountOddNumbersImp.countOddElementsInCollection(cI_float, new CountOddNumbersImp<Float>());
		System.out.println("Number of odd integers [float] = " + count);

		// testing our generic swap function with integers
		SwapElementsImp<Integer> sw = new SwapElementsImp<Integer>();
		System.out.println("Our array : " + Arrays.toString(sw.swap((Integer[]) cI.toArray(), 1, 2)));

		// testing our generic swap function with floats
		SwapElementsImp<Float> sw_float = new SwapElementsImp<Float>();
		System.out.println("Our array : " + Arrays.toString(sw_float.swap((Float[]) cI_float.toArray(), 1, 2)));

	}

}
