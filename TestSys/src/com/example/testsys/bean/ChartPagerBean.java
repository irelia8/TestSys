package com.example.testsys.bean;

import java.util.LinkedList;
/*
 * 曲线图表信息类，存储两个曲线图的信息
 */
public class ChartPagerBean 
{
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public LinkedList<Integer> getMajorValueList() {
		return majorValueList;
	}
	public void setMajorValueList(LinkedList<Integer> majorValueList) {
		this.majorValueList = majorValueList;
	}
	public int getMajorMin() {
		return majorMin;
	}
	public void setMajorMin(int majorMin) {
		this.majorMin = majorMin;
	}
	public int getMajorMax() {
		return majorMax;
	}
	public void setMajorMax(int majorMax) {
		this.majorMax = majorMax;
	}
	public int getMajorWarningMin() {
		return majorWarningMin;
	}
	public void setMajorWarningMin(int majorWarningMin) {
		this.majorWarningMin = majorWarningMin;
	}
	public int getMajorWarningMax() {
		return majorWarningMax;
	}
	public void setMajorWarningMax(int majorWarningMax) {
		this.majorWarningMax = majorWarningMax;
	}
	public boolean isHasSlave() {
		return isHasSlave;
	}
	public void setHasSlave(boolean isHasSlave) {
		this.isHasSlave = isHasSlave;
	}
	public String getSlaveName() {
		return slaveName;
	}
	public void setSlaveName(String slaveName) {
		this.slaveName = slaveName;
	}
	public LinkedList<Integer> getSlaveValueList() {
		return slaveValueList;
	}
	public void setSlaveValueList(LinkedList<Integer> slaveValueList) {
		this.slaveValueList = slaveValueList;
	}
	public int getSlaveMin() {
		return slaveMin;
	}
	public void setSlaveMin(int slaveMin) {
		this.slaveMin = slaveMin;
	}
	public int getSlaveMax() {
		return slaveMax;
	}
	public void setSlaveMax(int slaveMax) {
		this.slaveMax = slaveMax;
	}
	public int getSlaveWarningMin() {
		return slaveWarningMin;
	}
	public void setSlaveWarningMin(int slaveWarningMin) {
		this.slaveWarningMin = slaveWarningMin;
	}
	public int getSlaveWarningMax() {
		return slaveWarningMax;
	}
	public void setSlaveWarningMax(int slaveWarningMax) {
		this.slaveWarningMax = slaveWarningMax;
	}
	public ChartPagerBean(String majorName)
	{
		this.majorName = majorName;
	}
	
	//主曲线图的名称
	public String majorName = "";
	//主曲线图的点集合
	public LinkedList<Integer> majorValueList = new LinkedList<Integer>();
	//主曲线图y轴最小值
	public int majorMin = 0;
	//主曲线图y轴最大值
	public int majorMax = 0;
	//告警最小值
	public int majorWarningMin = 0;
	//告警最大值
	public int majorWarningMax = 0;
	
	//是否存在次曲线图
	public boolean isHasSlave = false;
	//次曲线图的名称
	public String slaveName = "";
	//次曲线图的点集合
	public LinkedList<Integer> slaveValueList = new LinkedList<Integer>();
	//次曲线图y轴最小值
	public int slaveMin = 0;
	//次曲线图y轴最大值
	public int slaveMax = 0;
	//告警最小值
	public int slaveWarningMin = 0;
	//告警最大值
	public int slaveWarningMax = 0;
}
