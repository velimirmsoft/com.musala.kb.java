package com.welle.read.and.process.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.welle.settings.FilePathsAndConstants;
import com.welle.unique.words.processor.UniqueWordsProcessor;
import com.welle.word.Word;

public class ReadAndProcessFile {

	private UniqueWordsProcessor wordProcessor;
	private FilePathsAndConstants constants = new FilePathsAndConstants();

	public ReadAndProcessFile(UniqueWordsProcessor whichImpl) {
		wordProcessor = whichImpl;
	}

	public ReadAndProcessFile(UniqueWordsProcessor whichImpl, String filePath) {
		wordProcessor = whichImpl;
		constants.setFileToRead(filePath);
	}

	public void readTxtFileAndProcess() {
		try (FileReader fr = new FileReader(getTextFileToProcess()); BufferedReader br = new BufferedReader(fr);) {
			String sCurrentLine;
			// get the line
			while ((sCurrentLine = br.readLine()) != null) {
				// split it using empty spaces
				String[] words = sCurrentLine.split("\\s+");
				for (String w : words) {
					// we need to remove invalid characters
					w = w.replaceAll("\\W+", "");
					// System.out.println("working on = " + w);
					if (!(w.isEmpty() || w.equals(" ")))
						// call our words processor
						wordProcessor.addUniqueWord(w);
				}
			}
		} catch (IOException ex) {
			System.err.println("thrown exception: " + ex.toString());
			Throwable[] suppressed = ex.getSuppressed();
			for (int i = 0; i < suppressed.length; i++) {
				System.err.println("suppressed exception: " + suppressed[i].toString());
			}
		}
	}

	public void reportUniqueWordsFromFile() {
		System.out.println("------------------------------");
		System.out.println("Our report on unique words count ...");
		System.out.println("Unique words = " + wordProcessor.getUniqueWordsCount());
		System.out.println("------------------------------");
	}

	public String getTextFileToProcess() {
		return constants.returnFileToRead();
	}

	public void setTextFileToProcess(String filePath) {
		constants.setFileToRead(filePath);
	}

	public void searchForWord(String word) {
		Word returnedWord = wordProcessor.searchForWord(word);
		if (returnedWord != null) {
			System.out.print("Got it -> ");
			System.out.print(returnedWord.getWord() + " - ");
			System.out.println(returnedWord.getCount());
		} else {
			System.out.println("No word of that kind was found!");
		}
	}

	public void sortOrderAndPrintWords(int limitOfOccurences, FilePathsAndConstants.OrderType orderType) {
		ArrayList<Word> list = wordProcessor.sortAndOrderByCountsWords(limitOfOccurences, orderType);
		System.out.println("------------------------------");
		System.out.println("Words with more then 1k counts ...");
		for (Word w : list) {
			System.out.println("" + w.getWord() + " - " + w.getCount());
		}
		System.out.println("------------------------------");
	}

	public void removeAllUppderCase() {
		// System.out.println("------------------------------");
		System.out.println("Removing all uppder case words ...");
		wordProcessor.removeAllUpperCaseWords();
		System.out.println("New count of Unique words = " + wordProcessor.getUniqueWordsCount());
	}

	public void sortOrderByAlphaAndPrintWords(int limitOfOccurences) {
		ArrayList<Word> list = wordProcessor.sortAndOrderByWordAlphaWords(limitOfOccurences);
		System.out.println("------------------------------");
		System.out.println("Words with more then 500 counts and sorted by alpha ...");
		for (Word w : list) {
			System.out.println("" + w.getWord() + " - " + w.getCount());
		}
		System.out.println("------------------------------");
	}

}
