package com.musala.kb.solution.utilis;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapUtilis {

	// sort function of a map
	public static Map<Character, Integer> sortByValue(Map<Character, Integer> unsortMap) {

		/*
		 * // Map<Character, Integer> sortedMap = new HashMap<Character, Integer>(); //
		 * TreeMap sorter - SORTING by KEY Map<Character, Integer> treeMap = new
		 * TreeMap<Character, Integer>();
		 * 
		 * /* For Java 8, try this lambda Map<Integer, String> treeMap = new TreeMap<>(
		 * (Comparator<Integer>) (o1, o2) -> o2.compareTo(o1) );
		 * treeMap.putAll(unsortMap);
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
