package com.welle.unique.words.processor;

import java.util.ArrayList;

import com.welle.settings.FilePathsAndConstants;
import com.welle.word.Word;

public interface UniqueWordsProcessor {

	public abstract void clearWords();

	public abstract void addUniqueWord(String word);

	public abstract int getUniqueWordsCount();

	public abstract Word searchForWord(String word);

	public abstract ArrayList<Word> sortAndOrderByCountsWords(int limitOfOccurences, FilePathsAndConstants.OrderType orderType);

	public abstract void removeAllUpperCaseWords();

	public abstract ArrayList<Word> sortAndOrderByWordAlphaWords(int limitOfOccurences);

}
