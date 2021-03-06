package com.example.testsys.fragment;


import java.util.ArrayList;

import com.example.testsys.R;
import com.example.testsys.adapter.TrafficLightAdapter;
import com.example.testsys.bean.BusStation;
import com.example.testsys.bean.Environment;
import com.example.testsys.bean.TrafficLight;
import com.example.testsys.util.HttpThreadNew;
import com.example.testsys.request.BaseRequest;
import com.example.testsys.request.BaseRequestNew;
import com.example.testsys.request.GetCarSpeedRequest;
import com.example.testsys.request.GetEnvironmentRequest;
import com.example.testsys.request.GetStationRequest;
import com.example.testsys.request.GetTrafficLight;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

public class EnvironmentFragment extends Fragment{
	
	
	
	ArrayAdapter<TrafficLight> trafficlightAdapter;
	private ListView lv_trafficlight;
	private TextView tv_station1;
	private TextView tv_station2;
	private ArrayList<TrafficLight> trafficLightList;

	private BusStation station1;
	private BusStation station2;
	
	private ArrayList<BaseRequestNew> requestList;
	private GetTrafficLight request1;
	private GetTrafficLight request2;
	private GetTrafficLight request3;
	private GetTrafficLight request4;
	private GetTrafficLight request5;
	private GetStationRequest request6;
	private GetStationRequest request7;
	
	
	Handler mHandler = new Handler(){
		
		public void handleMessage(Message msg) {
			
			switch (msg.what) {
			case 0:
				updateTrafficLight(trafficLightList.get(0),(TrafficLight) msg.obj);
				break;
			case 1:
				updateTrafficLight(trafficLightList.get(1),(TrafficLight) msg.obj);
				break;
			case 2:
				updateTrafficLight(trafficLightList.get(2),(TrafficLight) msg.obj);
				break;
			case 3:
				updateTrafficLight(trafficLightList.get(3),(TrafficLight) msg.obj);
				break;
			case 4:
				updateTrafficLight(trafficLightList.get(4),(TrafficLight) msg.obj);
				break;
			case 5:
				updateStation(station1,(BusStation) msg.obj);
				break;
			case 6:				
				updateStation(station2,(BusStation) msg.obj);
				break;
				
				
			default:
				System.out.println("notchange");
				break;
			}
			
			updateView();
			
		};
		
	};
	
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initData();
		startThread();
	}
	
	
	protected void updateTrafficLight(TrafficLight oldTL, TrafficLight newTL) {
		// TODO Auto-generated method stub
		oldTL.setGreenTime(newTL.getGreenTime());
		oldTL.setRedTime(newTL.getRedTime());
		oldTL.setYellowTime(newTL.getYellowTime());
		
	}


	protected void updateStation(BusStation oldStation, BusStation newStation) {
		// TODO Auto-generated method stub
		try {
			oldStation.setDistanceTo1(newStation.getDistanceTo1());
			oldStation.setDistanceTo2(newStation.getDistanceTo2());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("station  null");
		}
		
	}


	


	private void startThread() {
		// TODO Auto-generated method stub
		
		requestList = new ArrayList<BaseRequestNew>();
		request1 = new GetTrafficLight("http://172.16.164.3:8080/transportservice/type/jason/action/GetTrafficLightConfigAction.do",String.valueOf(1));
		request2 = new GetTrafficLight("http://172.16.164.3:8080/transportservice/type/jason/action/GetTrafficLightConfigAction.do",String.valueOf(2));
		request3 = new GetTrafficLight("http://172.16.164.3:8080/transportservice/type/jason/action/GetTrafficLightConfigAction.do",String.valueOf(3));
		request4 = new GetTrafficLight("http://172.16.164.3:8080/transportservice/type/jason/action/GetTrafficLightConfigAction.do",String.valueOf(4));
		request5 = new GetTrafficLight("http://172.16.164.3:8080/transportservice/type/jason/action/GetTrafficLightConfigAction.do",String.valueOf(5));
		
		request6 = new GetStationRequest("http://172.16.164.3:8080/transportservice/type/jason/action/GetBusStationInfo.do", String.valueOf(1));
		request7 = new GetStationRequest("http://172.16.164.3:8080/transportservice/type/jason/action/GetBusStationInfo.do", String.valueOf(2));
		request1.setTAG("GetTrafficLight");
		request2.setTAG("GetTrafficLight");
		request3.setTAG("GetTrafficLight");
		request4.setTAG("GetTrafficLight");
		request5.setTAG("GetTrafficLight");
		request6.setTAG("GetStation");
		request7.setTAG("GetStation");
		
		requestList.add(request1);
		requestList.add(request2);
		requestList.add(request3);
		requestList.add(request4);
		requestList.add(request5);
		requestList.add(request6);
		requestList.add(request7);
		
		
		HttpThreadNew threadNew = new HttpThreadNew(mHandler, requestList);
		threadNew.setLoop(true, 2000);
		threadNew.start();
		
		
		
	}


	private void initData() {
		trafficLightList = new ArrayList<TrafficLight>();
		
		
		for (int i = 0; i < 5; i++) {
			
			TrafficLight tf = new TrafficLight();
			tf.setGreenTime(0);
			tf.setRedTime(0);
			tf.setYellowTime(0);
			
			trafficLightList.add(tf);
		}
		
		station1 = new BusStation();
		station1.setDistanceTo1(0);
		station1.setDistanceTo2(0);
		
		station2 = new BusStation();
		station2.setDistanceTo1(0);
		station2.setDistanceTo2(0);
		
		
		
	}
	

	private void updateView() {
		trafficlightAdapter.notifyDataSetChanged();
		String str = "1号公交 : "+station1.getDistanceTo1()+"m，2号公交 : "+station1.getDistanceTo2()+"m";
		tv_station1.setText(str);
		str = "1号公交 : "+station2.getDistanceTo1()+"m，2号公交 : "+station2.getDistanceTo2()+"m";
		tv_station2.setText(str);
		
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_envio, container, false);
		initView(v);
		updateView();
		return v;
	}


	private void initView(View v) {
		// TODO Auto-generated method stub
		lv_trafficlight = (ListView) v.findViewById(R.id.lv_trafficLight);
		tv_station1 = (TextView) v.findViewById(R.id.tv_station1);
		tv_station2 = (TextView) v.findViewById(R.id.tv_station2);
		
		trafficlightAdapter = new TrafficLightAdapter(getActivity(), R.layout.item_tl, trafficLightList);
		lv_trafficlight.setAdapter(trafficlightAdapter);
	}
}
