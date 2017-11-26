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
		  int imageId = getIntent().getIntExtra("teacher_image", 0);//原文有问题 写的是teacher_name
	        String desc = getIntent().getStringExtra("teacher_desc");

	        // 获取特定的视图
	        ImageView imageView = (ImageView) findViewById(R.id.teacher_large_imageView);
	        TextView textView = (TextView) findViewById(R.id.teacher_desc_textView);

	        // 根据数据设置视图展现
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
	                    add.setText("查看评论");
	                    root.removeAllViews();
	            	}else{
	            		isrun();
	            		isStart = true;
	            		 add.setText("停止弹幕");
	            	}
	                break;
	            case R.id.button19:
	                if(!etadd.getText().toString().equals("")){
	                    adddamu(true);
	                    etadd.setText("");
	                    toast("评论成功");
	                }else{
	                	toast("请输入内容");
	                }
	                break;
	        }
	    }
	 
	    public void adddamu(boolean text) {
	        String[] str = {"你好啊,我可是多彩的弹幕", "hello boy,this is your word", "再见啦您嘞!!!",
	                "我的傻弟弟啊，你犯什么傻呢!", "这EDG咋了,不过依然很支持他们!", "666666,这操作我给满分", "我觉得这个比赛认真点会赢得"};
//	        int[] color = {color.red, R.color.blue, R.color.white,R.color.yellow};
	        TextView tv = new TextView(this);
	        tv.setTextSize(20);
	        //是为了区别随机产生的和自己发送的弹幕
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
	//使用计时器+handle持续产生弹幕。并清除界面产生的控件
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
	        //清除产生的控件
	                root.removeAllViews();
	                i = 0;
	            }
	            adddamu(false);
	            super.handleMessage(msg);
	        }
	    };
	}
