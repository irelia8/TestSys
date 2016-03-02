package com.example.testsys.bean;

/**
 * @author zongbingwu
 * 传感器信息类，包含了传感器的名称，�?�，以及其阀值范�?
 */
public class SensorBean 
{
	//传感器名
	private String name = "";
	//传感器的
	private int value = 0;
	//传感器阀值的
	private int minValue = Integer.MIN_VALUE;
	//传感器阀值的
	private int maxValue = Integer.MIN_VALUE;
	
	public SensorBean(String name)
	{
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getMinValue() {
		return minValue;
	}
	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}
	public int getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	
}
