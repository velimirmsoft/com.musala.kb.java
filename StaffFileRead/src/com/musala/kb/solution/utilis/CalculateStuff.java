package com.musala.kb.solution.utilis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CalculateStuff {

	public int calculateAvgAgeOfEmployees(ArrayList<String> ages) {
		int avgAgeOfEmployees = 0;
		int sumAge = 0;
		for (String age : ages) {
			sumAge = sumAge + Integer.parseInt(age);
		}
		avgAgeOfEmployees = sumAge / (ages.size());
		return avgAgeOfEmployees;
	}

	public float[] calculateAvgServiceOfEmployeesAndMaxService(ArrayList<String> lenOfServices) {

		float maxLengthOfService = 0;
		float avgServiceOfEmployees = 0;

		float sumService = 0;
		for (String lenOfService : lenOfServices) {
			float c = Float.parseFloat(lenOfService);
			sumService = sumService + c;
			if (c > maxLengthOfService) {
				maxLengthOfService = c;
			}
		}
		avgServiceOfEmployees = sumService / (lenOfServices.size());

		float[] r = new float[2];
		r[0] = maxLengthOfService;
		r[1] = avgServiceOfEmployees;

		return r;
	}

	@SuppressWarnings("deprecation")
	public static List<String> countCharactersInString(String s, boolean debugPrint) {

		// we are working with names, so yea, chars that are letters only are considered
		// 65 - 122

		Map<Character, Integer> histogramOfChars = new HashMap<Character, Integer>();

		for (Character c : s.toCharArray()) {

			c = Character.toLowerCase(c);

			if (!Character.isSpace(c)) {

				// result = testCondition ? value1 : value2
				int count = histogramOfChars.containsKey(c) ? histogramOfChars.get(c) : 0;
				histogramOfChars.put(c, count + 1);

			}
		}

		// sort map
		histogramOfChars = MapUtilis.sortByValue(histogramOfChars);

		// convert to list
		List<String> ls = new ArrayList<String>();
		for (Entry<Character, Integer> entry : histogramOfChars.entrySet()) {
			ls.add("" + entry.getKey());
		}

		// debug print our map
		if (debugPrint) {
			for (Entry<Character, Integer> entry : histogramOfChars.entrySet()) {
				System.out.println(entry.getKey() + " - " + entry.getValue());
			}
		}

		return ls;

	}

}
