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
		    "帖子1     主题：", "帖子2    主题：", "帖子3   主题：", "帖子4   主题：", "帖子5.....    主题："
		    };//定义一个String数组用来显示ListView的内容
		private ListView lv;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_mylist1);
	lv = (ListView) findViewById(R.id.lv);//得到ListView对象的引用
	/*为ListView设置Adapter来绑定数据*/
	lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));

	    }
	}
