#include "sorting.hh"

template void Sortings<int, intuival>::radix(int*, unsigned int);

template <class Elem, class Comp>
void Sortings<Elem, Comp>::radix(Elem *arr, unsigned int n)
{
//	if(arr != NULL)
//	{
//		int b[n];
//		int count[10];
//		int i, exp, bIndex;
//		Elem max;
//
//		exp = 1;
//		max = arr[0];
//
//		for(i = 1; i < n; i++)
//		{
//			if(arr[i] > Comp::uintVal(max))
//			{
//				max = arr[i];
//			}
//
//			arr[i] = intuival::uintVal(arr[i]);			
//		}
//
//		while(exp <= Comp::uintVal(max))
//		{
//			for(i = 0; i < n; i++)
//				count[i] = 0;		
//			for(i = 0; i < n; i++)
//				count[(Comp::uintVal(arr[i]) % (10 * exp)) / exp]++;
//			
//			for(i = 0; i < 10; i++)
//			std::cout << count[i] << " " << std::endl;
//
//			//sum buckets
//			for(i = 1; i < 10; i++)
//				count[i] += count[i - 1];
//			
//			//////////////////
//			//THIS IS THE LOOP CAUSING THE ERRORS
//			/////////////////
//			for(i = n - 1; i >= 0; i--)
//			{
//				for(int j = 0; j < 10; j++)
//					std::cout << count[j] << " " << std::endl;
//				bIndex = --count[(Comp::uintVal(arr[i]) % (10 * exp)) / exp];
//				std::cout << bIndex << " " << std::endl;
//				b[bIndex] = Comp::uintVal(arr[i]);
//			}
//
//			for(i = 0; i < n; i++)
//				arr[i] = b[i];
//
//			exp *= 10;
//		}
//	}
}
