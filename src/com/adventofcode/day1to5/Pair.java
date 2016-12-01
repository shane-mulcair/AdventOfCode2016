package com.adventofcode.day1to5;

public class Pair {

	public Pair(int x,int y){
		this.x=x;
		this.y=y;
	}
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o){
		Pair p=(Pair)o;
		return p.getX()==this.getX() && p.getY()==this.getY();
	}
	
}
