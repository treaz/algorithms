package com.horiaconstantin.random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RateLimiterTest {

	private RateLimiter rateLimiter;

	@BeforeEach
	void beforeEach() {
		rateLimiter = new RateLimiter(Duration.ofSeconds(2), 2);
	}

	@Test
	void testCanInvokeOnce() {
		assertTrue(rateLimiter.canInvoke());
	}

	@Test
	void testCanInvokeInShortSuccession() {
		rateLimiter = new RateLimiter(Duration.ofSeconds(60), 2);
		assertTrue(rateLimiter.canInvoke());
		assertTrue(rateLimiter.canInvoke());
		assertFalse(rateLimiter.canInvoke());
	}

	@Test
	void testCanInvokeWithBurst() throws InterruptedException {
		for (int i = 0; i < 2; i++) {
			assertTrue(rateLimiter.canInvoke());
			assertTrue(rateLimiter.canInvoke());
			TimeUnit.SECONDS.sleep(2);
		}
	}

	@Test
	void testCanInvokeConstantly() throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			assertTrue(rateLimiter.canInvoke());
			TimeUnit.SECONDS.sleep(1);
		}
	}

	@Test
	void testCanInvokeConstantlyTooFast() throws InterruptedException {
		for (int i = 0; i < 2; i++) {
			assertTrue(rateLimiter.canInvoke());
			TimeUnit.MILLISECONDS.sleep(950);
		}
		assertFalse(rateLimiter.canInvoke());
	}

}