package com.practice.branchingstatements;

class ContinueWithLabelDemo {

	public static boolean repeatPatternWhile(String s) {

		String check = "";
		int j = 1;
		if (s.length() == 1) {
			return false;
		}
		String sub = s.substring(0, j);
		// you don't need to check when just 2 concats of sub
		// are already longer than s
		while (j <= s.length() / 2) {
			// create string to compare with that has same length
			// as original string s
			while (check.length() < s.length()) {
				check = check + sub;
			}
			// if strings are equal return true
			if (s.equals(check)) {
				return true;
			} else {
				sub = s.substring(0, ++j);
				check = "";
			}
		}

		return false;

	}

	private static boolean repeatPatternFor(String string) {
		String sub = "";
		String compare = "";
		for (int i = 1; i <= string.length() / 2; i++) {
			sub = string.substring(0, i);
			while (compare.length() < string.length()) {
				compare = compare + sub;
			}
			if (compare.equals(string)) {
				return true;
			}
			compare = "";
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(repeatPatternWhile("ab"));
		System.out.println(repeatPatternFor("ab"));

	}
}
