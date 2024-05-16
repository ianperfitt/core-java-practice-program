import java.util.Stack;

class Solution {

	public static String makeGood(String s) {

		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {

			if (!stack.isEmpty()) {
				if (stack.pop() == c) {
					stack.push(c);
					continue;
				}
				if (Character.toUpperCase(stack.peek()) == c || Character.toLowerCase(stack.peek()) == c) {
					stack.pop();
					continue;
				}
			}
			stack.push(c);
		}
		return stack.toString();
	}
}