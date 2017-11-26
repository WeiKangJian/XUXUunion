package com.Activitys.real;

import com.example.real.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PrivateComment extends Activity {
	private ImageView image1;
	private EditText  edit1;
	private TextView textview;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_private_comment);
		image1 =(ImageView) findViewById(R.id.imageViewOfPrivate);
		textview = (TextView) findViewById(R.id.textViewOfPrivate);
		edit1 = (EditText) findViewById(R.id.editTextOfPrivate);
		button = (Button) findViewById(R.id.buttontoSend);
		
		
		int imageId = getIntent().getIntExtra("teacher_image", 0);//ԭ�������� д����teacher_name
	    final String name =  getIntent().getStringExtra("teacher_name");
//	    String introduce = getIntent().getStringExtra("teacher_introduce");
	    // ��ȡ�ض�����ͼ
//	    ImageView imageView = (ImageView) findViewById(R.id.imageViewofadd);
//	    TextView textView = (TextView) findViewById(R.id.textViewofintroduce);
//	    TextView textView2 = (TextView) findViewById(R.id.textViewofadd);
	    // ��������������ͼչ��
	    image1.setImageResource(imageId);
//	    textview.setText(introduce);
	    textview.setText(name);
	    button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(!edit1.getText().toString().equals("")){
				toast("���ͳɹ��������������");
				finish();
				}else{
					toast("����������");
				}
			}
		});
	}
	private void toast(String string){
		Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
	}

}
