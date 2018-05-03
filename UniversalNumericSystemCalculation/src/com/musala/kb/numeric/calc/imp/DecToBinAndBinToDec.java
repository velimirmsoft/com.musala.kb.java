package com.musala.kb.numeric.calc.imp;

import com.musala.kb.numeric.calc.UnvInterfaceNumCalc;

public class DecToBinAndBinToDec implements UnvInterfaceNumCalc {

	@Override
	public int toDecimal(String input) {	
		boolean isInvalidStringFound = false;
		int value = 0; 
		for ( int i = 0; i < input.length(); i++ ) {
			int c = nominalToDec(input.charAt(i));
			if(c == -1) {
				isInvalidStringFound = true;
				break;
			}
			value = value*2 + c;
		}
		
		if(isInvalidStringFound) {
			value = -1;
		}
		
		return value;
	}

	@Override
	public String fromDecimal(String input) {
		
		String toReturn = "-1";
		
		// check if we have 0s and 1s only
		if (input.matches("[0-9]+") && input.length() > 0) {
			// base of 2 for binary
			toReturn = Integer.toString(Integer.parseInt(input), 2);
		}
			
		return toReturn;
	}

	@Override
	public int nominalToDec(char x) {	
		switch (x) {
		case '0':
			return 0;
		case '1':
			return 1;
		default:
			return -1;
		}
	}

}
