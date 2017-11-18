package com.example.real;

import java.util.ArrayList;
import java.util.List;

import Config.listAdapter;
import Config.thelistcontent;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Mylist1Activity extends ListActivity {
		private ListView lv;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_mylist1);
	lv = (ListView) findViewById(R.id.lv);//得到ListView对象的引用
	/*为ListView设置Adapter来绑定数据*/
	listAdapter newadapter = new listAdapter(this, R.layout.item, thelistcontent.getAllLists());
	lv.setAdapter(newadapter);
//	IntentFilter filter = new IntentFilter(Strattips.action); 
//    registerReceiver(broadcastReceiver, filter); 
	    }
//	BroadcastReceiver broadcastReceiver = new BroadcastReceiver(){
//
//		@Override
//		public void onReceive(Context context, Intent intent) {
//			// TODO Auto-generated method stub
//			if(intent.getExtras().getBoolean("dir")){
//				onCreate(null);
//			}
//			
//		}
//		
//	};
//	 protected void onDestroy() { 
//
//	        unregisterReceiver(broadcastReceiver); 
//
//	    }; 
	}
