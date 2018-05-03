package com.musala.kb.printer.logger.tester;

public class Print {

	private static String all = "";
	
	public static String getAllPrintedText() {
		String temp = all;
		resetAllPrintedText();
		return temp;
	}
	
	public static void resetAllPrintedText() {
		all = "";
	}
	
	public static void mPrint(String toPrint) {
		System.out.println(toPrint);
		all = all + " " + toPrint;
	}
	
	public static void mPrint(int toPrint) {
		System.out.println("" + toPrint);
		all = all + " " + toPrint;
	}
	
	public static void mPrint(double toPrint) {
		System.out.println("" + toPrint);
		all = all + " " + toPrint;
	}
	
}
