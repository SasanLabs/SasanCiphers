package org.sasanlabs.ciphers.block.des.ffunction;

/**
 * F Function Step 1
 * 
 * @author preetkaran20@gmail.com KSASAN
 */
public class DESConfigurationBox {

	/**
	 * Configuration for Converting 32 bit to 48 bit
	 */
	public static final int[][] EXPANSION_BOX_CONFIGURATION = {
			{ 32, 1, 2, 3, 4, 5, 4, 5 },
			{ 6, 7, 8, 9, 8, 9, 10, 11 }, 
			{ 12, 13, 12, 13, 14, 15, 16, 17 }, 
			{ 16, 17, 18, 19, 20, 21, 20, 21 },
			{ 22, 23, 24, 25, 24, 25, 26, 27 }, 
			{ 28, 29, 28, 29, 30, 31, 32, 1 } 		
	};

}
