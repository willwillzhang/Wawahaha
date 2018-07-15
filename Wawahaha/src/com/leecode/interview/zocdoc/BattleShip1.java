package com.leecode.interview.zocdoc;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

enum Ship1 {
	Large, Medium, Small;
}

enum Orientation1 {
	Vertical, Horizontal;
}

class Coordinate1 implements Comparable<Coordinate1> {
	private int x;
	private int y;

	public Coordinate1(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Coordinate1 c) {
		if (this.x == c.x && this.y == c.y)
			return 0;
		return 1;
	}
}

class Board1 {
	int board[][] = new int[20][20];
	int remainingShip = 5;
	String playerName;
	int ship1 = 2;
	int ship2 = 2;
	int ship3 = 1;
	boolean gameOver = false;

	Set<Coordinate> ships = new HashSet<Coordinate>();

	public void placeShip(Ship s, int x, int y, Orientation o) throws Exception {
		
		Set<Coordinate> tmp = new TreeSet<Coordinate>();
		
		switch(s) {
		case Large:
			if(ship3 == 0)
				throw new Exception("cant place the large ship");
			
			if( o == Orientation.Horizontal ){
				if(x+5>19){
					throw new Exception("cannot place ship there");
				}
					
				for(int i = 0 ;i <5; i++){
					Coordinate newShip = new Coordinate(x+i, y);
					if(ships.contains(newShip)){
						throw new Exception("Over the ship");
					}
					tmp.add(newShip);
				}
			}else {
				
				if(y+5>19){
					throw new Exception("cannot place the ship");
				}
				
				for(int i = 0; i<5; i++){
					Coordinate newShip = new Coordinate(x, y+i);
					if(ships.contains(newShip))
						throw new Exception("cannot place over the ship");
					tmp.add(newShip);
				}
			}
			ships.addAll(tmp);
			tmp.clear();
			--ship3;
		case Medium:
			
		case Small:
		
		}
		
		
	}

	public boolean bombard(int x, int y, String playerName) {
		Coordinate c = new Coordinate(x,y);
		if(this.board[x][y] == 1){
			System.out.println("already hit, try again");
		}

		this.board[x][y] = 1;
		if(ships.contains(c)){
			System.out.println("hit the ship, lol.");
			ships.remove(c);
		}
		
		if(ships.size() == 0){
			System.out.println("You are the winner: " + playerName);
			this.gameOver = true;
		}
		
		return false;
	}

}

public class BattleShip1 {

}
