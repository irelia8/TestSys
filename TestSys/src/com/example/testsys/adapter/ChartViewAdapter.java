package com.example.testsys.adapter;

import java.util.ArrayList;

import com.example.testsys.R;
import com.example.testsys.bean.ChartPagerBean;
import com.example.testsys.fragment.ChartView;


import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class ChartViewAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private ArrayList<ChartPagerBean> chartPagerBeans;
	private Context context;
	
	public ChartViewAdapter(ArrayList<ChartPagerBean> chartPagerBeans,
			Context context) {
		this.chartPagerBeans = chartPagerBeans;
		this.context = context;
		mInflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return chartPagerBeans.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return chartPagerBeans.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		FrameLayout layout;
		if(arg1!=null){
			layout=(FrameLayout)arg1;
		}
		else{
			layout=(FrameLayout) mInflater.inflate(R.layout.char_pager_item, null);
		}
		LinearLayout chart=(LinearLayout) layout.findViewById(R.id.chart);
		ChartView chartView=new ChartView();
		chartView.chartView(context, chartPagerBeans.get(arg0), chart);
		return layout;
	}

}
