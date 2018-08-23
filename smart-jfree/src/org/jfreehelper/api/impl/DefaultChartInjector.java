package org.jfreehelper.api.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfreehelper.api.ChartInjector;
import org.jfreehelper.api.ChartThemeManager;

public class DefaultChartInjector implements ChartInjector {
	public String injectChart(HttpServletRequest req, JFreeChart chart) {
		return injectChart(req,chart,imageURL);
	}
	public String injectChart(HttpServletRequest req, JFreeChart chart,
			String $label) {
		try {
			String imageName=ServletUtilities.saveChartAsPNG(chart, width, height,req.getSession());
			String imageURL=req.getContextPath()+"/DisplayChart?filename="+imageName;
			req.setAttribute("imageURL", imageURL);
			return imageURL;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "none";
	}
	public String injectChart(HttpServletRequest req, DefaultCategoryDataset ds) {
		JFreeChart chart=createChart(ds);
		return injectChart(req,chart);
	}
	public String injectChart(HttpServletRequest req,DefaultCategoryDataset ds, String $label) {
		JFreeChart chart=createChart(ds);
		return injectChart(req, chart, $label);
	}
	public JFreeChart createChart(DefaultCategoryDataset ds) {
		//设置主题
		ChartFactory.setChartTheme(ChartThemeManager.defaultTheme.getStandardChartTheme());
		//创建图表
		JFreeChart chart=ChartFactory.
		createBarChart("", "", "", ds,PlotOrientation.VERTICAL, true, true, true);
		return chart;
	}

}
