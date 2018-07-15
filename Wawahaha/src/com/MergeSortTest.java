package com;

public class MergeSortTest {

	private int[] array;
	private int[] mergeArray;
	private int length;
	
	
	public void sort(int[] inputArray){
		this.array = inputArray;
		this.length = inputArray.length;
		this.mergeArray = new int[this.length];
		sort(0, this.length-1);
	}
	
	
	public void sort(int low, int high){
		if(low<high){
			int middle = (high-low)/2;
			sort(low, middle);
			sort(middle+1, high);
			merge(low, middle, high);
		}
	}
	
	public void merge(int low, int middle, int high){
		
		for(int i=0;i<high;i++){
			mergeArray[i] = array[i];
		}
		
		int i = low;
		int j = middle +1;
		int k = low;
		
		while(i<middle &&j<high){
			
			if(mergeArray[i] <mergeArray[j+1]){
				array[k++] = mergeArray[i++];
			}else{
				array[k++] = mergeArray[j++];
			}
			
			while(i<=middle){
				array[k++] = mergeArray[i++];
			}
			
			while(j>=middle){
				
			}
		}
	}
}
