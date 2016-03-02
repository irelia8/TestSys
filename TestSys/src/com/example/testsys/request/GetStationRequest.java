package com.example.testsys.request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.testsys.bean.BusStation;

public class GetStationRequest extends BaseRequestNew<BusStation> {

	private BusStation busStation;
	public GetStationRequest(String url, String requeststr) {
		super(url, requeststr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String onGetJasonBody(String requeststr) {
		// TODO Auto-generated method stub
		String strJson = "{\"BusStationId\":" +  Integer.valueOf(requeststr) + "}";
		
		return strJson;
	}

	@Override
	public void onJasonParese(String responseStr) {
		// TODO Auto-generated method stub
		System.out.println(responseStr+"===========onJasonparese============================");
		
		try {
			busStation = new BusStation();
			JSONObject jsobj = new JSONObject(responseStr);
			String stationStr = jsobj.getString("serverinfo");
			JSONArray stationArray = new JSONArray(stationStr);
			
			JSONObject Distance1 = stationArray.getJSONObject(0);
			JSONObject Distance2 = stationArray.getJSONObject(1);
			
			busStation.setDistanceTo1(Distance1.getInt("Distance"));
			busStation.setDistanceTo2(Distance2.getInt("Distance"));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if (busStation.getDistanceTo1()!=0) {
			super.returnValue = busStation;
		}
	}

}
