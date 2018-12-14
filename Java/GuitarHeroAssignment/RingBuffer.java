/**
 * This class creates a buffer for holding double values.
 * 
 * I pledge my honor that I have abided by the Stevens Honor System.
 * 
 * @author Sam Pelton
 */

public class RingBuffer
{
    private double[] buffer;
    private int size;
    private int first;
    private int last;
    
    public RingBuffer(int capacity)
    {
	buffer = new double[capacity];
	size = 0;
	first = 0;
	last = 1;
    }

    public int getSize()
    {
	return size;
    }

    public boolean isEmpty()
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

    public boolean isFull()
    {
	if ( size == buffer.length )
	    {
		return true;
	    }
	else
	    {
		return false;
	    }
    }

    public void enqueue(double x)
    {
	if ( isFull() )
	    {
		System.out.println("Buffer is already full!!!");
	    }
	else
	    {
		buffer[last] = x;
		size++;
		if ( last == buffer.length - 1 )
		    {
			last = 0;
		    }
		else
		    {
			last++;
		    }
	    }
    }

    public double dequeue()
    {
	if ( isEmpty() )
	    {
		System.out.println("Buffer is already empty!!!");
		return -1;
	    }
	else
	    {
	        if ( first == buffer.length - 1 )
	        {
	            first = 0;
	           }
	           else
	           {
	               first++;
	           }
		size--;
		return buffer[first];
	    }
    }

    public double peek()
    {
	if ( isEmpty() )
	    {
		System.out.println("Buffer is empty!!!");
		return -1;
	    }
	else
	    {
		return buffer[first];
	    }
    }
}
