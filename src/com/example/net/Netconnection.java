package com.example.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.os.AsyncTask;

public class Netconnection {
	  public Netconnection(final String url,final HttpMethod httpmethod,final successback sb,final failback fb,final String ...kvs){
		  // ������
		new AsyncTask<Void, Void, String>(){
			//�첽ͨ��ģ��
			@Override
			protected String doInBackground(Void... arg0) {
				URLConnection uc;
				StringBuffer Pargrams = new StringBuffer();//�������������Ѳ����ȷŵ���������
				for(int i = 0;i<kvs.length;i+=2){
					Pargrams.append(kvs[i]).append("=").append(kvs[i+1]).append("&");// �����ֵ��
				}
				try { 
					uc = new URL(url).openConnection(); //������
					switch (httpmethod) {
					case Post://������ΪPOST,���������д�����ǵļ�ֵ�ԣ������̨�������ݿ�
						uc.setDoOutput(true);//POST��������Ҫ������GET���á�Ĭ��ΪFALSE
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(uc.getOutputStream(), "utf-8"));
						 //����һ��д�����ݵĻ�������getOutputStream�ǻ�ȡҪд������ݡ����������ʽUTF-8
						bw.write(Pargrams.toString());
						//����Ҫд�������������ݣ�ת��ΪToSTRING��+
						break;
					default:
						//����POSTʱ����GET��ʽ����Ҫ������ļ�ֵ��д���������ҳURL��ȥ���ٻ�ȡ����ֵ�����Ǹ��ߺ��������Ҫʲô���ݣ��ȴ���˷���
						uc = new URL(url+"?"+Pargrams.toString()).openConnection();
						break;
					
		                              }
				System.out.println("URL"+uc.getURL());//������
				System.out.println("pargames"+Pargrams.toString()); //������
				//����Ĵ�����ǻ�ȡ��������Ӧ������,�趨Ϊresult
				BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream(), "utf-8"));
				StringBuffer result = new StringBuffer();
				String line = null;
					while((line=br.readLine())!=null){
						result.append(line);
					}
				System.out.println("result"+result.toString()); //������
				return result.toString();// ����DOINBACKGROUND��ֵ�����������RESULT,���Ƿ���������Ӧ��ͨ���·���ONPOSTEXEUCTE�ص������߳�
				} catch (MalformedURLException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}

				
				return null;
			}
			@Override
			
			protected void onPostExecute(String result) {
				 // ��ʹ��onPostExecute��ʱ��һ�㲽�����Ȱ�result��ֵ����һ���ӿڣ���ͨ�����̣߳�UI�̣߳�
				if(result!=null){
					if(sb!= null){
						sb.Onsuccess(result);// ���·���ONSUCESS��ͬ������ǵõ�RESULTȻ�����SUCCESS
					}
				}else{
					if(fb!=null){
						fb.Onfail();
					}
				}
				super.onPostExecute(result);
			} 
		  };
	  }
	  
	  
	  public static interface successback{//JAVA�ص����ƣ��ڳ�ʼ���е��ñ�ʵ�ֵĽӿڵķ���
		  void Onsuccess(String result);
	  }
	  
	  public static interface failback{
		  void Onfail();
	  }
	  
}
