package com.example.real;

import java.util.ArrayList;
import java.util.List;

import Config.listAdapter;
import Config.thelistcontent;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Mylist1Activity extends ListActivity {
		private ListView lv;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_mylist1);
	lv = (ListView) findViewById(R.id.lv);//�õ�ListView���������
	/*ΪListView����Adapter��������*/
	listAdapter newadapter = new listAdapter(this, R.layout.item, thelistcontent.getAllLists());
	lv.setAdapter(newadapter);
	    }
	}
