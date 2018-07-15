package com.lintcode;

import java.util.ArrayList;

public class Permutation {
	/**
	 * @param nums
	 *            : A list of integers.
	 * @return: A list of permutations.
	 */
	public ArrayList<ArrayList<Integer>> permute(int[] num) {

		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return rst;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(rst, list, num);
		return rst;
	}

	public void helper(ArrayList<ArrayList<Integer>> rst,
			ArrayList<Integer> list, int[] num) {
		if (list.size() == num.length) {
			rst.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < num.length; i++) {
			if (list.contains(num[i])) {
				continue;
			}
			list.add(num[i]);
			helper(rst, list, num);
 			list.remove(list.size() - 1);
		}

	}
	public static void main(String[] args){
		Permutation pe = new Permutation();
		int[] num = {1, 0,9,8,1};
		ArrayList<ArrayList<Integer>> results = pe.permute(num);
		
		for(ArrayList<Integer> rs : results){
			System.out.println(rs.toString());
		}
		
		ArrayList test = new ArrayList();
		results.addAll(test);
	}
}
