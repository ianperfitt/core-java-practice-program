package com.practice.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapPractice {

	public static void main(String[] args) {

		Map<Integer, Integer[]> ht = new LinkedHashMap<>();
		Integer[] arr = { 2, 3, 4, 5, 6 };
		Integer[] arr2 = { 7, 8, 9, 10, 11 };
		ht.put(2, arr2);
		ht.put(1, arr);
		System.out.println(ht);
		for (Integer i : ht.keySet()) {
			for (Integer j : ht.get(i)) {
				System.out.print("key: " + i + " ");
				System.out.println("value: " + j);
			}
		}
	}

}
