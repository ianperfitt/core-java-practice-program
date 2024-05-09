package com.practice.set;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TreeSetPractice {

	public static int[] sortByBits(int[] arr) {

		Map<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();

		for (int i = 0; i < arr.length; i++) {
			map.get(Integer.bitCount(arr[i])).add(arr[i]);
		}

		int[] solution = new int[arr.length];

		for (Entry e : map.entrySet()) {
			System.out.println(e);
		}
		return null;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		sortByBits(arr);

	}
}
