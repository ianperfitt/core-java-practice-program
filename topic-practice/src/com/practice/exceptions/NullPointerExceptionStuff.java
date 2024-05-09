package com.practice.exceptions;

public class NullPointerExceptionStuff {

	public static void main(String[] args) {

		Cat myCat = null;
		if (myCat != null) {
			myCat.makeNoise();
		}
	}
}
