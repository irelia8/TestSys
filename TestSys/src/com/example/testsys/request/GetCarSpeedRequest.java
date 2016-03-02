package com.example.testsys.request;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;


public class GetCarSpeedRequest extends BaseRequest {

	private static final String ACTION = "GetCarSpeed.do";
	private int id;
	private Integer s;
	public GetCarSpeedRequest(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
	}
   public GetCarSpeedRequest(int id) {
	// TODO Auto-generated constructor stub
	   this.id=id;
}
	@Override
	public String getActionName() {
		// TODO Auto-generated method stub
		return ACTION;
	}
   @Override
public String onGetJasonBody() {
	// TODO Auto-generated method stub
       JSONObject jsonObject=new JSONObject();
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
		 String s1=jsonObject.getString("serverinfo");
		   jsonObject=new JSONObject(s1);
		   return s=jsonObject.getInt("CarSpeed") ;
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	return null;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
public Integer getS() {
	return s;
}


   
}
