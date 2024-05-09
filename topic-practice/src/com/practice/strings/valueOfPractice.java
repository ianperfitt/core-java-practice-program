package com.practice.strings;

public class valueOfPractice {

	public static void main(String[] args) {
		String str = null;

		// valueOf is static method so doesn't require
		// an instance to be used. tricky !
		System.out.println(str.valueOf(10));
	}
}