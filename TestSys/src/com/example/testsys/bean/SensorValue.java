package com.example.testsys.bean;

public class SensorValue {
     private  int pm;
     private  int co2;
     private  int temp;
     private int LightIntensity;
     private int humidity;
	public int getPm() {
		return pm;
	}
	public void setPm(int pm) {
		this.pm = pm;
	}
	public int getCo2() {
		return co2;
	}
	public void setCo2(int co2) {
		this.co2 = co2;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public int getLightIntensity() {
		return LightIntensity;
	}
	public void setLightIntensity(int lightIntensity) {
		LightIntensity = lightIntensity;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public String toString() {
		return "道路环境 ：pm25=" + pm + ", temp=" + temp + ", humidity="
				+ humidity + ", co2=" + co2 ;
	}

}
