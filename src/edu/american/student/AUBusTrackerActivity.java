package edu.american.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import edu.american.student.util.HTTPObject;
import edu.american.student.util.LatLonPair;
import edu.american.student.util.LatLonPoint;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

public class AUBusTrackerActivity extends MapActivity 
{
	private boolean jamesServer=false;
	public LatLonPoint clientLocation ;
	private Location loc;
	private LocationListener locationListener;
	private LocationManager locationManager;
	private HTTPObject httpObject;
	private ArrayList<String> busXMLResponses= new ArrayList<String>();
	private ArrayList<String> busXMLResponses2 = new ArrayList<String>();
	private ArrayList<String> busesOnRoutes= new ArrayList<String>();
	private ArrayList<Bus> buses = new ArrayList<Bus>();
	private BlueRoute bRoute = new BlueRoute();
	private RedRoute rRoute = new RedRoute();
	private ShareRoute sRoute = new ShareRoute();
	private final int UPDATE_BUS_ICONS= 0;
	private final int UPDATE_USER_ICON =1;
	private final int DISTANCE_THRESHOLD =550;
	private String ROUTE_SHOWN="blue";
	private boolean displayRedRoute =true;
	private boolean displayBlueRoute = true;
	private Context context;
	private MapView mapView;
	private Dialog dialog;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1);
        context=this;
        getClientLocation();
        setupMapView();
        setupMenuBar();
        try 
        {
			runBusLocationListener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void setUpGrad(int id, int start, int end)
    {
	    View layout = findViewById(id);

	    GradientDrawable gd = new GradientDrawable(
	            GradientDrawable.Orientation.TOP_BOTTOM,
	            new int[] {start,end});
	    gd.setCornerRadius(0f);

	    layout.setBackgroundDrawable(gd);
    }
    
    public void displayStops(View v)
    {
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle("Select A Stop");

    	ListView modeList = new ListView(this);
    	String[] stringArray = {"null"};
    	if(displayRedRoute)
    	{
    		stringArray= new String[]{
    				"Massachusetts Ave. (Metrobus stop on Massachusetts Ave. across from the Katzen Arts Center)",
    				"Katzen (Metrobus stop on Massachusetts Ave. in front of Katzen Arts Center) - Admissions Green Room at the Katzen Arts Center Stop",
    				"WCL (side of law school on 48th St.)",
    				"Nebraska Hall (Metrobus stop on Nebraska Ave. across from Nebraska Hall)",
    				"Tenley Campus toward Metro (Metrobus stop on Nebraska Ave. across from Tenley Campus)",
    				"Tenleytown Metro Station (40th St. across from Tenleytown Metro station)",
    				"Tenley Campus toward WCL (Nebraska Ave. NW at second driveway to Tenley Campus)",
    				"Van Ness toward Metro (upon request)",
    				"Van Ness toward WCL (upon request)",
    				"Yuma St. (Metrobus stop at 49th and Yuma Sts.)"};
    		
    	}
    	if(displayBlueRoute)
    	{
        	stringArray = new String[] {"Nebraska Hall (Metrobus stop across from Nebraska Hall)",
            		"Tenley Campus toward Metro (Metrobus stop on Nebraska Ave. across from Tenley Campus)",
        			"Tenley Campus toward Campus (Nebraska Ave. NW at second driveway to Tenley Campus)",
                    "Van Ness (Metrobus stop on Nebraska Ave. NW after crossing Van Ness St., by request only)",
        			"Letts/Anderson Halls (South Campus)",
                    "Kogod",
        			"Nebraska Hall (Metrobus stop on Nebraska Ave. before Ward Circle) - Admissions Green Room at the Katzen Arts Center Stop)",
                    "Ward Building (Metrobus stop on Nebraska Ave. outside of Ward Building)" ,
        			"Brandywine (Brandywine and 40th Sts. NW, by request only)",
                    "Tenleytown Metro Station (Albemarle and 40th Sts. NW)"};
    	}
    	if(displayBlueRoute && displayRedRoute)
    	{
    		stringArray= new String[]{
            		"Blue/Red Route: Nebraska Hall (Metrobus stop across from Nebraska Hall)",
            		"Blue/Red Route: Tenley Campus toward Metro (Metrobus stop on Nebraska Ave. across from Tenley Campus)",
            		"Blue/Red Route: Tenley Campus toward Campus (Nebraska Ave. NW at second driveway to Tenley Campus)",
            		"Blue/Red Route: Van Ness (Metrobus stop on Nebraska Ave. NW after crossing Van Ness St., by request only)",
            		"Blue Route: Letts/Anderson Halls (South Campus)",
               		"Blue Route: Kogod",
               		"Blue Route: Nebraska Hall (Metrobus stop on Nebraska Ave. before Ward Circle) - Admissions Green Room at the Katzen Arts Center Stop)",
            		"Blue Route: Ward Building (Metrobus stop on Nebraska Ave. outside of Ward Building)",
            		"Blue Route: Brandywine (Brandywine and 40th Sts. NW, by request only)",
            		"Blue Route: Tenleytown Metro Station (Albemarle and 40th Sts. NW)",
            		"Red Route: Massachusetts Ave. (Metrobus stop on Massachusetts Ave. across from the Katzen Arts Center)",
            		"Red Route: Katzen (Metrobus stop on Massachusetts Ave. in front of Katzen Arts Center) - Admissions Green Room at the Katzen Arts Center Stop",
            		"Red Route: WCL (side of law school on 48th St.)",
            		"Red Route: Tenleytown Metro Station (40th St. across from Tenleytown Metro station)",
					"Red Route: Yuma St. (Metrobus stop at 49th and Yuma Sts.)"};
    	}
    	ArrayAdapter<String> modeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, stringArray);
    	modeList.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3)
			{
				//doesnt understand the shared routes
				Log.e("onItemClick",arg2+"");
				String a = (String)arg0.getItemAtPosition(arg2);
				try
				{
					a=a.split(": ")[1];
					Log.e("new a",a);
				}catch(Exception e)
				{
					
				}
				LatLonPoint routePoint=sRoute.getBusFromInfo(a);
				if(displayRedRoute && !displayBlueRoute)
				{
					if(routePoint == null)
					{
						routePoint=rRoute.getBusFromInfo(a);
					}
				}
				if(displayBlueRoute && !displayRedRoute)
				{
					if(routePoint == null)
					{
						routePoint=bRoute.getBusFromInfo(a);
					}
				}
				if(displayBlueRoute && displayRedRoute)
				{
					if(routePoint ==null)
					{
						
						routePoint = bRoute.getBusFromInfo(a);
					}
					if(routePoint == null)
					{
						routePoint= rRoute.getBusFromInfo(a);
					}
				}

				if(routePoint != null)
				{
		        	MapController mapController = mapView.getController();
		        	mapController.setCenter(routePoint);
		        	dialog.dismiss();
				}

				
			}});
    	modeList.setAdapter(modeAdapter);
    	builder.setView(modeList);

    	dialog = builder.create();

    	dialog.show();


    }
    public void displayAbout(View v)
    {
		AlertDialog.Builder adb= new AlertDialog.Builder(this);
		adb.setMessage("AU Shuttle Tracker\n" +
				"\n" +
				"Made by :\n" +
				"\tAmerican University Association for Computing Machinery Team\n\n" +
				"Android Development:\n" +
				"\tCameron Cook (CS '13) \n" +
				"\t\tcam.cook@linux.com\n\n" +
				"Server-side Development:\n"  +
				"\tJames Matthews (CS '14) \n" +
				"\t\tjfmatt8067@gmail.com\n\n" +
				"Graphic Design:\n" +
				"\tAlly Palanzi (Graphic Design/CS '14) \n" +
				"\t\tap4332b@student.american.edu\n\n" +
				"\tUna Kravets (Graphic Design/CS '14) \n" +
				"\t\tuk1522a@student.american.edu\n\n" +
				"License:\n" +
				"\tAndroid App- GNU Public License v2 (open source)\n" +
				"\tServer-side- GNU Public License v2 (open source)\n" +
				"\tIcons/Graphics- Creative Commons Share-alike License (copyleft, noncommerical)\n\n" +
				"Code:\n" +
				"\tGitHub: https://github.com/Ccook/AU-Shuttle-Tracker-App/");
		adb.setTitle("About AU Shuttle Tracker");
		adb.setPositiveButton("OK", null);
		adb.show();
    }
    private Location getLocation() 
    {

			locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);

            
            return loc;
    }

    public void displayNearby(View v)
    {
    	try
    	{
    		loc=getLocation();
    		clientLocation  = new LatLonPoint(loc.getLatitude(),loc.getLongitude());
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	if(clientLocation==null)
    	{
    		AlertDialog.Builder adb= new AlertDialog.Builder(this);
    		adb.setMessage("Your location was not found (Is GPS disabled?)");
    		adb.setTitle("Error!");
    		adb.setPositiveButton("OK", null);
    		adb.show();
    	}
    	else
    	{
    		MapView mapview = (MapView)this.findViewById(R.id.mapview);
        	MapController mapController = mapview.getController();
        	//mapController.setCenter(clientLocation);
        	//GeoPoint stopCenter = getNearestStop();
        	ArrayList<String> nearestStops = getNearestStops();
        	AlertDialog.Builder builder = new AlertDialog.Builder(this);
        	builder.setTitle("Select A Stop");

        	ListView modeList = new ListView(this);
        	String[] stringArray = new String[nearestStops.size()];
        	for(int i=0;i<nearestStops.size();i++)
        	{
        		stringArray[i]=nearestStops.get(i);
        	}
        
        	ArrayAdapter<String> modeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, stringArray);
        	modeList.setAdapter(modeAdapter);

        	builder.setView(modeList);
        	final Dialog dialog = builder.create();

        	dialog.show();

        	
    	}
    }
    
	private ArrayList<String> getNearestStops() 
	{
		int max = 1000;
		int latMax= clientLocation.getLatitudeE6()+max;
		int latMin= clientLocation.getLatitudeE6() -max;
		int longMax= clientLocation.getLongitudeE6()+max;
		int longMin= clientLocation.getLongitudeE6()-max;
		
		ArrayList<String> toReturn = new ArrayList<String>();
		
		if(displayBlueRoute)
		{
			ArrayList<LatLonPoint> stops= bRoute.returnBusStops();
			for(int i=0;i<stops.size();i++)
			{
				LatLonPoint indexed= stops.get(i);
				if(indexed.getLatitudeE6()>=latMin
				  && indexed.getLatitudeE6() <=latMax
				  && indexed.getLongitudeE6() >= longMin
				  && indexed.getLongitudeE6() <= longMax)
				{
					toReturn.add(bRoute.getBusInfo(indexed));
				}
				
			}
		}
		if(displayRedRoute)
		{
			ArrayList<LatLonPoint> stops= rRoute.returnBusStops();
			for(int i=0;i<stops.size();i++)
			{
				LatLonPoint indexed= stops.get(i);
				if(indexed.getLatitudeE6()>=latMin
				  && indexed.getLatitudeE6() <=latMax
				  && indexed.getLongitudeE6() >= longMin
				  && indexed.getLongitudeE6() <= longMax)
				{
					toReturn.add(bRoute.getBusInfo(indexed));
				}
				
			}
		}
		ArrayList<LatLonPoint> stops= sRoute.returnBusStops();
		for(int i=0;i<stops.size();i++)
		{
			LatLonPoint indexed= stops.get(i);
			if(indexed.getLatitudeE6()>=latMin
			  && indexed.getLatitudeE6() <=latMax
			  && indexed.getLongitudeE6() >= longMin
			  && indexed.getLongitudeE6() <= longMax)
			{
				toReturn.add(bRoute.getBusInfo(indexed));
			}
			
		}
		
		return toReturn;
	}

	private void setupMenuBar() 
	{
      	setUpGrad(R.id.imageView1,0xFEC4C3C5,0xFF616261);
      	setUpGrad(R.id.main,0xFF616261,0xFF696969);
      //	setUpGrad(R.id.outline3,0xFF616261,0xFF131313);
      	setUpGrad(R.id.outline3,0xFF616261,0xFF696969);
      //	setUpGrad(R.id.outline4,0xFF616261,0xFF131313);
      	setUpGrad(R.id.outline4,0xFF616261,0xFF696969);
		TextView outline1 = (TextView) this.findViewById(R.id.outline1);
		outline1.setBackgroundColor(Color.BLUE);
		TextView outline2 = (TextView) this.findViewById(R.id.outline2);
		outline2.setBackgroundColor(Color.RED);


		ImageButton btn = (ImageButton) this.findViewById(R.id.aboutButton);
		btn.setBackgroundColor(Color.TRANSPARENT);
		btn = (ImageButton) this.findViewById(R.id.showAllRouteButton);
		btn.setBackgroundColor(Color.TRANSPARENT);
		btn = (ImageButton) this.findViewById(R.id.switchRouteButton);
		btn.setBackgroundColor(Color.TRANSPARENT);
		btn = (ImageButton) this.findViewById(R.id.nearbyButton);
		btn.setBackgroundColor(Color.TRANSPARENT);
		btn = (ImageButton) this.findViewById(R.id.stopsButton);
		btn.setBackgroundColor(Color.TRANSPARENT);
		
		
	}

	private void getClientLocation()
	{
		// Acquire a reference to the system Location Manager
		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

		// Define a listener that responds to location updates
		locationListener = new LocationListener() {
		    public void onLocationChanged(Location location) {
		    	Log.e("LOC","obtained");
		    	Toast.makeText(context, "hello", 5);
		    	loc = location;
		    	clientLocation = new LatLonPoint (loc.getLatitude(),loc.getLongitude());
		    	//handler.sendEmptyMessage(UPDATE_USER_ICON);
		    }

		    public void onStatusChanged(String provider, int status, Bundle extras) {}

		    public void onProviderEnabled(String provider) {}

		    public void onProviderDisabled(String provider) {}
		  };

		// Register the listener with the Location Manager to receive location updates
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
		

		
	}

	public void onSwitchRouteButtonClick(View v)
	{
		if(ROUTE_SHOWN.equals("blue"))
		{
			displayRedRoute =true;
			displayBlueRoute =false;
			ROUTE_SHOWN="red";
			ImageButton imgButton = (ImageButton)this.findViewById(R.id.switchRouteButton);
			imgButton.setImageResource(R.drawable.bluebus);
			TextView outline1 = (TextView) this.findViewById(R.id.outline1);
			outline1.setBackgroundColor(Color.RED);
			TextView outline2 = (TextView) this.findViewById(R.id.outline2);
			outline2.setBackgroundColor(Color.RED);
		}
		else if (ROUTE_SHOWN.equals("red"))
		{

			displayRedRoute = false;
			displayBlueRoute =true;
			ROUTE_SHOWN = "blue";
			ImageButton imgButton = (ImageButton)this.findViewById(R.id.switchRouteButton);
			imgButton.setImageResource(R.drawable.redbus);
			TextView outline1 = (TextView) this.findViewById(R.id.outline1);
			outline1.setBackgroundColor(Color.BLUE);
			TextView outline2 = (TextView) this.findViewById(R.id.outline2);
			outline2.setBackgroundColor(Color.BLUE);/*
			TextView outline5 = (TextView) this.findViewById(R.id.outline5);
			outline5.setBackgroundColor(Color.BLUE);
			TextView outline6 = (TextView) this.findViewById(R.id.outline6);
			outline6.setBackgroundColor(Color.BLUE);*/
		}

		handler.sendEmptyMessage(UPDATE_BUS_ICONS);
	}
	public void showAllRoutes(View v)
	{
		displayRedRoute =true;
		displayBlueRoute = true;
		TextView outline1 = (TextView) this.findViewById(R.id.outline1);
		outline1.setBackgroundColor(Color.BLUE);
		TextView outline2 = (TextView) this.findViewById(R.id.outline2);
		outline2.setBackgroundColor(Color.RED);
		handler.sendEmptyMessage(UPDATE_BUS_ICONS);
	}
	private void runBusLocationListener() throws IOException 
	{
		
		httpObject = new HTTPObject();
		new Thread(new Runnable()
		{

			@Override
			public void run() 
	
			{
				while(true)
				{
					try {
						httpObject = new HTTPObject();
						try{
							busXMLResponses2 = httpObject.update2();
							busXMLResponses=httpObject.update();
							jamesServer=true;
							}
						catch(Exception e)
						{
							busXMLResponses=httpObject.update();
							jamesServer=false;
						}
						for(int i=0;i<busXMLResponses2.size();i++)
						{
							Log.e("JAMES SERVER",busXMLResponses2.get(i));
						}
						handler.sendEmptyMessage(UPDATE_BUS_ICONS);
						wait(120000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			public void wait(int n)
			{
				double start=System.currentTimeMillis();
				double current=System.currentTimeMillis();
				do
				{
					current=System.currentTimeMillis();
				}while(start+n>=current);
			}
			
		}).start();
		
	}

	private void setupMapView() 
	{
		mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
    	MapController mapController = mapView.getController();
    	mapController.setCenter(bRoute.returnRoute().get(0).getStart());
        mapController.setZoom(18);
        
        drawPath(bRoute.returnRoute(),Color.BLUE);
        drawBusStops(bRoute.returnBusStops(),Color.BLUE);
        drawPath(rRoute.returnRoute(),Color.RED);
        drawBusStops(rRoute.returnBusStops(),Color.RED);
        drawBusStops(sRoute.returnBusStops(),Color.TRANSPARENT);
        addMapPoint(sRoute.getMetroIcon(),context.getResources().getDrawable(R.drawable.metro),"Metro Info:","Unknown");
	}
	
	private void drawBusStops(ArrayList<LatLonPoint> busStops,int color)
	{
		if(color == Color.RED)
		{
			for(int i=0;i<busStops.size();i++)
			{
				addMapPoint(busStops.get(i), context.getResources().getDrawable(R.drawable.redstop_small), "Red Route Stop", rRoute.getBusInfo(busStops.get(i)));
			}
		}
		
		if(color == Color.BLUE)
		{
			for(int i=0;i<busStops.size();i++)
			{
				addMapPoint(busStops.get(i), context.getResources().getDrawable(R.drawable.bluestop_small), "Blue Route Stop", bRoute.getBusInfo(busStops.get(i)));
			}
		}
		if(color == Color.TRANSPARENT)
		{
			for(int i=0;i<busStops.size();i++)
			{
				addMapPoint(busStops.get(i), context.getResources().getDrawable(R.drawable.blueredstop_small), "Blue/Red Route Stop", sRoute.getBusInfo(busStops.get(i)));
			}
		}
	}
	private void drawPath(ArrayList<LatLonPair> route,int color) 
	{
		for(int i=0;i<route.size();i++)
		{
			drawPath(route.get(i).getStart(),route.get(i).getEnd(),color);
		}
		
	}

	private void drawPath(LatLonPoint start, LatLonPoint end, int color)
	{
		MapView mapView = (MapView) findViewById(R.id.mapview);
		List<Overlay> overlays = mapView.getOverlays();
		overlays.add(new RouteOverlay(start,end, color));
		
	}
	
	private void addMapPoint(LatLonPoint point,Drawable drawable,String message1, String message2)
	{
		MapView mapView = (MapView) findViewById(R.id.mapview);
        List<Overlay> mapOverlays = mapView.getOverlays();
        DotMapOverlay itemizedoverlay = new DotMapOverlay(this,drawable);
        
        OverlayItem overlayitem = new OverlayItem(point, message1, message2);
        itemizedoverlay.addOverlay(overlayitem);
        mapOverlays.add(itemizedoverlay);
	}
	public void clearOverlays(boolean redRoute,boolean blueRoute)
	{
		MapView mapView = (MapView) findViewById(R.id.mapview);
		List<Overlay> mapOverlays = mapView.getOverlays();
		if(!mapOverlays.isEmpty()) 
	    { 
			mapOverlays.clear(); 
			mapView.invalidate();
	    }
		if(blueRoute)
		{
			drawPath(bRoute.returnRoute(),Color.BLUE);
			drawBusStops(bRoute.returnBusStops(),Color.BLUE);
		}
		if(redRoute)
		{
			drawPath(rRoute.returnRoute(),Color.RED);	
	        drawBusStops(rRoute.returnBusStops(),Color.RED);
		}
		drawBusStops(sRoute.returnBusStops(),Color.TRANSPARENT);

	}


	private Handler handler = new Handler()
	{
		@Override
        public void handleMessage(Message msg)
		{
			if(msg.what ==UPDATE_BUS_ICONS)
			{
				jamesServer=false;
				int ADDRESS_NEXT=0;
				int TIME_CHECKED_NEXT =1;
				int LAT_NEXT =2;
				int LONGI_NEXT=3;
				int NAME_NEXT =4;
				int SPEED_NEXT= 5;
				int STATUS_NEXT =6;
				int[] toCheckList= {ADDRESS_NEXT,TIME_CHECKED_NEXT,LAT_NEXT,LONGI_NEXT,NAME_NEXT,SPEED_NEXT,STATUS_NEXT}; 
				clearOverlays(displayRedRoute,displayBlueRoute);
				if(!jamesServer)
				{
					for(int i=0;i<busXMLResponses.size();i++)
					{
						String XMLResponse= busXMLResponses.get(i);
						String address="";
						String timeChecked="";
						double lat=0.0;
						double longi=0.0;
						String name="";
						String speed="";
						String status="";
						
						boolean[] isNextList= {false,false,false,false,false,false,false};
						Scanner in = new Scanner(XMLResponse);
						in.useDelimiter("\n");
						while(in.hasNext())
						{
							String line = in.next();
							
							if(isNextList[ADDRESS_NEXT])
							{
								address=line;
								for(int j=0;j<isNextList.length;j++)
								{
									int index =toCheckList[j];
									isNextList[index]=false;
								}
							}
							else if (isNextList[TIME_CHECKED_NEXT])
							{
								timeChecked=line;
								for(int j=0;j<isNextList.length;j++)
								{
									int index =toCheckList[j];
									isNextList[index]=false;
								}
							}
							else if (isNextList[LAT_NEXT])
							{
								lat = Double.parseDouble(line);
								for(int j=0;j<isNextList.length;j++)
								{
									int index =toCheckList[j];
									isNextList[index]=false;
								}
							}
							else if (isNextList[LONGI_NEXT])
							{
								longi=Double.parseDouble(line);
								for(int j=0;j<isNextList.length;j++)
								{
									int index =toCheckList[j];
									isNextList[index]=false;
								}
							}
							else if (isNextList[NAME_NEXT])
							{
								name=line;
								Log.e("name",name);
								for(int j=0;j<isNextList.length;j++)
								{
									int index =toCheckList[j];
									isNextList[index]=false;
								}
							}
							else if (isNextList[SPEED_NEXT])
							{
								speed=line;
								Log.e("speed",speed);
								for(int j=0;j<isNextList.length;j++)
								{
									int index =toCheckList[j];
									isNextList[index]=false;
								}
							}
							else if (isNextList[STATUS_NEXT])
							{
								status=line;
								Log.e("status",status);
								for(int j=0;j<isNextList.length;j++)
								{
									int index =toCheckList[j];
									isNextList[index]=false;
								}
							}
							
							if(line.startsWith("<a:Address>"))
							{
								isNextList[ADDRESS_NEXT]=true;
								for(int j=0;j<isNextList.length;j++)
								{
									if(j==ADDRESS_NEXT)
									{
										continue;
									}
									int index =toCheckList[j];
									isNextList[index]=false;
								}
							}
							else if(line.startsWith("<a:ReportDate>"))
							{
								isNextList[TIME_CHECKED_NEXT]=true;
								for(int j=0;j<isNextList.length;j++)
								{
									if(j==TIME_CHECKED_NEXT)
									{
										continue;
									}
									int index =toCheckList[j];
									isNextList[index]=false;
								}
							}
							else if(line.startsWith("<a:Latitude>"))
							{
								isNextList[LAT_NEXT]=true;
								for(int j=0;j<isNextList.length;j++)
								{
									if(j==LAT_NEXT)
									{
										continue;
									}
									int index =toCheckList[j];
									isNextList[index]=false;
								}
							}
							else if(line.startsWith("<a:Longitude>"))
							{
								isNextList[LONGI_NEXT]=true;
								for(int j=0;j<isNextList.length;j++)
								{
									if(j==LONGI_NEXT)
									{
										continue;
									}
									int index =toCheckList[j];
									isNextList[index]=false;
								}
							}
							else if(line.startsWith("<a:Name>"))
							{
								isNextList[NAME_NEXT]=true;
								for(int j=0;j<isNextList.length;j++)
								{
									if(j==NAME_NEXT)
									{
										continue;
									}
									int index =toCheckList[j];
									isNextList[index]=false;
								}
							}
							else if(line.startsWith("<a:Speed>"))
							{
								isNextList[SPEED_NEXT]=true;
								for(int j=0;j<isNextList.length;j++)
								{
									if(j==SPEED_NEXT)
									{
										continue;
									}
									int index =toCheckList[j];
									isNextList[index]=false;
								}
							}
							else if(line.startsWith("<a:Status>"))
							{
								isNextList[STATUS_NEXT]=true;
								for(int j=0;j<isNextList.length;j++)
								{
									if(j==STATUS_NEXT)
									{
										continue;
									}
									int index =toCheckList[j];
									isNextList[index]=false;
								}
							}
							

							
						}
						LatLonPoint busLocation = new LatLonPoint(lat,longi);
						if(busInList(name) != -1)
						{
							buses.get(i).setLocation(busLocation);
							buses.get(i).setNearestAddress(address);
							buses.get(i).setStatus(status);
							buses.get(i).setSpeed(speed);
							buses.get(i).setBusNumber(Integer.parseInt(name.replace("Bus ", "")));
							
						}
						else
						{
							buses.add(new Bus());
							buses.get(buses.size()-1).setLocation(busLocation);
							buses.get(buses.size()-1).setNearestAddress(address);
							buses.get(buses.size()-1).setStatus(status);
							buses.get(buses.size()-1).setSpeed(speed);
							try{
							buses.get(buses.size()-1).setBusNumber(Integer.parseInt(name.replace("Bus ", "")));
							}catch(Exception e){}
							}
						String message = "Name: "+name+"\n"+"Nearest Address: "+address+"\n"+"Time Checked: "+timeChecked+"\n"+
										"Lat: "+lat+"\n"+"Long: "+longi+"\n"+"Status: "+status;
						if(status.equals("Stopped"))
						{
							break;
						}
						if(isCloseToRoute(busLocation))
						{
							int busIconID= R.drawable.blueredbus_small;
							boolean knownRoute = false;
							for(int j=0;j<busesOnRoutes.size();j++)
							{
								String busName=busesOnRoutes.get(j).replace("r", "").replace("b", "");
								if(busName.equals(name.replace("Bus ", "")))
								{
									if(busesOnRoutes.get(j).charAt(0)=='r')
									{
										busIconID=R.drawable.redbus_small;
									}
									else
									{
										busIconID=R.drawable.bluebus_small;
									}
								}
							}
							if(busIconID==R.drawable.blueredbus_small)
							{	if(predictRoute(busLocation)==Color.BLUE)
								{
									busIconID= R.drawable.bluebus_small;
									busesOnRoutes.add("b"+name.replace("Bus ", ""));
								}
								if(predictRoute(busLocation)==Color.RED)
								{
									busIconID= R.drawable.redbus_small;
									busesOnRoutes.add("r"+name.replace("Bus ", ""));
								}
							}

							
							addMapPoint(busLocation,context.getResources().getDrawable(busIconID),"BUS",message);	

							
						}
					}
					
				}

						
			}
			else if (msg.what== UPDATE_USER_ICON)
			{
				addMapPoint(clientLocation,context.getResources().getDrawable(R.drawable.pin),"YOUR LOCATION","");
			}
			addMapPoint(sRoute.getMetroIcon(),context.getResources().getDrawable(R.drawable.metro),"Metro Info:",getMetroTimes());
        }

		private int busInList(String name)
		{
			try{
			int indexedNumber = Integer.parseInt(name.replace(" ", "").replace("Bus", ""));
			for(int i=0;i<buses.size();i++)
			{
				if(buses.get(i).busNumber == indexedNumber)
				{
					return i;
				}
			}}catch(Exception e ){}
			return -1;
		}

		private int predictRoute(LatLonPoint busLocation) 
		{
			boolean tmpDisplayRedRoute = displayRedRoute;
			boolean tmpDisplayBlueRoute = displayBlueRoute;
			displayRedRoute =true;
			displayBlueRoute = false;
			int returnVal =0;
			if(isCloseToRoute(busLocation))
			{
				returnVal += Color.RED;
			}
			displayRedRoute =false;
			displayBlueRoute = true;
			if (isCloseToRoute(busLocation))
			{
				returnVal+= Color.BLUE;
			}
			displayRedRoute =tmpDisplayRedRoute;
			displayBlueRoute = tmpDisplayBlueRoute;

			return returnVal;
		}

		private boolean isCloseToRoute(LatLonPoint busLocation) 
		{
			int busLat = busLocation.getLatitudeE6();
			int busLong = busLocation.getLongitudeE6();
			if(displayRedRoute)
			{
				ArrayList<LatLonPair> route =rRoute.returnRoute();
				for(int i=0;i<route.size();i++)
				{
					LatLonPoint routePoint = route.get(i).getStart();
					int routeLat = routePoint.getLatitudeE6();
					int routeLong = routePoint.getLongitudeE6();
					if(busLat >= routeLat -DISTANCE_THRESHOLD &&
							busLat<= routeLat + DISTANCE_THRESHOLD)
					{
						if(busLong >= routeLong - DISTANCE_THRESHOLD &&
								busLong <= routeLong)
						{
							return true;
						}
					}
					
				}
			}
			if(displayBlueRoute)
			{
				ArrayList<LatLonPair> route =bRoute.returnRoute();
				for(int i=0;i<route.size();i++)
				{
					LatLonPoint routePoint = route.get(i).getStart();
					int routeLat = routePoint.getLatitudeE6();
					int routeLong = routePoint.getLongitudeE6();
					if(busLat >= routeLat -DISTANCE_THRESHOLD &&
							busLat<= routeLat + DISTANCE_THRESHOLD)
					{
						if(busLong >= routeLong - DISTANCE_THRESHOLD &&
								busLong <= routeLong)
						{
							return true;
						}
					}
					
				}
			}
			return false;
		}
	};
	
	
	public String  getMetroTimes()
	{
		String info = getMetroInfo();
		String toReturn ="";
		String toReturn2="";
		int counter =0;
		Scanner in = new Scanner(info);
		in.useDelimiter("\n");
		while(in.hasNext())
		{
			String next = in.next();
			Log.e("next",next);
			toReturn+=next+" ";
		}
		in = new Scanner(toReturn);
		in.useDelimiter("\n");
		toReturn2+="Cars | To Station | Minutes\n";
		
		while(in.hasNext())
		{
			Scanner out = new Scanner(in.next());
			while(out.hasNext())
			{
				String word = out.next();
				
				if(isNumber(word))
				{
					counter++;
					toReturn2+=word+"        ";
				}
				else
				{
					toReturn2+=word+"    ";
				}
				if(counter==2)
				{
					toReturn2+="\n";
					counter =0;
				}
			}
			//toReturn2+=in.next();
		}
		
		
		return toReturn2;
	}
	public String getMetroInfo()
	{
		//http://wmata.com/rider_tools/pids/showpid.cfm?station_id=10
		
		String toReturnString ="";
		try
		{
			ArrayList<String> toReturn =httpObject.updateMetroInfo();
			boolean station= false;
			for(int i=0;i<toReturn.size();i++)
			{
				String line = toReturn.get(i);
				
				if(line.contains("<img src=\"/img/icon-marble-red.gif\" alt=\"red\" />"))
				{
					station=true;
				}
				if(line.contains("</table>")&&station)
				{
					station=false;
				}
				if(station)
				{
					if(line.contains("</td>") || line.contains("<td>"))
					{
						toReturnString+=line.replace("<td>", "").replace("</td>", "").replace("					","")+"\n";
					}
					if(line.startsWith("						"))
					{
						line = line.replace("						", "");
						if(!line.contains("<")&& !line.contains(">"))
						{
							toReturnString+=line+"\n";
						}
					}
				}
			}
		}catch(Exception e)
		{
			
		}
		return toReturnString;
	}

	public boolean isNumber(String toTest)
	{
		try
		{
			Integer.parseInt(toTest);
			return true;
		}
		catch(Exception e)
		{
			
		}
		return false;
	}
	@Override
	protected boolean isRouteDisplayed() 
	{
		// TODO Auto-generated method stub
		return false;
	}
	
}