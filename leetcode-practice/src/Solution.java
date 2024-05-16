import java.util.Stack;

class Solution {

	public static String simplifyPath(String path) {

		Stack<String> stack = new Stack<String>();

		for (String s : path.split("/")) {

			if (s.equals(".") || s.isEmpty()) {
				continue;
			}

			else if (s.equals("..")) {

				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.add(s);
			}
		}

		StringBuilder result = new StringBuilder();
		for (String dir : stack) {
			result.append("/");
			result.append(dir);
		}

		return result.length() > 0 ? result.toString() : "/";
	}
}