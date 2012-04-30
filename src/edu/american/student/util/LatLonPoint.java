package edu.american.student.util;

import com.google.android.maps.GeoPoint;

/**
 * This class allows you to use lat long instead of google's bullshit
 * @author Cam Cook
 *
 */
public class LatLonPoint extends GeoPoint
{

	    public LatLonPoint(double latitude, double longitude) {
	        super((int) (latitude * 1E6), (int) (longitude * 1E6));
	    }
	
}
