#include "../include/list.h"

int main(int argc, const char** argv)
{
	int num1 = 5;
	int num2 = 7;
	int num3 = 58;
	int num4 = 512;
	int num5 = 500;

	char c1 = 'q';
	char c2 = 'w';
	char c3 = 'e';
	char c4 = 'r';
	char c5 = 't';

	struct s_node** head = NULL;
	struct s_node** list2append = NULL;
	struct s_node* nullptr = NULL;
	struct s_node* a = new_node("A", NULL, NULL);
	struct s_node* b = new_node("B", NULL, NULL);
	struct s_node* c = new_node("C", NULL, NULL);
	struct s_node* d = new_node("D", NULL, NULL);
	struct s_node* e = new_node("E", NULL, NULL);
	struct s_node* f = new_node("F", NULL, NULL);
	struct s_node* g = new_node("G", NULL, NULL);
	struct s_node* h = new_node("H", NULL, NULL);
	struct s_node* x = new_node("5", NULL, NULL);
	struct s_node* z = new_node("Z", NULL, NULL);
	struct s_node* null_node = new_node(NULL, NULL, NULL);
	struct s_node* y = new_node("7", NULL, NULL);

	struct s_node* num6 = new_node(&num1, NULL, NULL);
	struct s_node* num7 = new_node(&num2, NULL, NULL);
	struct s_node* num8 = new_node(&num3, NULL, NULL);
	struct s_node* num9 = new_node(&num4, NULL, NULL);
	struct s_node* num10 = new_node(&num5, NULL, NULL);

	struct s_node* ch1 = new_node(&c1, NULL, NULL);
	struct s_node* ch2 = new_node(&c2, NULL, NULL);
	struct s_node* ch3 = new_node(&c3, NULL, NULL);
	struct s_node* ch4 = new_node(&c4, NULL, NULL);
	struct s_node* ch5 = new_node(&c5, NULL, NULL);

	my_str("\nView testlist.c to see comments for expected output\n\n");

	head = &nullptr;

	add_node(NULL, head);
	add_node(b, NULL);
	add_node(a, head);
	add_node(b, head);
	add_node(c, head);
	add_node(d, head);
	add_node(e, head);
	add_node(f, head);
	add_node(g, head);
	add_node(h, head);	/*list is HGFEDCBA*/

	traverse_string(NULL);
	traverse_string(*head);

	add_elem("I", head);	/*list is IHGFEDCBA*/
	add_elem(NULL, head);
	add_elem("I", NULL);

	traverse_string(*head);

	append(x, head);		/*list is IHGFEDCBA5*/
	append(NULL, head);
	append(x, NULL);
	append(null_node, head);
	append(x, NULL);

	debug_string(*head);

	add_node_at(z, head, 3);	/*list is IHGZFEDCBA5*/
	add_node_at(NULL, head, 2);
	add_node_at(z, NULL, 2);
	add_node_at(y, head, 100);	/*list is IGHZFEDCBA57*/

	traverse_string(*head);

	remove_node(head); 	/*list is HGZFEDCBA57 -- check return value on this*/
	remove_node(NULL);

	traverse_string(*head);

	remove_last(head);	/*list is HGZFEDCBA5 -- same*/
	remove_last(NULL);

	traverse_string(*head);

	remove_node_at(head, 5);	/*list is HGZFECBA*/
	remove_node_at(head, 100);
	remove_node_at(NULL, -5);

	traverse_string(*head);

	my_int(count_s_nodes(*head));
	my_char('\n');
	my_int(count_s_nodes(NULL));
	my_char('\n');

	empty_list(head);
	empty_list(NULL);

	my_int(count_s_nodes(*head));
	my_char('\n');

	a = new_node("A", NULL, NULL);
	b = new_node("B", NULL, NULL);
	c = new_node("C", NULL, NULL);
	d = new_node("D", NULL, NULL);

	head = &a;
	add_node(b, head);
	add_node(c, head);
	add_node(d, head);	/*list is DCBA*/

	traverse_string(*head);

	e = new_node("E", NULL, NULL);
	f = new_node("F", NULL, NULL);
	g = new_node("G", NULL, NULL);
	h = new_node("H", NULL, NULL);

	list2append = &e;
	add_node(f, list2append);
	add_node(g, list2append);
	add_node(h, list2append);	/*list is HGFE*/

	traverse_string(*list2append);

	/*have one of these uncommented at a time to test*/
	add_node_at(*list2append, head, 2);	/*head is DCHBA*/
	/*add_node(*list2append, head);*/		/*head is HDCBA*/
	/*append(*list2append, head);*/		/*head is DCBAHGFE*/

	debug_string(*head);

	debug_string(NULL);

	print_int(num6);
	print_int(num7);
	print_int(num8);
	print_int(num9);
	print_int(num10);

	print_char(ch1);
	print_char(ch2);
	print_char(ch3);
	print_char(ch4);
	print_char(ch5);
	return 0;
}
