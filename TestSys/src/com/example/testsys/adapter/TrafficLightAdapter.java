package com.example.testsys.adapter;

import java.util.List;

import com.example.testsys.R;
import com.example.testsys.bean.TrafficLight;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TrafficLightAdapter extends ArrayAdapter<TrafficLight> {
	 LayoutInflater inflater ;
	 TextView red;
	 TextView green;
	 TextView yellow;
	 
	public TrafficLightAdapter(Context context, int resource,
			List<TrafficLight> tfLightsList) {
		super(context, resource, tfLightsList);
		inflater = LayoutInflater.from(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		TrafficLight tl = getItem(position);
		
         View view = inflater.inflate(R.layout.item_tl, null);
         red = (TextView) view.findViewById(R.id.red);
         green = (TextView) view.findViewById(R.id.green);
         yellow = (TextView) view.findViewById(R.id.yellow);
         red.setText("红灯：" + tl.getRedTime());
         green.setText("绿灯：" + tl.getRedTime());
         yellow.setText("黄灯：" + tl.getYellowTime());
         return view;
	}
}
