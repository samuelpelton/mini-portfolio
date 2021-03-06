#include "../../include/my.h"


void my_num_base_h(int i, char* str, int c)
{
	int len = my_strlen(str);

	if (i == 1 <<(8*sizeof(int)-1))
	{
		return;
	}

	if ((i == 0) && (c == 0))
	{
		my_int(0);
		return;
	}

	if (i < 0)
	{
		my_char('-');
		i *= -1;
	}

	if (str == NULL)
	{
		my_str("NULL\n");
		return;
	}

	if (len == 0)
	{
		/*my_str("error: string cannot be empty\n");*/
		return;
	}

	if (my_strindex(str, ' ') != NULL)
	{
		/*my_str("error: space found in string\n");*/
		return;
	}

	if (len == 1)
	{
		while (len < i + 1)
		{
			my_str(str);
			len++;
		}
		return;
	}

	if (i != 0)
	{
		c++;
		my_num_base_h(i / len, str, c);
		my_char(str[i % len]);
	}
}

void my_num_base(int i, char* str)
{
	my_num_base_h(i, str, 0);
}
