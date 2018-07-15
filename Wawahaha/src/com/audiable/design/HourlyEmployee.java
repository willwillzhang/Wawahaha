package com.audiable.design;

public class HourlyEmployee extends Employee {

	private double wage;
	private double hours;

	public HourlyEmployee(String firstName, String lastName, String ssn, double wage, double hours) {
		super(firstName, lastName, ssn);
		setWage(wage);
		setHours(hours);
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage > 0 ? wage : 0.0;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours > 0 ? hours : 0.0;
	}

	@Override
	public double earnings() {
		return getHours() * getWage();
	}

	public String toString() {
		return String.format("hourly employee: %s: $%,.2f; %s: %,.2f", "hourly wage", getWage(),
				"hours worked", getHours());
	}

}
