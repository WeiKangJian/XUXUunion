package com.example.real;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Mylist1Activity extends ListActivity {
	private static final String[] strs = new String[] {
		    "����1     ���⣺", "����2    ���⣺", "����3   ���⣺", "����4   ���⣺", "����5.....    ���⣺"
		    };//����һ��String����������ʾListView������
		private ListView lv;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_mylist1);
	lv = (ListView) findViewById(R.id.lv);//�õ�ListView���������
	/*ΪListView����Adapter��������*/
	lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));

	    }
	}
