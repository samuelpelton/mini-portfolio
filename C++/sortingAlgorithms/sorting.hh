#ifndef _SORTING_H_
#define _SORTING_H_

#include <iostream>
#include <cstring>
using namespace std;

template <class Elem, class Comp>
class Sortings
{
 public:
  static void merge(Elem *arr, unsigned int n);
  
  /**
   * Sorts input array using quicksort algorithm
   * pre-condition: Elem *arr to be sorted
   *                unsigned int n length of arr
   *
   * post-condition: array is sorted
   */
  static void quick(Elem *arr, unsigned int n); // do merge or this one
  /**
   * Sorts input array using selection sort  algorithm
   * pre-condition: Elem *arr to be sorted
   *                unsigned int n length of arr
   *
   * post-condition: array is sorted
   */
  static void select(Elem *arr, unsigned int n);
  static void insert(Elem *arr, unsigned int n); // do select or this one
  static void shell(Elem *arr, unsigned int n);
  /**
   * Sorts input array using radix sort algorithm
   * pre-condition: Elem *arr to be sorted
   *                unsigned int n length of arr
   *
   * post-condition: array is sorted
   */
  static void radix(Elem *arr, unsigned int n); // do shell or this one
// when using radix, Comp should be a class
  // with a static method "uintVal(...)" that gives an unsigned int representation of the items
 private:
  // These are all optional, add or remove as functions as you need
  static const unsigned int THRESHOLD = 3; // used by shell (I also use it in merge & quick)
  static const unsigned int RADIX = 16; // used by radix
  static void insert(Elem *arr, unsigned int incr, unsigned int n); // used by shell
  static void swap(Elem *arr, unsigned int, unsigned int);
  static void mergeRecurse(Elem *arr, Elem tmp[], unsigned int l, unsigned int r); // used by merge
  static void quickRecurse(Elem *arr, unsigned int l, unsigned int r); // used by quick
  static unsigned int partition(Elem *arr, unsigned int l, unsigned int r); // used by quickRecurse
  static unsigned int findPivot(Elem *arr, unsigned int l, unsigned int r); // used by quickRecurse
};

class intuival
{
public:
  /**
   * Takes an int value and returns it as an unsigned int
   * 
   * pre-condition: int n to be modified
   * post-condition: return unsigned int value of int
   */
  static unsigned int uintVal(int n);
};

class intintCompare
{
 public:
  /**
   * returns true if first int is less than second
   */
  static bool lt(int, int);
  /**
   * returns true if first int is greater than second
   */
  static bool gt(int, int);
  /**
   * returns true if first int is equal to second
   */
  static bool eq(int, int);
};

class strstrCompare
{
 public:
  /**
   * returns true if first string is less than second
   */
  static bool lt(char*, char*);
  /**
   * returns true if first string is greater than second
   */
  static bool gt(char*, char*);
  /**
   * returns true if first string is equal to second
   */
  static bool eq(char*, char*);  
};

#endif
