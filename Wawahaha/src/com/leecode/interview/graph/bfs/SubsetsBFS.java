package com.leecode.interview.graph.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
求子集合，给定一个数列

dfs 递归分两层：
1.数列中的每个数字都是一个start node，这个最外面的一层
2.递归求每个start node的子集合
*/

public class SubsetsBFS {
	public static void main(String[] args){
		int nums[] = {1,2,3};
		for(List<Integer> list : new SubsetsBFS().subsetsBFS(nums))
		{
			System.out.println(list);
		}
	}
	
	public ArrayList<ArrayList<Integer>> subsetsBFS(int[] nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Queue<ArrayList<Integer>> queue = new LinkedList<ArrayList<Integer>>();
		
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++){
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(nums[i]);
			queue.add(new ArrayList<Integer>(temp));
			result.add(temp);
		}
		
		while(!queue.isEmpty()){
			ArrayList<Integer> parentLevelNode = queue.poll();
			//get the current position in the tree as a start node to do the BFS
			int pos = parentLevelNode.get(parentLevelNode.size()-1);
			
			for(int i=pos;i<nums.length;i++){
				ArrayList<Integer> tempList = new ArrayList<Integer>();
				tempList.addAll(parentLevelNode);
				tempList.add(nums[i]);
				queue.add(new ArrayList<Integer>(tempList));
				result.add(new ArrayList<Integer>(tempList));
			}
		}
		
		return result;
    }
   
}

