package com.welle.main;

import com.welle.read.and.process.file.ReadAndProcessFile;
import com.welle.settings.FilePathsAndConstants;
import com.welle.unique.words.processor.UniqueWordsProcessorListImpl;
import com.welle.unique.words.processor.UniqueWordsProcessorMapImpl;

public class UniqueWordsDriver {

	public void startOurUniqueWordsDriver(FilePathsAndConstants.WhichImplementation impl) {

		System.out.println("");
		System.out.println("Processing txt file ... please wait");

		ReadAndProcessFile doThings = null;

		// init our processor and impl

		switch (impl) {
		case LIST:
			System.out.println("list impl ...");
			doThings = new ReadAndProcessFile(new UniqueWordsProcessorListImpl());
			break;
		case MAP:
			System.out.println("maps impl ...");
			doThings = new ReadAndProcessFile(new UniqueWordsProcessorMapImpl());
			break;
		}

		// count unique words
		doThings.readTxtFileAndProcess();

		// report
		doThings.reportUniqueWordsFromFile();

		System.out.println("Enter the word you want to search for :");
		/*
		// wait for input and search for that word
		Scanner sc = new Scanner(System.in);
		String toSearchW = "";
		while (!(toSearchW = sc.nextLine()).equals("q")) {
			doThings.searchForWord(toSearchW);
		}
		// sc.close();
		*/
		doThings.searchForWord("Moby");
		doThings.searchForWord("welle");

		// print every word that appear more then some threshold
		doThings.sortOrderAndPrintWords(1000, FilePathsAndConstants.OrderType.ASC);

		// remove all uppder cases
		doThings.removeAllUppderCase();

		// print sorted and ordered
		doThings.sortOrderByAlphaAndPrintWords(500);

	}

}
