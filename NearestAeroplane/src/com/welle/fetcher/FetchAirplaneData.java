package com.welle.fetcher;

import java.util.ArrayList;

import com.welle.unity.AirborneAirplane;

public interface FetchAirplaneData {

	public void fetchAndStoreAeroplaneData();
	
	public Long returnTimeOfFetch();

	public ArrayList<AirborneAirplane> returnPlanes();

	public ArrayList<Float> getLatForAllAirbornes();
	
	public ArrayList<Float> getLongForAllAirbornes();

}
