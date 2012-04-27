package edu.american.student;

import java.util.ArrayList;

import edu.american.student.util.LatLonPair;
import edu.american.student.util.LatLonPoint;

public class ShareRoute 
{
	ArrayList<LatLonPoint> route = new ArrayList<LatLonPoint>();
	ArrayList<LatLonPoint> busStops = new ArrayList<LatLonPoint>();
	ArrayList<String> busStopInfo = new ArrayList<String>();

	public ShareRoute()
	{
		createBusStops();
		createRoute();
	}
	
	public LatLonPoint getMetroIcon()
	{
		return new LatLonPoint(38.948091080112015,-77.07910716533661);
	}
	public String getBusInfo(LatLonPoint location)
	{
		int j=-1;
		for(int i=0;i<busStops.size();i++)
		{
			if(busStops.get(i).equals(location))
			{
				j=i;
			}
		}
		if(j !=-1)
		{
			return busStopInfo.get(j);
		}
		return "Unknown Stop";
	}
	
	public void createBusStops()
	{
		busStops.add(new LatLonPoint(38.93895799996236,-77.08491683006287));
		busStops.add(new LatLonPoint(38.9456587666782,-77.07915544509888));
		busStops.add(new LatLonPoint(38.94522486322879,-77.07975625991821));
		
		
		busStopInfo.add("Nebraska Hall (Metrobus stop on Nebraska Ave. across from Nebraska Hall)");
		busStopInfo.add("Tenley Campus toward Metro (Metrobus stop on Nebraska Ave. across from Tenley Campus)");
		busStopInfo.add("Tenley Campus toward Campus (Nebraska Ave. NW at second driveway to Tenley Campus)");
		busStopInfo.add("Van Ness toward Metro (upon request)");
		busStopInfo.add("Van Ness toward Campus (upon request)");
	}
	public void createRoute()
	{
		
	}
	public ArrayList<LatLonPair> returnRoute()
	{
		ArrayList<LatLonPair> toReturn= new ArrayList<LatLonPair>();
		for(int i=1;i<route.size();i++)
		{
			toReturn.add(new LatLonPair(route.get(i-1),route.get(i)));
		}
		return toReturn;
	}
	public ArrayList<LatLonPoint> returnBusStops()
	{
		return busStops;
	}
}
