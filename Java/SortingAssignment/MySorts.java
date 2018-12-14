import java.util.Random;

/**
 * MySorts is a class consisting of 3 sorting algorithms:
 * Insertion Sort
 * Merge Sort
 * Shell Sort
 *
 * @author Sam Pelton
 */
public class MySorts
{
    /**
     * The main method runs the three sort algorithms
     * against multiple test cases
     */
    public static void main(String[] args)
    {
	System.out.println();

	//sorting basic String array

	System.out.println("Sorting basic String array:\n");

	String[] arr = {"hi", "my", "name", "is", "sam"};

	System.out.print("Initial Array: ");
	printStringArray(arr);

	System.out.print("Insertion Sort: ");
	insert(arr, 5);
	System.out.print("Merge Sort: ");
	merge(arr, 5);

	System.out.println();

	//sorting reversed int array

	System.out.println("Sorting reversed int array:\n");

	int[] reverse = new int[25];
	int count = 0;
	for ( int i = 24; i >= 0; i-- )
	{
		reverse[i] = count;
		count++;
	}

	System.out.print("Initial Array: ");
	printIntArray(reverse);
	System.out.print("Shell Sort: ");
	shell(reverse, 25);

	System.out.println();

	//sorting short "random" int array

	System.out.println("Sorting short \"random\" int array:\n");

	int[] example = {0, 4, 2, 12, 6, 27, 3, 1, 18, 9};

	System.out.print("Initial Array: ");
	printIntArray(example);
	System.out.print("Shell Sort: ");
	shell(example, 10);

	System.out.println();

	//sorting legitimately random array of ints from 0-99

	System.out.println("Sorting legitimately random array of ints from 0-99:\n");

	Random rand = new Random();

	example = new int[50];
	for ( int i = 0; i < 50; i++ )
	{
		example[i] = rand.nextInt(100);
	}

	System.out.print("Initial Array: ");
	printIntArray(example);
	System.out.print("Shell Sort: ");
	shell(example, 50);

	System.out.println();

	//testing against null arrays of different lengths

	System.out.println("Testing 6 sort attempts of null arrays:\n");

	shell(null, 0);
	shell(null, 5);
	insert(null, 0);
	insert(null, 5);
	merge(null, 0);
	merge(null, 5);

	System.out.println();

	//testing against non-null arrays of negative lengths

	System.out.println("Testing 3 sort attempts of arrays of negative length:\n");

	shell(example, -5);
	insert(arr, -5);
	merge(arr, -5);

	System.out.println();

    }

///////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method implements the insertion sort algorithm
     *
     * pre-condition:
     *
     * @param String[] arr
     * @param int n
     *
     * post-condition:
     *
     * if possible, given input, the array arr will be sorted and printed
     */
    public static void insert(String[] arr, int n)
    {
	if ( arr != null && n > 1 )
	{
		int i, j;

		if ( n > arr.length )
			n = arr.length;

		for ( i = 1; i < n; i++ )
			for ( j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j-- )
			{
				swapStrings( arr, j, j - 1);
			}
		printStringArray(arr);
	}
	else if (arr == null)
	{
		System.out.println("array is null");
	}
	else if (n < 0)
	{
		System.out.println("negative sorting size");
	}
	else
	{
		System.out.println(arr[0]);
	}


    }

//////////////////////////////////////////////////////////////////////////////////////
    /**
     * This method implements the merge sort algorithm
     *
     * pre-condition:
     *
     * @param String[] arr
     * @param int n
     *
     * post-condition:
     *
     * if possible, given input, the array arr will be sorted and printed
     */
    public static void merge(String[] arr, int n)
    {
	if ( arr != null && n > 1 )
	{
		if ( n > arr.length )
		{
			n = arr.length;
		}

		mergeSort(arr, 0, n-1);
		printStringArray(arr);
	}
	else if (arr == null)
	{
		System.out.println("array is null");
	}
	else if (n < 0)
	{
		System.out.println("negative sorting size");
	}
	else
	{
		System.out.println(arr[0]);
	}
    }

    private static void mergeSort( String[] arr, int l, int r )
    {
	if ( l < r )
	{
		int m = l + ( r - l ) / 2;

		mergeSort(arr, l, m);
		mergeSort(arr, m + 1, r);
		merge( arr, l, m, r);
	}
    }

    private static void merge( String[] arr, int l, int m, int r )
    {
	String[] help = new String[arr.length];
	int i, j, k;

	for ( i = 0; i < arr.length; i++ )
	{
		help[i] = arr[i];
	}

	i = l;
	j = m + 1;
	k = l;

	while ( i <= m && j <= r )
	{
		if ( help[i].compareTo(help[j]) < 0 )
		{
			arr[k] = help[i];
			i++;
		}
		else
		{
			arr[k] = help[j];
			j++;
		}
		k++;
	}

	while ( i <= m )
	{
		arr[k] = help[i];
		k++;
		i++;
	}

    }

//////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method implements the shell sort algorithm
     *
     * pre-condition:
     *
     * @param String[] arr
     * @param int n
     *
     * post-condition:
     *
     * if possible, given input, the array arr will be sorted and printed
     */
    public static void shell(int[] arr, int n)
    {
	if ( arr != null && n > 1 )
	{
		if ( n > arr.length )
			n = arr.length;

		int gap = n / 2;
		int i, j;

		while ( 0 < gap )
		{
			for ( i = gap; i < n; i += gap )
			{
				for ( j = i; j > gap - 1 && arr[j] < arr[j - gap]; j -= gap )
				{
					swapInts( arr, j, j - gap );
				}
			}

			gap /= 2;
		}

		printIntArray(arr);
	}
	else if ( arr == null )
	{
		System.out.println("array is null");
	}
	else if ( n < 0 )
	{
		System.out.println("negative sorting size");
	}
	else
	{
		System.out.println(arr[0]);
	}
    }

//////////////////////////////////////////////////////////////////////////////////////
//methods used by multiple sorts
//////////////////////////////////////////////////////////////////////////////////////

    private static void swapInts( int[] arr, int i, int j )
    {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
    }

    private static void swapStrings( String[] arr, int i, int j )
    {
	String temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
    }

    private static void printStringArray(String[] arr)
    {
	int i;
	for ( i = 0; i < arr.length; i++ )
	{
		System.out.print(arr[i] + " ");
	}
	System.out.println();
    }

    private static void printIntArray(int[] arr)
    {
	int i;
	for ( i = 0; i < arr.length; i++ )
	{
		System.out.print(arr[i] + " ");
	}
	System.out.println();
    }
}
