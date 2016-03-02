
package com.example.testsys.request;

public abstract class BaseRequestNew<T> {
	private String url;
	private String requeststr;
	private String responseStr;
	public T returnValue;
	private String TAG;

	
	public BaseRequestNew(String url, String requeststr) {
		super();
		this.setUrl(url);
		this.requeststr = requeststr;
	}
	
	

	public String getRequeststr() {
		return requeststr;
	}



	public void setRequeststr(String requeststr) {
		this.requeststr = requeststr;
	}



	public String getResponseStr() {
		return responseStr;
	}



	public void setResponseStr(String responseStr) {
		this.responseStr = responseStr;
	}



	public abstract String onGetJasonBody(String requeststr);
	
	
	public abstract void onJasonParese(String responseStr);



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getTAG() {
		return TAG;
	}



	public void setTAG(String tAG) {
		TAG = tAG;
	}



	
	
	
	
}
