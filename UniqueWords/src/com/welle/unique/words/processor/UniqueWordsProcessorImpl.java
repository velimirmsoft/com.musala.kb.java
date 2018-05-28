package com.welle.unique.words.processor;

import java.util.ArrayList;
import java.util.List;

import com.welle.word.Word;

public class UniqueWordsProcessorImpl extends UniqueWordsProcessor {

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
	public Word searchForWordInMyList(String word) {
		for (Word w : wordsList) {
			if (w.getWord().equals(word))
				return w;
		}
		return null;
	}

	@Override
	public ArrayList<Word> sortAndPrintWords(int limitOfOccurences, OrderType orderType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Word> removeAllUpperCaseWords(List<Word> wordsList) {
		// TODO Auto-generated method stub
		return null;
	}

}
