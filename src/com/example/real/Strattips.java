package com.example.real;

import Config.thelistcontent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Strattips extends Activity {
		private Button button1;
		private EditText thetext;
		private EditText thetext2;
		private EditText thetext3;
		public static int  timeclick = 0;
		public static final String action ="123";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_strattips);
		button1=(Button) findViewById(R.id.buttontosend);
		thetext = (EditText) findViewById(R.id.mytext);
		thetext2 = (EditText) findViewById(R.id.name);
		thetext3 = (EditText) findViewById(R.id.maincontent);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(timeclick>=3){
					toast("您今天发布的帖子已经达到上限");
					finish();
				}else{
				timeclick++;
				thelistcontent.flag=true;
				thelistcontent.Mycontent=thetext.getText().toString();
				thelistcontent.Myname = thetext2.getText().toString();
				thelistcontent.Mymain = thetext3.getText().toString();
//				Intent intent = new Intent(action); 
//				intent.putExtra("dir",true);
//                sendBroadcast(intent);
				toast("发布成功");
				startlist1();
				finish();
				}
			}
		});
	}
	private void toast(String content){
		Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
			
		}
	private void startlist1(){
		Intent intent =new Intent(this,Mylist1Activity.class);
		startActivity(intent);
	}
}
