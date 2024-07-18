
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	private String input;

	private String solution;

	@Test
	void test1() {
		input = "Let's take LeetCode contest";
		solution = Solution.reverseWords(input);
		assertEquals("s'teL ekat edoCteeL tsetnoc", solution);
	}
}