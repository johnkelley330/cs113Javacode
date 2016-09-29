import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		stack1.push(-1);
		stack1.push(15);
		stack1.push(23);
		stack1.push(44);
		stack1.push(4);
		stack1.push(99);
		System.out.println("stack1 first element: " + stack1.peek());
		while (stack1.empty() != true) {
			stack2.push(stack1.peek());
			queue.offer(stack1.pop());
		}
		System.out.println("stack1: " + stack1);
		System.out.println("stack2: " + stack2);
		System.out.println("queue: " + queue);
		System.out.println("stack2  queue");
		System.out.println("------  -----");
		while (stack2.empty() != true)
		{
			System.out.printf("%-6d  %-5d\n", stack2.pop(), queue.poll());
		}
	}
}
