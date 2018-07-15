package com;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedArray {

	static void merge(int ar1[], int ar2[], int m, int n) {
		// Iterate through all elements of ar2[] starting from
		// the last element
		for (int i = n - 1; i >= 0; i--) {
			/*
			 * Find the smallest element greater than ar2[i]. Move all elements
			 * one position ahead till the smallest greater element is not found
			 */
			int j, last = ar1[m - 1];
			for (j = m - 1; j >= 0 && ar1[j] > ar2[i]; j--)
				ar1[j + 1] = ar1[j];

			// If there was a greater element
			if (j != m - 1) {
				ar1[j + 1] = ar2[i];
				ar2[i] = last;
			}
		}
	}

	public static void main(String[] args) {
		// int ar1[] = {1, 5, 9, 10, 15, 20};
		// int ar2[] = {2, 3, 8, 13};
		// merge(ar1, ar2, ar1.length, ar2.length);

		List list = new ArrayList();
		list.add(1);
		list.add("aaa");

		list.forEach(e -> System.out.println(e));

	}
}
