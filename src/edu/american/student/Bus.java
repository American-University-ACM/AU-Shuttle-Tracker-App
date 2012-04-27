package edu.american.student;

import edu.american.student.util.LatLonPoint;

public class Bus 
{

	/*				int ADDRESS_NEXT=0;
				int TIME_CHECKED_NEXT =1;
				int LAT_NEXT =2;
				int LONGI_NEXT=3;
				int NAME_NEXT =4;
				int SPEED_NEXT= 5;
				int STATUS_NEXT =6;*/
	public LatLonPoint location;
	public int speed= -1;
	public String status="Unknown";
	public String nearestAddress="Unknown";
	public int busNumber =-1;
	
	public Bus()
	{
		
	}
	public LatLonPoint getLocation()
	{
		return location;
	}
	public String getStatus()
	{
		return status;
	}
	public String getNearestAddress()
	{
		return nearestAddress;
	}
	public int busNumber()
	{
		return busNumber;
	}
	public void setLocation(LatLonPoint busLocation) {
		// TODO Auto-generated method stub
		
	}
	public void setNearestAddress(String address) {
		// TODO Auto-generated method stub
		
	}
	public void setStatus(String status2) {
		// TODO Auto-generated method stub
		
	}
	public void setSpeed(String speed2) {
		// TODO Auto-generated method stub
		
	}
	public void setBusNumber(int parseInt) {
		// TODO Auto-generated method stub
		
	}
}
