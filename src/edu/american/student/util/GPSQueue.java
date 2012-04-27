package edu.american.student.util;

import java.util.ArrayList;

public class GPSQueue 
{
	private ArrayList<LatLonPoint> lastKnownBusLocations= new ArrayList<LatLonPoint>();
	
	public GPSQueue()
	{
		
	}
	public ArrayList<LatLonPoint >getLastKnownLocations()
	{
		ArrayList<LatLonPoint> toReturn = new ArrayList<LatLonPoint>();
		for(int i=0;i<lastKnownBusLocations.size();i++)
		{
			toReturn.add(lastKnownBusLocations.get(i));
		}
		lastKnownBusLocations.clear();
		return toReturn;
	}
	public void updateLocations(ArrayList<LatLonPoint> updatedList)
	{
		for(int i=0;i<updatedList.size();i++)
		{
			lastKnownBusLocations.add(updatedList.get(i));
		}
	}
	
}
