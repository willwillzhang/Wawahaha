package com.capitalOne;

import java.util.Arrays;
import java.util.List;

public class FindLargestNumberFromList {

	public static int findLargestNumber(List<Integer> list) {

		if (list == null || list.size() == 0) {
			return 0;
		}

		int result = list.get(0);

		for (int i = 1; i < list.size(); i++) {

			if (list.get(i) > result)
				result = list.get(i);
		}

		return result;
	}
	
	public static void main(String[] args){
		System.out.println(findLargestNumber(Arrays.asList(11,34,22,44,99,11)));
	}
}
