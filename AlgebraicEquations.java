/**
 * AlgebraicEquations.java
 * 
 * @author Vladi Veselinov <vpv266@email.vccs.edu>
 * @version 1.0
 */
public class AlgebraicEquations
{
    public static void decompose(int n, double[][] coefficients, int[] oldRow)
    {
	double[] scalings = doScaling(n, coefficients);
	for (int row = 0; row < n; row++)
	    oldRow[row] = row;
	for (int col = 0; col < n; col++)
	{
	    doUpper(col, coefficients);
	    int maxRow = beginLower(n, col, coefficients, scalings);
	    if (maxRow != col)
	    {
		for (int k = 0; k < n; k++)
		{
		    double temp = coefficients[maxRow][k];
		    coefficients[maxRow][k] = coefficients[col][k];
		    coefficients[col][k] = temp;
		}
		int temp = oldRow[maxRow];
		oldRow[maxRow] = oldRow[col];
		oldRow[col] = temp;
		scalings[maxRow] = scalings[col];
	    }
	    if (col != n - 1)
		for (int row = col + 1; row < n; row++)
		    coefficients[row][col] /= coefficients[col][col];
	}
    }

    private static double[] doScaling(int n, double[][] coefficients)
    {
	double[] scalings = new double[n];
	for (int row = 0; row < n; row++)
	{
	    double max = 0;
	    for (int col = 0; col < n; col++)
		if (Math.abs(coefficients[row][col]) > max)
		    max = Math.abs(coefficients[row][col]);
	    scalings[row] = 1 / max;
	}
	return scalings;
    }

    private static void doUpper(int col, double[][] coefficients)
    {
	for (int row = 0; row < col; row++)
	{
	    double sum = coefficients[row][col];
	    for (int k = 0; k < row; k++)
		sum -= coefficients[row][k] * coefficients[k][col];
	    coefficients[row][col] = sum;
	}
    }

    private static int beginLower(int n, int col, double[][] coefficients, double[] scalings)
    {
	int rowMax = col;
	double max = 0;
	for (int row = col; row < n; row++)
	{
	    double sum = coefficients[row][col];
	    for (int k = 0; k < col; k++)
		sum -= coefficients[row][k] * coefficients[k][col];
	    coefficients[row][col] = sum;
	    if (scalings[row] * Math.abs(sum) >= max)
	    {
		max = scalings[row] * Math.abs(sum);
		rowMax = row;
	    }
	}
	return rowMax;
    }

    public static double[] substitute(int n, double[][] lowerUpper, int[] oldRow, double[] rightSides)
    {
	rightSides = forward(n, lowerUpper, oldRow, rightSides);
	backward(n, lowerUpper, rightSides);
	return rightSides;
    }

    private static double[] forward(int n, double[][] lowerUpper, int[] oldRow, double[] rightSides)
    {
	int firstNonZeroRow = -1;
	double[] solution = new double[n];
	for (int row = 0; row < n; row++)
	{
	    double sum = rightSides[oldRow[row]];
	    if (firstNonZeroRow > -1)
		for (int col = firstNonZeroRow; col < row; col++)
		    sum -= lowerUpper[row][col] * solution[col];
	    else if (sum != 0)
		firstNonZeroRow = row;
	    solution[row] = sum;
	}
	return solution;
    }

    private static void backward(int n, double[][] lowerUpper, double[] rightSides)
    {
	for (int row = n - 1; row >= 0; row--)
	{
	    double sum = rightSides[row];
	    for (int col = row + 1; col < n; col++)
		sum -= lowerUpper[row][col] * rightSides[col];
	    rightSides[row] = sum / lowerUpper[row][row];
	}
    }
}