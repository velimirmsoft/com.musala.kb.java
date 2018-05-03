package com.musala.kb.solution.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapUtilis {

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
		histogramOfChars = sortByValue(histogramOfChars);

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

	// sort function of a map
	private static Map<Character, Integer> sortByValue(Map<Character, Integer> unsortMap) {
		
		
		/*
		// Map<Character, Integer> sortedMap = new HashMap<Character, Integer>();
		// TreeMap sorter - SORTING by KEY
		 Map<Character, Integer> treeMap = new TreeMap<Character, Integer>();

	    /* For Java 8, try this lambda
		Map<Integer, String> treeMap = new TreeMap<>(
		                (Comparator<Integer>) (o1, o2) -> o2.compareTo(o1)
		        );		
        treeMap.putAll(unsortMap);
        */


		// 1. Convert Map to List of Map
		List<Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(unsortMap.entrySet());

		// 2. Sort list with Collections.sort(), provide a custom Comparator
		// Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> o2, Map.Entry<Character, Integer> o1) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// 3. Loop the sorted list and put it into a new insertion order Map
		// LinkedHashMap
		Map<Character, Integer> sortedMap = new LinkedHashMap<Character, Integer>();
		for (Entry<Character, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}
	
}
