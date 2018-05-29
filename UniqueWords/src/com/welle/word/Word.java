package com.welle.word;

public class Word {

	private String word = "";
	private int count = 0;

	public Word(String word, int count) {
		this.word = word;
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Word))
			return false;
		Word testWord = (Word) obj;
		if (testWord.getWord().equals(this.getWord())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return getWord();
	}

	@Override
	public int hashCode() {
		return this.hashCode();
	}

}
