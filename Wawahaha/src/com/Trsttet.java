package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Trsttet {

	static String[] friendlyWords(String[] input) {
        if(input == null || input.length ==0){
            return new String[]{};
        }
        Arrays.sort(input);
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, StringBuilder> map = new HashMap<>();
        ArrayList<Integer> memory = new ArrayList<Integer>();
        
        for(int i = 0; i< input.length; i++){
        	if(memory.contains(i))
        		continue;
            for(int j = i+1; j<input.length;j++){
                if(sortStr(input[i]).equals(sortStr(input[j]))){
                    if(map.get(input[i]) != null){
                        map.get(input[i]).append(" "+ input[j]);
                    }else{
                        StringBuilder sb = new StringBuilder();
                        sb.append(input[j]);
                        map.put(input[i], sb);
                    }
                    memory.add(j);
                }
            }
        }
       
        if(map.size() != 0){
            for(Entry<String, StringBuilder> entry : map.entrySet()){
                StringBuilder tempStr = new StringBuilder();
                tempStr.append(entry.getKey());
                tempStr.append(" ");
                tempStr.append(entry.getValue());
                result.add(tempStr.toString());
            }
        }
        
        Collections.sort(result);
        return result.toArray(new String[result.size()]);
    }

    static String sortStr(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    
    public static void main(String[] args){
    	
    	String[] arr = {"car", "cheating", "dale", "deal", "lead", "listen", "silent", "teaching"};

    	for(String str : Trsttet.friendlyWords(arr)){
    		System.out.println(str);
    	}
    	
    	/*Abc a = new Abc();
    	a.name = "haha";
    	
    	Abc b = new Abc();
    	b.name = "haha";
    	//b.name = "dong";
    	
    	HashMap<Abc, String> map = new HashMap<>();
    	map.put(a, "haha");
    	
    	System.out.println(map.get(b));*/
    }
}


class Abc{
	
	String name;
	
	@Override
	public int hashCode(){
		return 1;
	}
	
	@Override
	public boolean equals(Object o){
		Abc temp = (Abc)o;
		return temp.name.equals(this.name);
	}
}
