package com.horiaconstantin.random;

import java.time.Duration;

public class RateLimiter {

	private Duration window;
	private int calls;

	public RateLimiter(Duration window, int calls) {
		this.window = window;
		this.calls = calls;
	}

	public boolean canInvoke() {
		return false;
	}

}
