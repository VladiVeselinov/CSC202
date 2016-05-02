import java.util.*;

/**
 * LinearRegression.java
 * 
 * @author 		Vladi Veselinov <vpv266@email.vccs.edu>
 * @version		1.0
 */

public class LinearRegression 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		Random r = new Random();
		int[][] pts;	// data points array
		System.out.print("Enter number of data points or 0 for default: ");
		int n = keyboard.nextInt();	// number of data points
		if(n < 1)
		{
			n = 10;
			pts = new int[][]
					{
						{81, 131},
						{14, 71},
						{60, 112},
						{12, 53},
						{99, 115},
						{35, 92},
						{4, 71},
						{23, 65},
						{45, 104},
						{14, 25}
					};
		}
		else
		{
			pts = new int[n][2];
			for(int i = 0; i < n; i++)
			{
				pts[i][0] = r.nextInt(100);
				pts[i][1] = 50 + pts[i][0] + 
						(int)Math.round(25*r.nextGaussian());
			}
		}
		
		System.out.println("Fert\tYield");
		for(int i = 0; i < 10 && i < n; i++)
			System.out.println(pts[i][0] + "\t" + pts[i][1]);
		
		int sumX = 0;
		int sumY = 0;
		for(int i = 0; i < n; i++)
		{
			sumX += pts[i][0];
			sumY += pts[i][1];
		}
		double avgX = (double)sumX / n;
		double avgY = (double)sumY / n;
		
		double xVariance = 0;
		double xyCovariance = 0;
		for(int i = 0; i < n; i++)
		{
			xVariance += Math.pow(pts[i][0] - avgX, 2);
			xyCovariance += (pts[i][0] - avgX) * (pts[i][1] - avgY);
		}
		xVariance /= n;
		xyCovariance /= n;
		
		double slope = xyCovariance / xVariance;
		double yieldAt0 = avgY - slope * avgX;
		double yieldAtMax = yieldAt0 + 100 * slope;
		
		double residual = 0;
		for(int i = 0; i < n; i++)
			residual += Math.pow(yieldAt0 + slope*pts[i][0] - pts[i][1], 2);
		residual = Math.sqrt(residual / n);
		
		System.out.println("Slope = " + slope);
		System.out.println("YieldAt0 = " + yieldAt0);
		System.out.println("YieldAtMax = " + yieldAtMax);
		System.out.println("Residual error = " + residual);
		keyboard.close();
	}
}
