package com.leecode.interview.graph.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * BFS is queue basis, DFS is stack basis.
 *
 */

public class MouseMaze {
	
	public String findCheese(Place startPoint){
		Queue<Place> queue = new LinkedList<Place>();
		queue.add(startPoint);
		
		HashMap<Place, StringBuilder> track = new HashMap<Place, StringBuilder>();
		
		String finalTrack = null;
		
		while(!queue.isEmpty() && finalTrack == null){
			
			for(int i =0; i<queue.size(); i++){
				Place sPoint = queue.poll();
				Place northPlace = sPoint.goNorth();
				Place southPlace = sPoint.goSouth();
				Place westPlace = sPoint.goWest();
				Place eastPlace = sPoint.goEast();
				
				validatePlace(sPoint, northPlace, queue, track, Orientation.North.getValue(), finalTrack);
				validatePlace(sPoint, southPlace, queue, track, Orientation.South.getValue(), finalTrack);
				validatePlace(sPoint, eastPlace, queue, track, Orientation.East.getValue(), finalTrack);
				validatePlace(sPoint, westPlace, queue, track, Orientation.West.getValue(), finalTrack);
			}
		}
		return finalTrack;
	}
	
	public void validatePlace(Place startPlace, Place nextPlace, Queue queue, HashMap<Place, StringBuilder> track, String orientation, String finalTrack){
		if(!nextPlace.isWall() && !nextPlace.isCheese()){
			queue.add(nextPlace);
			StringBuilder prePath = track.get(startPlace);
			track.put(nextPlace, prePath.append(orientation));
		}else if(nextPlace.isCheese()){
			StringBuilder prePath = track.get(startPlace);
			if(prePath != null)
				finalTrack = prePath.append(orientation).toString();
			else
				finalTrack = orientation;
		}
	}
	
	enum Orientation{
		
		North("N"), South("S"), East("E"), West("W");
		
		public String orientation;
		
		private Orientation(String orientation){
			this.orientation = orientation;
		}
		
		public String getValue(){
			return this.orientation;
		}
		
	}
}

interface Place {

	// Return the adjacent Place in the given direction
	public Place goNorth();
	public Place goSouth();
	public Place goEast();
	public Place goWest();

	// Returns true only for the special "Wall" place
	public boolean isWall();

	// Returns true only for the special "Cheese" place
	public boolean isCheese();
};


/*
A maze is a group of linked Places.  Each Place has a North, South, East, and West Place adjacent to it.  There are two special pre-defined Place's:  Place Wall represents a wall - the mouse can't go there.  

Place Cheese is ... cheese!   The connections between Places are symmetrical - if you start from any Place and go North and then South, you return to where you were.  

To simplify things, the maze has no closed loops - that is, if you start in any Place and follow any path, you eventually either hit a wall or find cheese -

you never come back to the Place you started unless you actually retrace your steps.

A mouse starts off in some Place and searches around for Cheese.  When it finds Cheese, it returns a set of directions - a string of the letters NSEW that lead from where it started to the Cheese.

The following framework defines the classes and functions.  Some other code not included here generates a maze by creating a bunch of Place's and linking them.  It then calls mouse(), 

passing some starting Place from the maze:

interface Place {

	// Return the adjacent Place in the given direction
	public Place goNorth();
	public Place goSouth();
	public Place goEast();
	public Place goWest();

	// Returns true only for the special "Wall" place
	public bool isWall();

	// Returns true only for the special "Cheese" place
	public bool isCheese();
};

class Mouse {
  public Mouse() {}

  // Return a string of the letters NSEW which, if used to traverse the
  // the maze from startingPoint, will reach a Place where isCheese() is
  // true.  Return null if you can't find such a path.
  public String findCheese(Place startingPoint) {
	... fill this in ...
  }
}

Implement findCheese().  You can add any fields or helper methods you need to Mouse.

Extra credit:  Eliminate the "no closed loops" restriction.  That is, change your code so that it works correctly even if there might be a path like SSNEEW that leads the mouse back to the Place it started from.
*/