package com.example.testsys.request;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

public class GetCarAB extends BaseRequest {
	private static final String ACTION = "GetCarAccountBalance.do";
	private int id;
	private int s1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GetCarAB(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
	}

	public GetCarAB(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	@Override
	public String getActionName() {
		// TODO Auto-generated method stub
		return ACTION;
	}

	@Override
	public String onGetJasonBody() {
		// TODO Auto-generated method stub
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("CarId", id);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject.toString();
	}

	@Override
	public Integer onJasonParese(String responseStr) {
		// TODO Auto-generated method stub
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(responseStr);
			String s = jsonObject.getString("serverinfo");
			jsonObject = new JSONObject(s);
			s1 = jsonObject.getInt("Balance");
			return s1;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public Integer getS1() {
		return s1;
	}

}
