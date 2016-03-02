package com.example.testsys.fragment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.*;
import org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine;

import com.example.testsys.bean.ChartPagerBean;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Handler;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;


public class ChartView{
	//刷新曲线图表
	
		public void chartView(Context context,ChartPagerBean chartPagerBean,LinearLayout layout)
		{
			/*请填写代码
			 * 
			 * 绘图
			 * */
			XYSeries series=new XYSeries(chartPagerBean.majorName);
			XYMultipleSeriesDataset dataset=new XYMultipleSeriesDataset();
			/*series.clear();
			dataset.clear();*/
			System.out.println(chartPagerBean.majorName+":"+chartPagerBean.majorValueList.size()+"条记录");
			for(int i=1;i<=chartPagerBean.majorValueList.size();i++)
			{
				System.out.println("chartPagerBean.majorValueList.get(i-1)="+chartPagerBean.majorValueList.get(i-1));
				series.add(i, chartPagerBean.majorValueList.get(i-1));
			}
			dataset.addSeries(series);
			XYMultipleSeriesRenderer renderer = buildRenderer(chartPagerBean);
			renderer.setChartTitle(chartPagerBean.majorName);
			renderer.setChartTitleTextSize(32);
			renderer.setXAxisMin(0);
			renderer.setXAxisMax(8);
			renderer.setYAxisMin(chartPagerBean.majorMin);
			renderer.setYAxisMax(chartPagerBean.majorMax);
			renderer.setAxesColor(Color.RED);
			renderer.setLabelsColor(Color.RED);
			renderer.setShowGrid(false);
			renderer.setGridColor(Color.GREEN);
			renderer.setXLabels(8);
			renderer.setYLabels(10);
			renderer.setXTitle("时间"+chartPagerBean.majorWarningMax);
			renderer.setYTitle("传感器"+chartPagerBean.majorWarningMin);
			renderer.setAxisTitleTextSize(24);
			renderer.setLabelsTextSize(20);
			renderer.setXLabelsColor(Color.WHITE);
			renderer.setYLabelsColor(0,Color.WHITE);
			renderer.setXLabelsPadding(5);
			renderer.setYLabelsPadding(8);
			renderer.setYLabelsAlign(Align.CENTER);
			renderer.setPointSize((float) 10);
			renderer.setShowLegend(true);
			renderer.setBackgroundColor(Color.alpha(Color.WHITE));
			renderer.setMarginsColor(Color.alpha(Color.WHITE));
			GraphicalView graphicalView=ChartFactory.getLineChartView(context, dataset, renderer);
			layout.removeAllViewsInLayout();
			layout.addView(graphicalView);
		}

		private XYMultipleSeriesRenderer buildRenderer(ChartPagerBean chartPagerBean) {
			// TODO Auto-generated method stub
			XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
			ColoursXYSeriesRenderer r = new ColoursXYSeriesRenderer();// 设置图表中曲线本身的样式，包括颜色、点的大小以及线的粗细等
			//设置折线的颜色(包含折线点)
			r.setColor(Color.BLUE);
			//设置折线点的样式
			r.setPointStyle(PointStyle.CIRCLE);
			r.setPointStrokeWidth(10);
			r.setChartValuesTextSize(30);
			//设置是否显示折线点文字属性
			r.setDisplayChartValues(true);
			//设置折线点文字距点的间距
			r.setChartValuesSpacing(20);
			//设置折线点文字距点的对齐方式
			r.setChartValuesTextAlign(Align.CENTER);
			//设置是否填充点
			r.setFillPoints(true);
			//设置折线的宽度
			r.setLineWidth(2);
			r.setPointColor(Color.GREEN);
			r.setUseColor(true);
			r.setWarningMaxValue(chartPagerBean.majorWarningMax);
			r.setWarningMinValue(chartPagerBean.majorWarningMin);
			r.setWarningColor(Color.RED);
			renderer.addSeriesRenderer(r);
			return renderer;
		}
}
