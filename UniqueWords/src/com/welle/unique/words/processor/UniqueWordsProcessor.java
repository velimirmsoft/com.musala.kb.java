package com.welle.unique.words.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.welle.settings.FilePathsAndConstants;
import com.welle.word.Word;

public abstract class UniqueWordsProcessor {

	// we have list which contains unique values of our 'Word' class

	protected List<Word> wordsList = new ArrayList<Word>();

	// solution with a hashMap

	protected HashMap<String, Integer> wordsMap = new HashMap<String, Integer>();
	
	// methods

	public abstract void clearWords();

	public abstract void addUniqueWord(String word);

	public abstract int getUniqueWordsCount();

	public abstract Word searchForWord(String word);

	public abstract ArrayList<Word> sortAndOrderByCountsWords(int limitOfOccurences, FilePathsAndConstants.OrderType orderType);

	public abstract void removeAllUpperCaseWords();

	public abstract ArrayList<Word> sortAndOrderByWordAlphaWords(int limitOfOccurences);

}
