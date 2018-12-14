#include "sorting.hh"

template void Sortings<int, intintCompare>::quick(int*, unsigned int);
template void Sortings<int, intintCompare>::quickRecurse(int*, unsigned int, unsigned int);
template unsigned int Sortings<int, intintCompare>::findPivot(int*, unsigned int, unsigned int);
template unsigned int Sortings<int, intintCompare>::partition(int*, unsigned int, unsigned int);


template void Sortings<char*, strstrCompare>::quick(char**, unsigned int);
template void Sortings<char*, strstrCompare>::quickRecurse(char**, unsigned int, unsigned int);
template unsigned int Sortings<char*, strstrCompare>::findPivot(char**, unsigned int, unsigned int);
template unsigned int Sortings<char*, strstrCompare>::partition(char**, unsigned int, unsigned int);



template <class Elem, class Comp>
void Sortings<Elem, Comp>::quick(Elem *arr, unsigned int n)
{
	if(arr != NULL)
	{
		unsigned int l, r;
		l = 0;
		r = n - 1;

		quickRecurse(arr, l, r);
	}
}

template <class Elem, class Comp>
void Sortings<Elem, Comp>::quickRecurse(Elem *arr, unsigned int l, unsigned int r)
{
	if(l != r)
	{
		unsigned int pivot = findPivot(arr, l, r);
		unsigned int end = r;
		unsigned int first = l;
	
		while(l <= r)
		{
			while(arr[l] < arr[pivot])
				l++;
			while(arr[r] > arr[pivot])
				r--;
			if(l <= r)
			{
				Sortings::swap(arr, l++, r++);
			}
		}
		
		quickRecurse(arr, first, r);
		quickRecurse(arr, l, end);
	}
}

template <class Elem, class Comp>
unsigned int Sortings<Elem, Comp>::findPivot(Elem *arr, unsigned int l, unsigned int r)
{
	unsigned int m = (r - l) / 2;

	if(Comp::gt(arr[l], arr[m]))
	{
		if(Comp::lt(arr[l], arr[r]))
			return l;
		if(Comp::gt(arr[m], arr[r]))
			return m;
		return r;
	}
	if(Comp::gt(arr[l], arr[r]))
		return l;
	if(Comp::gt(arr[m], arr[r]))
		return r;
	return m;
}

template <class Elem, class Comp>
unsigned int Sortings<Elem, Comp>::partition(Elem *arr, unsigned int l, unsigned int r)
{

}
