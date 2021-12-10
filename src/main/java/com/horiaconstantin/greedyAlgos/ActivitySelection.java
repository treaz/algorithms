package com.horiaconstantin.greedyAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * you have a set of activities that take a specific amount of time and need to use the same resource. You want to perform as many activities as possible.
 * @author Horia Constantin
 *
 */
public class ActivitySelection {

	public static void main(String[] args) {
		// a1;a4;a8;a11

		Integer[] s = { 0, 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 };
		Integer[] f = { 0, 4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16 };
//		RECURSIVEACTIVITYSELECTOR(s, f, 0, s.length);
//		List<Integer> list = recActSel(s, f, 0, s.length-1);
		List<Integer> list = greedyActSel(s, f);
		for (Integer elem:list) {
			System.out.println(elem);
		}
	}

	/**
	 * greedy iterative algo
	 * assumes that the input activities are ordered by monotonically increasing finish time
	 * @author Horia Constantin
	 * @return
	 */
	public static List<Integer> greedyActSel(Integer[] s, Integer[] f){
		int n = s.length;
		List <Integer> ret = new ArrayList<>();
		int k=0;
		for (int m=1; m<n; m++) {
			if (s[m]>=f[k]) {
				ret.add(m);
				k=m;
			}
		}
		return ret;
	}
	
	/**
	 * really bad implementation
	 * 
	 * @author Horia Constantin
	 * @param s
	 * @param f
	 * @param start
	 * @param end
	 */
	public static void RECURSIVEACTIVITYSELECTOR(Integer[] s, Integer[] f,
			int start, int end) {
		if (f[0] == null) {
			return;
		}
		List<Integer> fList = Arrays.asList(f);
		Integer min = Collections.min(fList);
		int minIndex = fList.indexOf(min);
		List<Integer> newArray = new ArrayList<>();
		List<Integer> newSArray = new ArrayList<>();
		for (int i = 0; i < s.length; i++) {
			if (s[i] >= f[minIndex]) {
				newArray.add(f[i]);
				newSArray.add(s[i]);
			}
		}
		System.out.println("Activity ending at " + f[minIndex]);
		RECURSIVEACTIVITYSELECTOR(newSArray.toArray(new Integer[1]),
				newArray.toArray(new Integer[1]), minIndex, end);
	}
	

	public static List<Integer> recActSel(Integer[] s, Integer[] f, int k, int n) {
		int m = k+1;
		while (m <= n && s[m] < f[k]) {
			m = m + 1;
		}
		if (m <= n) {
			List<Integer> list = new ArrayList<>();
			list.add(m);
			List<Integer> newlist = recActSel(s, f, m, n);
			if (!newlist.isEmpty()) {
				for (Integer elem : newlist) {
					list.add(elem);
				}
			}
			return list;
		} else {
			return new ArrayList<Integer>();
		}
	}
}
