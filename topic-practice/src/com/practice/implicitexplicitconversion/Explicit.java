package com.practice.implicitexplicitconversion;

public class Explicit {

	public static void main(String[] args) {
		double d = 100.0;

		float f = (float) d;

		long l = (long) f;

		int i = (int) l;

		short s = (short) i;

		byte b = (byte) s;
	}
}