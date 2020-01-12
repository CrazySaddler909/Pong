package com.crazycode.game;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {

	public long myLong = 1234;

	public MyTimer() {
		final MyTimer test = new MyTimer();

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				run();
			}
		}, 0, test.myLong);
	}

	public void doStuff() {
		// do stuff here
	}

	public void run() {
		System.out.println("jeff");
	}
}