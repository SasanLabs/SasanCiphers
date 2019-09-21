package org.sasanlabs.ciphers.stream.random;

/**
 * @author KSASAN preetkaran20@gmail.com
 * 
 *         Implementation of Simple degree 3 Linear Feedback Shift
 *         Register {@see <a
 *         href=https://github.com/SasanLabs/SasanCiphers/blob/master/docs/SimpleDegree3LFSR.md>More
 *         Information</a>}
 */
public class SimpleDegree3LFSR {

	private int[] initialState = { 1, 0, 0 };

	private int[] multiplier = { 0, 1, 1 };

	/** Length 4 **/
/*	private int[] initialState = { 1, 0, 0, 0 };

	private int[] multiplier = {0, 0, 1, 1 };
*/
	/** Lenght 5 **/
/*	private int[] initialState = { 1, 0, 0, 0, 0 };

	private int[] multiplier = {0, 0, 1, 0, 1 };
*/
	public int getNextState() {
		int value = initialState[initialState.length - 1];
		int xorValue = 0;
		for (int i = initialState.length - 1; i >= 0; i--) {
			xorValue = xorValue ^ (initialState[i] * multiplier[i]);
			if (i > 0) {
				initialState[i] = initialState[i - 1];
			}
		}
		initialState[0] = xorValue;
		return value;
	}

	public static void main(String[] args) {
		SimpleDegree3LFSR singleLFSR = new SimpleDegree3LFSR();
		for (int i = 0; i < 200; i++) {
			if (i % ((int) Math.pow(2, 3) - 1) == 0) {
				System.out.println();
			}
			System.out.print(singleLFSR.getNextState());
		}
	}

}
