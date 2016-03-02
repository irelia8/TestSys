package com.example.testsys.request;


import org.json.JSONException;
import org.json.JSONObject;

import com.example.testsys.bean.SensorValue;


import android.os.Handler;

public class GetSensorRequest  extends BaseRequest{
	// action name
		private static final String ACTION = "GetAllSense.do";
		// 存放传感器实时的值
		private SensorValue sensorValue=new SensorValue();
	
	public GetSensorRequest(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getActionName() {
		// TODO Auto-generated method stub
		return ACTION;
	}

	 @Override
	protected SensorValue onJasonParese(String responseStr) {
		// TODO Auto-generated method stub
		 JSONObject object;
		try {
			object = new JSONObject(responsestr);
			String t=object.getString("serverinfo");
			object=new JSONObject(t);
			sensorValue.setCo2(object.getInt("co2"));
			sensorValue.setHumidity(object.getInt("humidity"));
			sensorValue.setPm(object.getInt("pm2.5"));
			sensorValue.setTemp(object.getInt("temperature"));
			sensorValue.setLightIntensity(object.getInt("LightIntensity"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return sensorValue;
	}

}
