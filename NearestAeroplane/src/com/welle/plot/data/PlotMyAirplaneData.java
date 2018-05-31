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
import org.knowm.xchart.style.Styler.LegendPosition;

import com.welle.settings.and.constants.Const;

public class PlotMyAirplaneData implements PlotMyData {

	private enum Charts {
		Distance, Altitude, Speed, AllAirbornes;

		public int getIndex() {
			switch (this) {
			case Distance:
				return 0;
			case Altitude:
				return 1;
			case Speed:
				return 2;
			case AllAirbornes:
				return 3;
			}
			return 0;
		}
	}

	public static final String SERIES_NAME_DISTANCE = "Distance To our closest Airborne - Logger";
	public static final String SERIES_NAME_ALTITUDE = "Altitude To our closest Airborne - Logger";
	public static final String SERIES_NAME_SPEED = "Speed Of our closest Airborne - Logger";
	public static final String SERIES_NAME_ALL_COORDINATES = "Scatter of all Distances - Logger";
	public static final String SERIES_NAME_MY_LOCATION = "My Location - Logger";

	private List<Float> timeData = new ArrayList<Float>();
	private List<Float> distanceData = new ArrayList<Float>();
	private List<Float> altitudeData = new ArrayList<Float>();
	private List<Float> speedData = new ArrayList<Float>();

	private List<Float> scatterLatitude = new ArrayList<Float>();
	private List<Float> scatterLongitude = new ArrayList<Float>();

	// altitude and distance charts
	private List<XYChart> charts = new ArrayList<XYChart>();
	private JFrame swing_drawer;

	@Override
	public void initPlot() {

		// init lists
		timeData.add(0.0f);
		distanceData.add(0.0f);
		altitudeData.add(0.0f);
		speedData.add(0.0f);
		List<Float> dx = new ArrayList<Float>();
		dx.add(0.0f);
		List<Float> dy = new ArrayList<Float>();
		dy.add(0.0f);
		this.scatterLatitude = dx;
		this.scatterLongitude = dy;

		// Create Charts

		// distance
		XYChart chart_1 = QuickChart.getChart("Distance", "seconds * INTERVAL", "KM", SERIES_NAME_DISTANCE, timeData, distanceData);
		chart_1.getStyler().setLegendPosition(LegendPosition.InsideSE);
		charts.add(chart_1);

		// altitude
		XYChart chart_2 = QuickChart.getChart("Altitude", "seconds * INTERVAL", "M", SERIES_NAME_ALTITUDE, timeData, altitudeData);
		chart_2.getStyler().setLegendPosition(LegendPosition.InsideSE);
		chart_2.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);
		charts.add(chart_2);

		// speed
		XYChart chart_3 = QuickChart.getChart("Airborne Speed", "seconds * INTERVAL", "KM/h", SERIES_NAME_SPEED, timeData, speedData);
		chart_3.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);
		chart_3.getStyler().setLegendPosition(LegendPosition.InsideNE);
		charts.add(chart_3);

		// all location of airplanes

		// my location
		List<Float> myScatterX = new ArrayList<Float>();
		myScatterX.add(Const.DEF_LATITUDE);
		List<Float> myScatterY = new ArrayList<Float>();
		myScatterY.add(Const.DEF_LONGITUDE);

		// Create Chart Scatter
		XYChart chart_scatter = new XYChartBuilder().title("All Airbornes Ploted").xAxisTitle("Latitude").yAxisTitle("Longitude").build();
		chart_scatter.addSeries(SERIES_NAME_ALL_COORDINATES, scatterLatitude, scatterLongitude);
		chart_scatter.addSeries(SERIES_NAME_MY_LOCATION, myScatterX, myScatterY);
		// Customize Chart
		chart_scatter.getStyler().setLegendPosition(LegendPosition.InsideNE);
		chart_scatter.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Scatter);
		chart_scatter.getStyler().setMarkerSize(16);
		charts.add(chart_scatter);

	}

	@Override
	public void showPlot() {
		// show charts
		swing_drawer = new SwingWrapper<XYChart>(charts).displayChartMatrix();
	}

	@Override
	public void addAndUpdatePlot(String forAirplane, Float time, Float distance, Float altitude, Float speed, List<Float> scatterLatitude, List<Float> scatterLongitude) {

		// update data series
		timeData.add(time);
		distanceData.add(distance);
		altitudeData.add(altitude);
		speedData.add(speed);
		this.scatterLatitude = scatterLatitude;
		this.scatterLongitude = scatterLongitude;

		// update distance and altitude
		charts.get(Charts.Distance.getIndex()).updateXYSeries(SERIES_NAME_DISTANCE, timeData, distanceData, null);
		charts.get(Charts.Distance.getIndex()).setTitle(forAirplane);
		charts.get(Charts.Altitude.getIndex()).updateXYSeries(SERIES_NAME_ALTITUDE, timeData, altitudeData, null);
		charts.get(Charts.Altitude.getIndex()).setTitle(forAirplane);

		// speed update
		charts.get(Charts.Speed.getIndex()).updateXYSeries(SERIES_NAME_SPEED, timeData, speedData, null);
		charts.get(Charts.Speed.getIndex()).setTitle(forAirplane);

		// update scatter
		// add to Lat Lon list our current location!

		charts.get(Charts.AllAirbornes.getIndex()).updateXYSeries(SERIES_NAME_ALL_COORDINATES, scatterLatitude, scatterLongitude, null);
		List<Float> myScatterX = new ArrayList<Float>();
		myScatterX.add(Const.DEF_LATITUDE);
		List<Float> myScatterY = new ArrayList<Float>();
		myScatterY.add(Const.DEF_LONGITUDE);
		charts.get(Charts.AllAirbornes.getIndex()).updateXYSeries(SERIES_NAME_MY_LOCATION, myScatterX, myScatterY, null);

		// repait our views
		swing_drawer.repaint();

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
