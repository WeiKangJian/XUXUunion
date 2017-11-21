package com.example.real;

import Config.Config;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Myinfo extends Activity {
	private static boolean flag2 = false;
	//用来判断用户是否输入了信息
	private EditText edforNmae;
	private EditText edforschool;
	private EditText edforacc;
	private Button button;
	private TextView showname;
	private TextView showschool;
	private TextView showAcc;
	private Button button2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(flag2 == false){
		setContentView(R.layout.activity_myinfo);
		edforNmae= (EditText) findViewById(R.id.edforname);
		edforschool = (EditText) findViewById(R.id.editforschool);
		edforacc  = (EditText) findViewById(R.id.editforacc);
		button = (Button) findViewById(R.id.buttonme);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				cache();
				toast("提交成功");
				flag2 = true;
				finish();
			}
		});
		}else
		{
			setContentView(R.layout.my_info2);
			button2 = (Button) findViewById(R.id.buttontochange);
			showname = (TextView) findViewById(R.id.what);
			showschool = (TextView) findViewById(R.id.textViewtoschool);
			showAcc = (TextView) findViewById(R.id.textViewtoAcc);
			showname.setText(Config.getCachedToken(this,"Name"));
			showschool.setText(Config.getCachedToken(this,"School"));
			showAcc.setText(Config.getCachedToken(this, "Acc"));
			button2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					flag2 = false;
					onCreate(null);
				}
			});
			
		}
	}
	private void toast(String content){
		Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
			
		}
	private void cache(){
		Config.CachedToken(this, "Name", edforNmae.getText().toString());
		Config.CachedToken(this, "School", edforschool.getText().toString());
		Config.CachedToken(this, "Acc", edforacc.getText().toString());
	}
}
