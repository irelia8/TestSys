package com.example.testsys.request;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.testsys.bean.Environment;

public class GetEnvironmentRequest extends BaseRequestNew<Environment> {
	
	private Environment environment;
	
	public GetEnvironmentRequest(String url, String requeststr) {
		super(url, requeststr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String onGetJasonBody(String requeststr) {
		// TODO Auto-generated method stub
		return requeststr;
	}

	@Override
	public void onJasonParese(String responseStr) {
		// TODO Auto-generated method stub

		try {
			environment = new Environment();
			System.out.println(responseStr+"===========onJasonparese============================");
			JSONObject jsobj = new JSONObject(responseStr);
			String environmentStr = jsobj.getString("serverinfo");
			JSONObject environmentObj = new JSONObject(environmentStr);
			environment.setCo2(environmentObj.getInt("co2"));
			environment.setHumidity(environmentObj.getInt("humidity"));
			environment.setLight(environmentObj.getInt("LightIntensity"));
			environment.setPm25(environmentObj.getInt("pm2.5"));
			environment.setTemperature(environmentObj.getInt("temperature"));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if (environment.getCo2() != 0) {
			super.returnValue = environment;
		}
		
		
	}

}
