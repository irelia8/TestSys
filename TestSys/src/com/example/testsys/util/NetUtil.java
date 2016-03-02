package com.example.testsys.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public  class  NetUtil {

	public static String sendByPost(String url, String params) {

//		BufferedReader in = null;
//		StringBuffer sb=null;
//		try {
//			URL relUrl = new URL(url);
//			URLConnection con = relUrl.openConnection();
//			con.setDoOutput(true);
//			con.setDoInput(true);
//			con.setReadTimeout(20 * 1000);
//			con.setConnectTimeout(20 * 1000);
//			OutputStream os = con.getOutputStream();
//			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
//			osw.write(params);
//			osw.flush();
//			osw.close();
//			in = new BufferedReader(new InputStreamReader(con.getInputStream(),
//					"utf-8"));
//		    sb=new StringBuffer();
//			String line;
//			while((line=in.readLine())!=null){
//			    sb.append(line);
//			}
//			
//			return sb.toString();
//
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
     DefaultHttpClient httpClient=new DefaultHttpClient();
     HttpPost httpPost=new HttpPost(url);
     try {
		httpPost.setEntity(new StringEntity(params));
		HttpResponse response=httpClient.execute(httpPost);
		int res=response.getStatusLine().getStatusCode();
		if(res==200){
			HttpEntity entity=response.getEntity();
			String s=EntityUtils.toString(entity);
			System.out.println(s);
			return s;
		}
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;

	}
}
