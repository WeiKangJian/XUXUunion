package com.Activitys.real;

import com.example.real.R;

import Config.ListAdapter3;
import Config.Myfriendinfo;
import Config.config2;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class FriendList extends Activity {
	private ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_friend_list);
		lv = (ListView) findViewById(R.id.listViewcopy2);
		ListAdapter3 adapter = new ListAdapter3(this, R.layout.item, Myfriendinfo.getAllLists());
		lv.setAdapter(adapter);
		Myfriendinfo.mid = null;
	}
}
