package com.leecode.interview.graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class PermutationDFS {
	
	public static void main(String[] args){
		int nums[] = {1,2,3};
		for(List<Integer> list : new PermutationDFS().permute(nums))
		{
			System.out.println(list);
		}
	}
	
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return rst; 
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        //
        helper(rst, list, num);
        return rst;
   }
   //DFS算法的体现，当DFS到了［1，2，3］，remove掉［3］，回溯到［1，2］，再次DFS，发现没有组合，继续remove［2］
  //剩下［1］，再次DFS，加入［3］，变成［1，3］，
   public void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list, int[] num){
       //递归出口
	   if(list.size() == num.length) {
           rst.add(new ArrayList<Integer>(list));
           return;
       }
       
       //把［1］开头，［2］开头， ［3］开头的结果分别加入到rst中
       for(int i = 0; i<num.length; i++){
           if(list.contains(num[i])){
               continue;
           }
           list.add(num[i]);		//把［1］加入到［］，变成［1］开头
           							//DFS，把2加入，变成［1，2］开头
           //继续DFS（v，agj，s）－>把以s开头的加入到res中
           //eg. 把［1］开头加入到res中
           helper(rst, list, num); 
           //res->{1,2,3}, back to [1,2], remove[2], add [3], search ->take [1,3] as start, get [1,3,2]
           list.remove(list.size() - 1); // look back upon, remove the last node of current path. Recursive process here share the variable "path".
           								 // so, remove the last node of current path to construct a backtracking path that is shared and used by branch recursion.
       }
       
   }

  /* recursive process
   1
   12
   123
   1 ->remove 2
   13
   132
   */
}
