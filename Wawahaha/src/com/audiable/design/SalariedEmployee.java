package com.audiable.design;

public class SalariedEmployee extends Employee {
	double weeklySalary;

	public SalariedEmployee(String firstName, String lastName, String ssn, double salary) {
		super(firstName, lastName, ssn);
		setWeeklySalary(salary);
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	@Override
	public double earnings() {
		return getWeeklySalary();
	}

	public String toString() {
		return String.format("salaried employee: %s: $%,.2f", "weekly salary", getWeeklySalary());
	}
}
