package com.oodesign.parkinglot2;

public class Vehicle {

	private final int size;
	private final int lisense;
	private ParkingLotSingleton parkingLot;

	public Vehicle(int size) {
		this.size = size;
		this.lisense = this.hashCode();
		this.parkingLot = ParkingLotSingleton.getInstance();
	}

	private ParkingSpot findSpot() {
		ParkingSpot spot = null;

		switch (this.size) {
		case 1:
			spot = parkingLot.getSmallParkingSpots().remove(0);
			break;
		case 2:
			spot = parkingLot.getCompactParkingSpots().remove(0);
			break;
		case 3:
			spot = parkingLot.getLargeParkingSpots().remove(0);
			break;
		default:
			spot = null;
		}
		return spot;
	}

	public void park() {
		ParkingSpot spot = findSpot();
		if (spot != null){
			parkingLot.occupiedParkingSpots.put(this.lisense, spot);
			spot.occupy(this);
		}
	}
	
	public void leave() {
        ParkingSpot spot = parkingLot.occupiedParkingSpots.remove(this.lisense);
        spot.release();
        switch (this.size) {
        case 1:
            parkingLot.getSmallParkingSpots().add(spot);
            break;
        case 2:
        	parkingLot.getCompactParkingSpots().add(spot);
        	 break;
        case 3:
        	parkingLot.getLargeParkingSpots().add(spot);
        	 break;
        }
    }
}
