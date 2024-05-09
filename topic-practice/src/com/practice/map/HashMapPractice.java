package com.practice.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapPractice {

	public static void main(String[] args) {

		Map<Integer, Integer[]> ht = new HashMap<>();
		Integer[] arr = { 2, 3, 4, 5, 6 };
		Integer[] arr2 = { 7, 8, 9, 10, 11 };
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