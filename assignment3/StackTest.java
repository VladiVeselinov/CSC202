package assignment3;

/**
 * VipQueue.java
 * 
 * @author 		Vladi Veselinov <vpv266@email.vccs.edu>
 * @version		1.0
 */
public class StackTest
{
    public static void main(String[] args)
    {
	Stack<Integer> myStack = new Stack<Integer>(10);
	for(int i = 0; i < 15; i++)
	    myStack.push(i);
	while(!myStack.isEmpty())
	    System.out.print("->" + myStack.pop());
    }
}
