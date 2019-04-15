package com.horiaconstantin.java;

public class BetterProgrammerTask1 {
    
	public static void main(String[] args) {
		System.out.println(isPalindrome(""));
	}
	
    public static boolean isPalindrome(String s) {
		boolean isPalindrome= false;
		if (!s.isEmpty()) {
			StringBuilder sb = new StringBuilder(s);
			if (s.equals(sb.reverse().toString())) {
				isPalindrome=true;
			}
		}
        /*
          Definition: A palindrome is a string that reads the same forward and backward.
          For example, "abcba" is a palindrome, "abab" is not.
          Please implement this method to
          return true if the parameter is a palindrome and false otherwise.
         */
		return isPalindrome;
    }
}
