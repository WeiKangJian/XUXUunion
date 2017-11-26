package com.example.real;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import Config.Danmu;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Danmutext extends Activity implements View.OnClickListener {
    private Button add, send;
    private RelativeLayout root;
    private Timer timer;
    private EditText etadd;
    boolean isIn = true, isStart = true;
    int i = 0;
 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danmutext);
        view();
    }
 
    public void view() {
        root = (RelativeLayout) findViewById(R.id.RE);
        add = (Button) findViewById(R.id.caonima2);
        etadd = (EditText) findViewById(R.id.danmutext1);
        send = (Button) findViewById(R.id.caonima1);
        send.setOnClickListener(this);
        add.setOnClickListener(this);
        isrun();
    }
 
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.caonima2:
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
            case R.id.caonima1:
                if(!etadd.getText().toString().equals("")){
                    adddamu(true);
                    etadd.setText("");
                }
                break;
        }
    }
 
    public void adddamu(boolean text) {
        String[] str = {"��ð�,�ҿ��Ƕ�ʵĵ�Ļ", "hello boy,this is your word", "�ټ�������!!!",
                "�ҵ�ɵ�ܵܰ����㷸ʲôɵ��!", "��EDGզ��,������Ȼ��֧������!", "666666,������Ҹ�����", "�Ҿ����������������Ӯ��"};
//        int[] color = {color.red, R.color.blue, R.color.white,R.color.yellow};
        TextView tv = new TextView(this);
        tv.setTextSize(20);
        //��Ϊ��������������ĺ��Լ����͵ĵ�Ļ
        if (text == false) {
//            tv.setBackgroundResource(color[(int) (Math.random() * color.length)]);
            tv.setText(str[(int) (Math.random() * str.length)]);
        } else {
            tv.setText(etadd.getText().toString());
            tv.setTextColor(Color.GREEN);
//            tv.setBackgroundResource(R.drawable.right);
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
