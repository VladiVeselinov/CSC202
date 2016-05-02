package assignment3;

/**
 * StackNode.java
 * 
 * @author 		Vladi Veselinov <vpv266@email.vccs.edu>
 * @version		1.0
 */
public class StackNode<T>
{
    private T value;
    private StackNode<T> previous;	// Previous node
    public StackNode()
    {
	value = null;
	previous = null;
    }
    public void setValue(T val)
    {
	value = val;
    }
    public T getValue()
    {
	return value;
    }
    public void setPrevious(StackNode<T> prev)
    {
	previous = prev;
    }
    public StackNode<T> getPrevious()
    {
	return previous;
    }
}
