
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	private String s;

	@Test
	void shouldEqualThree() {
		s = "abcabcbb";
		assertEquals(3, Solution.lengthOfLongestSubstring(s));
	}

	@Test
	void shouldEqualOne() {
		s = "bbbbb";
		assertEquals(1, Solution.lengthOfLongestSubstring(s));
	}

	@Test
	void shouldEqual3Also() {
		s = "pwwkew";
		assertEquals(3, Solution.lengthOfLongestSubstring(s));
	}

}