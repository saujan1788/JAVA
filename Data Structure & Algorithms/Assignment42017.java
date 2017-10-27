/*
Assignment 4

Student name: Saujanya Bohara
Student number: 2892141
===========================================================================

Your task this week is to benchmark three fast sorting algorithms Mergesort,
Quicksort and Arrays.sort (that uses the dual-pivot quicksort described in Yaroslavskiy 2009)


Please note that marks will be awarded based on the quality of the report written by you
in the sections provided below.

When preparing your report you should take note of the comments provided for Assignment 3
that involved a simple benchmark report.

*/

/*=======================================================================================
*  Benchmarking Report for each of the sorting algorithms
=========================================================================================
*   MergeSort
*  VALUE      |    PERFORAMACE IN MILLISECONDS
   100000     |    22ms
   1000000    |    183ms
   10000000   |    1867ms
   100000000  |    21411ms
              

*
*  =======================================================================================
*   QuickSort
   VALUE      |    PERFORAMACE IN MILLISECONDS
   100000     |    22ms
   1000000    |    124ms
   10000000   |    1285ms
   100000000  |    14858ms

*
*
*
* ========================================================================================
*  Arrays.sort
   VALUE      |    PERFORAMACE IN MILLISECONDS
   100000     |    35ms
   1000000    |    149ms
   10000000   |    973ms
   100000000  |    10743ms
*
*
* MERGE SORT:Merge sort works on the O(nlogn) big-o notation and is a stable sorting algorithm.
 It merges sorted sub lists into larger and larger list until it reaches the result of full sorted list.
  The division involves no comparisons. The divide component is O(logn) (log base 2), and merging is O(n). 
  Theoratically it should outperform Quicksort but Mergesort merges values in a way that it requires a new 
  temp data array to store values, which is then copied back to the original array. This expensive overhead means that for large data sets
 
*QUICK SORT:Quicksort works in O(nlogn) in the best case scenario, but O(n^2) in worst-case scenarios.
 Quicksort uses recursion in a sense that it selects elements called pivots and moves all elements smaller
  before it and all greater ones after it. It continually does this (recursion). Quicksort runs O(nlogn) 
  when input is nearly sorted, but has worst case quadratic performance when input is sorted in reverse O(n^2).
   But again, this depends on how the pivot element is chosen.
 
*Arrays.sort: is basically an optimized version of Quicksort, but unlike Quicksort it uses two pivot elements 
which partitions to three parts. This makes it more effective and faster when using large arrays.
*
*
* ========================================================================================
*  Comparison based on your test results
* 
*   By checking the reports of our results we can come to a conclusion that 

*    RANGE OF VALUE       TYPE OF SORT   PERFORMANCE 
*    Small values         MergeSort      The sorting is done faster comparing to array sort
*                                        but the speed is somewhat same with Quick sort.
*
*                         QuickSort      The sorting is fast for the sammler range of values 
*                                        speed is same as MergeSort.
*
*                         Arrays.Sort    If the values are small then the performance is slow 
*                                        compared to the rest.
*
*    Medium values        MergeSort      Compare to othersThe performance starts decreasing as the 
*                                        value starts increasing.
*
*                         QuickSort      For medium range values it tends to perform better than 
*                                        any others.
*            
*                         Arrays.Sort    It performs faster than merge sort but it still is slower
*                                        than quick sort.
*
*   Large values          MergeSort      As the value increases the rate of speed gets rapidly
*                                        decreased
*                         
*                         QuickSort      It still performs fast than Mergesort but it will fall 
*                                        behind compared to Arrays.Sort
*       
*                         Arrays.Sort    The speed is rapidly increased compared to others
*
*
*    To sum up, we can say if we have a high range of value then Arrays.sort will be best for
*    performance and if the value is medium range then quick sort will be best, if low then 
*    merge sort or quick sort either of them will be okay.
*    

*
*/ 
//=====================================================================================  

