package ro.horia.dynaProgging;

import java.util.Arrays;

public class RodCuttingProblem {

	/**
	 * recursive is exponential time.
	 * 
	 * @author Horia Constantin
	 * @param prices
	 * @param rodLength
	 * @return
	 */
	public static int cutRod(int[] prices, int rodLength) {
		if (prices == null || rodLength == 0) {
			return 0;
		}
		int val = Integer.MIN_VALUE;
		for (int i = 0; i < rodLength; i++) {
			val = Math.max(val, prices[i] + cutRod(prices, rodLength - i - 1));
		}
		return val;
	}

	/**
	 * dyna prog top-down memoized approach
	 * 
	 * @author Horia Constantin
	 * @param prices
	 * @param rodLength
	 * @return
	 */
	public static int cutRodTD(int[] prices, int rodLength) {
		int[] memo = new int[prices.length];
		Arrays.fill(memo, Integer.MIN_VALUE);
		return cutRodTDAux(prices, rodLength, memo);
	}

	private static int cutRodTDAux(int[] prices, int length, int[] memo) {
		if (length == 0) {
			return 0;
		}
		if (memo[length - 1] >= 0) {
			return memo[length - 1];
		}
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < length; i++) {
			result = Math.max(result,
					prices[i] + cutRodTDAux(prices, length - i - 1, memo));
		}
		memo[length - 1] = result;
		return result;
	}

	public static void main(String[] args) {
		int[] prices = { 1, 5, 8, 9 };
		int[] manyprices = {1,5,8,9,10,17, 17,20, 24,30};
		int rodLength = 4;
//		System.out.println(cutRod(prices, rodLength));
//		System.out.println(cutRodTD(prices, rodLength));
//		System.out.println(cutRodBU(prices));
		
		int[] results = cutRodBUExt(manyprices, rodLength);
		int len = rodLength;
		while (len>0) {
			System.out.println("Cut after: "+results[len]);
			len=len-results[len];
		}
	}

	/**
	 * dyna prog bottom up implementation
	 * @author Horia Constantin
	 * @param prices
	 * @return
	 */
	private static int cutRodBU(int[] prices) {
		int length = prices.length;
		int[] results = new int[length+1];
		results[0]=0;
		for (int j = 0; j < length; j++) {
			int val = Integer.MIN_VALUE;
			for (int i = 0; i <= j; i++) {
				val = Math.max(val, prices[i]+results[j - i]);
			}
			results[j+1] = val;
		}
//		for (int result:results) {
//			System.out.println(result);
//		}
		return results[length];
	}
	
	/**
	 * dyna prog bottom up implementation
	 * @author Horia Constantin
	 * @param prices
	 * @return
	 */
	private static int[] cutRodBUExt(int[] prices, int length) {
		int[] results = new int[length+1];
		int[] cuts = new int[length+1];
		results[0]=0;
		for (int j = 0; j < length; j++) {
			int val = Integer.MIN_VALUE;
			for (int i = 0; i <= j; i++) {
				if (val< prices[i]+results[j - i]) {
					val = prices[i]+results[j - i];
					cuts[j+1]=i+1;
				}
			}
			results[j+1] = val;
		}
//		for (int result:results) {
//			System.out.println(result);
//		}
		return cuts;
	}

}
