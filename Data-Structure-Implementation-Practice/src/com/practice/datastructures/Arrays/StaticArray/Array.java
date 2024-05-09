package com.practice.datastructures.Arrays.StaticArray;

import java.util.Arrays;

public class Array {

	static int[] arr;

	public static void populate(int[] arr) {
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 4;
	}

	public static void add(int index, int val) {
		arr[index] = val;
	}

	public static void print() {
		System.out.println("Printing all elements");
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static void remove(int index) {

		int[] newArr = new int[arr.length - 1];
		for (int i = 0, j = 0; i < arr.length; i++, j++) {
			if (i == index) {
				j--;
			} else {
				newArr[j] = arr[i];
			}
		}

	}

	public static void main(String[] args) {
		// 1. instantiate
		arr = new int[5];

		// multi dimensional array
		String[][] arr2 = { { "dog", "cat" }, { "human", "wolf" } };
		String[][] arr3 = new String[2][3];

		// copy array into another
		System.arraycopy(arr2, 0, arr3, 0, arr2.length);
		String[][] arr4 = Arrays.copyOfRange(arr2, 0, arr2.length);

		// populate
		populate(arr);

		// update at specific index
		add(3, 10);

		// print all elements
		print();

		// access specific element
		int i = arr[2];

		// search for specific element
		Arrays.binarySearch(arr, 3);

		// remove at specific index i = 3
		remove(3);
		print();
		
		// fill Array with specific element
		Arrays.fill(arr, 0);
	}
}