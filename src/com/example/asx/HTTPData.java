package com.example.asx;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.R.string;
import android.os.AsyncTask;

public class HTTPData extends AsyncTask<String, Void, String> {
	
	private HttpClient nHttpClient;
	private HttpGet nHttpGet;
	private HttpResponse nHttpResponse;
	private HttpEntity nHttpEntity;
	private InputStream in;
	private HttpGetDataListener listener;
	private String url;
	public HTTPData(String url,HttpGetDataListener listener){
		this.url = url;
		this.listener=listener;

	}
	@Override
	protected String doInBackground(String... params) {
		try {
			nHttpClient = new DefaultHttpClient();
			nHttpGet = new HttpGet(url);
			nHttpResponse = nHttpClient.execute(nHttpGet);
			nHttpEntity =nHttpResponse.getEntity();
			in = nHttpEntity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
			StringBuffer sb = new StringBuffer();
			while ((line = br.readLine())!= null){
				sb.append(line);
			}
			return sb.toString();
		} catch (Exception e) {

		}
		return null;
	}
	@Override
	protected void onPostExecute(String result) {
		listener.getDataUrl(result);
		super.onPostExecute(result);
	}
	
}
