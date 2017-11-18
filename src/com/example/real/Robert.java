package com.example.real;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.asx.HTTPData;
import com.example.asx.HttpGetDataListener;
import com.example.asx.ListData;
import com.example.asx.TextAdapter;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.content.IntentSender.SendIntentException;
import android.location.GpsStatus.Listener;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Robert extends Activity implements HttpGetDataListener,OnClickListener {
	private HTTPData httpData;
	private List<ListData>lists;
	private ListView lv;
	private EditText sendText;
	private Button send_btn;
	private String content_str;
	private TextAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_robert);
	initview();
	}
	private void initview(){
		lv = (ListView) findViewById(R.id.lv);
		sendText = (EditText) findViewById(R.id.sendText);
		send_btn = (Button) findViewById(R.id.send_btn);
		lists = new ArrayList<ListData>();
		send_btn.setOnClickListener(this);
		adapter = new TextAdapter(lists, this);
		lv.setAdapter(adapter);
	}
	@Override
	public void getDataUrl(String data) {
		System.out.println(data);
		parseText(data);
	}
//	Ω‚Œˆ∑µªÿ÷µ
	 public void parseText(String str){
		 try {
			 JSONObject jb = new JSONObject(str);
//			 System.out.println(jb.getString("text"));
//			System.out.println(jb.getString("code"));
			 ListData listData;
			 listData = new ListData(jb.getString("text"),ListData.RECEIVE);
			 lists.add(listData);
			 adapter.notifyDataSetChanged(); 
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	@Override
	public void onClick(View v) {
		content_str =sendText.getText().toString();
		sendText.setText("");
		String dropk =content_str.replace(" ", "");
		String droph =dropk.replace("\n", "");
		ListData listData;
		listData = new ListData(content_str,ListData.SEND);
		lists.add(listData);
		adapter.notifyDataSetChanged();
		httpData =  (HTTPData) new HTTPData("http://www.tuling123.com/openapi/api?key=f12d0fb42c5c42088cba98ca99f23bdb&info="+droph,this).execute();			
	}
}