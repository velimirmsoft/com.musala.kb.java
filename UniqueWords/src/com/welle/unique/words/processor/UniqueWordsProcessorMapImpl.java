package com.welle.unique.words.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.welle.settings.FilePathsAndConstants;
import com.welle.word.Word;

public class UniqueWordsProcessorMapImpl extends UniqueWordsProcessor {

	@Override
	public void clearWords() {
		wordsMap.clear();
	}

	@Override
	public void addUniqueWord(String word) {
		if (wordsMap.get(word) == null) {
			wordsMap.put(word, 1);
		} else {
			wordsMap.put(word, wordsMap.get(word) + 1);
		}
	}

	@Override
	public int getUniqueWordsCount() {
		return wordsMap.size();
	}

	@Override
	public Word searchForWord(String word) {
		Word toReturn = null;
		Set<Entry<String, Integer>> entrySet = wordsMap.entrySet();
		for (Entry<String, Integer> e : entrySet) {
			if (e.getKey().equals(word)) {
				toReturn = new Word(word, e.getValue());
				break;
			}
		}
		return toReturn;
	}

	@Override
	public ArrayList<Word> sortAndOrderByCountsWords(int limitOfOccurences, FilePathsAndConstants.OrderType orderType) {
		ArrayList<Word> toReturnList = new ArrayList<Word>();
		for (Entry<String, Integer> e : wordsMap.entrySet()) {
			if (e.getValue() >= limitOfOccurences) {
				toReturnList.add(new Word(e.getKey(), e.getValue()));
			}
		}
		toReturnList.sort((Word o1, Word o2) -> o1.getCount() - o2.getCount());
		return toReturnList;
	}

	@Override
	public void removeAllUpperCaseWords() {
		HashMap<String, Integer> newWordsMap = new HashMap<String, Integer>();
		for (Entry<String, Integer> e : wordsMap.entrySet()) {
			if (!(e.getKey().toUpperCase().equals(e.getKey()))) {
				newWordsMap.put(e.getKey(), e.getValue());
			}
		}
		wordsMap = newWordsMap;
	}

	@Override
	public ArrayList<Word> sortAndOrderByWordAlphaWords(int limitOfOccurences) {
		ArrayList<Word> toReturnList = new ArrayList<Word>();
		for (Entry<String, Integer> e : wordsMap.entrySet()) {
			if (e.getValue() >= limitOfOccurences) {
				toReturnList.add(new Word(e.getKey(), e.getValue()));
			}
		}
		toReturnList.sort((Word o1, Word o2) -> o1.toString().toLowerCase().compareTo(o2.toString().toLowerCase()));
		return toReturnList;
	}

}
