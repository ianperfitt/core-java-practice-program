import java.util.Scanner;

class Solution {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter  your string:");
		String s = scanner.nextLine();
		System.out.println(countVowelsAndConsonants(s)[0]);
		System.out.println(countVowelsAndConsonants(s)[1]);
		
	}

	private static int[] countVowelsAndConsonants(String s) {

		int vowels = 0;
		int consonants = 0;

		for (char c : s.toCharArray()) {
			if (c >= 'a' && c <= 'z') {
				if ("aeiou".indexOf(c) != -1) {
					vowels++;
				} else {
					consonants++;
				}
			}
		}
		return new int[] { vowels, consonants };
	}
}