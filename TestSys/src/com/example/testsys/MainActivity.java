package com.example.testsys;

import java.util.ArrayList;

import org.w3c.dom.ls.LSInput;


import com.example.testsys.adapter.MenuAdapter;
import com.example.testsys.bean.Menu;
import com.example.testsys.bean.SensorValue;
import com.example.testsys.fragment.MyCarFragment;
import com.example.testsys.fragment.NewsFragment;
import com.example.testsys.request.GetSensorRequest;
import com.slidingmenu.lib.SlidingMenu;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

 @TargetApi(Build.VERSION_CODES.HONEYCOMB) public class MainActivity extends FragmentActivity implements OnItemClickListener {

	private Button button;
	private TextView tiltle;
	private TextView tv;
	private ListView listView;
	private MenuAdapter adapter;
    private MyCarFragment Carfragment;
    private NewsFragment newsFragment;
    private SlidingMenu menu;
    private ArrayList<Menu> arrayList;
    private Handler handler=new Handler(new Handler.Callback() {
		
		@Override
		public boolean handleMessage(Message arg0) {
			// TODO Auto-generated method stub
			if (arg0.what==1) {
				SensorValue sensorValue=(SensorValue) arg0.obj;
				System.out.println(sensorValue.getCo2());
				tv.setText(sensorValue.toString());
			}
			return false;
		}
	});
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.button1);
		tiltle=(TextView) findViewById(R.id.tilite);
		tv=(TextView) findViewById(R.id.road_env_tv);
	    menu = new SlidingMenu(this);
		menu.setMode(SlidingMenu.LEFT);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		menu.setBehindOffset(getWindowManager().getDefaultDisplay().getWidth()/5);
		menu.attachToActivity(this,SlidingMenu.RIGHT);
		menu.setMenu(R.layout.left_meu);
		listView = (ListView) menu.findViewById(R.id.list_view);
		arrayList = new ArrayList();
		Menu menu1 = new Menu("C", "我的座驾");
		Menu menu2 = new Menu("R", "我的路况");
		Menu menu3 = new Menu("P", "公交查询");
		Menu menu4 = new Menu("B", "停车查询");
		Menu menu5 = new Menu("E", "道路环境");
		arrayList.add(menu1);
		arrayList.add(menu2);
		arrayList.add(menu3);
		arrayList.add(menu4);
		arrayList.add(menu5);
		adapter = new MenuAdapter(arrayList, this);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				menu.showMenu();
			}
		});
         GetSensorRequest sensorRequest=new GetSensorRequest(handler);
         sensorRequest.setLoop(true, 5000);
         sensorRequest.startThread();
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
		hideFragment(transaction);
		switch (arg2) {
		case 0:
			if (Carfragment==null) {
				Carfragment=new MyCarFragment();
				transaction.add(R.id.content, Carfragment);
			}
			else{
				transaction.show(Carfragment);
			}
			break;
		case 1:
			if(newsFragment==null){
				newsFragment=new NewsFragment();
				transaction.add(R.id.content, newsFragment);
			}
			else{
				transaction.show(newsFragment);
				}
		default:
			
		}
		transaction.commit();
		tiltle.setText(arrayList.get(arg2).getName());
		menu.toggle();
	}
    private void hideFragment(android.support.v4.app.FragmentTransaction transaction ) {
		if(Carfragment!=null){
			transaction.hide(Carfragment);
		}
		if(newsFragment!=null){
			transaction.hide(newsFragment);
		}
	}
}
