import java.util.HashMap;
import java.util.Map;

class Solution {

	// Brute Force
//	public static int lengthOfLongestSubstring(String s) {
//
//		Set<Character> tracker = new HashSet<>();
//		int solution = 0;
//
//		for (int i = 0; i < s.length(); i++) {
//			for (int j = i; j < s.length(); j++) {
//				char c = s.charAt(j);
//
//				if (tracker.contains(s.charAt(j))) {
//					break;
//				} else {
//					solution = Math.max(solution, j - i + 1);
//					tracker.add(c);
//				}
//			}
//			tracker.clear();
//		}
//		return solution;
//	}

	// Sliding Window Using Hashmap
//	public static int lengthOfLongestSubstring(String s) {
//
//		Map<Character, Integer> chars = new HashMap<>();
//
//		int left = 0;
//
//		int res = 0;
//		for (int right = 0; right < s.length(); right++) {
//			char r = s.charAt(right);
//			chars.put(r, chars.getOrDefault(r, 0) + 1);
//
//			while (chars.get(r) > 1) {
//				char l = s.charAt(left);
//				chars.put(l, chars.get(l) - 1);
//				left++;
//			}
//
//			res = Math.max(res, right - left + 1);
//		}
//
//		return res;
//	}

	// Sliding Window Using Hashmap Optimized
	public static int lengthOfLongestSubstring(String s) {

		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		int len = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				if (map.get(c) >= start)
					start = map.get(c) + 1;
			}
			len = Math.max(len, i - start + 1);
			map.put(c, i);
		}

		return len;
	}
}
