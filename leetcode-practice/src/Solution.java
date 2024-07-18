class Solution {

	public static String reverseWords(String s) {

		String[] splitString = s.split(" ");
		StringBuilder solution = new StringBuilder();
		
		for(String str : splitString) {
			StringBuilder reverse = new StringBuilder(str).reverse().append(" ");
			solution.append(reverse);
		}
		
		return solution.toString().trim();
	}
}