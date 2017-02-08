package com.bridgeLabz.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgeLabz.clinic_proj.Appointment;

/**
 * @author bridgeit Satyendra Singh
 * ClinicUtility class gives the utility Funtion for com.bridgeLabz.clinic_proj.ClinicManagement.
 * In this class Having several method name (writeDoctor, writePatient, search and Appointment etc);
 */
public class ClinicUtility 
{
	// Common detail
	private String name;
	private String id;
	// Doctor detail
	private String specz;
	private String avail;
	
	// Patient Detail
	private long mobNo;
	private int age;
	
	Utility u = new Utility();
	
	JSONObject appointlist = new JSONObject();
	JSONArray aList = new JSONArray();
	
	JSONObject doctor = new JSONObject();
	JSONObject patient = new JSONObject();
	
	JSONParser parser = new JSONParser();
	
	@SuppressWarnings("unchecked")
	public void writeDoctor() throws Exception
	{
		JSONArray doctorList=new JSONArray();
		
		System.out.println("Enter number of Doctor:");
		int n=u.inputInteger();
		
		for(int i=0;i<n;i++)
		{
			JSONObject dctr=new JSONObject();
			System.out.println("Enter Doctor Name:");
			name=u.inputString();
			
			dctr.put("Doctor Name:", name);
			System.out.println("Enter Doctor Id:");
			id = u.inputString();
			
			dctr.put("Doctor Id:", id);
			System.out.println("Enter Doctor's Specialization:");
			specz = u.inputString();
			
			dctr.put("Doctor Specialization:", specz);
			System.out.println("Enter Doctor Availability:");
			avail= u.inputString();
			
			dctr.put("Doctor Availability:", avail);
		
			doctorList.add(dctr);		
		}
		doctor.put("Doctor List:", doctorList);
		
		writeFile(doctor);
	}
	
	@SuppressWarnings("unchecked")
	public void writePatient() throws Exception
	{
		JSONArray patientList=new JSONArray();
		
		System.out.println("Enter number of Patient:");
		int n=u.inputInteger();
		
		for(int i=0;i<n;i++)
		{
			JSONObject ptnts=new JSONObject();
			
			System.out.println("Enter Patient Name:");
			name=u.inputString();
			ptnts.put("Patient Name:", name);
			
			System.out.println("Enter Patient Id:");
			id = u.inputString();
			ptnts.put("Patient Id:", id);

			System.out.println("Enter Patient's age:");
			age=u.inputInteger();
			ptnts.put("Patient's age:", age);

			System.out.println("Enter Patient's MobNum:");
			mobNo= u.inputLong();
			ptnts.put("Patient's MobNum:", mobNo);
			
			patientList.add(ptnts);		
		}
		patient.put("Patient List:", patientList);
		
		writeFile(patient);
	}
	public void writeFile(JSONObject object) throws Exception 
	{
		System.out.println("Enter file path");
		String path =u.inputString();
		try { 
			System.out.println("Writting JSON into file ..."); 
			FileWriter jsonFileWriter = new FileWriter(path);
				jsonFileWriter.write(object.toJSONString());
				jsonFileWriter.flush();
				jsonFileWriter.close(); 
				System.out.println("Data Added:");
		} 
		catch (IOException e) 
		{
			e.printStackTrace(); 
			Exception ex = new Exception("Something is wrong please try again..");
			throw ex;
		}
	}

	public void search() throws Exception 
	{
		System.out.println("Press 1 for Doctor\nPress 2 for Patient");
		int option = u.inputInteger();
		switch(option){
		case 1: searchDoctor();
				break;
		case 2: searchPatient();
				break;
		default: System.out.println("Invalid option");
		}
	}

	private void searchPatient() throws Exception
	{
		System.out.println("Press 1 for search by name\npress 2 for search by Id"
				+ "\nPress 3 for mobile number");
		int option = u.inputInteger();
		switch(option){
		case 1:searchByName();break;
		case 2:searchById();break;
		case 3:searchByNumber();break;
		}
	}

	private void searchByNumber() throws Exception 
	{
		System.out.println("Enter Patient's Mobile Number to be search: ");
		long mobileNumber = u.inputLong();
		int flag=0;
		try{
			JSONObject patientList = (JSONObject)parser.parse(new FileReader("/home/bridgeit/Desktop/patient.json"));
			JSONArray list = (JSONArray) patientList.get("Patient List:");
			
			for (int i = 0; i < list.size(); i++) 
			{
				JSONObject patient =(JSONObject) list.get(i);
				long temp = (long) patient.get("Patient's MobNum:");
				if(temp==mobileNumber)
				{
					System.out.println(patient.toString());
					flag=1;
				}
			}
			if(flag==0)
				System.out.println("Not found !!!!!");
		}catch(IOException | ParseException e){
			e.printStackTrace();
			Exception ex  = new Exception("Unable to read file"); 
			throw ex;
		}
	}

	private void searchById() throws Exception
	{
		System.out.println("Enter Patient's Id Number to be search: ");
		String id = u.inputString();
		int flag=0;
		try{
			JSONObject patientList = (JSONObject)parser.parse(new FileReader("/home/bridgeit/Desktop/patient.json"));
			JSONArray list = (JSONArray) patientList.get("Patient List:");
			
			for (int i = 0; i < list.size(); i++) 
			{
				JSONObject patient =(JSONObject) list.get(i);
				String temp = (String) patient.get("Patient Id:");
				if(temp.equals(id))
				{
					System.out.println(patient.toString());
					flag=1;
				}
			}
			if(flag==0)
				System.out.println("Not found !!!!!");
		}catch(IOException | ParseException e){
			e.printStackTrace();
			Exception ex  = new Exception("Unable to read file"); 
			throw ex;
		}
	}

