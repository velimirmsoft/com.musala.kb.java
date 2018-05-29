package com.welle.main;

import com.welle.fetcher.FetchAirplaneData;

public class MainClass {

	public static void main(String[] args) {
		
		FetchAirplaneData f = new FetchAirplaneData();
		f.fetchAndStoreAeroplaneData();

	}

}
