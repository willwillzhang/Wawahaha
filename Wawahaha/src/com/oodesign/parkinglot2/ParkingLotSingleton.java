package com.oodesign.parkinglot2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ParkingLotSingleton {
	private static ParkingLotSingleton parkingLot = null;
	
	private static final int NUMBER_OF_SMALL_ParkingSpotS = 10;
    private static final int NUMBER_OF_COMPACT_ParkingSpotS = 10;
    private static final int NUMBER_OF_LARGE_ParkingSpotS = 10; 
    
    public Map<Integer, ParkingSpot> occupiedParkingSpots;
    private List<ParkingSpot> smallSpots;
    private List<ParkingSpot> compactSpots;
    private List<ParkingSpot> largeSpots;
    
    private ParkingLotSingleton(){
    	smallSpots = new LinkedList<>();
        compactSpots = new LinkedList<>();
        largeSpots = new LinkedList<>();
        occupiedParkingSpots = new HashMap<>();
        
        for (int i = 1; i <= NUMBER_OF_SMALL_ParkingSpotS; i++)
            smallSpots.add(new ParkingSpot(i, 1));

        for (int i = 1; i <= NUMBER_OF_COMPACT_ParkingSpotS; i++)
            compactSpots.add(new ParkingSpot(i, 2));

        for (int i = 1; i <= NUMBER_OF_LARGE_ParkingSpotS; i++)
            largeSpots.add(new ParkingSpot(i, 3));
    }
    
    public List<ParkingSpot> getSmallParkingSpots() {
        return smallSpots;
    }

    public List<ParkingSpot> getCompactParkingSpots() {
        return compactSpots;
    }

    public List<ParkingSpot> getLargeParkingSpots() {
        return largeSpots;
    }
    
    public static ParkingLotSingleton getInstance(){
    	if(parkingLot == null)
    		parkingLot = new ParkingLotSingleton();
    	
    	return parkingLot;
    }
	
}
