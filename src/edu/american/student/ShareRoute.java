package edu.american.student;

import java.util.ArrayList;

import android.util.Log;

import edu.american.student.util.LatLonPair;
import edu.american.student.util.LatLonPoint;

/**
 * This holds all the info on Shared Route between Red and Blue
 * @author Cam Cook
 *
 */
public class ShareRoute 
{
	ArrayList<LatLonPoint> route = new ArrayList<LatLonPoint>();// route definitions
	ArrayList<LatLonPoint> busStops = new ArrayList<LatLonPoint>();// busStop definitions
	ArrayList<String> busStopInfo = new ArrayList<String>();//busStop info

	/**
	 * On init, populate stops and route
	 */
	public ShareRoute()
	{
		createBusStops();
		createRoute();
	}
	/**
	 * From an info string, take a best guess as to the bus info is describing
	 * @param info the info string
	 * @return the lat lon point of the bus stop that best describes it
	 */
	public LatLonPoint getBusFromInfo(String info)
	{
		//Forced fix
		if(info.startsWith("Nebraska Hall (Metrobus stop across from Nebraska"))
		{
			return busStops.get(0);
		}
		else if(info.startsWith("Van Ness (Metrobus stop on Nebraska Ave."))
		{
			return busStops.get(3);
		}
		else if (info.startsWith("Tenley Campus toward WCL"))
		{
			return busStops.get(2);
		}
		else if (info.startsWith("Van Ness toward WCL"))
		{
			return busStops.get(4);
		}
		
		int[] returnVals = new int[busStopInfo.size()];
		
		for(int i=0;i<busStopInfo.size();i++)
		{
			returnVals[i]=stringCompare(busStopInfo.get(i),info);
		}
		int smallestIndex =-1;
		int smallestVal = 1000000;
		for(int i=0;i<returnVals.length;i++)
		{
			if(returnVals[i]<smallestVal && returnVals[i]<5)
			{
				smallestIndex=i;
				smallestVal = returnVals[i];
			}
		}
		if(smallestIndex ==-1)
		{
			return null;
		}
		return busStops.get(smallestIndex);
	}
	
	/**
	 * returns the metro Icon point
	 * @return
	 */
	public LatLonPoint getMetroIcon()
	{
		return new LatLonPoint(38.948091080112015,-77.07910716533661);
	}
	
	/**
	 * From a location, descibe the bus stop there
	 * @param location the bus stop location
	 * @return the info of that bus stop
	 */
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
	
	/**
	 * populates bus stops and its info (order is important)
	 */
	public void createBusStops()
	{
		//TODO bug
		busStops.add(new LatLonPoint(38.93895799996236,-77.08491683006287));
		busStops.add(new LatLonPoint(38.9456587666782,-77.07915544509888));
		busStops.add(new LatLonPoint(38.94522486322879,-77.07975625991821));
		busStops.add(new LatLonPoint(38.94328895394465,-77.08104372024536));;
		busStops.add(new LatLonPoint(38.94299689407566,-77.08176255226135));
		
		busStopInfo.add("Nebraska Hall (Metrobus stop on Nebraska Ave. across from Nebraska Hall)");
		busStopInfo.add("Tenley Campus toward Metro (Metrobus stop on Nebraska Ave. across from Tenley Campus)");
		busStopInfo.add("Tenley Campus toward Campus (Nebraska Ave. NW at second driveway to Tenley Campus)");
		busStopInfo.add("Van Ness toward Metro (upon request)");
		busStopInfo.add("Van Ness toward Campus (upon request)");
	}
	
	
	/**
	 * Here as a place holder, Lets say White(Super) route is implemented<br>
	 * It would go here.
	 */
	public void createRoute()
	{
		
	}
	
	/**
	 * Returns the route definitions
	 * @return the route definitions
	 */
	public ArrayList<LatLonPair> returnRoute()
	{
		ArrayList<LatLonPair> toReturn= new ArrayList<LatLonPair>();
		for(int i=1;i<route.size();i++)
		{
			toReturn.add(new LatLonPair(route.get(i-1),route.get(i)));
		}
		return toReturn;
	}
	
	/**
	 * return the bus stop definitions
	 * @return the bus stop definitions
	 */
	public ArrayList<LatLonPoint> returnBusStops()
	{
		return busStops;
	}
	
	/**
	 * This method compares string a and string b and rates its closeness char-by-char
	 * @param a string a
	 * @param b string b
	 * @return the rating of the comparison
	 */
	public int stringCompare(String a, String b)
	{
		Log.e("size a",a.length()+"");
		Log.e("size b",b.length()+"");
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();
	
		int returnVal =0;
		if(aArr.length<= bArr.length)
		{
			for(int i=0;i<aArr.length;i++)
			{
				if(aArr[i] != bArr[i])
				{
					returnVal++;
				}
			}
		}
		else
		{
			for(int i=0;i<bArr.length;i++)
			{
				if(aArr[i] != bArr[i])
				{
					returnVal++;
				}
			}
		}
		return returnVal;
	}
}
