package com.practice.misc;

import java.util.Arrays;

public class SortingMultidimensionalArraysUsingComparatorPractice {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		
		Arrays.sort(arr, (a,b) -> b[1] - a[1]);
		
		for(int[] a : arr) {
			System.out.print("1: " + a[0] + " ");
			System.out.println("2: " + a[1]);
		}
	}

}
