package com.horiaconstantin.adding;

public class BinaryAdd {

	/**
	 * 
	 * @author Horia Constantin
	 * @param a it should be a binary array
	 * @param b	it should be a binary array
	 * @return
	 */
	public static int[] binaryAdd(int[] a, int[] b) {
		int[] result = new int[a.length+1];
		int extraBite=0;
		for (int i=a.length-1;i>=0;i--) {
			int biteSum=a[i]+b[i]+extraBite;
			extraBite=0;
			switch (biteSum) {
				case 0:
					result[i+1]=biteSum;
					break;
				case 1:
					result[i+1]=biteSum;
					break;
				case 2:
					result[i+1]=0;
					extraBite=1;
					break;
				case 3:
					result[i+1]=1;
					extraBite=1;
					break;
			}
			biteSum=0;
			System.out.println(result[i]);
		}
		if (extraBite==1) {
			System.out.println("found extrabite");
			result[0]=1;
		}
		return result;
	}
}
