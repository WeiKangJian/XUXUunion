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
		  // 构造器
		new AsyncTask<Void, Void, String>(){
			//异步通信模块
			@Override
			protected String doInBackground(Void... arg0) {
				URLConnection uc;
				StringBuffer Pargrams = new StringBuffer();//创建缓冲区，把参数先放到缓冲区中
				for(int i = 0;i<kvs.length;i+=2){
					Pargrams.append(kvs[i]).append("=").append(kvs[i+1]).append("&");// 构造键值对
				}
				try { 
					uc = new URL(url).openConnection(); //打开连接
					switch (httpmethod) {
					case Post://当方法为POST,往这个链接写入我们的键值对，方便后台导入数据库
						uc.setDoOutput(true);//POST方法必须要声明，GET不用。默认为FALSE
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(uc.getOutputStream(), "utf-8"));
						 //创建一个写入数据的缓冲区，getOutputStream是获取要写入的数据。给定编码格式UTF-8
						bw.write(Pargrams.toString());
						//给定要写进服务器的数据，转换为ToSTRING。+
						break;
					default:
						//不是POST时。是GET方式，需要把请求的键值对写到请求的网页URL中去，再获取返回值，就是告诉后端我们需要什么数据，等待后端返回
						uc = new URL(url+"?"+Pargrams.toString()).openConnection();
						break;
					
		                              }
				System.out.println("URL"+uc.getURL());//调试用
				System.out.println("pargames"+Pargrams.toString()); //调试用
				//下面的代码块是获取服务器响应的数据,设定为result
				BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream(), "utf-8"));
				StringBuffer result = new StringBuffer();
				String line = null;
					while((line=br.readLine())!=null){
						result.append(line);
					}
				System.out.println("result"+result.toString()); //调试用
				return result.toString();// 返回DOINBACKGROUND的值，就是下面的RESULT,就是服务器的响应，通过下方的ONPOSTEXEUCTE回调给主线程
				} catch (MalformedURLException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}

				
				return null;
			}
			@Override
			
			protected void onPostExecute(String result) {
				 // 在使用onPostExecute的时候，一般步骤是先把result的值传给一个接口，再通过主线程（UI线程）
				if(result!=null){
					if(sb!= null){
						sb.Onsuccess(result);// 和下方的ONSUCESS不同，这个是得到RESULT然后处理的SUCCESS
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
	  
	  
	  public static interface successback{//JAVA回调机制，在初始化中调用被实现的接口的方法
		  void Onsuccess(String result);
	  }
	  
	  public static interface failback{
		  void Onfail();
	  }
	  
}
