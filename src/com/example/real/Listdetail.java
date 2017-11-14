package com.example.real;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Listdetail extends Activity {
	private Button submit;
	private Toast toast;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listdetail);
		final Intent intent3 = new Intent(this,Mylist1Activity.class);
		submit = (Button) findViewById(R.id.button1);
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				toast("评论成功");
				finish();
			}
		});
		  int imageId = getIntent().getIntExtra("teacher_image", 0);//原文有问题 写的是teacher_name
	        String desc = getIntent().getStringExtra("teacher_desc");

	        // 获取特定的视图
	        ImageView imageView = (ImageView) findViewById(R.id.teacher_large_imageView);
	        TextView textView = (TextView) findViewById(R.id.teacher_desc_textView);

	        // 根据数据设置视图展现
	        imageView.setImageResource(imageId);
	        textView.setText(desc);
	}
	private void toast(String content){
		Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
			
		}
}
