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
		
		// this method is used when Collection is comparing Objects
		// so when we call '.contains' on our list this method will be called
		// and it checks for duplicates

		if (!(obj instanceof Word))
			return false;

		Word testWord = (Word) obj;

		// ako imame takov zbor, znaci ne treba da se kreira nov object vo
		// hasSetot pa zatoa vracame true

		if (testWord.getWord().equals(this.getWord())) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int hashCode() {
		return this.hashCode();
	}

}
