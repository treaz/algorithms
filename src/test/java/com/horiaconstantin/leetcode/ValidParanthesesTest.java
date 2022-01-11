package com.horiaconstantin.leetcode;

import org.junit.jupiter.api.Test;

import static com.horiaconstantin.leetcode.ValidParantheses.isValid;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidParanthesesTest {

	@Test
	void testIsValidWithInvalidInput() {
		assertFalse(isValid("test"));
		assertFalse(isValid(null));
	}

	@Test
	void testIsValidWithSimpleInput() {
		assertTrue(isValid("()"));
		assertTrue(isValid("{}"));
		assertTrue(isValid("[]"));
	}

	@Test
	void testIsValidWithMultipleInput() {
		assertTrue(isValid("{}(){}[]"));
	}

	@Test
	void testIsValidWithComplexInput() {
		assertTrue(isValid("{[({}())][]}"));
	}

	@Test
	void testIsValidWithComplexIncorrectInput() {
		assertFalse(isValid("{[({}))][]}"));
	}
}