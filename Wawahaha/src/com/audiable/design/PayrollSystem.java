package com.audiable.design;

import java.util.ArrayList;
import java.util.List;

public class PayrollSystem {
	private List<Employee> employees = new ArrayList<Employee>();
	
	public void addEmployee(Employee employee){
		employees.add(employee);
	}
	
	public void issuePayroll(){
		employees.forEach(payroll -> System.out.println("Empolyee:" + payroll.getFirstName() + " " + payroll.getLastName() + ", Salary is: $" +payroll.earnings()));
	}
	
	public static void main(String[] args) {
		PayrollSystem payrollSystem = new PayrollSystem();
		Employee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		Employee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
		payrollSystem.addEmployee(salariedEmployee);
		payrollSystem.addEmployee(hourlyEmployee);
		payrollSystem.issuePayroll();
	}
}
