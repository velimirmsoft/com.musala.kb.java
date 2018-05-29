package com.welle.main;

import com.welle.settings.FilePathsAndConstants;
import com.welle.settings.MeasureTime;

public class MainClass {

	public static void main(String[] args) {

		UniqueWordsDriver u = new UniqueWordsDriver();

		MeasureTime.startMeasuring();
		u.startOurUniqueWordsDriver(FilePathsAndConstants.WhichImplementation.LIST);
		MeasureTime.stopMeasuring();

		MeasureTime.startMeasuring();
		u.startOurUniqueWordsDriver(FilePathsAndConstants.WhichImplementation.MAP);
		MeasureTime.stopMeasuring();

	}

}
