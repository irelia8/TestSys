package com.example.testsys.fragment;

import java.util.ArrayList;

import com.example.testsys.R;
import com.example.testsys.adapter.ChartViewAdapter;
import com.example.testsys.bean.ChartPagerBean;
import com.example.testsys.bean.SensorValue;
import com.example.testsys.request.GetSensorRequest;



import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class ChartViewFragment extends Fragment {
	private View rootView;
	private GridView gridView;
	private ChartViewAdapter mAdapter;
	private ArrayList<ChartPagerBean> mChartArray;
	private ChartPagerBean mCo2Chart;
	private ChartPagerBean mLightChart;
	private ChartPagerBean mAirTChart;
	private ChartPagerBean mPMChart;
	private GetSensorRequest getSensorRequest;
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			System.out.println(((SensorValue) msg.obj).toString());
			onGetSensor((SensorValue) msg.obj);
		};
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.real_time_data_activity,
				container, false);
		return rootView;
	}
  @Override
public void onActivityCreated(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onActivityCreated(savedInstanceState);
	initView();
}
	private void initView() {
		// TODO Auto-generated method stub
		gridView = (GridView) rootView.findViewById(R.id.gridView2);
		mChartArray = new ArrayList<ChartPagerBean>();

		mCo2Chart = new ChartPagerBean("CO2");
		mLightChart = new ChartPagerBean("光照");
		mAirTChart = new ChartPagerBean("温度");
		mPMChart = new ChartPagerBean("PM");

		mChartArray.add(mCo2Chart);
		mChartArray.add(mLightChart);
		mChartArray.add(mAirTChart);
		mChartArray.add(mPMChart);

		mAdapter = new ChartViewAdapter(mChartArray, getActivity());
		gridView.setAdapter(mAdapter);
		getSensorRequest = new GetSensorRequest(handler);
		getSensorRequest.setLoop(true, 1000);
		getSensorRequest.startThread();
	}

	public void onGetSensor(SensorValue value) {

		if (value != null) {

			// C02浓度
			mCo2Chart.majorMin = 0;// co2的最小值
			mCo2Chart.majorMax = 1000;// co2的最大值
			mCo2Chart.setMajorWarningMin(5000);
			mCo2Chart.setMajorWarningMax(7200);

			// 光照强度
			mLightChart.majorMin = 0;// 光照强度最小值
			mLightChart.majorMax = 15000;// 光照强度最大值
			mLightChart.setMajorWarningMin(2000);
			mLightChart.setMajorWarningMax(3000);

			// 空气温度
			mAirTChart.majorMin = 0;// 空气温度最小值
			mAirTChart.majorMax = 100;// 空气温度最大值
			mAirTChart.setMajorWarningMin(20);
			mAirTChart.setMajorWarningMax(40);

			// 空气湿度
			mPMChart.majorMin = 0;// 空气湿度最小值
			mPMChart.majorMax = 100;// 空气湿度最大值
			mPMChart.setMajorWarningMin(120);
			mPMChart.setMajorWarningMax(140);

			if (mCo2Chart.majorValueList.size() == 8) {
				mCo2Chart.majorValueList.remove(0);
			}
			mCo2Chart.majorValueList.add(value.getCo2());

			if (mLightChart.majorValueList.size() == 8) {
				mLightChart.majorValueList.remove(0);
			}
			mLightChart.majorValueList.add(value.getLightIntensity());

			if (mAirTChart.majorValueList.size() == 8) {
				mAirTChart.majorValueList.remove(0);
			}
			mAirTChart.majorValueList.add(value.getTemp());

			if (mPMChart.majorValueList.size() == 8) {
				mPMChart.majorValueList.remove(0);
			}
			mPMChart.majorValueList.add(value.getPm());

		}

		mAdapter.notifyDataSetChanged();
	}
}
