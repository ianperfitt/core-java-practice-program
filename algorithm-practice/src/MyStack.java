import java.util.LinkedList;
import java.util.Queue;

class MyStack {

	static private Queue<Integer> q1;

	public MyStack() {
		this.q1 = new LinkedList<>();
	}

	public void push(int x) {
		q1.add(x);
		for (int i = 1; i < q1.size(); i++) {
			q1.add(q1.remove());
		}
	}

	public int pop() {
		return q1.remove();
	}

	public int top() {
		return q1.peek();
	}

	public boolean empty() {
		return q1.isEmpty();
	}

	public void print() {
		for (int i : q1) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.print();
		System.out.println(stack.top());
	}
}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj =
 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
