package edu.american.student.util;





/**
 * Simply holds two lat longs
 * @author cam
 *
 */
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
