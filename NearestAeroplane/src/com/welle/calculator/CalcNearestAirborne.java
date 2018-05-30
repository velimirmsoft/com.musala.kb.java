package com.welle.calculator;

import java.util.ArrayList;

import com.welle.settings.and.constants.Const.POSITION;
import com.welle.unity.AirborneAirplane;

public interface CalcNearestAirborne {

	public AirborneAirplane calculateNearesAirborne(ArrayList<AirborneAirplane> planes, double myLatitude, double myLongitude);

	public Double calcEuclideanDistance(double myLatitude, double myLongitude, double planeLatitude, double planeLongitude);

	public POSITION determinatePosition(double Latitude, double Longitude);

}
