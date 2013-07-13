package com.horia.array;

public class Container {

	public Container(int low, int high, int sum) {
		super();
		this.low = low;
		this.high = high;
		this.sum = sum;
	}
	private int low;
	private int high;
	private int sum;
	public int getLow() {
		return low;
	}
	public int getHigh() {
		return high;
	}
	public int getSum() {
		return sum;
	}
	@Override
	public String toString() {
		return "Container [low=" + low + ", high=" + high + ", sum=" + sum
				+ "]";
	}
}
