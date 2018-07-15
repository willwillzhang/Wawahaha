package com.oodesign.parkinglot;

public class Vehicle {
	
	private ParkingSpot parkingSpot;
	private VehicleType vehicleType;
	private int lisencePlate;
	
	public Vehicle(VehicleType vehicleType, int lisencePlate){
		this.vehicleType = vehicleType;
		this.lisencePlate = lisencePlate;
	}
	
	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}
	
	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public int getLisensePlate() {
		return lisencePlate;
	}

	public void setLisensePlate(int lisensePlate) {
		this.lisencePlate = lisensePlate;
	}

}
