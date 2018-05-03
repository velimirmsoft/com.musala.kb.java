package com.musala.kb.solution.properties.imp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.musala.kb.solution.properties.ReadEmployeesFilePropInterface;
import com.musala.kb.solution.utilis.CalculateStuff;

public class ReadEmployeesFilePropImp implements ReadEmployeesFilePropInterface {

	private static final String propertiesFilePath = "res/config.properties";

	// use this properties values to read/get/manipulate data in our txt file
	private String separatorString = "";
	private String sepratorKeyValueString = "";
	// private String keyNameString = "";
	// private String keyAgeString = "";
	// private String keyServiceLengthString = "";

	private int avgAgeOfEmployees = 0;
	private float avgServiceOfEmployees = 0;
	private float maxLengthOfService = 0;

	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<String> ages = new ArrayList<String>();
	private ArrayList<String> lenOfServices = new ArrayList<String>();
	
	public ReadEmployeesFilePropImp() {
		readPropertyFile();
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

				if (!sCurrentLine.equals(separatorString)) {

					// System.out.println("sCurrentLine = " + sCurrentLine);
					names.add(sCurrentLine.split(sepratorKeyValueString)[1]);

					sCurrentLine = br.readLine();
					// System.out.println("sCurrentLine = " + sCurrentLine);
					ages.add(sCurrentLine.split(sepratorKeyValueString)[1]);

					sCurrentLine = br.readLine();
					// System.out.println("sCurrentLine = " + sCurrentLine);
					lenOfServices.add(sCurrentLine.split(sepratorKeyValueString)[1]);
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

	@Override
	public void readPropertyFile() {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(propertiesFilePath);

			// load a properties file
			prop.load(input);

			// get the property value

			separatorString = prop.getProperty("separator");
			sepratorKeyValueString = prop.getProperty("separator-key-value");
			// keyNameString = prop.getProperty("key-name");
			// keyAgeString = prop.getProperty("key-age");
			// keyServiceLengthString = prop.getProperty("key-serviceLength");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}