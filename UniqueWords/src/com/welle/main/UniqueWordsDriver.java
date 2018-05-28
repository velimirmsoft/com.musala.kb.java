package com.welle.main;

import java.util.Scanner;

import com.welle.read.and.process.file.ReadAndProcessFile;

public class UniqueWordsDriver {

	public void startOurUniqueWordsDriver() {

		ReadAndProcessFile doThings = new ReadAndProcessFile();

		System.out.println("Processing txt file ... please wait");
		
		// count thins
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

		// ...

	}

}