	private void searchByName() throws Exception 
	{
		System.out.println("Enter Patient's Name to be search: ");
		String name = u.inputString();
		int flag=0;
		try{
			JSONObject patientList = (JSONObject)parser.parse(new FileReader("/home/bridgeit/Desktop/patient.json"));
			JSONArray list = (JSONArray) patientList.get("Patient List:");
			
			for (int i = 0; i < list.size(); i++) 
			{
				JSONObject patient =(JSONObject) list.get(i);
				String temp = (String) patient.get("Patient Name:");
				if(temp.equals(name))
				{
					System.out.println(patient.toString());
					flag=1;
				}
			}
			if(flag==0)
				System.out.println("Not found !!!!!");
		}catch(IOException | ParseException e){
			e.printStackTrace();
			Exception ex  = new Exception("Unable to read file"); 
			throw ex;
		}
	}
	private void searchDoctor() throws Exception 
	{
		System.out.println("Press 1 for search by name\npress 2 for search by Id"
				+ "\nPress 3 for Search by Specialization or Available");
		int option = u.inputInteger();
		switch(option){
		case 1:searchByDoctorName();break;
		case 2:searchByDoctorId();break;
		case 3:searchByNumAvail();break;
		default:System.out.println("Invalid Option");}
	}
	private void searchByNumAvail() throws Exception
	{
		System.out.println("Enter Doctor's Specialization to be search: ");
		String spec= u.inputString();
		int flag=0;
		try{
			JSONObject doctorList = (JSONObject)parser.parse(new FileReader("/home/bridgeit/Desktop/doctor.json"));
			JSONArray list = (JSONArray) doctorList.get("Doctor List:");
			
			for (int i = 0; i < list.size(); i++) 
			{
				JSONObject doctor =(JSONObject) list.get(i);
				String temp = (String) doctor.get("Doctor Specialization:");
				if(temp.equals(spec))
				{
					System.out.println(doctor.toString());
					flag=1;
				}
			}
			if(flag==0)
				System.out.println("Not found !!!!!");
		}catch(IOException | ParseException e){
			e.printStackTrace();
			Exception ex  = new Exception("Unable to read Doctor Specialization"); 
			throw ex;
		}
	}

	private void searchByDoctorId() throws Exception
	{
		System.out.println("Enter Doctor's Id to be search: ");
		String id = u.inputString();
		int flag=0;
		try{
			JSONObject doctorList = (JSONObject)parser.parse(new FileReader("/home/bridgeit/Desktop/doctor.json"));
			JSONArray list = (JSONArray) doctorList.get("Doctor List:");
			
			for (int i = 0; i < list.size(); i++) 
			{
				JSONObject doctor =(JSONObject) list.get(i);
				String temp = (String) doctor.get("Doctor Id:");
				if(temp.equals(id))
				{
					System.out.println(doctor.toString());
					flag=1;
				}
			}
			if(flag==0)
				System.out.println("Not found !!!!!");
		}catch(IOException | ParseException e){
			e.printStackTrace();
			Exception ex  = new Exception("Unable to read Doctor Id"); 
			throw ex;
		}
	}

	private void searchByDoctorName() throws Exception 
	{
		System.out.println("Enter Doctor's Name to be search: ");
		String name = u.inputString();
		int flag=0;
		try{
			JSONObject doctorList = (JSONObject)parser.parse(new FileReader("/home/bridgeit/Desktop/doctor.json"));
			JSONArray list = (JSONArray) doctorList.get("Doctor List:");
			
			for (int i = 0; i < list.size(); i++) 
			{
				JSONObject doctor =(JSONObject) list.get(i);
				String temp = (String) doctor.get("Doctor Name:");
				if(temp.equals(name))
				{
					System.out.println(doctor.toString());
					flag=1;
				}
			}
			if(flag==0)
				System.out.println("Not found !!!!!");
		}catch(IOException | ParseException e){
			e.printStackTrace();
			Exception ex  = new Exception("Unable to read Doctor name"); 
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	public void appointment() throws Exception 
	{
		
		
		int count1=0,count2=0;
		int index=0;
		String s = null;
		
		do {
			System.out.println("List of Doctor Name with Specialization and Availability"
					+ "\n1. Dr.Uma(child), timing- 10:30-12:30 \n2. Dr.Amit(heart), timing- 4:00pm-6:00pm");
			
				System.out.println("Enter respective number");
				int n = u.inputInteger();

				System.out.println("enter your Name");
				String name = u.inputString();

				switch (n) {
				case 1:
					if (count1 < 2) {

						JSONObject add = new JSONObject();
						add.put("Doctor Name", "Dr. Uma");
						add.put("Patient Name", name);
						aList.add(index, add);
						index++;
						count1++;

					} else {
						System.out.println("Today Doctor Not Available Try for next day.");
					}
					break;
				case 2:
					if (count2 < 2) {

						JSONObject add = new JSONObject();
						add.put("Doctor Name", "Dr. Amit");
						add.put("Patient Name", name);
						aList.add(index, add);
						index++;
						count2++;
						System.out.println("Appointment added");

					} else {
						System.out.println("Today Doctor Not Available Try for next day.");
					}
					break;
					
				default:
					System.out.println("Invalid option try again");
					break;
				}
			
			System.out.println("for Countinue press yes otherwise no");
			s = u.inputString();
		} while (s.equalsIgnoreCase("yes"));
		appointlist.put("appointlist", aList);
		writeFile(appointlist);
		
	}

	
}