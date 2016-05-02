package assignment3;

/**
 * VipQueue.java
 * 
 * @author 		Vladi Veselinov <vpv266@email.vccs.edu>
 * @version		1.0
 */
public class VipQueue<T>
{
    private Stack<T> stack;
    private Queue<T> queue;
    private int size;
    private int capacity;
    public VipQueue(int capacity)
    {
	stack = new Stack<T>(capacity);
	queue = new Queue<T>(capacity);
	size = 0;
	this.capacity = capacity;
    }
    public boolean isEmpty()
    {
	if(size == 0)
	    return true;
	else
	    return false;
    }
    public boolean isFull()
    {
	if(size == capacity)
	    return true;
	else
	    return false;
    }
    public T peek()
    {
	if(isEmpty())
	    return null;
	if(!stack.isEmpty())
	    return stack.peek();
	else
	    return queue.peek();
    }
    public T dequeue()
    {
	if(isEmpty())
	    return null;
	size--;
	if(!stack.isEmpty())
	    return stack.pop();
	else
	    return queue.dequeue();
    }
    public void enqueue(T element)
    {
	if(isFull())
	    return;
	queue.enqueue(element);
	size++;
    }
    public void vipEnqueue(T element)
    {
	if(isFull())
	    return;
	stack.push(element);
	size++;
    }
}
