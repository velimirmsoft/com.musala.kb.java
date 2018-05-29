package com.welle.main;

import com.welle.settings.FilePathsAndConstants;
import com.welle.settings.MeasureTime;

public class MainClass {

	static MeasureTime mt = new MeasureTime();

	public static void main(String[] args) {

		UniqueWordsDriver u = new UniqueWordsDriver();

		mt.startMeasuring();
		u.startOurUniqueWordsDriver(FilePathsAndConstants.WhichImplementation.LIST);
		mt.stopMeasuring();

		mt.startMeasuring();
		u.startOurUniqueWordsDriver(FilePathsAndConstants.WhichImplementation.MAP);
		mt.stopMeasuring();

	}

}
