package com.example.testsys.bean;

public class Car {
     private  int id;
     private  int speed;
     private int balance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Car(int id, int speed, int balance) {
		super();
		this.id = id;
		this.speed = speed;
		this.balance = balance;
	}
    
}
