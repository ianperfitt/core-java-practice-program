
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void test1() {
		int[] nums1 = { 1, 2, 3, 6 };
		int[] nums2 = { 2, 3, 4, 5 };
		assertEquals(2, Solution.getCommon(nums1, nums2));
	}
}