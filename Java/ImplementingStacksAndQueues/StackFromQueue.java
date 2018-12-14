package week7;
/**
 * This class uses queues to represent a stack.
 *
 * I pledge my honor that I have abided by the Stevens Honor System.
 *
 * @author Sam Pelton
 */
public class StackFromQueue
{
    private Queue  queue0;
    private Queue  queue1;
    private Queue  queueStorage;

    private boolean queue;

    public StackFromQueue()
    {
	queue0 = new Queue();
	queue1 = new Queue();
	queueStorage = new Queue();

	queue = false;
    }

    public StackFromQueue(int length)
    {
	queue0 = new Queue(length);
	queue1 = new Queue(length);
	queueStorage = new Queue(length);

	queue = false;
    }

    public int size()
    {
	if ( queue == false )
	    {
		return queue0.size();
	    }
	else
	    {
		return queue1.size();
	    }
    }

    public boolean empty()
    {
        if ( queue == false )
	    {
		return queue0.empty();
	    }
	else
	    {
		return queue1.empty();
	    }
    }

    public void push(int num)
    {
	if ( queue == false )
	    {
		queue0.enqueue(num);
	    }
        else
	    {
		queue1.enqueue(num);
	    }
    }

    public int pop()
    {
	int num;

	if ( queue == false )
	    {
		while ( queue0.size() > 1 )
		    {
			queue1.enqueue(queue0.dequeue());
		    }
		num = queue0.dequeue();
		queue = true;
		return num;
	    }
	else
	    {
	    	while ( queue1.size() > 1 )
		    {
			queue0.enqueue(queue1.dequeue());
		    }
		num = queue1.dequeue();
		queue = false;
		return num;
	    }
    }

    public int peek()
    {
	int num;

	if ( queue == false )
	    {
		while ( queue0.size() > 1 )
		    {
			queueStorage.enqueue(queue0.dequeue());
		    }
		num = queue0.dequeue();
		queueStorage.enqueue(num);

		while ( queueStorage.size() > 0 )
		    {
			queue0.enqueue(queueStorage.dequeue());
		    }
	    }
	else
	    {
		while ( queue1.size() > 1 )
		    {
			queueStorage.enqueue(queue1.dequeue());
		    }
		num = queue1.dequeue();
		queueStorage.enqueue(num);

		while ( queueStorage.size() > 0 )
		    {
			queue1.enqueue(queueStorage.dequeue());
		    }
	    }
	return num;
    }
}
