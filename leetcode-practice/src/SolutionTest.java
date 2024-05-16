
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	private String s;

	@Test
	void test1() {
		s = "/home/";
		assertEquals("/home", Solution.simplifyPath(s));
	}

	@Test
	void test2() {
		s = "/home//foo/";
		assertEquals("/home/foo", Solution.simplifyPath(s));
	}

	@Test
	void test3() {
		s = "/home/user/Documents/../Pictures";
		assertEquals("/home/user/Pictures", Solution.simplifyPath(s));
	}

	@Test
	void test4() {
		s = "/../";
		assertEquals("/", Solution.simplifyPath(s));
	}

	@Test
	void test5() {
		s = "/.../a/../b/c/../d/./";
		assertEquals("/.../b/d", Solution.simplifyPath(s));
	}

}