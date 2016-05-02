import java.util.*;

/**
 * AlgebraicEquationsDriver.java
 * 
 * @author Vladi Veselinov <vpv266@email.vccs.edu>
 * @version 1.0
 */
public class AlgebraicEquationsDriver
{
    static Scanner keyboard = new Scanner(System.in);
    private static double[][] dCoefficients = new double[][]
    {
	    { -6, 33, 16 },
	    { -7, 34, -8 },
	    { -25, 22, 9 } };
    private static double[] dRightSides = new double[]
    { -36, 43, -46 };

    public static void main(String[] args)
    {
	int n = setUp();
	print("Equations", n, dCoefficients, dRightSides);
	double[][] coefficients = new double[n][n];
	double[] rightSides = new double[n];
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < n; j++)
		coefficients[i][j] = dCoefficients[i][j];
	for (int i = 0; i < n; i++)
	    rightSides[i] = dRightSides[i];
	int[] oldRow = new int[n];
	AlgebraicEquations.decompose(n, coefficients, oldRow);
	double[] solution = AlgebraicEquations.substitute(n, coefficients, oldRow, rightSides);
	print("Solution", n, solution);
	double[] evaluated = evaluate(n, dCoefficients, solution);
	print("Verification", n, dRightSides, evaluated);
    }

    private static int setUp()
    {
	System.out.print("Number of Equations and Unknowns: ");
	int n = keyboard.nextInt();
	if (n == 0)
	    return 3;
	dCoefficients = new double[Math.abs(n)][Math.abs(n)];
	dRightSides = new double[Math.abs(n)];
	if (n < 0)
	{
	    generateEquations(-n, dCoefficients, dRightSides);
	    return -n;
	}
	for (int row = 0; row < n; row++)
	{
	    System.out.println("\nEnter equation " + row + "'s " + "coefficients separated by spaces:");
	    for (int col = 0; col < n; col++)
		dCoefficients[row][col] = keyboard.nextInt();
	    System.out.print("Enter right-side value: ");
	    dRightSides[row] = keyboard.nextInt();
	}
	return n;
    }

    private static void generateEquations(int n, double[][] coefficients, double[] rightSides)
    {
	for (int row = 0; row < n; row++)
	{
	    for (int col = 0; col < n; col++)
		coefficients[row][col] = Math.round(100 * (Math.random() - 0.5));
	    rightSides[row] = Math.round(100 * (Math.random() - 0.5));
	}
    }

    private static void print(String message, int n, double[][] coefficients, double[] rightSides)
    {
	System.out.println("\n" + message);
	for (int row = 0; row < n; row++)
	{
	    for (int col = 0; col < n; col++)
		System.out.print(coefficients[row][col] + "\t");
	    System.out.println("\t" + rightSides[row]);
	}
    }

    private static void print(String message, int n, double[] solution)
    {
	System.out.println("\n" + message);
	for (int row = 0; row < n; row++)
	    System.out.println(solution[row]);
    }

    public static double[] evaluate(int n, double[][] coefficients, double[] solution)
    {
	double[] rightSides = new double[n];
	for (int row = 0; row < n; row++)
	{
	    rightSides[row] = 0;
	    for (int col = 0; col < n; col++)
		rightSides[row] += coefficients[row][col] * solution[col];
	}
	return rightSides;
    }

    private static void print(String message, int n, double[] origRS, double[] checkRS)
    {
	System.out.println("\n" + message);
	for (int row = 0; row < n; row++)
	    System.out.println(origRS[row] + "\t" + checkRS[row]);
    }
}
