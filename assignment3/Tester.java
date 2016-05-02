package assignment3;

/**
 * Tester.java
 * 
 * @author 		Vladi Veselinov <vpv266@email.vccs.edu>
 * @version		1.0
 */
public class Tester
{
    public static void main(String[] args)
    {
	VipQueue<Integer> vq = new VipQueue<Integer>(10);
	for(int i = 0; i < 5; i++)
	{
	    if(!vq.isFull())
		vq.enqueue((Integer)i);
	    if(!vq.isFull())
		vq.vipEnqueue((Integer)(i*i));
	}
	while(!vq.isEmpty())
	    System.out.print("->" + vq.dequeue());
    }
}
