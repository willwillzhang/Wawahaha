package com.jpchase;

import java.util.ArrayList;
import java.util.List;


class Tuple<T1,T2>{
	T1 first;
	T2 second;
	
	public Tuple(T1 first, T2 second){
		this.first = first;
		this.second = second;
	}
	
	public T1 getFirst(){
		return this.first;
	}
	
	public T2 getSecond(){
		return this.second;
	}
}

public class JpMorganGetProfit {
	public static void main(String[] args){
		
		int[] arr = {-2, 1, 3, 4, -1, 2, 1, -5, 4};
		
		for(Integer i : getIndexOfMaxProfitRange(arr)){
			System.out.println(i);
		}
		
		System.out.println(getMaxProfit(arr));
		
	}
	
	public static List<Integer> getIndexOfMaxProfitRange(int[] arr){
		List<Integer> result = new ArrayList<Integer>();
		
		if( arr==null ){
			return result;
		}else if(arr.length == 1){
			result.add(0);
			result.add(0);
		}
		
		int start = 0;
		int end = 0; 
		int max = Integer.MIN_VALUE;
		
		int sum[] = new int[arr.length];
		
		for(int i=1; i<arr.length; i++){
			
			sum[i] = sum[i-1] + arr[i];
			
			if(arr[i] >= sum[i]){
				start=i;
				end=i;
				sum[i]=arr[i];
			}
			
			if(sum[i]>max){
				end = i;
				max = sum[i];
			}
		}
		
		result.add(start);
		result.add(end);
		
		return result;
	}
	
	public static int getMaxProfit(int[] arr){
		
		int profit = 0;
		
		if(arr==null){
			return 0;
		}
		int lowest = arr[0];
		for(int i = 0; i<arr.length; i++){
			int currProfit = arr[i] - lowest;
			if(currProfit < 0){
				lowest = arr[i];
			}
			profit = Math.max(profit, currProfit);
		}
		
		
		return profit;
	}
	
}
