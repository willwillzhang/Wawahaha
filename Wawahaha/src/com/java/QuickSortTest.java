package com.java;

public class QuickSortTest {

	public void sort(int[] inputArr) {
		if (inputArr == null || inputArr.length == 0)
			return;

		int low = 0;
		int high = inputArr.length - 1;

		quicksort(inputArr, low, high);
	}

	public void quicksort(int[] arr, int low, int high) {
		if (low >= high)
			return;

		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		int i = low, j = high;

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		if (low < j)
			quicksort(arr, low, j);

		if (high > i)
			quicksort(arr, i, high);
	}

}
