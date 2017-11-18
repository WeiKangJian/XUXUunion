package com.example.asx;

import java.util.List;

import com.example.real.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TextAdapter extends BaseAdapter{
	private List<ListData> lists;
	private Context ncontext;
	private RelativeLayout layout;
	
	public TextAdapter(List<ListData> lists,Context ncontext) {
		this.lists =lists;
		this.ncontext=ncontext;
	
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lists.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return lists.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(ncontext);
		if(lists.get(position).getFlag()==ListData.RECEIVE){
				layout = (RelativeLayout) inflater.inflate(R.layout.leftitem, null);
		}
		if(lists.get(position).getFlag()==ListData.SEND){
			layout = (RelativeLayout) inflater.inflate(R.layout.rightitem, null);
		}
		TextView tv = (TextView) layout.findViewById(R.id.tv);
		tv.setText(lists.get(position).getContent());
		return layout;
	}
	

}
