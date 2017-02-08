package com.bridgeLabz.clinic_proj;

import com.bridgeLabz.util.ClinicUtility;
import com.bridgeLabz.util.Utility;

/**
 * @author bridgeit Satyendra Singh
 *Clinique Management Programme. This programme is used to manage a list of Doctors associated with the Clinique. 
  This also manages the list of patients who use the clinique. It manages Doctors by Name, Id, Specialization and 
  Availability (AM,  PM or both). It manages Patients by Name, ID, Mobile Number and Age. The Program allows users 
  to search Doctor by name, id, Specialization or Availability. Also the programs allows users to search patient by 
  name, mobile number or id. The programs allows patients to take appointment with the doctor. 
  A doctor at  any availability time can see only 5 patients. If exceeded the user can take appointment for patient 
  at different date or availability time. Print the Doctor Patient Report. Also show which Specialization is popular 
  in the Clinique as well as which Doctor is popular. For Java Engineers use the following
	1.JDBC Connection Pooling to maintain Doctor, Patient and Appointment Info in the Database
	2.Use Log4J to Log Data
	3.Read Patient and Doctor Data from JSON File using File IO.
 */
public class ClinicManagement {

	public static void main(String[] args)
	{
		Utility u = new Utility();
		ClinicUtility cu = new ClinicUtility();
		System.out.println("Swaagat hai is faltu clinic me dosto...\nOr batao kaise ho...! Acche hi honge fir BC kyu aye \n"
				+ "chalo Ab agaye ho to..");
		System.out.println("Please enter your option ");
		System.out.println("\tpress 1 for save Doctor Details \n\tpress 2 for save Patient Details"
				+ "\n\tpress 3 for Search Doctor/Patient \n\tpress 4 for Take Appointment");
		int option = u.inputInteger();
		switch(option){
		
		case 1: try {
					cu.writeDoctor();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Doctors Details Saved");
		    break;
		case 2:  try {
					cu.writePatient();
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
				 System.out.println("Doctors Details Saved");
				 break;
				 
		case 3: try {
					cu.search();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("File not found check file path");
				}
				break;
		case 4 : 
				try {
					cu.appointment();
				} catch (Exception e) {
					e.printStackTrace();
				}break;
		
		default:
			System.out.println("This option is not valid. Please enter valid option");
			
		}
		/*try 
		{
			cu.writeDoctor();
			System.out.println("Doctors Details Saved");
			
			cu.writePatient();
			System.out.println("Patients Details Saved");
			
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Please Check your filepath.");
		}*/
	}

}
