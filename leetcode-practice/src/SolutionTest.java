
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	private String s;

	@Test
	void test1() {
		s = "leEeetcode";
		assertEquals("leetcode", Solution.makeGood(s));
	}
}