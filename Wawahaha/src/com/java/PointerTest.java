package com.java;

import java.util.HashMap;

public class PointerTest {

	static HashMap<Integer, User> userMap = new HashMap<Integer, User>();
	
	public static void main(String[] args){
		int userId = 1;
		
		int tweetId = 1;
		int tweetId1 = 2;
		
		if(!userMap.containsKey(userId)){
            User u = new User(userId);
            userMap.put(userId, u);
        }
        userMap.get(userId).post(tweetId);
        userMap.get(userId).post(tweetId1);
		
        Tweet head = userMap.get(userId).tweet_head; 
        
        while(head!= null){
        	System.out.println(head.id);
        	head = head.next; 
        }
	}
}

class Tweet {
	int id;
	Tweet next;

	public Tweet(int id) {
		this.id = id;
		next = null;
	}
}

class User{
	int id;
	Tweet tweet_head;
	
	public User(int id){
		this.id =id;
		this.tweet_head = null;
	}
	
	public void post(int id){
        Tweet t = new Tweet(id);
        //java pass by value, not reference. So, tweet_head pass a reference as a value to t.next, so the both point the same place 
        t.next=tweet_head; // pass reference as value, so t.next create a pointer to the object which tweet_head is pointing to.
        //all this is the refernece, not the 
        tweet_head=t;
        
    }
}