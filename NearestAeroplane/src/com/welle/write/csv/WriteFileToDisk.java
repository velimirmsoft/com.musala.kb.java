package com.welle.write.csv;

import java.util.ArrayList;

import com.welle.unity.AirborneAirplane;

public interface WriteFileToDisk {

	public void writeAirplanesDataToDisk(String fileName, Long timeOfWriting, ArrayList<AirborneAirplane> planes);
	
	public void setPath(String path);
	
	public String getPath();

}