import java.util.*;
class Assignment42017{
    static final int d = 10000;
  public static void main(String args[]){
    //==========================================================
    //Benchmarking MergeSort code
    Random r = new Random();
        int[] a = new int[d];
        for (int i = 0; i < a.length; i++) 
        {
            a[i] = (int)(Math.random()*d);
        }
    long start = System.nanoTime();
    mergeSort(a, 1, a.length);
    long end = System.nanoTime();
    long t1 = end-start;
    System.out.println("Mergesort: " + t1/1000000 +"ms");

    //==========================================================
    // Benchmarking QuickSort code
    int[] b = new int[d];
        for (int i = 0; i < b.length; i++) 
        {
            b[i] = (int)(Math.random()*d);
        }
    long start1 = System.nanoTime();
    quickSort(b, 0, b.length);
    long end1 = System.nanoTime();
    long t2 = end1-start1;
    System.out.println("Quicksort: " + t2/1000000 +"ms");

    //==========================================================
    //Benchmarking Arrays.sort

        int[] c = new int[d];
        for (int i = 0; i < c.length; i++) 
        {
        c[i] = (int)(Math.random()*d);
        }
    long start2 = System.nanoTime();
    Arrays.sort(c);
    long end2 = System.nanoTime();
    long t3 = end2-start2;
    System.out.println("ArraysSort: " + t3/1000000 +"ms");
    //==========================================================

  }
  

  static void quickSort(int f[], int p, int q){
		  if(q-p <= 1)
		      ; //skip
		  else{
		     int x;
		     int i, j, k;
		     // let x = middle element in f[p..q-1]
		     x = f[(p+q)/2];
		     //x = f[p];
		     i = p; j = p; k = q;
		     while(j != k){
		       if(f[j] == x)
		          j = j + 1;
		       else if(f[j] < x){ //swap f[j] with f[i]
		          int temp;
		          temp = f[j];
		          f[j] = f[i];
		          f[i] = temp;
		          j = j + 1;
		          i = i + 1;
		       }
		       else{ // f[j] > x
		          // swap f[j] with f[k-1]
		          int temp;
		          temp = f[j];
		          f[j] = f[k-1];
		          f[k-1] = temp;
		          k = k - 1;
		       }
		     }
         quickSort(f,p,i);
         quickSort(f,j,q);
		  }
    }

    static void mergeSort(int f[], int lb, int ub){
    	//termination reached when a segment of size 1 reached - lb+1 = ub
    	if(lb+1 < ub){
    		int mid = (lb+ub)/2;
    		mergeSort(f,lb,mid);
    		mergeSort(f,mid,ub);
    		merge(f,lb,mid,ub);
    	}
    }
    static void merge(int f[], int p, int q, int r){
    	//p<=q<=r
    	int i = p; int j = q;
    	//use temp array to store merged sub-sequence
    	int temp[] = new int[r-p]; int t = 0;
    	while(i < q && j < r){
    		if(f[i] <= f[j]){
    			temp[t]=f[i];i++;t++;
    		}
    		else{
    			temp[t] = f[j]; j++; t++;
    		}
    	}
    	//tag on remaining sequence
    	while(i < q){
    		temp[t]=f[i];i++;t++;
    	}
    	while(j < r){
    		temp[t] = f[j]; j++; t++;
    	}
    	//copy temp back to f
    	i = p; t = 0;
    	while(t < temp.length){
    		f[i] = temp[t];
    		i++; t++;
    	}
    }
		
    static void insertionSort(int k[], int a, int b){
    	int j = a+1;
    	while(j < b){
    		int i = j;
    		while(i > a && k[i] < k[i-1]){ //swap k[i], k[i-1]
    		  int temp = k[i];
    		  k[i] = k[i-1]; k[i-1] = temp;
    		  i = i - 1;
    		}
    		j = j + 1;
    	}
    }
}
