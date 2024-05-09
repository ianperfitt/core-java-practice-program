package com.practice.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapPractice {

	public static void main(String[] args) {

		Map<Integer, Integer[]> ht = new TreeMap<>();
		Integer[] arr = { 2, 3, 4, 6, 5 };
		Integer[] arr2 = { 11, 7, 8, 9, 10 };
		ht.put(2, arr2);
		ht.put(1, arr);
		for (Integer i : ht.keySet()) {
			for (Integer j : ht.get(i)) {
				System.out.print("key: " + i + " ");
				System.out.println("value: " + j);
			}
		}
	}
}
