package com.zocdoc;

import java.util.List;
import java.util.Map;

public class FindDistanceBetweenTwoActor {

	public void findDistance(Map<String, List<String>> actorToMovies, Map<String, List<String>> movieToActors, String actorA, String actorB){
		
		List<String> moviesA = actorToMovies.get(actorA);
		List<String> moviesB = actorToMovies.get(actorA);
		
		int distance = 0;
		
		if(!compare(moviesA, moviesB)){
			
			for(String movie : moviesA){
				
				List<String> actors = movieToActors.get(movie);
				
				if(!actors.contains(actorB)){
					
					for(String actor : actors){
						
					}
				}
			}
		}
		
	}
	/*
	public int helper(String targetActor, List<String> movies,  Map<String, List<String>> actorToMovies, Map<String, List<String>> movieToActors, int distance){
		
		distance++;
		
		for(String movie : movies){
			List<String> actors = movieToActors.get(movie);
			if(actors.contains(targetActor))
				return distance;
			
			else{
				for(String actor: actors){
					List<String> submovies = actorToMovies.get(actor);
					

				}
			}
				
		}

	}
	*/
	
	public boolean compare(List<String> a, List<String> b){
		boolean contains = false;
		
		for(String movie : a){
			if(b.contains(movie))
				contains = true;
		}
		
		return contains;
	}
}
