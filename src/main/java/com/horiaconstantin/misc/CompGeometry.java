package com.horiaconstantin.misc;

/**
 * chapter 33 in the book
 * @author Horia Constantin
 *
 */
public class CompGeometry {
 
	/**
	 * check wether 2 segments intersect
	 * @author Horia Constantin
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param p4
	 * @return
	 */
	public static boolean segmIntersect (Point p1, Point p2, Point p3, Point p4) {
		int d1 = direction (p3, p4, p1);
		int d2 = direction (p3, p4, p2);
		int d3 = direction (p1, p2, p3);
		int d4 = direction (p1, p2, p4);
		if (((d1>0 && d2<0)|| (d1<0 && d2>0))&&((d3>0 && d4<0)||(d3<0 && d4>0))){
			return true;
		} else if (d1==0 && onSegment(p3, p4,p1)) {
			return true;
		} else if (d2==0 && onSegment(p3, p4, p2)) {
			return true;
		} else if (d3==0 && onSegment(p1, p2, p3)) {
			return true;
		} else if (d4==0 && onSegment(p1, p2, p4)) {
			return true;
		}
		return false;
	}

	/**
	 * determines whether a point known to be colinear with a segment lies on that segment.
	 * @author Horia Constantin
	 * @param pi
	 * @param pk
	 * @param pj
	 * @return
	 */
	private static boolean onSegment(Point pi, Point pk, Point pj) {
		if ((Math.min(pi.x, pj.x)<=pk.x &&pk.x <=Math.max(pi.x, pj.x))&& ((Math.min(pi.x, pj.x)<=pk.x && pk.x<=Math.max(pi.x, pj.x)))) {
			return true;
		}
		return false;
	}

	/**
	 * implementation of the finding of the cross product of 2 vectors
	 * If this cross product is positive, then p0p1 is clockwise from p0p2; if negative, it is counterclockwise.
	 * @author Horia Constantin
	 * @param pi the common point of the vectors.
	 * @param pj
	 * @param pk
	 * @return
	 */
	private static int direction(Point pi, Point pj, Point pk) {
		return (pk.x-pi.x)*(pj.y-pi.y)-(pj.x-pi.x)*(pk.y-pi.y);
	}
}
