package com.oodesign.parkinglot;

import com.oodesign.parkinglot.parkingspotfactory.ParkingSpotFactory;

public class ParkingLotSingleton {
	
	private static ParkingSpot[] busParkingSpots = new ParkingSpot[]{};
	private static ParkingSpot[] carParkingSpots = new ParkingSpot[]{};
	private static ParkingSpot[] motorcycleSpots = new ParkingSpot[]{};
	private static Integer availableBusSpots = 0;
	private static Integer availableMotorSpots = 0;
	private static Integer availableCarSpots = 0;
		
	public static void initilize(int busSpotSize, int carSpotSize, int motorcycleSpotSize){
		busParkingSpots = createParkingSpot(busSpotSize, VehicleType.BUS);
		carParkingSpots = createParkingSpot(busSpotSize, VehicleType.CAR);
		motorcycleSpots = createParkingSpot(busSpotSize, VehicleType.MOTORCYCLE);
		availableBusSpots = busParkingSpots.length;
		availableMotorSpots = busParkingSpots.length;
		availableCarSpots = busParkingSpots.length;
	}
	
	private static ParkingSpot[] createParkingSpot(int parkingSpotSize, VehicleType vehicleType){
		ParkingSpot[] parkingSpots = new ParkingSpot[parkingSpotSize];
		for(int i = 0; i<parkingSpotSize; i++){
			parkingSpots[i] = ParkingSpotFactory.createVehicle(vehicleType, i);
		}
		return parkingSpots;
	}
	
	public static void park(Vehicle vehicle){
		if(vehicle.getVehicleType().equals(VehicleType.CAR)){
			ParkingSpot parkingSpot = findAvailableParkingSpot(vehicle.getVehicleType());
			vehicle.setParkingSpot(parkingSpot);
			availableCarSpots--;
			System.out.println("Parking an " + vehicle.getVehicleType() + " to number " + vehicle.getParkingSpot().getNum() + " in " + vehicle.getVehicleType() + " parkSpot");
			System.out.println("Currently, the available Car ParkingSpot number is " + availableCarSpots);
		}
	}
	
	public static void leave(Vehicle vehicle){
		if(vehicle.getVehicleType() == VehicleType.BUS){
			busParkingSpots[vehicle.getParkingSpot().getNum()].setAvaiable(true);
			availableBusSpots++;
		}else if(vehicle.getVehicleType() == VehicleType.CAR){
			carParkingSpots[vehicle.getParkingSpot().getNum()].setAvaiable(true);
			availableCarSpots++;
			System.out.println("An " + vehicle.getVehicleType() + " left the parklot, the number was " + vehicle.getParkingSpot().getNum());
			System.out.println("Currently, the available Car ParkingSpot number is " + availableCarSpots);
		}else if(vehicle.getVehicleType() == VehicleType.MOTORCYCLE){
			
		}
	}
	
	private static ParkingSpot findAvailableParkingSpot(VehicleType vehicleType){
		ParkingSpot parkingSpot = null;
		if(VehicleType.BUS == vehicleType){
			parkingSpot = checAvailableParkSpot(busParkingSpots, availableBusSpots);
		}
		else if(VehicleType.CAR == vehicleType){
			parkingSpot = checAvailableParkSpot(carParkingSpots, availableCarSpots);
		}
		else if(VehicleType.MOTORCYCLE == vehicleType){
			parkingSpot = checAvailableParkSpot(motorcycleSpots, availableMotorSpots);
		}
			
		return parkingSpot;
	}
	
	private static ParkingSpot checAvailableParkSpot(ParkingSpot[] parkSpots, int currAvailableSpots){
		int parkSlotNum = -1;
		if(currAvailableSpots == 0){
			return null;
		}else{
			++parkSlotNum;
			while(busParkingSpots[parkSlotNum].isAvaiable()){
				parkSlotNum++;
			}
			busParkingSpots[parkSlotNum].setAvaiable(false);
			currAvailableSpots--;
			
			return busParkingSpots[parkSlotNum];
		}
	}
	
}
