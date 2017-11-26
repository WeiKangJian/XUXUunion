package com.Activitys.real;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.example.real.R;

import Config.Danmu;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Listdetail extends Activity implements View.OnClickListener {
    private Button add, send;
    private RelativeLayout root;
    private Timer timer;
    private EditText etadd;
    boolean isIn = true, isStart = true;
    int i = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listdetail);
		final Intent intent3 = new Intent(this,Mylist1Activity.class);
		  int imageId = getIntent().getIntExtra("teacher_image", 0);//ԭ�������� д����teacher_name
	        String desc = getIntent().getStringExtra("teacher_desc");

	        // ��ȡ�ض�����ͼ
	        ImageView imageView = (ImageView) findViewById(R.id.teacher_large_imageView);
	        TextView textView = (TextView) findViewById(R.id.teacher_desc_textView);

	        // ��������������ͼչ��
	        imageView.setImageResource(imageId);
	        textView.setText(desc);
	        view();
	}
	private void toast(String content){
		Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
			
		}
	 public void view() {
	        root = (RelativeLayout) findViewById(R.id.RERERE);
	        add = (Button) findViewById(R.id.button29);
	        etadd = (EditText) findViewById(R.id.editText9);
	        send = (Button) findViewById(R.id.button19);
	        send.setOnClickListener(this);
	        add.setOnClickListener(this);
	        isrun();
	    }
	 
	    @Override
	    public void onClick(View v) {
	        switch (v.getId()) {
	            case R.id.button29:
	            	if(isStart == true){
	                    timer.cancel();
	                    isStart = false;
	                    add.setText("�鿴����");
	                    root.removeAllViews();
	            	}else{
	            		isrun();
	            		isStart = true;
	            		 add.setText("ֹͣ��Ļ");
	            	}
	                break;
	            case R.id.button19:
	                if(!etadd.getText().toString().equals("")){
	                    adddamu(true);
	                    etadd.setText("");
	                    toast("���۳ɹ�");
	                }else{
	                	toast("����������");
	                }
	                break;
	        }
	    }
	 
	    public void adddamu(boolean text) {
	        String[] str = {"��ð�,�ҿ��Ƕ�ʵĵ�Ļ", "hello boy,this is your word", "�ټ�������!!!",
	                "�ҵ�ɵ�ܵܰ����㷸ʲôɵ��!", "��EDGզ��,������Ȼ��֧������!", "666666,������Ҹ�����", "�Ҿ����������������Ӯ��"};
//	        int[] color = {color.red, R.color.blue, R.color.white,R.color.yellow};
	        TextView tv = new TextView(this);
	        tv.setTextSize(20);
	        //��Ϊ��������������ĺ��Լ����͵ĵ�Ļ
	        if (text == false) {
//	            tv.setBackgroundResource(color[(int) (Math.random() * color.length)]);
	            tv.setText(str[(int) (Math.random() * str.length)]);
	        } else {
	            tv.setText(etadd.getText().toString());
	            tv.setTextColor(Color.GREEN);
//	            tv.setBackgroundResource(R.drawable.right);
	        }
	        root.addView(tv);
	        new Danmu(tv, root, isIn);
	    }
	//ʹ�ü�ʱ��+handle����������Ļ���������������Ŀؼ�
	    public void isrun() {
	        timer = new Timer();
	        TimerTask task = new TimerTask() {
	            @Override
	            public void run() {
	                i++;
	                Message message = handler.obtainMessage();
	                handler.sendMessage(message);
	            }
	        };
	        timer.schedule(task, new Date(), 200);
	    }
	 
	    private Handler handler = new Handler() {
	        @Override
	        public void handleMessage(Message msg) {
	            if (i == 2) {
	        //��������Ŀؼ�
	                root.removeAllViews();
	                i = 0;
	            }
	            adddamu(false);
	            super.handleMessage(msg);
	        }
	    };
	}
