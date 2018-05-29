package com.welle.unique.words.processor;

import java.util.ArrayList;
import java.util.Comparator;

import com.welle.settings.FilePathsAndConstants;
import com.welle.word.Word;

public class UniqueWordsProcessorListImpl extends UniqueWordsProcessor {

	@Override
	public void addUniqueWord(String word) {
		Word testWord = new Word(word, 1);
		if (wordsList.contains(testWord)) {
			// if that kind of word exists, just update its occurrences
			int index = wordsList.indexOf(testWord);
			Word privousWord = wordsList.get(index);
			privousWord.setCount(privousWord.getCount() + 1);
			wordsList.remove(index);
			wordsList.add(index, privousWord);
		} else {
			// create new object and add it to our list
			Word newWord = new Word(word, 1);
			wordsList.add(newWord);
		}
	}

	@Override
	public int getUniqueWordsCount() {
		return wordsList.size();
	}

	@Override
	public Word searchForWord(String word) {
		for (Word w : wordsList) {
			if (w.getWord().equals(word))
				return w;
		}
		return null;
	}

	@Override
	public ArrayList<Word> sortAndOrderByCountsWords(int limitOfOccurences, FilePathsAndConstants.OrderType orderType) {
		ArrayList<Word> newList = new ArrayList<Word>();
		for (Word w : wordsList) {
			if (w.getCount() >= limitOfOccurences)
				newList.add(w);
		}
		switch (orderType) {
		case ASC:
			// java 7 solution with collection sort and anonymous function
			newList.sort(new Comparator<Word>() {
				@Override
				public int compare(Word o1, Word o2) {
					return o1.getCount() - o2.getCount();
				}

			});
			break;
		case DESC:
			// java 8 solution - lambda expression
			newList.sort((Word o1, Word o2) -> o2.getCount() - o1.getCount());
			break;
		}
		return newList;
	}

	@Override
	public void removeAllUpperCaseWords() {
		ArrayList<Word> newList = new ArrayList<Word>();
		for (Word w : wordsList) {
			if (!(w.getWord().toUpperCase().equals(w.getWord())))
				newList.add(w);
		}
		wordsList = newList;
	}

	@Override
	public ArrayList<Word> sortAndOrderByWordAlphaWords(int limitOfOccurences) {
		ArrayList<Word> newList = new ArrayList<Word>();
		for (Word w : wordsList) {
			if (w.getCount() >= limitOfOccurences)
				newList.add(w);
		}
		newList.sort(new Comparator<Word>() {
			@Override
			public int compare(Word o1, Word o2) {
				return o1.toString().toLowerCase().compareTo(o2.toString().toLowerCase());
			}

		});
		return newList;
	}

	@Override
	public void clearWords() {
		wordsList.clear();
	}

}
