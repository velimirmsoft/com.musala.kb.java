package com.welle.generic.one;

public class checkOdd implements isOdd<Integer> {

	@Override
	public boolean isOddNum(Integer num) {
		if(num % 2 == 0)
			return true;
		return false;
	}
	
}
