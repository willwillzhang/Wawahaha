package com.systemdesign.Payroll;
import java.io.*;
public class Payroll {
   public static void main(String args[])throws IOException{

	boolean notExists = true;

while(notExists == true) {
	//objects
	FileInputStream fstream = new FileInputStream("Employee.txt");
	DataInputStream in = new DataInputStream(fstream);
	BufferedReader textReader = new BufferedReader(new InputStreamReader(in));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	//Declarations
	String str = "", UserInput = "", tmp = "";
	String empcode = "", empname = "", emplevel = "";
	double emprate = 0;
	int ctr = 0;
	String timeIn = "", timeOut = "", holiday = "", overtin = "", overtout = "";
	double totalHours = 0, hours = 0, minutes = 0, tmpTime = 0, late = 0, undertime = 0, overHours = 0, overMinutes = 0;
	double salary = 0, overSal = 0, tmpSal = 0, regular = 0;
	double tmpLate = 0, tmpHour = 0, tmpUndertime = 0;
	


	System.out.print("Enter Employee Code : ");
	UserInput = br.readLine();

	//loop through the text file
	while( (str = textReader.readLine()) != null ) {
		if ( str.equalsIgnoreCase(UserInput) ) {
		   empcode = UserInput;
                   //found the userinput, store the details now
		   while( (tmp = textReader.readLine()) != null) {
		   	//lets put everyline into a variable for reference use
			switch(ctr) {
				case 0:
					empname = tmp;
					break;
				case 1:
					emplevel = tmp;
					break;
				case 2:
					emprate = Double.parseDouble(tmp);
					break;
			}
			ctr++;

		   }

		}
		//System.out.println(str);
	}

	System.out.println();
	System.out.println();

	//check if record exists
	if( !(empcode.equalsIgnoreCase("")) ) {
		//display the record if it exists
		System.out.println("-------------------Employee Details---------------------------");
		System.out.println("Name of the Employee : " + empname);
		System.out.println("Employee Code : " + empcode);
		System.out.println("Employee Level : " +emplevel);
		System.out.println("Employee Rate : " + emprate);
		
			//enter for time in and time out
			String CurrentDay = "";
			int ctr2 = 1;
			while(ctr2 <= 5){
				switch(ctr2) {
				case 1:
					CurrentDay = "Monday";
					break;
				case 2:
					CurrentDay = "Tuesday";
					break;
				case 3:
					CurrentDay = "Wednesday";
					break;
				case 4:
					CurrentDay = "Thursday";
					break;
				case 5:
					CurrentDay = "Friday";
					break;
				}
				System.out.println();
				System.out.println();
				
				//ask for time in and time out for regular and overtime
				//also ask if today is holiday
				System.out.print("Enter Time In for " + CurrentDay + " : ");
				timeIn = br.readLine();
				System.out.print("Enter Time Out for " + CurrentDay + " : ");
				timeOut = br.readLine();
				System.out.print("Is today holiday? [y/n] : ");
				holiday = br.readLine();
				System.out.print("Enter Time In for Over Time : ");
				overtin = br.readLine();
				System.out.print("Enter Time Out for Over Time : ");
				overtout = br.readLine();
				
				//split the hour and minute
				String tin[] = timeIn.split(":");
				String tout[] = timeOut.split(":");
				
				
				//time calculation
				hours += ( Double.parseDouble(tout[0]) - Double.parseDouble(tin[0]) ) >= 9 ? 8 : Double.parseDouble(tout[0]) - Double.parseDouble(tin[0]);
				tmpTime = Double.parseDouble(tout[0]) - Double.parseDouble(tin[0]);
				tmpHour = ( Double.parseDouble(tout[0]) - Double.parseDouble(tin[0]) ) >= 9 ? 8 : Double.parseDouble(tout[0]) - Double.parseDouble(tin[0]);
				
				//minute late and under time calculation
				if ( tmpTime <= 9 ) {
					late += Double.parseDouble(tin[1]);
					tmpLate = Double.parseDouble(tin[1]);
				}
				
				if ( Double.parseDouble(tout[0]) < 17 ) {
					undertime += 60 - Double.parseDouble(tout[1]);
					tmpUndertime = 60 - Double.parseDouble(tout[1]); 
				}
				
				
				//salary rate calculation
				if ( holiday.equalsIgnoreCase("y") ) {
					tmpSal = (emprate / 8) * 1.1;
					tmpTime = (( (tmpHour*60) - (tmpLate + tmpUndertime) ) / 60);
					hours -= tmpTime;
					overHours += (( (tmpHour*60) - (tmpLate + tmpUndertime) ) / 60);
					overSal += tmpSal * tmpTime;
				} else {
					tmpSal = emprate / 8;
					tmpTime = (( (tmpHour*60) - (tmpLate + tmpUndertime) ) / 60);
					salary += tmpSal * tmpTime;
					//System.out.println(salary + " = " + tmpSal * tmpHour + " " + tmpLate + " " + tmpUndertime + " ");
				}
				
				//if there is overtime	
				if ( !( overtin.equalsIgnoreCase("00:00") || overtin.equalsIgnoreCase("") ) ) {
					String ovin[] = overtin.split(":");
					String ovout[] = overtout.split(":");
					
					double tmp1 = 0;
					double tmp2 = 0;
					double minTmp = 0;
						
						tmp1 = Double.parseDouble(ovin[0]) <= 17 ? 17 : Double.parseDouble(ovin[0]);
						tmp2 = Double.parseDouble(ovout[0]) <= 20 ? 20 : 20;
						minTmp = Double.parseDouble(ovin[1]) + Double.parseDouble(ovout[1]);
						
						if ( (tmp2 - tmp1) <= 3 && tmp2 - tmp1 > 0) {
							overMinutes = ((tmp2 - tmp1) * 60) - minTmp;
							overHours += overMinutes/60;
							double overTmp = overMinutes/60;
							double overRate = (emprate / 8) * 1.1;
							overSal += overRate * overTmp;
						}
				}
		
				ctr2++;
			}
			
		System.out.print("Enter Date Covered : " );
		String covered = br.readLine();
		minutes += (hours*60) - (late + undertime);
		totalHours = minutes/60;
		
		System.out.println();
		
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println("Name of the Employee : " + empname);
		System.out.println("Employee Code : " + empcode);
		System.out.println("Employee Level : " +emplevel);
		System.out.println("Employee Rate : " + emprate);
		System.out.println("-------------------------------------------");
		System.out.println("Date Covered : " + covered);
		System.out.println("Total Hours : " + totalHours);
		System.out.println("Overtime : " + overHours);
		System.out.println("Regular Income : " + salary );
		System.out.println("Overtime Income : " + overSal );
		System.out.println("Gross Income : " + (salary + overSal) );
		System.out.println("Deductions");
		
		//tax and gsis deduction computation
		double tax = ((salary + overSal) * .10);
		double gsis = 0;
		
		if( emplevel.equalsIgnoreCase("Level 1") ) {
			gsis = (salary + overSal) * .01;
		} else if ( emplevel.equalsIgnoreCase("Level 2") ) {
			gsis = (salary + overSal) * .015;
		} else {
			gsis = (salary + overSal) * 0.02;
		}
		
		System.out.println("\t* Tax : " + tax);
		System.out.println("\t* GSIS : " + gsis);
		System.out.println("Net Income : " + (( (salary + overSal) - (tax + gsis) ) + 500) );
		
		System.out.println("-------------------------------------------");

		notExists = false;
	
	} else { 
		System.out.println("-------------------Record Doesn't Exists---------------------------");
		notExists = true;
	}
	

      }	

   }

}