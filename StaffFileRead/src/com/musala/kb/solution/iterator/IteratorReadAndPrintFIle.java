package com.musala.kb.solution.iterator;

import java.io.IOException;
import java.util.List;

import com.musala.kb.solution.utilis.CalculateStuff;

public class IteratorReadAndPrintFIle {

	/*
	 * 
	 * Write a program that reads given information from a text file about
	 * compmany's staff and prints: The average age of the employees; The first
	 * three most common characters in the names of the employees; The average
	 * length of service of the employees; The maximum length of service among all
	 * employees;
	 * 
	 */

	private int avgAgeOfEmployees = 0;
	private float avgServiceOfEmployees = 0;
	private float maxLengthOfService = 0;

	public IteratorReadAndPrintFIle() {
		System.out.println("Iterator pattern solution ... \n");
	}

	public String readFileData(String filePath) {

		int totalEmployees = 0;
		int sumAge = 0;
		float sumService = 0;
		String oneLongName = "";

		int counter = 0;
		try {
			for (String sCurrentLine : new FileLineIterable(filePath)) {

				if (!sCurrentLine.equals("<<>>")) {

					counter = counter + 1;

					if (counter == 1) {
						// System.out.println(sCurrentLine);
						// System.out.println(counter);
						// names
						oneLongName = oneLongName + sCurrentLine;
						totalEmployees++;
					}

					if (counter == 2) {
						// System.out.println(sCurrentLine);
						// System.out.println(counter);
						// avgAgeOfEmployees
						int ageOfEmployee = Integer.parseInt(sCurrentLine.split("=")[1]);
						sumAge = sumAge + ageOfEmployee;
						// avgAgeOfEmployees
					}

					if (counter == 3) {
						// System.out.println(sCurrentLine);
						// System.out.println(counter);
						// avgServiceOfEmployees + max
						float service = Float.parseFloat(sCurrentLine.split("=")[1]);
						sumService = sumService + service;
						if (service > maxLengthOfService) {
							maxLengthOfService = service;
						}
						counter = 0;
						// avgServiceOfEmployees
					}

				}

			}

		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "-1";
		}

		avgAgeOfEmployees = sumAge / (totalEmployees);
		System.out.println("avgAgeOfEmployees = " + avgAgeOfEmployees);

		avgServiceOfEmployees = sumService / totalEmployees;
		System.out.println("avgServiceOfEmployees = " + avgServiceOfEmployees);
		System.out.println("maxLengthOfService = " + maxLengthOfService);

		List<String> mapOfMostCommonChars = CalculateStuff.countCharactersInString(oneLongName, false);
		System.out.println("Top 1 char = " + mapOfMostCommonChars.get(0));
		System.out.println("Top 2 char = " + mapOfMostCommonChars.get(1));
		System.out.println("Top 3 char = " + mapOfMostCommonChars.get(2));
		
		String debugReturn = avgAgeOfEmployees + " " + avgServiceOfEmployees + " " + maxLengthOfService + " " + mapOfMostCommonChars.get(0) + " " +  mapOfMostCommonChars.get(1) + " " +  mapOfMostCommonChars.get(2);
		
		return debugReturn;

	}

}
