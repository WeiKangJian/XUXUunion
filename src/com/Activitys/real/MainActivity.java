package com.Activitys.real;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.real.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity{	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Timer timer = new Timer();
		final Intent intent = new Intent(this,LoginActivity.class);
		TimerTask task  = new TimerTask() {
			@Override
			public void run() {
					startActivity(intent);
					MainActivity.this.finish();
			}
	};
	timer.schedule(task, 2000);
	}
}
