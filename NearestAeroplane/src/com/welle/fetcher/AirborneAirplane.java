package com.welle.fetcher;

public class AirborneAirplane {

	private String ICAO24_ID;
	private String CountryOfOrigin;
	private Double GeometricAltitude;
	private Double Lattitude;
	private Double Longitude;
	private String Callsign;

	// this is calculated
	private Float GeodesicDistance;

	public AirborneAirplane(String ICAO24_ID, String CountryOfOrigin, Double GeometricAltitude, Double Lattitude,
			Double Longitude, String Callsign) {
		this.ICAO24_ID = ICAO24_ID;
		this.CountryOfOrigin = CountryOfOrigin;
		this.GeometricAltitude = GeometricAltitude;
		this.Lattitude = Lattitude;
		this.Longitude = Longitude;
		this.Callsign = Callsign;
	}

	@Override
	public String toString() {
		return GeodesicDistance + " - " + Callsign + " - " + Lattitude + " - " + Longitude + " - " + GeometricAltitude
				+ " - " + CountryOfOrigin + " - " + ICAO24_ID;
	}

	public Float getGeodesicDistance() {
		return GeodesicDistance;
	}

	public void setGeodesicDistance(Float geodesicDistance) {
		GeodesicDistance = geodesicDistance;
	}

	public String getCallsign() {
		return Callsign;
	}

	public void setCallsign(String callsign) {
		Callsign = callsign;
	}

	public Double getLattitude() {
		return Lattitude;
	}

	public void setLattitude(Double lattitude) {
		Lattitude = lattitude;
	}

	public Double getLongitude() {
		return Longitude;
	}

	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}

	public Double getGeometricAltitude() {
		return GeometricAltitude;
	}

	public void setGeometricAltitude(Double geometricAltitude) {
		GeometricAltitude = geometricAltitude;
	}

	public String getCountryOfOrigin() {
		return CountryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		CountryOfOrigin = countryOfOrigin;
	}

	public String getICAO24_ID() {
		return ICAO24_ID;
	}

	public void setICAO24_ID(String iCAO24_ID) {
		ICAO24_ID = iCAO24_ID;
	}

}
