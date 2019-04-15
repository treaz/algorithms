package com.horiaconstantin.misc;

public class FiboMain {

	//really bad impl...
	public static void main(String[] args) throws InterruptedException {
		FiboCalc f = new FiboCalc();
		f.n=10;
		new Thread(f).start();
		Thread.sleep(10000);
		System.out.println(f.result);
	}
}
