package com.musala.kb.hexreader;

public class HexReader implements HexReaderInterface {

	@Override
	public int hexValue(char inputChar) {

		switch (inputChar) {
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
		case '8':
			return 8;
		case '9':
			return 9;
		case 'a':
		case 'A':
			return 10;
		case 'b':
		case 'B':
			return 11;
		case 'c':
		case 'C':
			return 12;
		case 'd':
		case 'D':
			return 13;
		case 'e':
		case 'E':
			return 14;
		case 'f':
		case 'F':
			return 15;
		default:
			return -1;
		}

	}

	@Override
	public int hexToDec(String inputHex) {
		
		boolean isInvalidStringFound = false;
		int value = 0; 
		for ( int i = 0; i < inputHex.length(); i++ ) {
			int c = hexValue(inputHex.charAt(i));
			if(c == -1) {
				isInvalidStringFound = true;
				break;
			}
			value = value*16 + c;
		}
		
		if(isInvalidStringFound) {
			value = -1;
		}
				 
		
		return value;
	}

}
