package com.welle.fetcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.welle.settings.and.constants.Const;
import com.welle.unity.AirborneAirplane;

public class FetchAirplaneDataImpl implements FetchAirplaneData {

	private ArrayList<AirborneAirplane> planes = new ArrayList<AirborneAirplane>();

	@Override
	public ArrayList<AirborneAirplane> returnPlanes() {
		return planes;
	}

	@Override
	public void fetchAndStoreAeroplaneData() {

		System.out.println("");
		System.out.println("Getting data!");

		URL url;
		try {

			planes.clear();

			url = new URL(Const.OPENSKY_AIRPLANES);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Content-Type", "application/json");
			con.setConnectTimeout(3000);
			con.setRequestMethod("GET");

			int status = con.getResponseCode();
			System.out.println("Our Airborne API returned status -> " + status);

			if (status >= 200 && status < 400) {

				StringBuffer content = null;
				try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));) {

					String inputLine;
					content = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
						content.append(inputLine);
					}
					in.close();

				} catch (IOException ex) {
					System.err.println("thrown exception: " + ex.toString());
					Throwable[] suppressed = ex.getSuppressed();
					for (int i = 0; i < suppressed.length; i++) {
						System.err.println("suppressed exception: " + suppressed[i].toString());
					}
				}

				JSONParser parser = new JSONParser();
				Object obj = parser.parse(content.toString());
				JSONObject jsonObject = (JSONObject) obj;

				Long time = (Long) jsonObject.get("time");
				Date dateObj = new Date(time * 1000);
				System.out.println("time -> " + dateObj);

				JSONArray results = (JSONArray) jsonObject.get("states");
				@SuppressWarnings("unchecked")
				Iterator<JSONArray> iterator = results.iterator();
				while (iterator.hasNext()) {
					JSONArray o = iterator.next();
					if (o.get(0) != null && o.get(2) != null && o.get(7) != null && o.get(5) != null && o.get(6) != null && o.get(1) != null) {
						planes.add(new AirborneAirplane((String) o.get(0), (String) o.get(2), Float.valueOf("" + o.get(7)), Float.valueOf("" + o.get(6)), Float.valueOf("" + o.get(5)),
								(String) o.get(1)));
					}
				}

				System.out.println("Total Planes -> " + planes.size());

			} else {
				System.out.println("Something went wrong -> status = " + status);
			}

		} catch (

		MalformedURLException e) {
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

	@Override
	public ArrayList<Float> getLatForAllAirbornes() {
		ArrayList<Float> r = new ArrayList<Float>();
		for (AirborneAirplane a : planes) {
			r.add(a.getLattitude());
		}
		return r;
	}

	@Override
	public ArrayList<Float> getLongForAllAirbornes() {
		ArrayList<Float> r = new ArrayList<Float>();
		for (AirborneAirplane a : planes) {
			r.add(a.getLongitude());
		}
		return r;
	}

}
