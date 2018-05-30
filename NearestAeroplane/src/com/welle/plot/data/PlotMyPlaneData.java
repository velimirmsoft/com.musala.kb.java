package com.welle.plot.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.colors.XChartSeriesColors;

public class PlotMyPlaneData implements PlotMyData {

	private List<Double> timeData = new ArrayList<Double>();
	private List<Double> distanceData = new ArrayList<Double>();
	private List<Double> altitudeData = new ArrayList<Double>();
	public static final String SERIES_NAME_DISTANCE = "Distance To our closest Airborne - Logger";
	public static final String SERIES_NAME_ALTITUDE = "Altitude To our closest Airborne - Logger";

	private List<XYChart> charts = new ArrayList<XYChart>();

	private JFrame sw;

	@Override
	public void initPlot() {

		addToMySeries(0.0, 0.0, 0.0);
		// Create Chart
		XYChart chart_1 = QuickChart.getChart("Distance", "seconds * INTERVAL", "KM", SERIES_NAME_DISTANCE, timeData, distanceData);
		charts.add(chart_1);
		XYChart chart_2 = QuickChart.getChart("Altitude", "seconds * INTERVAL", "M", SERIES_NAME_ALTITUDE, timeData, altitudeData);
		// Customize Chart
		chart_2.getStyler().setAxisTitlesVisible(false);
		chart_2.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);
		charts.add(chart_2);
		
		// add scatter chart
		// I want to try add a map of all airplanes distances

	}

	@Override
	public void showPlot() {
		// Show it
		sw = new SwingWrapper<XYChart>(charts).displayChartMatrix();
	}

	@Override
	public void updatePlot(String forAirplane) {
		// debugPrintData();
		charts.get(0).updateXYSeries(SERIES_NAME_DISTANCE, timeData, distanceData, null);
		charts.get(1).updateXYSeries(SERIES_NAME_ALTITUDE, timeData, altitudeData, null);
		charts.get(0).setTitle(forAirplane);
		charts.get(1).setTitle(forAirplane);
		sw.repaint();
	}

	@Override
	public void addToMySeries(Double x, Double distance, Double altitude) {
		timeData.add(x);
		distanceData.add(distance);
		altitudeData.add(altitude);
	}

	@Override
	public void debugPrintData() {
		System.out.println(Arrays.toString(timeData.toArray()));
		System.out.println(Arrays.toString(distanceData.toArray()));
		System.out.println(Arrays.toString(altitudeData.toArray()));
	}

}
