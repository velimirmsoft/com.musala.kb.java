package com.welle.calculator;

import java.util.ArrayList;

import com.welle.settings.and.constants.Const.Position;
import com.welle.unity.AirborneAirplane;

public interface CalcNearestAirborne {

	public AirborneAirplane calculateNearesAirborne(ArrayList<AirborneAirplane> planes, Float myLatitude, Float myLongitude);

	public Float calcEuclideanDistance(Float myLatitude, Float myLongitude, Float planeLatitude, Float planeLongitude);

	public Position determinatePosition(Float Latitude, Float Longitude);

}
