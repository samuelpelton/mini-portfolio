package week7;

public class Driver
{
    public static void main(String args[])
    {
	Stack stack = new Stack(3);
	Queue queue = new Queue(3);
	StackFromQueue stackFromQueue = new StackFromQueue(3);

	stack.push(1);
	stack.push(2);

	System.out.println("2" + stack.size());

	stack.push(3);

	System.out.println("3" + stack.size());

	System.out.println("3" + stack.peek());
	System.out.println("3" + stack.pop());
    }
}
