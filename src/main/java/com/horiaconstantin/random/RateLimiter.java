package com.horiaconstantin.random;

import java.time.Duration;
import java.util.ArrayDeque;
import java.util.Queue;

public class RateLimiter {

	private Duration window;
	private int calls;
	private Queue<Long> invocations = new ArrayDeque<>();

	public RateLimiter(Duration window, int calls) {
		this.window = window;
		this.calls = calls;
	}

	public boolean canInvoke() {
		long currentTimeMillis = System.currentTimeMillis();
		if (invocations.size() == 0) {
			invocations.add(currentTimeMillis);
			return true;
		}
		Long oldestInvocation = invocations.peek();
		while (invocations.size() > 0 && currentTimeMillis > oldestInvocation + window.toMillis()) {
			invocations.poll();
			oldestInvocation = invocations.peek();
		}

		if (invocations.size() < calls) {
			invocations.add(currentTimeMillis);
			return true;
		}

		return false;
	}

}
