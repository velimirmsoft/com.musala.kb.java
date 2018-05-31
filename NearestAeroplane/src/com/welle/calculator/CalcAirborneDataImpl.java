package com.welle.calculator;

import java.util.ArrayList;

import static com.welle.settings.and.constants.Const.Position;

import com.welle.settings.and.constants.Const;
import com.welle.unity.AirborneAirplane;

public class CalcAirborneDataImpl implements CalcNearestAirborne, CalcSpeedOfAirplane {

	// here we save the state of our previousPlane
	private AirborneAirplane previousPlane = null;

	@Override
	public AirborneAirplane calculateNearesAirborne(ArrayList<AirborneAirplane> planes, Float myLatitude, Float myLongitude) {

		System.out.println("Calculating nearest airborne plane!");

		// Position myPos = determinatePosition(myLatitude, myLongitude);
		// System.out.println("My pos = " + myPos);

		Float minDistance = 1000000000.0f;
		int indexOfOurClosestAirplane = 0;
		int c = 0;
		for (AirborneAirplane a : planes) {
			Float tempDis = calcEuclideanDistance(myLatitude, myLongitude, a.getLattitude(), a.getLongitude());
			if (tempDis < minDistance) {
				minDistance = tempDis;
				indexOfOurClosestAirplane = c;
			}
			c++;
		}

		AirborneAirplane finalPlane = planes.get(indexOfOurClosestAirplane);
		finalPlane.setGeodesicDistance(minDistance);

		// calc the speed of this airplane
		Float speed = getVelocityOfOurAirplane(getPrivousStateOfOurAirplane(), finalPlane, Const.timeInterval);
		finalPlane.setSpeedOfAirplane(speed);

		// save our airplane
		setPrivousStateOfOurAirplane(finalPlane);

		System.out.println(finalPlane.toString());

		return finalPlane;
	}

	@Override
	public Position determinatePosition(Float latitude, Float longitude) {
		Position pos = null;
		if (longitude > 0 && latitude > 0) {
			pos = Position.NE;
		} else if (longitude < 0 && latitude > 0) {
			pos = Position.NW;
		} else if (longitude < 0 && latitude < 0) {
			pos = Position.SW;
		} else if (longitude < 0 && latitude > 0) {
			pos = Position.SE;
		}
		return pos;
	}

	@Override
	public Float calcEuclideanDistance(Float myLatitude, Float myLongitude, Float planeLatitude, Float planeLongitude) {
		// copied from the net - theres a lot of math there ...
		Float theta = myLongitude - planeLongitude;
		Float dist = (float) (Math.sin(deg2rad(myLatitude)) * Math.sin(deg2rad(planeLatitude)) + Math.cos(deg2rad(myLatitude)) * Math.cos(deg2rad(planeLatitude)) * Math.cos(deg2rad(theta)));
		dist = (float) Math.acos(dist);
		dist = rad2deg(dist);
		dist = (float) (dist * 60 * 1.1515);
		dist = (float) (dist * 1.609344);
		return (dist);
	}

	private Float deg2rad(Float deg) {
		return (float) (deg * Math.PI / 180.0);
	}

	private Float rad2deg(Float rad) {
		return (float) (rad * 180.0 / Math.PI);
	}

	@Override
	public Float getVelocityOfOurAirplane(AirborneAirplane pastState, AirborneAirplane currentState, Long timeBetweenStates) {
		// v = s / t
		if (pastState != null) {

			Float d = calcEuclideanDistance(pastState.getLattitude(), pastState.getLongitude(), currentState.getLattitude(), currentState.getLongitude());
			// System.out.println("d = " + d);

			// convert the time into H's
			float h = (float) (timeBetweenStates / 1000) / 60 / 60;
			// System.out.println("h = " + h);

			// Float a = pastState.getGeodesicDistance();
			// Float b = currentState.getGeodesicDistance();

			// Float cosT = b / a;
			// Float T = (float) Math.acos(cosT);

			// Float d2 = (float) Math.sin(T) * a;
			// System.out.println("Od teorema d2 = " + d2);

			Float constToFixThingsUp = (float) (2 * timeBetweenStates / 1000);
			Float tReturn = d / h / (constToFixThingsUp);

			// invalid input
			if (Float.isNaN(tReturn) || tReturn >= 100000)
				return 0.0f;

			return tReturn;
		}
		return 0.0f;
	}

	@Override
	public void setPrivousStateOfOurAirplane(AirborneAirplane a) {
		previousPlane = a;
	}

	@Override
	public AirborneAirplane getPrivousStateOfOurAirplane() {
		return previousPlane;
	}
}
