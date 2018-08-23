package org.jfreehelper.api;

import org.jfree.chart.StandardChartTheme;
import org.jfreehelper.api.impl.DefaultChartThemeManager;

public interface ChartThemeManager {
	ChartThemeManager defaultTheme=new DefaultChartThemeManager();
	StandardChartTheme getStandardChartTheme();
}
