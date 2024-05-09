package com.practice.exceptions;

public class CheckedVsUnchecked {

	public static void main(String[] args) {

		String name = null;
		printLength(name);

	}

	private static void printLength(String myString) {
		throw new RuntimeException();
	}
}
