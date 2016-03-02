package com.example.testsys.util;

import java.util.ArrayList;

import android.os.Handler;
import android.os.Message;

import com.example.testsys.request.BaseRequestNew;


public class HttpThreadNew extends Thread {
	private Handler mHandler;
	private ArrayList<BaseRequestNew> mRequestList;
	private int loopPeriod = 1000;
	private boolean isLoop = false;
	private boolean isRun = true;


	public HttpThreadNew(Handler handler, ArrayList<BaseRequestNew> mRequestList) {
		super();
		this.mHandler = handler;
		this.mRequestList = mRequestList;
	}

	public void setLoop(boolean isLoop, int loopPeriod) {
		this.isLoop = isLoop;
		this.loopPeriod = loopPeriod;
	}

	public void stopRequestThread() {
		isRun = false;

		isLoop = false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

		do {

			for (int i = 0; i < mRequestList.size(); i++) {
				
				BaseRequestNew mRequest = mRequestList.get(i);
				System.out.println("----REQUEST:" + i + "------"
						+ mRequest.getTAG());			
				System.out.println(mRequest.getUrl() + "--------url------"
						+ mRequest.getTAG());
				System.out.println(mRequest.getRequeststr()
						+ "--------Requeststr-------" + mRequest.getTAG());
				String responseStr = "";
				responseStr = HttpUtil.sendByPost(mRequest.getUrl(),
						mRequest.onGetJasonBody(mRequest.getRequeststr()));
				System.out.println(responseStr + "--------responseStr---------"
						+ mRequest.getTAG());
				mRequest.onJasonParese(responseStr);

				System.out.println(mRequest.returnValue
						+ "----------returnValue---------" + mRequest.getTAG());

				if (mHandler != null) {
					Message msg = new Message();
					msg.what = i;
					msg.obj = mRequest.returnValue;
					mHandler.sendMessage(msg);
				}

				if (isLoop) {
					try {
						Thread.sleep(loopPeriod);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}

		} while (isLoop);

	}

}
