package com.welle.calculator;

import java.util.ArrayList;

import static com.welle.settings.and.constants.Const.POSITION;
import com.welle.unity.AirborneAirplane;

public class CalcNearestAirborneImpl implements CalcNearestAirborne {

	@Override
	public AirborneAirplane calculateNearesAirborne(ArrayList<AirborneAirplane> planes, double myLatitude, double myLongitude) {

		System.out.println("Calculating nearest airborne plane!");

		POSITION myPos = determinatePosition(myLatitude, myLongitude);
		System.out.println("My pos = " + myPos);

		Double minDistance = 1000000000.0;
		int indexOfOurClosestAirplane = 0;
		int c = 0;
		for (AirborneAirplane a : planes) {
			if (determinatePosition(a.getLattitude(), a.getLongitude()) == myPos) {
				Double tempDis = calcEuclideanDistance(myLatitude, myLongitude, a.getLattitude(), a.getLongitude());
				if (tempDis < minDistance) {
					minDistance = tempDis;
					indexOfOurClosestAirplane = c;
				}
			}
			c++;
		}

		AirborneAirplane finalPlane = planes.get(indexOfOurClosestAirplane);
		finalPlane.setGeodesicDistance(minDistance);

		System.out.println(finalPlane.toString());

		return finalPlane;
	}

	@Override
	public POSITION determinatePosition(double Latitude, double Longitude) {
		POSITION pos = null;
		if (Longitude > 0 && Latitude > 0) {
			pos = POSITION.NE;
		} else if (Longitude < 0 && Latitude > 0) {
			pos = POSITION.NW;
		} else if (Longitude < 0 && Latitude < 0) {
			pos = POSITION.SW;
		} else if (Longitude < 0 && Latitude > 0) {
			pos = POSITION.SE;
		}
		return pos;
	}

	@Override
	public Double calcEuclideanDistance(double myLatitude, double myLongitude, double planeLatitude, double planeLongitude) {
		// copied from the net - theres a lot of math there ...
		double theta = myLongitude - planeLongitude;
		double dist = Math.sin(deg2rad(myLatitude)) * Math.sin(deg2rad(planeLatitude)) + Math.cos(deg2rad(myLatitude)) * Math.cos(deg2rad(planeLatitude)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344;
		return (dist);
	}

	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}

}
