package com.Activitys.real;

import java.util.ArrayList;
import java.util.List;

import com.example.real.Danmutext;
import com.example.real.R;

import Config.thelistcontent;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class ListActivity extends Activity {
	    private RelativeLayout re;
	    private IntentFilter intentFilter;
	    private NetworkChangeReceiver networkChangeReceiver;
		private View image2;
		private View image1;
		private View image3;
		private View image4;
		private View image5;
		private View image6;
		private View image7;
		private View image8;
		private Spinner spinner;
		private ArrayAdapter<String> adapter;
		private List<String> list = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mylist);
		intentFilter = new IntentFilter();
		intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
		networkChangeReceiver = new NetworkChangeReceiver();
		registerReceiver(networkChangeReceiver, intentFilter);
		list.add("北京外国语大学");
		list.add("北京理工大学");
		list.add("中国人民大学");
		re = (RelativeLayout) findViewById(R.id.re);
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
		image1 = findViewById(R.id.imageView1);
		image2 = findViewById(R.id.imageView2);
		image3 =findViewById(R.id.imageView5);
		image4 = findViewById(R.id.imageView3);
		image5 = findViewById(R.id.six);
		image6 = findViewById(R.id.imageView4);
		image7 = findViewById(R.id.imageView7);
		image8 = findViewById(R.id.imageView8);
		spinner = (Spinner) findViewById(R.id.spinner1);
		spinner.setAdapter(adapter);
		image2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {;
					startmylist1();
			}
		});
		image1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startmylist2();
			}
		});
		image3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startmylist3();
			}
		});
		image4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				strataddFriend();
			}
		});
		image5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startSend();
			}
		});
		image6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startRobert();
			}
		});
		image7.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startMyfo();
			}
		});
		image8.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startToast();
			}
		});
		spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				if(adapter.getItem(arg2)=="北京外国语大学") {
					re.setBackgroundResource(R.drawable.list1);
				}
				else if(adapter.getItem(arg2)=="北京理工大学") {
					re.setBackgroundResource(R.drawable.bit);
				}
			}
                                                                                                                                                                                                                                                             
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	protected void onDestroy(){
		super.onDestroy();
		unregisterReceiver(networkChangeReceiver);
	}
	private void startmylist1(){
		Intent intent1 = new Intent(this,Mylist1Activity.class);
		startActivity(intent1);
	}
	private void startmylist2(){
		Intent intent2 = new Intent(this,Mylist2Activity.class);
		startActivity(intent2);
	}
	private void startmylist3(){
		Intent intent3 = new Intent(this,Mylist3Activity.class);
		startActivity(intent3);
	}
	private void strataddFriend(){
		Intent intent4 = new Intent(this,FriendList.class);
		startActivity(intent4);
	}
	private void startSend(){
		Intent intent5 = new Intent(this,Strattips.class);
		startActivity(intent5);
	}
	private void startRobert(){
		Intent intent6 = new Intent(this,Robert.class);
		startActivity(intent6);
	}
	private void startMyfo(){
		Intent intent7 = new Intent(this,Myinfo.class);
		startActivity(intent7);
	}
	private void startToast(){
		Intent intent8 = new Intent(this,Danmutext.class);
		startActivity(intent8);
		Toast.makeText(this, "该功能尚未开放", Toast.LENGTH_SHORT).show();
		
	}
	 class NetworkChangeReceiver extends BroadcastReceiver{
			@Override
			public void onReceive(Context context, Intent intent) {
				// TODO Auto-generated method stub
				ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
				NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
				if(networkInfo!=null&&networkInfo.isAvailable()){
					Toast.makeText(context, "连接到服务器", Toast.LENGTH_SHORT).show();
				}else
				{
					Toast.makeText(context, "连接服务器失败", Toast.LENGTH_SHORT).show();
				}
				
			}
		 
	 }

}
