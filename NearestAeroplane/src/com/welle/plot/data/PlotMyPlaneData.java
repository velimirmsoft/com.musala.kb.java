package com.welle.plot.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;

import com.welle.settings.and.constants.Const;

public class PlotMyPlaneData implements PlotMyData {

	private List<Double> timeData = new ArrayList<Double>();
	private List<Double> distanceData = new ArrayList<Double>();
	private List<Double> altitudeData = new ArrayList<Double>();

	private List<Double> scatterLatitude = new ArrayList<Double>();
	private List<Double> scatterLongitude = new ArrayList<Double>();

	public static final String SERIES_NAME_DISTANCE = "Distance To our closest Airborne - Logger";
	public static final String SERIES_NAME_ALTITUDE = "Altitude To our closest Airborne - Logger";
	public static final String SERIES_NAME_SCATTER = "Scatter of all Distances - Logger";

	private List<XYChart> charts = new ArrayList<XYChart>();

	private JFrame sw;

	XYChart chart_scatter;
	private JFrame sw_scatter;

	@Override
	public void initPlot() {

		// init lists
		List<Double> dx = new ArrayList<Double>();
		dx.add(0.0);
		List<Double> dy = new ArrayList<Double>();
		dy.add(0.0);
		timeData.add(0.0);
		distanceData.add(0.0);
		altitudeData.add(0.0);
		this.scatterLatitude = dx;
		this.scatterLongitude = dy;

		// Create Chart
		XYChart chart_1 = QuickChart.getChart("Distance", "seconds * INTERVAL", "KM", SERIES_NAME_DISTANCE, timeData, distanceData);
		charts.add(chart_1);
		XYChart chart_2 = QuickChart.getChart("Altitude", "seconds * INTERVAL", "M", SERIES_NAME_ALTITUDE, timeData, altitudeData);
		// Customize Chart
		chart_2.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);
		charts.add(chart_2);

		// add scatter chart
		// I want to try add a map of all airplanes distances
		List<Double> myScatterX = new ArrayList<Double>();
		myScatterX.add(Const.DEF_LATITUDE);
		List<Double> myScatterY = new ArrayList<Double>();
		myScatterY.add(Const.DEF_LONGITUDE);
		// Create Chart
		chart_scatter = new XYChartBuilder().title("All Airbornes Ploted").xAxisTitle("Latitude").yAxisTitle("Longitude").build();
		chart_scatter.addSeries(SERIES_NAME_SCATTER, scatterLatitude, scatterLongitude);
		chart_scatter.addSeries("myLocation", myScatterX, myScatterY);
		// Customize Chart
		chart_scatter.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Scatter);
		chart_scatter.getStyler().setMarkerSize(16);

	}

	@Override
	public void showPlot() {
		// Show it
		sw = new SwingWrapper<XYChart>(charts).displayChartMatrix();
		sw_scatter = new SwingWrapper<XYChart>(chart_scatter).displayChart();
	}

	@Override
	public void addAndUpdatePlot(String forAirplane, Double x, Double distance, Double altitude, List<Double> scatterLatitude, List<Double> scatterLongitude) {

		timeData.add(x);
		distanceData.add(distance);
		altitudeData.add(altitude);
		this.scatterLatitude = scatterLatitude;
		this.scatterLongitude = scatterLongitude;

		// distance and altitude
		charts.get(0).updateXYSeries(SERIES_NAME_DISTANCE, timeData, distanceData, null);
		charts.get(1).updateXYSeries(SERIES_NAME_ALTITUDE, timeData, altitudeData, null);
		charts.get(0).setTitle(forAirplane);
		charts.get(1).setTitle(forAirplane);

		// update scatter
		// add to Lat Lon list our current location!

		chart_scatter.updateXYSeries(SERIES_NAME_SCATTER, scatterLatitude, scatterLongitude, null);
		
		List<Double> myScatterX = new ArrayList<Double>();
		myScatterX.add(Const.DEF_LATITUDE);
		List<Double> myScatterY = new ArrayList<Double>();
		myScatterY.add(Const.DEF_LONGITUDE);
		chart_scatter.updateXYSeries("myLocation", myScatterX, myScatterY, null);
		
		sw.repaint();
		sw_scatter.repaint();

	}

	@Override
	public void debugPrintData() {
		System.out.println(Arrays.toString(timeData.toArray()));
		System.out.println(Arrays.toString(distanceData.toArray()));
		System.out.println(Arrays.toString(altitudeData.toArray()));
		System.out.println(Arrays.toString(scatterLatitude.toArray()));
		System.out.println(Arrays.toString(scatterLongitude.toArray()));
	}

}
