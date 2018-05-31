package com.welle.calculator;

import com.welle.unity.AirborneAirplane;

import com.welle.settings.and.constants.Const.Position;
import com.welle.unity.AirborneAirplane;

public interface CalcSpeedOfAirplane {

	// save privous state of our airplanes

	public void setPrivousStateOfOurAirplane(AirborneAirplane a);

	public AirborneAirplane getPrivousStateOfOurAirplane();

	public Float getVelocityOfOurAirplane(AirborneAirplane s1, AirborneAirplane s2, Long timeBetweenStates);

}
