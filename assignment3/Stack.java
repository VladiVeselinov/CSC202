package assignment3;

/**
 * Stack.java
 * 
 * @author 		Vladi Veselinov <vpv266@email.vccs.edu>
 * @version		1.0
 */
public class Stack<T>
{
    private int capacity;
    private int position;
    private StackNode<T> currentNode;
    public Stack(int capacity)
    {
	this.capacity = capacity;
	position = 0;
	currentNode = new StackNode<T>();
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
	return currentNode.getValue();
    }
    public T pop()
    {
	T value = currentNode.getValue();
	if(!isEmpty())
	{
	    currentNode = currentNode.getPrevious();
	    position--;
	}
	return value;
    }
    public void push(T element)
    {
	if(isFull())
	    return;
	StackNode<T> newNode = new StackNode<T>();
	newNode.setValue(element);
	newNode.setPrevious(currentNode);
	currentNode = newNode;
	position++;
    }
}
