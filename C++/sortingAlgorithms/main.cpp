#include "sorting.hh"
#include <cstdlib>
using namespace std;

int main(int argc, char **argv)
{
  int i = 0;
  if (argc > 3)
    {
      switch (argv[1][0])
	{
	case 'i':
	  int iarr[argc - 2];
	  for (i = 2; i < argc; i++)
	    iarr[i - 2] = atoi(argv[i]);
	  Sortings<int, intuival>::radix(iarr, argc - 2); // replace with sorting you want to test
	  for (i = 0; i < argc - 2; i++)
	    {
	      cout << iarr[i] << " ";
	    }
	  break;
	case 's':
	  char *sarr[argc - 2];
	  for (i = 2; i < argc; i++)
	    sarr[i - 2] = argv[i];
	  Sortings<char*, strstrCompare>::select(sarr, argc - 2); // replace with sorting you want to test
	  for (i = 0; i < argc - 2; i++)
	    {
	      cout << sarr[i] << " ";
	    }
	  
	  break;
	default:
	  i = -1;
	  cout << "Cannot sort that" << endl;
	}
    }
  else
    {
      cout << "Use: ./mysort {i | s} item1 [item2] [item3] ..." << endl;
    }
  return 0;
}
