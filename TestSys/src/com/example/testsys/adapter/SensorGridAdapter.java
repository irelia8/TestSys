package com.example.testsys.adapter;

import java.util.ArrayList;


import com.example.testsys.R;
import com.example.testsys.bean.SensorBean;


import android.R.raw;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SensorGridAdapter extends BaseAdapter {

	private static class ViewHolder {
		LinearLayout bgLayout;
		TextView sensorName;
		TextView stautsTextView;
		TextView setValeuTextView;
		TextView valueTextView;

	}

	private Context mContext;
	private ArrayList<SensorBean> beans;
	private LayoutInflater mInflater;

	public SensorGridAdapter(Context mContext, ArrayList<SensorBean> beans) {
		this.mContext = mContext;
		this.beans = beans;
		mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return beans.size();
	}

	@Override
	public SensorBean getItem(int arg0) {
		// TODO Auto-generated method stub
		return beans.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.sensor_grid_item, null);
			holder.bgLayout = (LinearLayout) convertView
					.findViewById(R.id.bgLayout);
			holder.sensorName = (TextView) convertView
					.findViewById(R.id.sensor_grid_item_name);
			holder.setValeuTextView = (TextView) convertView
					.findViewById(R.id.sensor_grid_item_set_value);
			holder.stautsTextView = (TextView) convertView
					.findViewById(R.id.sensor_grid_item_status);
			holder.valueTextView = (TextView) convertView
					.findViewById(R.id.sensor_grid_item_value);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		SensorBean bean = beans.get(position);
		holder.sensorName.setText(bean.getName());
		holder.valueTextView.setText(bean.getValue()+"");
		boolean bStatus = bean.getValue() <= bean.getMaxValue()
				&& bean.getValue() >= bean.getMinValue();
		holder.stautsTextView.setText(bStatus ? "正常" : "预警");
		holder.bgLayout.setBackgroundColor(bStatus ? mContext.getResources()
				.getColor(R.color.green) : mContext.getResources().getColor(
				R.color.red));
		holder.setValeuTextView.setText(bean.getMinValue()+"~"+bean.getMaxValue());
	
		return convertView;
	}

}
