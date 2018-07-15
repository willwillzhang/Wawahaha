package com.javaapi.test;

import java.util.Arrays;

public class SortCharacterAndNumStr {
	
	public static void main(String[] args){
		String test = "BACD321YXW";
		
		System.out.println(sort_string(test));
	}

    static String sort_string(String str) {
        if(str == null)
            return "";
        
        char[] chars = str.toCharArray();
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i<chars.length; i++){
            //greater than 48, means that is a number
            if((int)chars[i]>48 && (int)chars[i]<=57){
                String numStr =  sortPartString(CharType.NUMBER, i, chars);
                result.append(numStr);
                i += numStr.length()-1;
                
            }else if((int)chars[i]>=65 && (int)chars[i]<=90){
                String charStr =  sortPartString(CharType.CHAR, i, chars);
                result.append(charStr);
                i += charStr.length()-1;
            }
        }
        
        return result.toString();
    }


    public static String sortPartString(CharType charType, int index, char[] chars){
        StringBuilder segmentStr = new StringBuilder();
        
        if(CharType.NUMBER == charType){
            for(int i = index; i<chars.length; i++){
                if((int)chars[i]>=48 && (int)chars[i]<=57){
                    segmentStr.append(chars[i]);
                }else{
                	break;
                }
            }
            
        }else if(CharType.CHAR == charType){
            for(int i = index; i<chars.length; i++){
                if((int)chars[i]>=65 && (int)chars[i]<=90){
                    segmentStr.append(chars[i]);
                }else{
                	break;
                }
            }
        }
        char[] result = segmentStr.toString().toCharArray();
        Arrays.sort(result);
        return new String(result);
    } 

    enum CharType{
        NUMBER, CHAR;
    }


}
