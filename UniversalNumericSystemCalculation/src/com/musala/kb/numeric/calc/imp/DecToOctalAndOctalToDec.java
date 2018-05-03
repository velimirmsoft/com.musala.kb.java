package com.musala.kb.numeric.calc.imp;

import com.musala.kb.numeric.calc.UnvInterfaceNumCalc;

public class DecToOctalAndOctalToDec implements UnvInterfaceNumCalc {

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
			value = value*8 + c;
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
			toReturn = Integer.toString(Integer.parseInt(input), 8);
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
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		default:
			return -1;
		}
	}

}

