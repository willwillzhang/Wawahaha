package com.leecode.interview.graph.dfs;

/*
求子集合，给定一个数列

dfs 递归分两层：
1.数列中的每个数字都是一个start node，这个最外面的一层
2.递归求每个start node的子集合
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public static void main(String[] args){
		int nums[] = {1,2,3};
		for(List<Integer> list : new Subsets().subsets(nums))
		{
			System.out.println(list);
		}
	}
	
	public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.length==0)
            return result;
        ArrayList<Integer> list =  new ArrayList<Integer>(); 
        Arrays.sort(nums);
        helper(result, list, nums, 0);
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> result,
                        ArrayList<Integer> list,
                        int nums[],
                        int pos)
    {
        result.add(new ArrayList<Integer>(list));
        //template
        for(int i = pos; i<nums.length; i++){  //每个数字都是一个start node, 求子集合
        	if(i!=0 && nums[i] == nums[i-1])	//	nums[i] == nums[i-1]   1. the num[i] is not first time occurred, which is second time occurred, so need to remove it.
        			continue;					//	i != 0  means  2. i is not the first num that also means is not first time occurred
            list.add(nums[i]);
            helper(result, list, nums, i+1); //以list作为一个新的start node继续递归，求子集合
            list.remove(list.size()-1);
        }
      
    }
    
    public void helper1(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] nums, int pos){
    	
    	result.add(new ArrayList<Integer>(list));
    	
    	for(int i=pos; i<nums.length; i++){
    		if(i==0 && nums[i] == nums[i-1])
    			continue;
    		
    		list.add(nums[i]);
    		helper1(result, list, nums, i+1);
    		list.remove(list.size()-1);
    	}
    }
}
