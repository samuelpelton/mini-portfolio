package week8;
/**
 * This class represents a stack using an array.
 * 
 * I pledge my honor that I have abided by the Stevens Honor System.
 *
 * @author Sam Pelton
 */
public class Stack
{
    private char[] stack;
    private char size;

    /**
     * This constructor initializes the stack capacity to the value
     * taken as a parameter.
     */
    public Stack(int capacity)
    {
	stack = new char[capacity];
	size = 0;
    }

    /**
     * This is the default constructor which initializes the stack
     * capacity to 10.
     */
    public Stack()
    {
	stack = new char[10];
	size = 0;
    }

    public int size()
    {
	return size;
    }

    public void push(char input)
    {
	if ( size == stack.length )
	    {
		System.out.println("Stack is already full!!!");
	    }
	for ( int i = size - 1; i >= 0; i-- )
	    {
		stack[i+1] = stack[i];
	    }
	stack[0] = input;
	size++;
    }

    public char pop()
    {
	if ( empty() )
	    {
		System.out.println("Stack is empty!!!");
		return ' ';
	    }
	char popped = stack[0];
	
	for ( int i = 0; i < size; i++ )
	    {
		if ( i == stack.length - 1 )
		    {
			stack[i] = ' ';
		    }
		else
		    {
			stack[i] = stack[i+1];
		    }
	    }
	size--;
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

    public char peek()
    {
	if ( empty() )
	    {
		System.out.println("Stack is empty!!!");
		return ' ';
	    }
	return stack[0];
    }
}
