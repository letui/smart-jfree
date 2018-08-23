package org.jfreehelper.api;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfreehelper.api.impl.DefaultChartInjector;

public interface ChartInjector {
	String imageURL="imageURL";
	int width=800;
	int height=300;
	ChartInjector self=new DefaultChartInjector();
	public JFreeChart createChart(DefaultCategoryDataset ds);
	public String injectChart(HttpServletRequest req,JFreeChart chart);
	public String injectChart(HttpServletRequest req,JFreeChart chart,String $label);
	public String injectChart(HttpServletRequest req,DefaultCategoryDataset ds);
	public String injectChart(HttpServletRequest req,DefaultCategoryDataset ds,String $label);
}
