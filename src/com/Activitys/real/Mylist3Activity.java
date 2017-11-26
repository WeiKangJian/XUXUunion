package com.Activitys.real;

import com.example.real.R;

import Config.listAdapter2;
import Config.thelistcontent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Mylist3Activity extends Activity {
	private ListView lv;
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mylist3);
		lv = (ListView) findViewById(R.id.listViewcopy);
		listAdapter2 newadapter = new listAdapter2(this, R.layout.item, thelistcontent.getAllLists());
		lv.setAdapter(newadapter);
		button = (Button) findViewById(R.id.buttontoupdata);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				updata();
			}
		});
	}
   private void updata(){
	   onCreate(null);
	   
   }
}
