#include "sorting.hh"

template void Sortings<int, intintCompare>::select(int*, unsigned int);
template void Sortings<char*, strstrCompare>::select(char**, unsigned int);

template <class Elem, class Comp>
void Sortings<Elem, Comp>::select(Elem *arr, unsigned int n)
{
	if(arr != NULL)
	{
		Elem min;
		unsigned int i, j, k;	
		
		for(i = 0; i < n - 1; i++)
		{
			min = arr[i];
			k = i;

			for(j = i + 1; j < n; j++)
			{
				if(Comp::lt(arr[j], min))
				{
					min = arr[j];
					k = j;
				}
			}

			Sortings::swap(arr, i, k);	
		}
	}
}
