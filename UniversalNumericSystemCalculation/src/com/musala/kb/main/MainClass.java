package com.musala.kb.main;

import java.util.Scanner;

import com.musala.kb.numeric.calc.imp.ContextNumericSystems;
import com.musala.kb.numeric.calc.imp.DecToBinAndBinToDec;
import com.musala.kb.numeric.calc.imp.DecToOctalAndOctalToDec;

public class MainClass {

	/*
	 * 
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
	 * 
	 */

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		// binary test

		ContextNumericSystems chr_binary = new ContextNumericSystems();
		chr_binary.setUnvInterfaceNumCalc(new DecToBinAndBinToDec());

		System.out.println("input a BINARY value to convert to DEC ...");
		String input = "";
		while (!(input = s.nextLine()).equals("")) {
			System.out.println(chr_binary.toDecimal(input));
		}

		System.out.println("input a DECIMAL value to convert to BINARY ...");
		input = "";
		while (!(input = s.nextLine()).equals("")) {
			System.out.println(chr_binary.fromDecimal(input));
		}

		// octal test

		ContextNumericSystems chr_octal = new ContextNumericSystems();
		chr_octal.setUnvInterfaceNumCalc(new DecToOctalAndOctalToDec());

		System.out.println("input a OCTAL value to convert to DEC ...");
		input = "";
		while (!(input = s.nextLine()).equals("")) {
			System.out.println(chr_octal.toDecimal(input));
		}

		System.out.println("input a DECIMAL value to convert to OCTAL ...");
		input = "";
		while (!(input = s.nextLine()).equals("")) {
			System.out.println(chr_octal.fromDecimal(input));
		}
		
		s.close();

	}

}
