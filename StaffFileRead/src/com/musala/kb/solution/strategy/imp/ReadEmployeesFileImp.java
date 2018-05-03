package com.musala.kb.solution.strategy.imp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.musala.kb.solution.strategy.ReadEmployeesFileStrategy;
import com.musala.kb.solution.utilis.CalculateStuff;

public class ReadEmployeesFileImp implements ReadEmployeesFileStrategy {

	private int avgAgeOfEmployees = 0;
	private float avgServiceOfEmployees = 0;
	private float maxLengthOfService = 0;

	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<String> ages = new ArrayList<String>();
	private ArrayList<String> lenOfServices = new ArrayList<String>();

	public ReadEmployeesFileImp() {

	}

	@Override
	public void readFileAndStoreInMemory(String filePath) {

		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(filePath);
			br = new BufferedReader(fr);

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

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

	@Override
	public int calculateAvgAge() {

		if (ages.isEmpty()) {
			try {
				throw new Exception("error!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -1;
		} else {

			// avgAgeOfEmployees
			int sumAge = 0;
			for (String age : ages) {
				sumAge = sumAge + Integer.parseInt(age);
			}

			avgAgeOfEmployees = sumAge / (ages.size());
			System.out.println("avgAgeOfEmployees = " + avgAgeOfEmployees);

			return avgAgeOfEmployees;
		}

	}

	@Override
	public float calculateAvgServicesOfEmployees() {

		if (lenOfServices.isEmpty()) {
			try {
				throw new Exception("error!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -1;
		} else {

			// avgServiceOfEmployees
			float sumService = 0;
			for (String lenOfService : lenOfServices) {
				float c = Float.parseFloat(lenOfService);
				sumService = sumService + c;
			}

			avgServiceOfEmployees = sumService / (lenOfServices.size());
			System.out.println("avgServiceOfEmployees = " + avgServiceOfEmployees);

			return avgServiceOfEmployees;
		}

	}

	@Override
	public float calculateMaxLengthOfService() {

		if (lenOfServices.isEmpty()) {
			try {
				throw new Exception("error!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -1;
		} else {

			// maxLengthOfService
			for (String lenOfService : lenOfServices) {
				float c = Float.parseFloat(lenOfService);
				if (c > maxLengthOfService) {
					maxLengthOfService = c;
				}
			}

			System.out.println("maxLengthOfService = " + maxLengthOfService);

			return maxLengthOfService;

		}

	}

	@Override
	public String calculateMostCommonChars() {

		String oneLongName = "";
		for (String name : names) {
			oneLongName = oneLongName + name;
		}

		List<String> mapOfMostCommonChars = CalculateStuff.countCharactersInString(oneLongName, false);
		System.out.println("Top 1 char = " + mapOfMostCommonChars.get(0));
		System.out.println("Top 2 char = " + mapOfMostCommonChars.get(1));
		System.out.println("Top 3 char = " + mapOfMostCommonChars.get(2));

		return mapOfMostCommonChars.get(0) + " " + mapOfMostCommonChars.get(1) + " " + mapOfMostCommonChars.get(2);

	}

}