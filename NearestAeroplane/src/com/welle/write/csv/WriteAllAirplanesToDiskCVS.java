package com.welle.write.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.welle.unity.AirborneAirplane;

public class WriteAllAirplanesToDiskCVS implements WriteFileToDisk {

	private String path = "";

	@Override
	public void writeAllAirplanesToDisk(String fileName, Long timeOfWriting, ArrayList<AirborneAirplane> planes) {

		String csvFile = getPath() + fileName + ".cvs";
		try (FileWriter writer = new FileWriter(csvFile)) {
			for (AirborneAirplane a : planes) {
				writer.write(a.toString());
				writer.write("\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String getPath() {
		return path;
	}

}
