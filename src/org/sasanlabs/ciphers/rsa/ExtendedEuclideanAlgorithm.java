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
	
	public BigInteger findInverse(BigInteger r0, BigInteger r1) {
		/**Formula for Extended Euclidean is
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
		
		
		return BigInteger.ONE;
	}
	
	public static void main(String[] args) {
		System.out.println(findGCD(BigInteger.valueOf(5), BigInteger.valueOf(10)));
	}
	
}
