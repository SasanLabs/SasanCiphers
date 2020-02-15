package org.sasanlabs.ciphers.rsa;

import java.math.BigInteger;

/**
 * EEA is used to find the multiplicative inverse of a number in a Ring.
 * 
 * @author preetkaran20@gmail.com KSASAN
 */
public class ExtendedEuclideanAlgorithm {

	/**
	 * Finding GCD based on Euclidean Algorithm
	 * @param r0
	 * @param r1
	 * @return
	 */
	public static BigInteger findGCD(BigInteger r0, BigInteger r1) {
		if(r0.compareTo(r1) < 0) {
			BigInteger c = r1;
			r1 = r0;
			r0 = c;
		}
		if(r1 == BigInteger.ZERO) {
			return r0;
		}	
		return findGCD(r1, r0.mod(r1));
	}
	
	static BigInteger s0 = BigInteger.ONE;
	static BigInteger s1 = BigInteger.ZERO;
	static BigInteger t0 = BigInteger.ZERO;
	static BigInteger t1 = BigInteger.ONE;
	
	/**
	 * Formula for Extended Euclidean is
	 * s2 = s0 - q*s1
	 * t2 = t0 - q*t1
	 * Derivation of this formula is:
	 * 
	 * r2 = s2*r0 + t2*r1
	 * ri = si*r0 + ti*r1 --> eq1
	 *
	 * r0 = q*r1 + r2
	 * ri = ri-2 - q*ri-1
	 * Substituting ri-2 and ri-1 by eq1
	 * ri = si-2*r0 + ti-2*r1 - q(si-1*r0 + ti-1*r1)
	 * ri = (si-2 - q*si-1)r0 + (ti-2 - q*ti-1)r1
	 * 
	 */
	public static BigInteger findInverse(BigInteger r0, BigInteger r1) {
		if(r1 == BigInteger.ZERO) {
			return r0;
		}
		BigInteger s2 = s0.subtract(r0.divide(r1).multiply(s1));
		BigInteger t2 = t0.subtract(r0.divide(r1).multiply(t1));
		s0 = s1;
		t0 = t1;
		s1 = s2;
		t1 = t2;
		return findInverse(r1, r0.mod(r1));
	}
	
	public static void main(String[] args) {
		System.out.println(findGCD(BigInteger.valueOf(3), BigInteger.valueOf(11)));
		BigInteger GCD = findInverse(BigInteger.valueOf(10), BigInteger.valueOf(17));
		if (GCD.equals(BigInteger.ONE)) {
			System.out.println("S0: " + s0 + " S1: " + s1);
			System.out.println("T0: " + t0 + " T1: " + t1);
			System.out.println("Modulo Inverse is : " + s0);
		}
	}
	
}
