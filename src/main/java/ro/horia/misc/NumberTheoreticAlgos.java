package ro.horia.misc;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.BitSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * based on gcd (a, b) = gcd(b, a mod b)
 * @author Horia Constantin
 *
 */
public class NumberTheoreticAlgos {

	public static int calcGDC(int a , int b) {
		if (b==0) {
			return a;
		} else {
			return calcGDC(b, a % b);
		}
	}
	
	/**
	 * computes x and y, where d=gcd(a, b)=ax+by 
	 * @author Horia Constantin
	 * @param a
	 * @param b
	 */
	public static EuclidHelper extEuclidGDC(int a, int b) {
		EuclidHelper res = new EuclidHelper();
		if (b==0) {
			res.a=a;
			res.x=1;
			res.y=0;
		} else {
			EuclidHelper temp = extEuclidGDC(b, a % b);
			res.a=temp.a;
			res.x=temp.y;
			res.y=temp.x-(a/b*temp.y);
		}
		return res;
	}
	
	/**
	 * solves ecuations of the type a*x=b mod n
	 * @author Horia Constantin
	 * @param a
	 * @param b
	 * @param n
	 */
	public static void modularLinearEcuationSolver(int a , int b, int n) {
		EuclidHelper res = extEuclidGDC(a, n);
		int d =res.a;
		if (b % d==0) {
			int x0=res.x * (b/d) % n;
			for (int i=0;i<d; i++) {
				System.out.println(mod((x0+i*n/d),n));
			}
		} else {
			System.out.println("no solutions");
		}
		}
	
	/**
	 * used as a helper to respect the mathematical properties of mods
	 * @author Horia Constantin
	 * @param in
	 * @param modArg
	 * @return
	 */
	private static int mod(int in, int modArg) {
		int res = 0;
		res = in % modArg;
		if (res <0) {
			res=res+modArg;
		}
		return res;
	}
	
	public static int modularExponentiation(int a , int b, int n) {
		int c =0;
		int d=1;
		String bitStr = Integer.toBinaryString(b);
		for (int i= 0;i<bitStr.length();i++) {
			c = 2*c;
			d = d*d%n;
			if (bitStr.charAt(i)=='1') {
				c++;
				d=d*a%n;
			}
			System.out.println("interm: "+d);
		}
		return d;
	}
	
	public static int pollardRho(int n) {
		
		int i=1;
		int xprev=new Random().nextInt(n-1);
		int y=xprev;
		int k=2;
		while (true) {
			i++;
			int x = (xprev*xprev-1) %n;
			int d = calcGDC(y-x, n);
			if (d!=1 && d!=n) {
				System.out.println(d);
				
			}
			if (i==k) {
				y=x;
				k=2*k;
			}
			xprev=x;
		}
	}
	
	//another implementation of pollard rho
	private final static BigInteger ZERO = new BigInteger("0");
    private final static BigInteger ONE  = new BigInteger("1");
    private final static BigInteger TWO  = new BigInteger("2");
    private final static SecureRandom random = new SecureRandom();

    public static BigInteger rho(BigInteger N) {
        BigInteger divisor;
        BigInteger c  = new BigInteger(N.bitLength(), random);
        BigInteger x  = new BigInteger(N.bitLength(), random);
        BigInteger xx = x;

        // check divisibility by 2
        if (N.mod(TWO).compareTo(ZERO) == 0) return TWO;

        do {
            x  =  x.multiply(x).mod(N).add(c).mod(N);
            xx = xx.multiply(xx).mod(N).add(c).mod(N);
            xx = xx.multiply(xx).mod(N).add(c).mod(N);
            divisor = x.subtract(xx).gcd(N);
        } while((divisor.compareTo(ONE)) == 0);

        return divisor;
    }

    public static void factor(BigInteger N) {
        if (N.compareTo(ONE) == 0) return;
        if (N.isProbablePrime(20)) { System.out.println(N); return; }
        BigInteger divisor = rho(N);
        factor(divisor);
        factor(N.divide(divisor));
    }

 
	public static void main(String[] args) {
//		System.out.println(calcGDC(30, 21)); //3
//		EuclidHelper res =extEuclidGDC(99, 78);
//		System.out.println(res.x); //-11
//		System.out.println(res.y);//14
//		modularLinearEcuationSolver(14, 30, 100); // 95, 45
//		System.out.println(modularExponentiation(7, 560, 561));//1
//		System.out.println(pollardRho(1387)); //19 73
		Pattern p = Pattern.compile("a*b");
		 Matcher m = p.matcher("aaaaab");
		 boolean b = m.matches();
		BigInteger N = new BigInteger("1387");
        factor(N);//19 73
	}
}
