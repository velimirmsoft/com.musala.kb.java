package com.welle.read.and.process.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.welle.settings.FilesAndPaths;
import com.welle.unique.words.processor.UniqueWordsProcessor;
import com.welle.unique.words.processor.UniqueWordsProcessorImpl;
import com.welle.word.Word;

public class ReadAndProcessFile {

	private UniqueWordsProcessor wordProcessor;
	private FilesAndPaths constants = new FilesAndPaths();

	public ReadAndProcessFile() {
		wordProcessor = new UniqueWordsProcessorImpl();
	}

	public ReadAndProcessFile(String filePath) {
		wordProcessor = new UniqueWordsProcessorImpl();
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
		Word returnedWord = wordProcessor.searchForWordInMyList(word);
		if (returnedWord != null) {
			System.out.print("Got it -> ");
			System.out.print(returnedWord.getWord() + " - ");
			System.out.println(returnedWord.getCount());
		} else {
			System.out.println("No word of that kind was found!");
		}
	}

}
