package com.example.real;

import Config.config2;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class FriendList extends Activity {
	private TextView textview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_friend_list);
		textview = (TextView) findViewById(R.id.friendname);
		textview.setText(config2.getcacheToken(this));
	}
}
