package com.musala.kb.ultils;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapUtilis {

	// sort function of a map
	public static Map<Integer, Map<String, Integer>> sortByValue(Map<Integer, Map<String, Integer>> unsortMap) {

		// 1. Convert Map to List of Map
		List<Entry<Integer, Map<String, Integer>>> list = new LinkedList<Map.Entry<Integer, Map<String, Integer>>>(
				unsortMap.entrySet());

		// 2. Sort list with Collections.sort(), provide a custom Comparator
		// Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Map.Entry<Integer, Map<String, Integer>>>() {
			public int compare(Map.Entry<Integer, Map<String, Integer>> o2,
					Map.Entry<Integer, Map<String, Integer>> o1) {
				// (o1.getValue().).compareTo(o2.getValue())
				Map<String, Integer> x1 = o1.getValue();
				Map<String, Integer> x2 = o2.getValue();
				return (x1.entrySet().iterator().next().getValue())
						.compareTo(x2.entrySet().iterator().next().getValue());
			}
		});

		// 3. Loop the sorted list and put it into a new insertion order Map
		// LinkedHashMap
		Map<Integer, Map<String, Integer>> sortedMap = new LinkedHashMap<Integer, Map<String, Integer>>();
		for (Entry<Integer, Map<String, Integer>> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

}
