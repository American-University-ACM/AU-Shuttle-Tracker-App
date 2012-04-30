package edu.american.student.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This method acts as an interface between the internet and the app
 * @author Cam Cok
 * 
 * 
**/
public class HTTPObject 
{
	private String URL = "http://busdata.streeteagleweb.com/Service.svc";
	private String COMMAND = "POST";
	
	public HTTPObject() throws IOException
	{

	}
	
	/**
	 * update contacts StreetEagle 
	 **/
	public ArrayList<String> update() throws Exception
	{
		URL url = new URL(URL);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();

		conn.setRequestMethod(COMMAND);
		conn.setDoOutput(true);

		conn.setRequestProperty("content-type","text/xml; charset=utf-8");
		conn.setRequestProperty("Accept", "*/*");
		conn.setRequestProperty("SOAPAction", "\"http://tempuri.org/IService/Get_BusesByVehicleIdString\"");

		(new PrintStream(conn.getOutputStream())).print(
		"<?xml version=\"1.0\" encoding=\"utf-8\"?>"
		+ "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\">"
		+ "<s:Body>"
		+ "<Get_BusesByVehicleIdString xmlns=\"http://tempuri.org/\">"
		+ "<strUserName>americanuniversityBB</strUserName>"
		+ "<lngCustID>808</lngCustID>"
		+ "<strVehicleIdString>1,2,3,4,5,6,7,8,9</strVehicleIdString>"
		+ "</Get_BusesByVehicleIdString>"
		+ "</s:Body>"
		+ "</s:Envelope>");

		conn.setReadTimeout(5*1000);
		conn.connect();

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		                //Change the file you're writing to
		//FileWriter fw = new FileWriter(SAVE_FILE);
		//BufferedWriter bw = new BufferedWriter(fw);
		String line = null;
		String temp ="";
		while ((line = reader.readLine()) != null) 
		{
			//bw.write(line);
			temp +=line+"\n";
		}
		//bw.flush();
		ArrayList<String> toReturnList = new ArrayList<String>();
		Scanner in = new Scanner(temp);
		in.useDelimiter(Pattern.compile("<a:List_Bus>"));
		
		while(in.hasNext())
		{
			String toAdd=in.next().replace("</a:List_Bus>", "").replace("</Get_BusesByVehicleIdStringResult></Get_BusesByVehicleIdStringResponse></s:Body></s:Envelope>", "");
			toAdd=toAdd.replace(">",">\n").replace("</","\n</");
			toReturnList.add(toAdd);
		}
		reader.close();
		return toReturnList;
	}

	/**
	 * update2 contacts james's server
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String> update2() throws IOException
	{
		ArrayList<String>returnArray = new ArrayList<String>();
		URL URL =new URL("http://shuttle.wcpetersen.com/Tracker.ashx");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(URL.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
        {
        		returnArray.add(inputLine);
        }
        in.close();
		return returnArray;
	}
	
	/**
	 * updateMetroInfo contacts metro servers
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String> updateMetroInfo() throws IOException
	{
		ArrayList<String> returnArray = new ArrayList<String>();
        URL oracle = new URL("http://wmata.com/rider_tools/pids/showpid.cfm?station_id=10");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            {
        		returnArray.add(inputLine);
            }
        in.close();
		return returnArray;
	}
}