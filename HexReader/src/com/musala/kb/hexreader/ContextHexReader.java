package com.musala.kb.hexreader;

public class ContextHexReader {

	private HexReaderInterface hexReader;
	
	public void setHexReaderInterfaceImpls(HexReaderInterface hexReader) {
		this.hexReader = hexReader;
	}
	
	public int startHexReading(String inputString) {
		
		int returnedValue = hexReader.hexToDec(inputString);
		if(returnedValue == -1) {
			System.out.println("invalid input string");
		}else {
			System.out.println("conversion = " + returnedValue);
		}
		
		return returnedValue;
		
	}
	
}
