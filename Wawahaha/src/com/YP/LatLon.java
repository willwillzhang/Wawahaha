package com.YP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class LatLon {
	private final String filePath;
	private final Map<String, List<Location>> userLocations = new HashMap<String, List<Location>>();

	public LatLon(String filePath) {
		this.filePath = filePath;
	}

	public static void main(String[] args) {
		LatLon latlon = new LatLon("/Users/brianzhang/Documents/workspace/InterviewPath/src/com/YP/users.tsv");
		latlon.processFile();
		// System.out.println(latlon.numberOfUniqueUserIDs());
		// System.out.println(latlon.numberOfUniqueLatLon());
		// System.out.println(latlon.findFurthestDistanceUser());
		List<Location> topKClosestLocations = latlon.getClosestUserIDs(32.961807,-96.8292, 10);
		topKClosestLocations.forEach(e -> System.out.println(e.getLatitude() + "," + e.getLongitude()));
	}

	public Map<String, List<Location>> processFile() {

		try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				String[] strArr = sCurrentLine.split("\t");
				// filter the invalid line
				if (strArr.length == 3) {
					if (userLocations.containsKey(strArr[0]))
						userLocations.get(strArr[0])
								.add(new Location(Double.parseDouble(strArr[1]), Double.parseDouble(strArr[2])));
					else {
						ArrayList<Location> locations = new ArrayList<Location>();
						locations.add(new Location(Double.parseDouble(strArr[1]), Double.parseDouble(strArr[2])));
						userLocations.put(strArr[0], locations);
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return userLocations;
	}

	// A) Question:How many unique USERIDs are there?
	public int numberOfUniqueUserIDs() {
		HashSet<String> set = new HashSet<String>();
		userLocations.entrySet().stream().forEach(e -> set.add(e.getKey()));
		return set.size();
	}

	// B) Question:How many unique lat/lon pairs are there?
	public int numberOfUniqueLatLon() {
		HashSet<Location> set = new HashSet<Location>();
		userLocations.entrySet().stream().map(e -> e.getValue()).flatMap(locations -> locations.stream())
				.forEach(location -> set.add(location));
		return set.size();
	}

	// C) Question:For every UserID that has more than one location, what is the
	// UserID of the person who has the furthest distance between any two of
	// their locations?
	public String findFurthestDistanceUser() {
		// get the smallest distance of every userId
		double furtherestDistiance = Double.MIN_VALUE;
		String userId = null;
		for (Map.Entry<String, List<Location>> entry : userLocations.entrySet()) {
			List<Location> locations = entry.getValue();
			for (int i = 0; i < locations.size(); i++) {
				for (int j = i + 1; j < locations.size(); j++) {
					double temp = distance(locations.get(i).getLatitude(), locations.get(i).getLongitude(),
							locations.get(j).getLatitude(), locations.get(j).getLongitude());
					if (temp > furtherestDistiance) {
						furtherestDistiance = temp;
						userId = entry.getKey();
					}
				}
			}
		}
		return userId;
	}

	// D) Question:Build a method that takes in a lat/lon, and returns the top K
	// closest locations based on distance to the input lat/lon
	public List<Location> getClosestUserIDs(double lat, double lon, int how_many_to_return) {
		List<Location> result = new ArrayList<Location>();
		TreeMap<Double, Location> distances = new TreeMap<Double, Location>();
		userLocations.entrySet().stream().map(e -> e.getValue()).flatMap(locations -> locations.stream()).forEach(e -> {
			distances.put(distance(lat, lon, e.getLatitude(), e.getLongitude()),
					new Location(e.getLatitude(), e.getLongitude()));
		});
		int count = 0;
		for (Map.Entry<Double, Location> entry : distances.entrySet()) {
			if (count < how_many_to_return && entry.getValue().getLatitude() != lat
					&& entry.getValue().getLongitude() != lon) {
				result.add(entry.getValue());
				count++;
			}
		}

		return result;
	}

	public double distance(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344;

		return (dist);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts decimal degrees to radians : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts radians to decimal degrees : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}
