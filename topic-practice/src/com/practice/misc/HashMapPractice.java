package com.practice.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapPractice {

	public static void main(String[] args) {

		// declare hash map
		Map<Integer, Integer> map = new HashMap<>();

		// populate hashmap
		map.put(1, 2);
		map.put(3, 4);
		map.put(5, 6);

		// get a value from a key that does not exist, setting default value to -1
		int i = map.getOrDefault(4, -1);

		// update value by one for a given key and if key doesn't exist set value to 1
		map.put(7, map.getOrDefault(7, 8));

		// loop over values and print
		for (Integer value : map.values()) {
			System.out.println("Value: " + value);
		}

		// loop over keys and print
		for (Integer key : map.keySet()) {
			System.out.println("Key: " + key);
		}

		// loop over entries and print key + values
		for (Entry e : map.entrySet()) {
			System.out.println("Entry Key: " + e.getKey() + " Entry Value: " + e.getValue());
		}
	}

}
