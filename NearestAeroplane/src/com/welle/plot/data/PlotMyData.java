package com.welle.plot.data;

import java.util.List;

public interface PlotMyData {

	public void initPlot();

	public void showPlot();

	public void addAndUpdatePlot(String forAirplane, Double x, Double y, Double z, List<Double> scatterX, List<Double> scatterY);

	public void debugPrintData();

}
