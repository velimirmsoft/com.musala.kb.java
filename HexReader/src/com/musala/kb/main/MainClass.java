package com.musala.kb.main;

import java.util.Scanner;

import com.musala.kb.hexreader.ContextHexReader;
import com.musala.kb.hexreader.HexReader;

public class MainClass {

	/*
	 * The hexadecimal digits are the ordinary, base-10 digits '0' through '9' plus
	 * the letters 'A' through 'F'. In the hexadecimal system, these digits
	 * represent the values 0 through 15, respectively.
	 * 
	 * Write a function named hexValue that uses a switch statement to find the
	 * hexadecimal value of a given character. The character is a parameter to the
	 * function, and its hexadecimal value is the return value of the function. You
	 * should count lower case letters 'a' through 'f' as having the same value as
	 * the corresponding upper case letters. If the parameter is not one of the
	 * legal hexadecimal digits, return -1 as the value of the function.
	 * 
	 * A hexadecimal integer is a sequence of hexadecimal digits, such as 34A7, FF8,
	 * 174204, or FADE. If str is a string containing a hexadecimal integer, then
	 * the corresponding base-10 integer can be computed as follows:
	 * 
	 * value = 0; for ( i = 0; i < str.length(); i++ ) value = value*16 + hexValue(
	 * str.charAt(i) );
	 * 
	 * 
	 * Of course, this is not valid if str contains any characters that are not
	 * hexadecimal digits. Write a program that reads a string from the user. If all
	 * the characters in the string are hexadecimal digits, print out the
	 * corresponding base-10 value. If not, print out an error message.
	 * 
	 * Part II
	 * 
	 * Modify the HexReader program so that now it implements a universal interface
	 * for numeric systems calculator. The interface should contain two method
	 * definitions - one that converts to decimal and the other from decimal to
	 * other numeric system. Then implement the interface for two different numeric
	 * systems other than hexadecimal.
	 * 
	 */

	public static void main(String[] args) {

		ContextHexReader chr = new ContextHexReader();
		chr.setHexReaderInterfaceImpls(new HexReader());

		Scanner s = new Scanner(System.in);

		System.out.println("input a hex value to convert:");
		String input = "";
		while (!(input = s.nextLine()).equals("")) {
			chr.startHexReading(input);
		}
		
		s.close();

	}

}
