package week7;
/**
 * This class uses an array to represent a queue.
 *
 * I pledge my honor that I have abided by the Stevens Honor System.
 *
 * @author Sam Pelton
 */
public class Queue
{
    private int[] queue;
    private int size;

    public Queue( int length )
    {
	queue = new int[length];
	size = 0;
    }

    public Queue()
    {
	queue = new int[10];
	size = 0;
    }

    public int size()
    {
	return size;
    }

    public void enqueue( int num )
    {
	if ( size == queue.length )
	    {
		System.out.println("Queue is already full!!!");
	    }
	else
	    {
		for ( int i = queue.length - 1; i > 0; i-- )
		    {
			queue[i] = queue[i-1];
		    }
		queue[0] = num;
		size++;
	    }
	
    }

    public int dequeue()
    {
	int num = queue[size-1];

	queue[size-1] = 0;

	size--;

	return num;
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
		System.out.println("Queue is empty!!!");
		return -1;
	    }
	return queue[size-1];
    }
}
