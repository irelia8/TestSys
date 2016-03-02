package com.example.testsys.request;


import org.json.JSONException;
import org.json.JSONObject;


import com.example.testsys.bean.TrafficLight;

public class GetTrafficLight extends BaseRequestNew<TrafficLight> {

	private TrafficLight trafficLight;
	public GetTrafficLight(String url, String requeststr) {
		super(url, requeststr);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String onGetJasonBody(String requeststr) {
		// TODO Auto-generated method stub
		String strJson = "{\"TrafficLightId\":" +  Integer.valueOf(requeststr) + "}";
		
		return strJson;
	}

	@Override
	public void onJasonParese(String responseStr) {
		// TODO Auto-generated method stub
		
		
		try {
			trafficLight = new TrafficLight();
			JSONObject jsobj = new JSONObject(responseStr);
			String trafficLightStr = jsobj.getString("serverinfo");
			JSONObject trafficLightObj = new JSONObject(trafficLightStr);
			trafficLight.setGreenTime(trafficLightObj.getInt("GreenTime"));
			trafficLight.setYellowTime(trafficLightObj.getInt("YellowTime"));
			trafficLight.setRedTime(trafficLightObj.getInt("YellowTime"));
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
			super.returnValue = trafficLight;
		
		
	}

}
