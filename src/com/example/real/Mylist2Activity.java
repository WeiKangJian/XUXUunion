package com.example.real;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Mylist2Activity extends Activity {
	private VideoView video1;
	private Button button1;
	private Button button2;
	public static final String url = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4" ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mylist2);
		String videourl = url;
		Uri uri = Uri.parse(videourl);
		video1 = (VideoView) findViewById(R.id.videoView);
		video1.setOnCompletionListener( new MyPlayerOnCompletionListener());
		video1.setVideoURI(uri);
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			int flag = 1;
			@Override
			public void onClick(View arg0) {
				if(flag==1){
				video1.start();
				flag = 0;
				button1.setText("暂停");
				}
				else if(flag==0){
					video1.pause();
					flag = 1;
					button1.setText("播放");
				}
			}
		});
//		button2 = (Button) findViewById(R.id.button2);
//		button2.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				video1.pause();
//				// TODO Auto-generated method stub
//				
//			}
//		});
	}
	class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText( Mylist2Activity.this, "感谢您的收看", Toast.LENGTH_SHORT).show();
        }
    }
}
