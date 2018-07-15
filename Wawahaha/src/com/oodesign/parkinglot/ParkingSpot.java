package com.oodesign.parkinglot;

public class ParkingSpot {
	
	private VehicleType placedVechicleType;
	private Vehicle placedVehile;
	private int parkingSpotNum;
	private boolean isAvaiable;
	
	public ParkingSpot(VehicleType vType, int num){
		this.placedVechicleType = vType;
		this.parkingSpotNum = num;
	}
	
	public VehicleType getVechicleType() {
		return placedVechicleType;
	}
	public void setVechicleType(VehicleType vechicleType) {
		this.placedVechicleType = vechicleType;
	}
	public int getNum() {
		return parkingSpotNum;
	}
	public void setNum(int num) {
		this.parkingSpotNum = num;
	}
	public boolean isAvaiable() {
		return isAvaiable;
	}
	public void setAvaiable(boolean isAvaiable) {
		this.isAvaiable = isAvaiable;
	}

	public Vehicle getVehile() {
		return placedVehile;
	}

	public void setVehile(Vehicle vehile) {
		this.placedVehile = vehile;
	}
	
}
