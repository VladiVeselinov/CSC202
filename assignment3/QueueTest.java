package assignment3;


public class QueueTest
{
    public static void main(String[] args)
    {
	Queue<Integer> myQueue = new Queue<Integer>(20);
	for(int i = 0; i < 25; i++)
	    myQueue.enqueue(i);
	while(!myQueue.isEmpty())
	    System.out.print("->" + myQueue.dequeue());
    }
}
