package week7;
/**
 * This class represents a stack using an array.
 * 
 * I pledge my honor that I have abided by the Stevens Honor System.
 *
 * @author Sam Pelton
 */
public class Stack
{
    private int[] stack;
    private int size;

    /**
     * This constructor initializes the stack capacity to the value
     * taken as a parameter.
     */
    public Stack(int capacity)
    {
	stack = new int[capacity];
	size = 0;
    }

    /**
     * This is the default constructor which initializes the stack
     * capacity to 10.
     */
    public Stack()
    {
	stack = new int[10];
	size = 0;
    }

    public int size()
    {
	return size;
    }

    public void push(int input)
    {
	if ( size == stack.length )
	    {
		System.out.println("Stack is already full!!!");
	    }
	for ( int i = size - 1; i > 0; i-- )
	    {
		stack[i+1] = stack[i];
	    }
	stack[0] = input;
	size++;
    }

    public int pop()
    {
	if ( empty() )
	    {
		System.out.println("Stack is empty!!!");
		return -1;
	    }
	int popped = stack[0];
	
	for ( int i = 0; i < size; i++ )
	    {
		if ( i == stack.length - 1 )
		    {
			stack[i] = 0;
		    }
		else
		    {
			stack[i] = stack[i+1];
		    }
	    }

	return popped;
    }

    public boolean empty()
    {
	if ( size == 0 )
	    {
		return true;
	    }
	else
	    {
		return false;
	    }
    }

    public int peek()
    {
	if ( empty() )
	    {
		System.out.println("Stack is empty!!!");
		return -1;
	    }
	return stack[0];
    }
}
