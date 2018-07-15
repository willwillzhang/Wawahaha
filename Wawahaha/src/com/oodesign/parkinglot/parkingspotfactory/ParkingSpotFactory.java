package com.oodesign.parkinglot.parkingspotfactory;

import com.oodesign.parkinglot.ParkingSpot;
import com.oodesign.parkinglot.VehicleType;

public class ParkingSpotFactory {
	
	public static ParkingSpot createVehicle(VehicleType vehicleType, int num){
		
		ParkingSpot parkingSpot = null;
		
		if(vehicleType == VehicleType.BUS){
			parkingSpot = new ParkingSpot(vehicleType, num);
		}else if(vehicleType == VehicleType.CAR){
			parkingSpot = new ParkingSpot(vehicleType, num);
		}else if(vehicleType == VehicleType.MOTORCYCLE){
			parkingSpot = new ParkingSpot(vehicleType, num);
		}
		
		return parkingSpot;
	}
	
}