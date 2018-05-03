package com.musala.kb.ultils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapUtilis {

	// sort function of a map
	public static Map<Integer, Map<String, Integer>> sortByValueOfInnerMap(
			Map<Integer, Map<String, Integer>> unsortMap) {

		// 1. Convert Map to List of Map
		// moze da se koristi i ArrayList namesto linkedList - mislam deka razlikata e
		// samo vo performansite

		List<Entry<Integer, Map<String, Integer>>> list = new ArrayList<Map.Entry<Integer, Map<String, Integer>>>(
				unsortMap.entrySet());

		// System.out.println("---------------------------");
		// for (Entry<Integer, Map<String, Integer>> l : list) {
		// System.out.println("l -> " + l.getValue());
		// }
		// System.out.println("" + unsortMap.keySet().toArray()[0] + "*" +
		// unsortMap.values().toArray()[0]);

		// 2. Sort list with Collections.sort(), provide a custom Comparator
		// Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Map.Entry<Integer, Map<String, Integer>>>() {
			public int compare(Map.Entry<Integer, Map<String, Integer>> o2,
					Map.Entry<Integer, Map<String, Integer>> o1) {
				Map<String, Integer> x1 = o1.getValue();
				Map<String, Integer> x2 = o2.getValue();
				// handle null next element exception !
				return (x1.entrySet().iterator().next().getValue())
						.compareTo(x2.entrySet().iterator().next().getValue());
			}
		});

		// System.out.println("#");
		// for (Entry<Integer, Map<String, Integer>> l : list) {
		// System.out.println("l -> " + l.getValue());
		// }

		// 3. Loop the sorted list and put it into a new insertion order Map
		// LinkedHashMap
		// tuka, mora da bide LinkedHashMap zatoa sto ako ne e, koga vi rakame nazad
		// sortiranite vrednosti
		// gi podreduva po KEY (integer) i nasiot sort nema effect
		// LinkedHashMap is precisely what you're looking for.
		// It is exactly like HashMap, except that when you iterate over it, it presents
		// the items in the insertion order.

		Map<Integer, Map<String, Integer>> sortedMap = new LinkedHashMap<Integer, Map<String, Integer>>();
		for (Entry<Integer, Map<String, Integer>> l : list) {
			sortedMap.put(l.getKey(), l.getValue());
		}

		// System.out.println("" + sortedMap.keySet().toArray()[0] + "*" +
		// sortedMap.values().toArray()[0]);
		// System.out.println("---------------------------");

		return sortedMap;
	}

}
