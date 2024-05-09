package com.practice.arrays;

public class MultidimensionalArrayPractice {

	public static void main(String[] args) {

		int[][] arr = { { 1, 2 }, { 3, 4 }, { 5, 6 } };

		for (int[] a : arr) {
			for (int b : a) {
				System.out.println(b);
			}
		}
	}
}
