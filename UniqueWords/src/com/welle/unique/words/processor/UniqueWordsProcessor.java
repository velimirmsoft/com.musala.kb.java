package com.welle.unique.words.processor;

import java.util.ArrayList;
import java.util.List;

import com.welle.word.Word;

public abstract class UniqueWordsProcessor {

	public enum OrderType {
		ASC, DESC
	}

	// we have list which contains unique values of our 'Word' class

	protected List<Word> wordsList = new ArrayList<Word>();

	public void clearWordsList() {
		wordsList.clear();
	}

	public abstract void addUniqueWord(String word);

	public abstract int getUniqueWordsCount();

	public abstract Word searchForWordInMyList(String word);

	public abstract ArrayList<Word> sortAndPrintWords(int limitOfOccurences, OrderType orderType);
	
	public abstract ArrayList<Word> removeAllUpperCaseWords(List<Word> wordsList);

}
