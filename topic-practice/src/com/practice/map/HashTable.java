package com.practice.map;

import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

//HashTable is like a HashMap but thread safe
public class HashTable {

	public static void main(String[] args) {

		Map<Integer, Integer> ht = new Hashtable<>();
		ht.put(1, 2);
		ht.put(3, 4);
		ht.put(null, 7);
		for(Entry e : ht.entrySet()) {
			System.out.println("key: " + e.getKey());
			System.out.println("value: " + e.getValue());
		}

	}

}
