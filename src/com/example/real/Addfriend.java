package com.example.real;

import Config.config2;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Addfriend extends Activity {
	private Button button;
	private Toast toast;
	public Context Addfriend;
	private void setfriend(){
		config2.setcacheToken(this, getIntent().getStringExtra("teacher_name"));
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addfriend);
		button = (Button) findViewById(R.id.buttonToAdd);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				toast("�����ͳɹ�");
				setfriend();
				finish();
			}
		});
		int imageId = getIntent().getIntExtra("teacher_image", 0);//ԭ�������� д����teacher_name
	    final String name =  getIntent().getStringExtra("teacher_name");
	    String introduce = getIntent().getStringExtra("teacher_introduce");
	    // ��ȡ�ض�����ͼ
	    ImageView imageView = (ImageView) findViewById(R.id.imageViewofadd);
	    TextView textView = (TextView) findViewById(R.id.textViewofintroduce);
	    TextView textView2 = (TextView) findViewById(R.id.textViewofadd);
	    // ��������������ͼչ��
	    imageView.setImageResource(imageId);
	    textView.setText(introduce);
	    textView2.setText(name);
	}
	private void toast(String content){
		Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
			
		}
}
