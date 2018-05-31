package com.welle.plot.data;

import java.util.List;

public interface PlotMyData {

	public void initPlot();

	public void showPlot();

	public void addAndUpdatePlot(String forAirplane, Float time, Float y1, Float y2, Float y3, List<Float> scatterX, List<Float> scatterY);

	public void debugPrintData();

}
