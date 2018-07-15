package com.leecode.interview;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	public static void main(String[] args){
		int[] test = {-1, 0, 1, 2, -1, -4};
		
		for(ArrayList list : threeSum(test))
		{
			System.out.println(list);
		}
	}
	
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num.length<3||num == null)
            return res;
        
        Arrays.sort(num);
        
        for(int i = 0; i <= num.length-3; i++){
            if(i==0||num[i]!=num[i-1]){//remove duplicate
                int low = i+1;
                int high = num.length-1;
                while(low<high){
                    int sum = num[i]+num[low]+num[high];
                    if(sum == 0){
                        ArrayList<Integer> unit = new ArrayList<Integer>();
                        unit.add(num[i]);
                        unit.add(num[low]);
                        unit.add(num[high]);
                        
                        res.add(unit);
                        
                        low++;
                        high--;
                        
                        while(low<high&&num[low]==num[low-1])//remove duplicate
                            low++;
                        while(low<high&&num[high]==num[high+1])//remove duplicate
                            high--;
                            
                    }else if(sum > 0)
                        high --;
                     else{
                    	 low ++;
                     }
                }
            }
        }
        return res;
    }
}
