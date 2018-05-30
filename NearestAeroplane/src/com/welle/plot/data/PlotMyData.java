package com.welle.plot.data;

public interface PlotMyData {

	public void initPlot();
	
	public void showPlot();
	
	public void updatePlot(String forAirplane);
	
	public void addToMySeries(Double x, Double y, Double z);
	
	public void debugPrintData();
	
}
