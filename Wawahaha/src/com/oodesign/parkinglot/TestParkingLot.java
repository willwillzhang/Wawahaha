package com.oodesign.parkinglot;

public class TestParkingLot {
	
	public static void main(String[] args){
		ParkingLotSingleton.initilize(100, 100, 100);
		
		Vehicle vehicle = new Vehicle(VehicleType.CAR, 19208271);
		ParkingLotSingleton.park(vehicle);
		ParkingLotSingleton.leave(vehicle);
	}
}
