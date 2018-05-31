package com.welle.unity;

public class AirborneAirplane {

	private String icao24Id;
	private String countryOfOrigin;
	private Float geometricAltitude;
	private Float lattitude;
	private Float longitude;
	private String callSign;
	private Float speedOfAirplane;

	// this is calculated
	private Float geodesicDistance = 0.0f;

	public AirborneAirplane(String icao24Id, String CountryOfOrigin, Float GeometricAltitude, Float Lattitude, Float Longitude, String Callsign) {
		this.icao24Id = icao24Id;
		this.countryOfOrigin = CountryOfOrigin;
		this.geometricAltitude = GeometricAltitude;
		this.lattitude = Lattitude;
		this.longitude = Longitude;
		this.callSign = Callsign;
	}

	@Override
	public String toString() {
		return geodesicDistance + " KM | " + callSign + " | " + lattitude + " and " + longitude + " | " + geometricAltitude + " | " + speedOfAirplane + " KM/h | " + countryOfOrigin + " | " + icao24Id;
	}

	public Float getGeodesicDistance() {
		return geodesicDistance;
	}

	public void setGeodesicDistance(Float geodesicDistance) {
		this.geodesicDistance = geodesicDistance;
	}

	public String getCallsign() {
		return callSign;
	}

	public void setCallsign(String Callsign) {
		this.callSign = Callsign;
	}

	public Float getLattitude() {
		return lattitude;
	}

	public void setLattitude(Float lattitude) {
		this.lattitude = lattitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getGeometricAltitude() {
		return geometricAltitude;
	}

	public void setGeometricAltitude(Float geometricAltitude) {
		this.geometricAltitude = geometricAltitude;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getICAO24_ID() {
		return icao24Id;
	}

	public void setICAO24_ID(String iCAO24_ID) {
		this.icao24Id = iCAO24_ID;
	}

	public Float getSpeedOfAirplane() {
		return speedOfAirplane;
	}

	public void setSpeedOfAirplane(Float speedOfAirplane) {
		this.speedOfAirplane = speedOfAirplane;
	}

}
