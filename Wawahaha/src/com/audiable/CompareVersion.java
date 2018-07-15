package com.audiable; 

//The tricky part of the problem is to handle cases like 1.0 and 1. They should be equal.

public class CompareVersion {
	
	public static int compareVer(String v1, String v2){
		if(v1 == null || v2 == null){
			if(v1!=null){
				return 1;
			}else if(v2!=null){
				return -1;
			}
			return 0;
		}
		
		String[] v1Arr = v1.split("\\.");
		String[] v2Arr = v2.split("\\.");
		
		for(int i=0,j=0; i<v1Arr.length || j<v2Arr.length; i++, j++){
			int a = i<v1Arr.length ? Integer.valueOf(v1Arr[i]) : 0;
			int b = j<v2Arr.length ? Integer.valueOf(v2Arr[j]) : 0;
			
			if(a>b) return 1;
			if(a<b) return -1;
		}
		return 0;
	}
	
	public static void main(String[] args){
	
		String version1 = "1.0";
		String version2 = "1.";
		
		System.out.println(compareVer(version1, version2));
		
	}
}
