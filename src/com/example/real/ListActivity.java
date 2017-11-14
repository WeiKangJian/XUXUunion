package com.example.real;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class ListActivity extends Activity {
	    private RelativeLayout re;
		private View image2;
		private View image1;
		private View image3;
		private Spinner spinner;
		private ArrayAdapter<String> adapter;
		private List<String> list = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mylist);
		list.add("北京理工大学");
		list.add("北京外国语大学");
		list.add("中国人民大学");
		re = (RelativeLayout) findViewById(R.id.re);
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
		image1 = findViewById(R.id.imageView1);
		image2 = findViewById(R.id.imageView2);
		image3.findViewById(R.id.imageView5);
		spinner = (Spinner) findViewById(R.id.spinner1);
		spinner.setAdapter(adapter);
		image2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
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

}
