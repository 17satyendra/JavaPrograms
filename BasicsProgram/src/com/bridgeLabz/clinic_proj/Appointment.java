package com.bridgeLabz.clinic_proj;

import java.util.Date;

public class Appointment 
{
	String patientName;
	String doctorName;
	Date date;
	int noOfAppoint;
	public Appointment() 
	{
		
	}
	/**
	 * @return the patientName
	 */
	public String getPatientName() {
		return patientName;
	}
	/**
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	/**
	 * @return the doctorName
	 */
	public String getDoctorName() {
		return doctorName;
	}
	/**
	 * @param doctorName the doctorName to set
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the noOfAppoint
	 */
	public int getNoOfAppoint() {
		return noOfAppoint;
	}
	/**
	 * @param noOfAppoint the noOfAppoint to set
	 */
	public void setNoOfAppoint(int noOfAppoint) {
		this.noOfAppoint = noOfAppoint;
	}
	
}
