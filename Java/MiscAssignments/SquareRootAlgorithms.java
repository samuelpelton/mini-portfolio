/**
 * SquareRootAlgorithms.java
 *
 * "I pledge my honor that I have abided by the Stevens Honor System."
 *
 * This program takes a number as a String and calculates the square root of
 * the number as an integer through two different methods. It calculates the 
 * square root by sum in the first method and by division in the second method.
 * This program prints the results of calculating via each method.
 *
 * @author Sam Pelton
 *
 */
public class SquareRootAlgorithms
{
    public static void main(String args[])
    {
        if ( args.length != 1 )
	    {
		System.out.println("Input must be one String!");
	    }
	else
	    {

		int num = 0;
		int factor = 1;
		for ( int i = args[0].length() - 1; i >= 0; i -- )
		    {
			num += (args[0].charAt(i) - '0') * factor;
			factor *= 10;
		    }

		System.out.println( "Square Root by Sums: " + sqrtBySums(num) );
		System.out.println( "Square Root by Division: " + sqrtByDivs(num));
	    }
    }

    public static int sqrtBySums(int n)
    {
	int oddNum = -1;
	int sum = 0;
	int count = 0;
	while ( sum < n )
	    {
		oddNum += 2;
		sum += oddNum;
		count++;
	    }

        if ( sum == n )
	    {
		return count;
	    }
	else
	    {
		return count - 1;
	    }
    }

    public static int sqrtByDivs(int n)
    {
	if ( n < 0 )
	    {
		return -1;
	    }
	
	int x = n;
	int y = 1;

	while ( x > y )
	    {
		x = (x + y) / 2;
		y = n / x;
	    }

	return x;
    }
}
