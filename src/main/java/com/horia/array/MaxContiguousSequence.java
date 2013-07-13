package com.horia.array;

/**
 * algorithms page 93
 * 
 * @author Horia Constantin
 * 
 */
public class MaxContiguousSequence {

	//horia algo implementationnot actually working
//	public Container findMaxSubarray(int[] array, int low, int high) {
//		if (low == high) {
//			return new Container(low, high, array[low]);
//		} else {
//			int mid = (low + high) / 2;
//			Container leftContainer = findMaxSubarray(array, low, mid);
//			Container rightContainer = findMaxSubarray(array, mid + 1, high);
//			Container crossContainer = findMaxCrossingSubarray(array, low, mid,
//					high);
//			if (leftContainer.getSum() >= rightContainer.getSum()
//					&& leftContainer.getSum() >= crossContainer.getSum()) {
//				return new Container(leftContainer.getLow(),
//						leftContainer.getHigh(), leftContainer.getSum());
//			} else if (rightContainer.getSum() >= leftContainer.getSum()
//					&& rightContainer.getSum() >= crossContainer.getSum()) {
//				return new Container(rightContainer.getLow(),
//						rightContainer.getHigh(), rightContainer.getSum());
//			} else {
//				return new Container(crossContainer.getLow(),
//						crossContainer.getHigh(), crossContainer.getSum());
//			}
//		}
//	}
//
//	private Container findMaxCrossingSubarray(int[] array, int low, int mid,
//			int high) {
//		int lsum = Integer.MIN_VALUE;
//		int sum = 0;
//		int maxLeft = Integer.MAX_VALUE;
//		int maxRight = Integer.MAX_VALUE;
//		for (int i = mid; i >= low; i--) {
//			sum = sum + array[i];
//			if (sum > lsum) {
//				sum = lsum;
//				maxLeft = i;
//			}
//		}
//		int rsum = Integer.MIN_VALUE;
//		sum = 0;
//		for (int i=0; i<high;i++) {
//			sum = sum + array[i];
//			if (sum > rsum) {
//				sum = rsum;
//				maxRight = i;
//			}
//		}
//		return new Container(maxLeft, maxRight, lsum + rsum);
//	}
	
	/**
     * Recursive maximum contiguous subsequence sum algorithm.
     * Finds maximum sum in subarray spanning a[left..right].
     * Does not attempt to maintain actual best sequence.
     * Speed: n*log(n)
     */
    public static int maxSumRec( int [ ] a, int left, int right )
    {
        int maxLeftBorderSum = 0, maxRightBorderSum = 0;
        int leftBorderSum = 0, rightBorderSum = 0;
        int center = ( left + right ) / 2;

        if( left == right )  // Base case
            return a[ left ] > 0 ? a[ left ] : 0;

        int maxLeftSum  = maxSumRec( a, left, center );
        int maxRightSum = maxSumRec( a, center + 1, right );

        for( int i = center; i >= left; i-- )
        {
            leftBorderSum += a[ i ];
            if( leftBorderSum > maxLeftBorderSum )
                maxLeftBorderSum = leftBorderSum;
        }

        for( int i = center + 1; i <= right; i++ )
        {
            rightBorderSum += a[ i ];
            if( rightBorderSum > maxRightBorderSum )
                maxRightBorderSum = rightBorderSum;
        }

        return max3( maxLeftSum, maxRightSum,
                     maxLeftBorderSum + maxRightBorderSum );
    }

    /**
     * Return maximum of three integers.
     */
    private static int max3( int a, int b, int c )
    {
        return a > b ? a > c ? a : c : b > c ? b : c;
    }

}
