package com.example.testsys.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.pm.FeatureInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter  extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private ArrayList<String>   titleList   ;
	public ViewPagerAdapter(FragmentManager fm , List<Fragment> mFragments,ArrayList<String>   titleList   ) {
		super(fm);
		this.mFragments=mFragments;
		this.titleList=titleList;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return mFragments.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mFragments.size();
	}
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return titleList.get(position);
	}

}
