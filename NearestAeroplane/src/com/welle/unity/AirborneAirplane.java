package com.welle.unity;

public class AirborneAirplane {

	private String iCAO24_ID;
	private String countryOfOrigin;
	private Double geometricAltitude;
	private Double lattitude;
	private Double longitude;
	private String callSign;

	// this is calculated
	private Double GeodesicDistance;

	public AirborneAirplane(String ICAO24_ID, String CountryOfOrigin, Double GeometricAltitude, Double Lattitude, Double Longitude, String Callsign) {
		this.iCAO24_ID = ICAO24_ID;
		this.countryOfOrigin = CountryOfOrigin;
		this.geometricAltitude = GeometricAltitude;
		this.lattitude = Lattitude;
		this.longitude = Longitude;
		this.callSign = Callsign;
	}

	@Override
	public String toString() {
		return GeodesicDistance + " KM | " + callSign + " | " + lattitude + " and " + longitude + " | " + geometricAltitude + " | " + countryOfOrigin + " | " + iCAO24_ID;
	}

	public Double getGeodesicDistance() {
		return GeodesicDistance;
	}

	public void setGeodesicDistance(Double geodesicDistance) {
		GeodesicDistance = geodesicDistance;
	}

	public String getCallsign() {
		return callSign;
	}

	public void setCallsign(String Callsign) {
		this.callSign = Callsign;
	}

	public Double getLattitude() {
		return lattitude;
	}

	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getGeometricAltitude() {
		return geometricAltitude;
	}

	public void setGeometricAltitude(Double geometricAltitude) {
		this.geometricAltitude = geometricAltitude;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getICAO24_ID() {
		return iCAO24_ID;
	}

	public void setICAO24_ID(String iCAO24_ID) {
		this.iCAO24_ID = iCAO24_ID;
	}

}
