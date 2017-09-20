package com.wx.auth;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class AuthUtil {
	 public static final String APPID="wxcf1aa1663bc40274";
	 public static final String APPSECRET="6db41f63ed129478ffebd919dd78b9bf";
	 public static final String TOKEN="qypaasQYPAASdjkorg";
	 public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException{
		 JSONObject jsonobject =null;
		 DefaultHttpClient client = new DefaultHttpClient();
		 HttpGet httpGet = new HttpGet(url);
		 HttpResponse response =client.execute(httpGet);
		 HttpEntity entity =response.getEntity();
		 if(entity !=null){
			 String result =EntityUtils.toString(entity,"UTF-8");
			 jsonobject = JSONObject.fromObject(result);
		 }
		 httpGet.releaseConnection();
		 return jsonobject;
	 }
}
