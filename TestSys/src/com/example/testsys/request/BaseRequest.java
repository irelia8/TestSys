package com.example.testsys.request;


import com.example.testsys.util.NetUtil;

import android.os.Handler;
import android.os.Message;

public abstract class BaseRequest {

	public String action;
	public String responsestr;
	protected Handler handler;
	private volatile boolean mCancel = false;
	public boolean isLoop;
	public boolean isPause;
	private volatile int loopPeriod = 1000;// 默认为1秒

	public BaseRequest(Handler handler) {
		this.handler = handler;
	}
  public BaseRequest() {
	// TODO Auto-generated constructor stub
}
	public void startThread() {
		// TODO Auto-generated method stub
		new Thread() {

			public void run() {
				String url = "http://172.16.164.3:8080/transportservice/type/jason/action/";
				url = url + getActionName();
				System.out.println(url);
				do {
					responsestr = NetUtil.sendByPost(url, onGetJasonBody());
					Object object = onJasonParese(responsestr);
					
					if (handler != null) {
						Message message = new Message();
						message.what = 1;
						message.obj = object;
						handler.sendMessage(message);
					}
					try {
						Thread.sleep(loopPeriod);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} while (isLoop);
			};

		}.start();
	}

	protected abstract String getActionName(); // 获取当前请求动作名称

	// 当前是jason协议时的获取body函数,要求子类覆盖定义该函数
	protected String onGetJasonBody() {
		return "";
	}

	// 当前是jason协议时解析回应函数,要求子类覆盖定义该函数
	protected Object onJasonParese(String responseStr) {
		return null;
	}

	// 判断线程是否暂停
	public void pause() {
		isPause = true;
	}

	// 线程重新开始
	public void restart() {
		isLoop = false;
	}

	// 设置线程是否为循环执行
	public void setLoop(boolean isLoop, int loopPeriod) {
		this.isLoop = isLoop;
		this.loopPeriod = loopPeriod;
	}
}
