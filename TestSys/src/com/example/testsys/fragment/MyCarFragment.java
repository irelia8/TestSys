package com.example.testsys.fragment;

import java.util.ArrayList;

import com.example.testsys.R;
import com.example.testsys.adapter.CarAdapter;
import com.example.testsys.adapter.SensorGridAdapter;
import com.example.testsys.bean.Car;
import com.example.testsys.bean.SensorBean;
import com.example.testsys.bean.SensorValue;
import com.example.testsys.request.GetCarAB;
import com.example.testsys.request.GetCarSpeedRequest;
import com.example.testsys.request.GetSensorRequest;
import com.example.testsys.util.NetUtil;


import android.R.integer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MyCarFragment extends Fragment {

	private View rootView;
	private ListView listView;
	private ArrayList<Car> cars;
	private EditText text1,text2;
	private CarAdapter adapter;
	private LoadingDialog lodingdialog;
	private GridView gridView;
	private ArrayList<SensorBean> sensorBeans;
	private SensorGridAdapter mAdapter;
	private 	GetSensorRequest getSensorRequest;
	private Handler handler2=new Handler(){
		public void handleMessage(Message msg) {
			updateView((SensorValue)msg.obj);
		};
	};
private Handler handler=new Handler(){
	public void handleMessage(Message msg) {
		try {
			if(msg.what==1){
				adapter.notifyDataSetChanged();
				HideLoading();
				Toast.makeText(getActivity(), "充值成功", Toast.LENGTH_LONG).show();
			}
			else{
				listView.removeAllViewsInLayout();
			cars=(ArrayList<Car>) msg.obj;
			adapter = new CarAdapter(cars, getActivity());
			listView.setAdapter(adapter);
			HideLoading();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		};
};
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return rootView = inflater.inflate(R.layout.myvar_fragmrnt, container,
				false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		listView = (ListView) rootView.findViewById(R.id.car);
		text1=(EditText)rootView.findViewById(R.id.car_id);
		text2=(EditText)rootView.findViewById(R.id.car_p);
        Button cz=(Button) rootView.findViewById(R.id.cx);
        Button sx=(Button) rootView.findViewById(R.id.sx);
        ShowLoading();
		theard();
		sensorBeans = new ArrayList<SensorBean>();
		sensorBeans.add(new SensorBean("CO2"));
		sensorBeans.add(new SensorBean("光照强度"));
		sensorBeans.add(new SensorBean("PM"));
		sensorBeans.add(new SensorBean("温度"));
		gridView = (GridView) getView().findViewById(R.id.gridView1);
		mAdapter = new SensorGridAdapter(getActivity(), sensorBeans);
		gridView.setAdapter(mAdapter);
	   getSensorRequest=new GetSensorRequest(handler2);
		getSensorRequest.setLoop(true, 1000);
		getSensorRequest.startThread();
		cz.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ShowLoading();
				new Thread(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						String url = "http://172.16.164.3:8080/transportservice/type/jason/action/";
						 url = url + "SetCarAccountRecharge.do";
                         String strJson = "{\"CarId\":" +  Integer.valueOf(text1.getText().toString()) + ",\"Money\":" +  Integer.valueOf(text2.getText().toString()) + "}";
                         NetUtil.sendByPost(url, strJson);
                     	for (int i = 1; i <= 4; i++) {
        					GetCarAB ab = new GetCarAB(i);
        					GetCarSpeedRequest carSpeedRequest = new GetCarSpeedRequest(
        							i);
        					String url1 = "http://172.16.164.3:8080/transportservice/type/jason/action/";
        					url1 = url1 + ab.getActionName();
        					String url2 = "http://172.16.164.3:8080/transportservice/type/jason/action/";
        					url2 = url2 + carSpeedRequest.getActionName();
        					String responsestr1 = NetUtil.sendByPost(url1,
        							ab.onGetJasonBody());
        					Integer object1 = ab.onJasonParese(responsestr1);
        					String responsestr2 = NetUtil.sendByPost(url2,
        							carSpeedRequest.onGetJasonBody());
        					Integer object2 = carSpeedRequest
        							.onJasonParese(responsestr2);
        					try {
        						if(cars!=null){
        							cars.get(i-1).setBalance(object1);
        							cars.get(i-1).setSpeed(object2);
        							}	
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
				
				}
				
				Message msg=new Message();
				msg.what=1;
				handler.sendMessage(msg);
					}
				}.start();
				//theard();
			}
			
		});
		sx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ShowLoading();
				theard();
			}
		});
	}

	private void theard() {
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				cars = new ArrayList<Car>();
				for (int i = 1; i <= 4; i++) {
					GetCarAB ab = new GetCarAB(i);
					GetCarSpeedRequest carSpeedRequest = new GetCarSpeedRequest(
							i);
					String url1 = "http://172.16.164.3:8080/transportservice/type/jason/action/";
					url1 = url1 + ab.getActionName();
					String url2 = "http://172.16.164.3:8080/transportservice/type/jason/action/";
					url2 = url2 + carSpeedRequest.getActionName();
					String responsestr1 = NetUtil.sendByPost(url1,
							ab.onGetJasonBody());
					Integer object1 = ab.onJasonParese(responsestr1);
					String responsestr2 = NetUtil.sendByPost(url2,
							carSpeedRequest.onGetJasonBody());
					Integer object2 = carSpeedRequest
							.onJasonParese(responsestr2);
					try {
						Car car=new Car(i, object2,object1);
						cars.add(car);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
					
				}
				
				Message msg=new Message();
				msg.what=2;
				msg.obj=cars;
				handler.sendMessage(msg);
			}
		}.start();
	}
	protected void ShowLoading()
	{
		if(lodingdialog==null)
		{
			lodingdialog=new LoadingDialog();	
		}
		lodingdialog.setStyle(DialogFragment.STYLE_NO_FRAME, 0);
		lodingdialog.show(getFragmentManager(), "loading");
		 
		
	}
	protected void HideLoading()
	{
		if(lodingdialog!=null)
		{
			lodingdialog.dismiss();
		}
	}
	
public void updateView(SensorValue value) {
		
		if (value != null) {

			SensorBean co2 = sensorBeans.get(0);
			co2.setValue(value.getCo2());
			co2.setMinValue(5000);
			co2.setMaxValue(7200);

			SensorBean light = sensorBeans.get(1);
			light.setValue(value.getLightIntensity());
			light.setMinValue(2000);
			light.setMaxValue(3000);

			SensorBean airT = sensorBeans.get(2);
			airT.setValue(value.getPm());
			airT.setMinValue(120);
			airT.setMaxValue(140);

			SensorBean airT2 = sensorBeans.get(3);
			airT2.setValue(value.getHumidity());
			airT2.setMinValue(20);
			airT2.setMaxValue(40);
            mAdapter.notifyDataSetChanged();
		}
	}
@Override
public void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
	  System.out.println("aaaaaaaa");	
		if(getSensorRequest!=null){
			getSensorRequest.restart();
		}
}
}
