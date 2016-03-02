package com.example.testsys.fragment;




import com.example.testsys.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

		//使用DialogFragment至少需要实现onCreateView或者onCreateDIalog方法。
		@TargetApi(Build.VERSION_CODES.HONEYCOMB) //onCreateView即使用定义的xml布局文件展示Dialog。
		//onCreateDialog即利用AlertDialog或者Dialog创建出Dialog。
@SuppressLint("NewApi") public class LoadingDialog extends DialogFragment{
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		LinearLayout layout= (LinearLayout) inflater.inflate(R.layout.load_progress_dialog, null);
		ImageView imageView=(ImageView) layout.findViewById(R.id.progress_dialog_icon);
		Animation animation=AnimationUtils.loadAnimation(getActivity(), R.anim.loadingdata);
		imageView.setAnimation(animation);
		return layout;
	}
}
