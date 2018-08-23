package org.jfreehelper.api.impl;

import java.awt.Font;

import org.jfree.chart.StandardChartTheme;
import org.jfreehelper.api.ChartThemeManager;

public class DefaultChartThemeManager implements ChartThemeManager {

	public StandardChartTheme getStandardChartTheme() {
		StandardChartTheme theme = new StandardChartTheme("unicode");
		theme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 20));
		theme.setLargeFont(new Font("宋体", Font.PLAIN, 14));
		theme.setRegularFont(new Font("宋体", Font.PLAIN, 12));
		theme.setSmallFont(new Font("宋体", Font.PLAIN, 10));
		theme.setShadowVisible(false);
		return theme;
	}

}
