package org.sasanlabs.ciphers.rsa;

import java.math.BigInteger;

/**
 * EEA is used to find the multiplicative inverse of a number in a Ring.
 * 
 * @author preetkaran20@gmail.com KSASAN
 */
public class ExtendedEuclideanAlgorithm {

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
	
	public static BigInteger findInverse(BigInteger r0, BigInteger r1) {
		//1 = s*r0 + t*r1
		//r0 = t*r1 + mod(r0,r1)
		return BigInteger.ONE;
	}
	
	public static void main(String[] args) {
		System.out.println(findGCD(BigInteger.valueOf(5), BigInteger.valueOf(10)));
	}
	
}
