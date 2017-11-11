package com.example.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import android.os.AsyncTask;

public class Nettext {
	public Nettext(final String url,final HttpMethod method,final SucessBack sb,final FailBack fb,final String ...vegs){
		new AsyncTask<Void, Void, String>(){
			@Override
			protected String doInBackground(Void... arg0) {
				URLConnection uc;
				StringBuffer par = new StringBuffer();
				for(int i =0;i<vegs.length;i=i+2){
					par.append(vegs[i]).append("=").append(vegs[i+1]).append("&");
				}
			try {
				uc =new URL(url).openConnection();
				switch (method) {
				case Post:
					uc.setDoOutput(true);
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(uc.getOutputStream(), "utf-8"));
					bw.write(par.toString());
				default:
					uc = new URL(url+"?"+par.toString()).openConnection();
					break;
				}
				BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream(), "utf-8"));
				StringBuffer result = new StringBuffer();
				String line = null;
				while((line = br.readLine())!=null){
					result.append(line);
				}
				return result.toString();
			} catch (Exception e) {
				// TODO: handle exception
			}
				return null;
			}
			@Override
			protected void onPostExecute(String result) {
				if(result!=null){
					if(sb!=null)//?
					sb.Onsuccess(result);
				}else{
					if(fb!=null)
					fb.OnFalii();
				}
				// TODO Auto-generated method stub
				super.onPostExecute(result);
			}
			
		};
		
	}
	public static interface SucessBack{
		void Onsuccess(String result);
	}
	public static interface FailBack{
		void OnFalii();
	}
}
