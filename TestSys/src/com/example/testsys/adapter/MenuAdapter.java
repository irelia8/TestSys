package com.example.testsys.adapter;

import java.util.ArrayList;

import com.example.testsys.R;
import com.example.testsys.bean.Menu;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MenuAdapter extends BaseAdapter{
   
	private ArrayList<Menu> arrayList;
	private LayoutInflater mInflater;
	private Context context;
	
	public class ViewHolder{
		TextView textView1;
		TextView textView2;
	}
	
	public MenuAdapter(ArrayList<Menu> arrayList,
			Context context) {
		this.arrayList = arrayList;
		this.context = context;
		this.mInflater =LayoutInflater.from(context) ;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrayList.size();
	}

	@Override
	public Menu getItem(int arg0) {
		// TODO Auto-generated method stub
		return arrayList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if(arg1==null){
			holder=new ViewHolder();
			
		arg1=mInflater.inflate(R.layout.list_item, null);
		holder.textView1=(TextView) arg1.findViewById(R.id.id);
		holder.textView2=(TextView) arg1.findViewById(R.id.id2);
        arg1.setTag(holder);
		}
		else{
			holder=(ViewHolder) arg1.getTag();
		}
		holder.textView1.setText(arrayList.get(arg0).getId());
		holder.textView2.setText(arrayList.get(arg0).getName());
		
		return arg1;
	}

	
}
