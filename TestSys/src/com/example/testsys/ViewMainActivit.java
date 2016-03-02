package com.example.testsys;

import java.util.ArrayList;
import java.util.List;

import com.example.testsys.adapter.ViewPagerAdapter;
import com.example.testsys.fragment.ChartViewFragment;
import com.example.testsys.fragment.MyCarFragment;
import com.example.testsys.fragment.NewsFragment;



import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.FrameLayout;

public class ViewMainActivit extends FragmentActivity {

	private List<Fragment> fragments;
	private ViewPager m_vp;
	private PagerTabStrip pagerTabStrip;
	private ViewPagerAdapter adapter;
	ArrayList<String> titleList = new ArrayList<String>();

	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_main);
		m_vp = (ViewPager) findViewById(R.id.view_pager);

		pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagertab);
		pagerTabStrip.setTabIndicatorColor(getResources().getColor(
				android.R.color.holo_green_dark));
		pagerTabStrip.setBackgroundColor(getResources().getColor(
				android.R.color.holo_blue_dark));
		fragments = new ArrayList<Fragment>();
		fragments.add(new MyCarFragment());
		fragments.add(new NewsFragment());
		fragments.add(new NewsFragment());
		titleList.add("我的座驾 ");
		titleList.add("道路状况");
		titleList.add("环境图标");
		adapter=new ViewPagerAdapter(getSupportFragmentManager(), fragments, titleList);
		m_vp.setAdapter(adapter);

	}

}
