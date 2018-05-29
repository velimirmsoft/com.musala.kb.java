package com.welle.fetcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.welle.settings.and.constants.Constants;

public class FetchAirplaneData implements FetchData {

	protected ArrayList<AirborneAirplane> planes = new ArrayList<AirborneAirplane>();

	@Override
	public void fetchAndStoreAeroplaneData() {

		URL url;
		try {

			url = new URL(Constants.OPENSKY_AIRPLANES);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Content-Type", "application/json");
			con.setConnectTimeout(5000);
			con.setRequestMethod("GET");

			int status = con.getResponseCode();
			System.out.println("Our Airborne API returned status -> " + status);

			if (status == 200) {

				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				in.close();
				// System.out.println("" + content.toString());

				JSONParser parser = new JSONParser();
				Object obj = parser.parse(content.toString());
				JSONObject jsonObject = (JSONObject) obj;

				Long time = (Long) jsonObject.get("time");
				System.out.println("time -> " + new SimpleDateFormat("EEEE, MMMM dd, YYYY").format(time));

				JSONArray results = (JSONArray) jsonObject.get("states");
				Iterator<?> iterator = results.iterator();
				while (iterator.hasNext()) {

					// private String ICAO24_ID;
					// private String CountryOfOrigin;
					// private Float GeometricAltitude;
					// private Float Lattitude;
					// private Float Longitude;
					// private String Callsign;

					JSONArray o = (JSONArray) iterator.next();
					
					if (o.get(0) != null && o.get(2) != null  && o.get(7) != null  && o.get(5) != null  && o.get(6) != null && o.get(1) != null ) {
						
						planes.add(new AirborneAirplane(
								(String) o.get(0), 
								(String) o.get(2),
								Double.valueOf("" + o.get(7)), 
								(Double) o.get(5), 
								(Double) o.get(6),
								(String) o.get(1)));
						
					}
					
				}
				
				System.out.println("Total Planes -> " + planes.size());

			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
