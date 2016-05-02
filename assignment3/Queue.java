package assignment3;

/**
 * Queue.java
 * 
 * @author 		Vladi Veselinov <vpv266@email.vccs.edu>
 * @version		1.0
 */
public class Queue<T>
{
    private int capacity;
    private int position;
    private T[] queue;	// elements array
    public Queue(int capacity)
    {
	this.capacity = capacity;
	queue = (T[])new Object[capacity];
	position = 0;
    }
    public boolean isEmpty()
    {
	if(position == 0)
	    return true;
	else
	    return false;
    }
    public boolean isFull()
    {
	if(position == capacity)
	    return true;
	else
	    return false;
    }
    public T peek()
    {
	if(isEmpty())
	    return null;
	else
	    return queue[0];
    }
    public T dequeue()
    {
	if(isEmpty())
	    return null;
	T value = queue[0];
	// Now I shift the array to the left to remove the element
	for(int i = 0; i < position-1; i++)
	    queue[i] = queue[i+1];
	position--;
	return value;
    }
    public void enqueue(T element)
    {
	if(isFull())
	    return;
	queue[position] = element;
	position++;
    }
}
