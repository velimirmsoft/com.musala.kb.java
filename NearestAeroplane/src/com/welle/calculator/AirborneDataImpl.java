package com.welle.calculator;

import java.util.ArrayList;

import static com.welle.settings.and.constants.Const.Position;

import com.welle.settings.and.constants.Const;
import com.welle.settings.and.constants.MyMath;
import com.welle.unity.AirborneAirplane;

public class AirborneDataImpl implements CalcNearestAirborne, CalcSpeedOfAirplane {

	// here we save the state of our previousPlane
	private AirborneAirplane previousPlane = null;
	private Long timeBetweenStates = (long) 0;
	private Float previousSpeed = 0.0f;

	@Override
	public AirborneAirplane calculateNearesAirborne(ArrayList<AirborneAirplane> planes, Float myLatitude, Float myLongitude) {

		System.out.println("Calculating nearest airborne plane!");

		// Position myPos = determinatePosition(myLatitude, myLongitude);
		// System.out.println("My pos = " + myPos);

		Float minDistance = 1000000000.0f;
		int indexOfOurClosestAirplane = 0, counter = 0;
		for (AirborneAirplane a : planes) {
			Float tempDis = calcEuclideanDistance(myLatitude, myLongitude, a.getLattitude(), a.getLongitude());
			if (tempDis < minDistance) {
				minDistance = tempDis;
				indexOfOurClosestAirplane = counter;
			}
			counter++;
		}

		AirborneAirplane finalPlane = planes.get(indexOfOurClosestAirplane);

		finalPlane.setGeodesicDistance(minDistance);
		finalPlane.setSpeedOfAirplane(getVelocityOfOurAirplane(getPrivousStateOfOurAirplane(), finalPlane, timeBetweenStates));
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
		Float dist = (float) (Math.sin(MyMath.deg2rad(myLatitude)) * Math.sin(MyMath.deg2rad(planeLatitude))
				+ Math.cos(MyMath.deg2rad(myLatitude)) * Math.cos(MyMath.deg2rad(planeLatitude)) * Math.cos(MyMath.deg2rad(theta)));
		dist = (float) Math.acos(dist);
		dist = MyMath.rad2deg(dist);
		dist = (float) (dist * 60 * 1.1515);
		dist = (float) (dist * 1.609344);
		return (dist);
	}

	@Override
	public Float getVelocityOfOurAirplane(AirborneAirplane pastState, AirborneAirplane currentState, Long timeBetweenStates) {
		if (pastState != null) {
			Float d = calcEuclideanDistance(pastState.getLattitude(), pastState.getLongitude(), currentState.getLattitude(), currentState.getLongitude());
			float h = (float) (timeBetweenStates / 1000) / 60 / 60;
			// v = s / t
			Float tReturn = d / h;
			if (Float.isNaN(tReturn) || tReturn >= 100000 || tReturn == previousSpeed) {
				this.timeBetweenStates = this.timeBetweenStates + Const.timeInterval;
				return 0.0f;
			}
			this.timeBetweenStates = Const.timeInterval;
			previousSpeed = tReturn;
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
