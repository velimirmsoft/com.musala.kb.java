package com.welle.calculator;

import com.welle.unity.AirborneAirplane;

import com.welle.settings.and.constants.Const.Position;
import com.welle.unity.AirborneAirplane;

public interface CalcSpeedOfAirplane {

	public void setPrivousStateOfOurAirplane(AirborneAirplane a);

	public AirborneAirplane getPrivousStateOfOurAirplane();

	public Float getVelocityOfOurAirplane(AirborneAirplane s1, AirborneAirplane s2, Long timeBetweenStates);

}
