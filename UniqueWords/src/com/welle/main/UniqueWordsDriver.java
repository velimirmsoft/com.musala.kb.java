package com.welle.main;

import java.util.Scanner;

import com.welle.read.and.process.file.ReadAndProcessFile;
import com.welle.unique.words.processor.UniqueWordsProcessor.OrderType;

public class UniqueWordsDriver {

	public void startOurUniqueWordsDriver() {

		System.out.println("Processing txt file ... please wait");

		// init our processor
		ReadAndProcessFile doThings = new ReadAndProcessFile();

		// count unique words
		doThings.readTxtFileAndProcess();

		// report
		doThings.reportUniqueWordsFromFile();

		System.out.println("Enter the word you want to search for :");
		// wait for input and search for that word
		Scanner sc = new Scanner(System.in);
		String toSearchW = "";
		while (!(toSearchW = sc.nextLine()).equals("q")) {
			doThings.searchForWord(toSearchW);
		}
		sc.close();

		// print every word that appear more then some threshold
		doThings.sortOrderAndPrintWords(1000, OrderType.ASC);

		// remove all uppder cases
		doThings.removeAllUppderCase();

		//
		doThings.sortOrderByAlphaAndPrintWords(500);

	}

}
