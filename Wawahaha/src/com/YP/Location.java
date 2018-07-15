package com.YP;

public class Location {

	private double latitude;
	private double longitude;

	public Location(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public boolean equals(Object o) {
		if ((o instanceof Location) && ((Location) o).getLatitude() == this.latitude
				&& (((Location) o).getLongitude() == this.longitude)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + ((Double) this.latitude).hashCode();
		result = 31 * result + ((Double) this.longitude).hashCode();
		return result;
	}

}
