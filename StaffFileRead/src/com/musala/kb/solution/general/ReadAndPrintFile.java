package com.musala.kb.solution.general;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.musala.kb.solution.utilis.CalculateStuff;

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

	private CalculateStuff calculator = null;

	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<String> ages = new ArrayList<String>();
	private ArrayList<String> lenOfServices = new ArrayList<String>();

	public ReadAndPrintFile() {
		System.out.println("General solution ... \n");
		calculator = new CalculateStuff();
	}

	public int readFileData(String filePath) {

		int status = -1;

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

			if (names.size() != 0 && ages.size() != 0 && lenOfServices.size() != 0) {
				status = 1;
			}

		} catch (IOException ex) {
			status = -1;
			// Print out all exceptions, including suppressed ones
			System.err.println("thrown exception: " + ex.toString());
			Throwable[] suppressed = ex.getSuppressed();
			for (int i = 0; i < suppressed.length; i++) {
				System.err.println("suppressed exception: " + suppressed[i].toString());
			}
		}

		return status;

	}

	public String calculateThings() {

		if (names.isEmpty() || ages.isEmpty() || lenOfServices.isEmpty()) {
			return "-1";
		} else {

			// avgAgeOfEmployees
			String avgAge = "" + calculator.calculateAvgAgeOfEmployees(ages);
			System.out.println("avgAgeOfEmployees = " + avgAge);

			// avgServiceOfEmployees
			float[] r = calculator.calculateAvgServiceOfEmployeesAndMaxService(lenOfServices);
			System.out.println("avgServiceOfEmployees = " + r[1]);

			// maxLengthOfService
			System.out.println("maxLengthOfService = " + r[0]);

			// find the most common chars
			// just merge all the strings, and send them to the function below

			String oneLongName = "";
			for (String name : names) {
				oneLongName = oneLongName + name;
			}

			List<String> mapOfMostCommonChars = CalculateStuff.countCharactersInString(oneLongName, false);
			System.out.println("Top 1 char = " + mapOfMostCommonChars.get(0));
			System.out.println("Top 2 char = " + mapOfMostCommonChars.get(1));
			System.out.println("Top 3 char = " + mapOfMostCommonChars.get(2));

			/*
			byte ptext[];
			String c1 = "";
			String c2 = "";
			String c3 = "";
			try {
				ptext = mapOfMostCommonChars.get(0).getBytes("ISO-8859-1");
				c1 = new String(ptext, "UTF-16"); 
				ptext = mapOfMostCommonChars.get(1).getBytes("ISO-8859-1");
				c2 = new String(ptext, "UTF-16"); 
				ptext = mapOfMostCommonChars.get(2).getBytes("ISO-8859-1");
				c3 = new String(ptext, "UTF-16"); 
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			*/
			
			String debugReturn = avgAge + " " + r[1] + " " + r[0] + " " + mapOfMostCommonChars.get(0) + " " +  mapOfMostCommonChars.get(1) + " " +  mapOfMostCommonChars.get(2);
			
			return debugReturn;
		}

	}

}
