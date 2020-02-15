package org.sasanlabs.ciphers.discreteLogarithmProblem;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author preetkaran20@gmail.com KSASAN This code is inspired by <a href=
 *         "https://wstein.org/edu/124/lectures/lecture8/html/node5.html">Complexity
 *         Analysis</a> This class is used to check the complexity of DLP and
 *         why it is a hard problem.
 * 
 *         Question what is Discrete Logarithm problem ? there is a cyclic group
 *         Zp* (p is prime as this is abelian cyclic group) so it will have a
 *         generator/primitive element called alpha. Generator or Primitive
 *         element is the one such that raising on all the powers, it generates
 *         the entire group ie from {1,...., p-1}
 * 
 *         problem statement:
 * 
 *         alpha^x = beta mod p where alpha, p and beta are known and we need to
 *         find x.
 * 
 * 
 *         TODO including new attacks against Diffie Hellman/Discrete Logarithm
 *         problem. finding some other way to solve this problem (Research
 *         need to be done.)
 *         <a href="https://weakdh.org/imperfect-forward-secrecy-ccs15.pdf">Need
 *         to Read this</a>
 * 
 * 
 */
public class TestingDLPComplexity {

	private static BigInteger solveDHP(BigInteger alpha, BigInteger p, BigInteger beta) {
		BigInteger val = BigInteger.ONE;
		for (BigInteger i = BigInteger.ONE; i.compareTo(p) < 0; i = i.add(BigInteger.ONE)) {
			val = val.multiply(alpha);
			if (val.mod(p).compareTo(beta) == 0) {
				return i;
			} else {
				val = val.mod(p);
			}
		}
		return BigInteger.valueOf(-1);
	}

	private static BigInteger solvingDHPForVerySmallP() {
		return solveDHP(BigInteger.valueOf(5), BigInteger.valueOf(2017), BigInteger.valueOf(1003));
	}

	private static BigInteger solvingDHPForSmallP() {
		return solveDHP(BigInteger.valueOf(5), BigInteger.valueOf(201007), BigInteger.valueOf(191));
	}

	private static BigInteger solvingDHPForMediumP() {
		return solveDHP(BigInteger.valueOf(5), BigInteger.valueOf(1912913), BigInteger.valueOf(1091));
	}

	private static BigInteger solvingDHPForLargeP() {
		return solveDHP(BigInteger.valueOf(7), BigInteger.valueOf(15055717), BigInteger.valueOf(9001));
	}

	private static BigInteger solvingDHPForVeryLargeP() {
		BigInteger alpha = BigInteger.valueOf(11);
		BigInteger p = new BigInteger("999999937");
		// 41012
		BigInteger beta = BigInteger.valueOf(12897);
		return  solveDHP(alpha, p, beta);
	}

	/**
	 * As we see from the below results that time increases as we increase the size
	 * of Modulus ie abelian group so hence it is a complex problem and complexity
	 * increases multiple folds
	 * 
	 * TODO including new attacks against Diffie Hellman/Discrete Logarithm problem.
	 * TODO finding some other way to solve this problem (Research need to be done.)
	 */
	public static void main(String[] args) {
		Date startDate = new Date();
		System.out.println("Solution: " + solvingDHPForVerySmallP() + " Time Taken: "
				+ (new Date().getTime() - startDate.getTime()));

		startDate = new Date();
		System.out.println(
				"Solution: " + solvingDHPForSmallP() + " Time Taken: " + (new Date().getTime() - startDate.getTime()));

		startDate = new Date();
		System.out.println(
				"Solution: " + solvingDHPForMediumP() + " Time Taken: " + (new Date().getTime() - startDate.getTime()));

		startDate = new Date();
		System.out.println(
				"Solution: " + solvingDHPForLargeP() + " Time Taken: " + (new Date().getTime() - startDate.getTime()));

		startDate = new Date();
		System.out.println("Solution: " + solvingDHPForVeryLargeP() + " Time Taken: "
				+ (new Date().getTime() - startDate.getTime()));

	}
}
