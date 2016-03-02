package com.example.testsys.adapter;

import java.util.ArrayList;

import com.example.testsys.R;
import com.example.testsys.bean.Car;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CarAdapter extends BaseAdapter {

	private ArrayList<Car> arrayList;
	private LayoutInflater mInflater;
	private Context context;

	public class ViewHolder {
		TextView textView1;
		TextView textView2;
		TextView textView3;
	}

	public CarAdapter(ArrayList<Car> arrayList, Context context) {
		this.arrayList = arrayList;
		this.context = context;
		this.mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrayList.size();
	}

	@Override
	public Car getItem(int arg0) {
		// TODO Auto-generated method stub
		return arrayList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if (arg1 == null) {
			holder = new ViewHolder();

			arg1 = mInflater.inflate(R.layout.car_item, null);
			holder.textView1 = (TextView) arg1.findViewById(R.id.car_id);
			holder.textView2 = (TextView) arg1.findViewById(R.id.car_speed);
			holder.textView3 = (TextView) arg1.findViewById(R.id.car_balance);

			arg1.setTag(holder);
		} else {
			holder = (ViewHolder) arg1.getTag();
		}
		holder.textView1.setText(arrayList.get(arg0).getId()+"号车");
		holder.textView2.setText(arrayList.get(arg0).getSpeed()+"迈速度");
		holder.textView3.setText(arrayList.get(arg0).getBalance()+"元余额");

		return arg1;
	}

}
