package com.musala.kb.solution.general;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadAndPrintFile {

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

	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<String> ages = new ArrayList<String>();
	private ArrayList<String> lenOfServices = new ArrayList<String>();

	public ReadAndPrintFile() {
		System.out.println("General solution ... \n");
	}

	public void readFileData(String filePath) {

		// This compliant solution uses a try-with-resources statement to manage both br
		// and bw:
		// This solution preserves any exceptions thrown during the processing of the
		// input while still guaranteeing that both br and bw are properly closed,
		// regardless of what exceptions occur. Finally, this code demonstrates how to
		// access
		// every exception that may be produced from the try-with-resources block

		try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr);) {
			// Process the input and produce the output

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {

				if (!sCurrentLine.equals("<<>>")) {

					// System.out.println("sCurrentLine = " + sCurrentLine);
					names.add(sCurrentLine.split("=")[1]);

					sCurrentLine = br.readLine();
					// System.out.println("sCurrentLine = " + sCurrentLine);
					ages.add(sCurrentLine.split("=")[1]);

					sCurrentLine = br.readLine();
					// System.out.println("sCurrentLine = " + sCurrentLine);
					lenOfServices.add(sCurrentLine.split("=")[1]);
				}

			}

		} catch (IOException ex) {
			// Print out all exceptions, including suppressed ones
			System.err.println("thrown exception: " + ex.toString());
			Throwable[] suppressed = ex.getSuppressed();
			for (int i = 0; i < suppressed.length; i++) {
				System.err.println("suppressed exception: " + suppressed[i].toString());
			}
		}

	}

	public int calculateThings() {

		if (names.isEmpty() || ages.isEmpty() || lenOfServices.isEmpty()) {
			return -1;
		} else {

			// avgAgeOfEmployees
			int sumAge = 0;
			for (String age : ages) {
				sumAge = sumAge + Integer.parseInt(age);
			}
			avgAgeOfEmployees = sumAge / (ages.size());
			System.out.println("avgAgeOfEmployees = " + avgAgeOfEmployees);

			// avgServiceOfEmployees & maxLengthOfService
			float sumService = 0;
			for (String lenOfService : lenOfServices) {
				float c = Float.parseFloat(lenOfService);
				sumService = sumService + c;
				if (c > maxLengthOfService) {
					maxLengthOfService = c;
				}
			}
			avgServiceOfEmployees = sumService / (lenOfServices.size());
			System.out.println("avgServiceOfEmployees = " + avgServiceOfEmployees);
			System.out.println("maxLengthOfService = " + maxLengthOfService);

			// find the most common chars
			// just merge all the strings, and send them to the function below

			String oneLongName = "";
			for (String name : names) {
				oneLongName = oneLongName + name;
			}

			List<String> mapOfMostCommonChars = MapUtilis.countCharactersInString(oneLongName, false);
			System.out.println("Top 1 char = " + mapOfMostCommonChars.get(0));
			System.out.println("Top 2 char = " + mapOfMostCommonChars.get(1));
			System.out.println("Top 3 char = " + mapOfMostCommonChars.get(2));

			return 1;
		}

	}

}
