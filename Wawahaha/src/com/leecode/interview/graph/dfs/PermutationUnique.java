package com.leecode.interview.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
http://www.lintcode.com/problem/permutations-ii/
Given a collection of numbers that might contain duplicates, return all possible unique permutations. 
For example, 
[1,1,2] have the following unique permutations: 
[1,1,2], [1,2,1], and [2,1,1].
*/
public class PermutationUnique {
	public static void main(String[] args){
		int nums[] = {1,2,2,3};
		List<ArrayList<Integer>> result = new PermutationUnique().permuteUnique(nums);
		System.out.println("count is: " + result.size());
		for(List<Integer> list : result)
		{
			System.out.println(list);
		}
	}
	
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return result;
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        
        Arrays.sort(num);
        helper(result, list, visited, num);
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, boolean[] visited, int[] num) {
        if(list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < num.length; i++) {
        	//去除重复
            if (visited[i] || (i != 0 && num[i] == num[i - 1] && visited[i - 1])){
                continue;
        /*
            visited[i-1] == true, eg. [1,2(1),2(2)], [1,2(2),2(1)], 
            we take the first sequence of duplicate 2 as the correct answer,
			so first 2 must be visited, otherwise like the second sequence that
			access the second the 2 firstly is wrong answer.
        */
            }
            visited[i] = true;
            list.add(num[i]);
            helper(result, list, visited, num);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }  
    
    
    
}
