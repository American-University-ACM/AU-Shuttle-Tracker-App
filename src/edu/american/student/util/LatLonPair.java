package edu.american.student.util;

import com.google.android.maps.GeoPoint;




public class LatLonPair 
{

	private LatLonPoint start;
	private LatLonPoint end;
	public LatLonPair(LatLonPoint latLonPoint, LatLonPoint latLonPoint2)
	{
		this.start=latLonPoint;
		this.end=latLonPoint2;
	}
	
	public LatLonPoint getStart()
	{
		return start;
	}
	
	public LatLonPoint getEnd()
	{
		return end;
	}
	

}