package org.sasanlabs.ciphers;

/**
 * @author preetkaran20@gmail.com KSASAN
 */
public class BitManipulationUtils {

	public static int byteArrayToInt(byte[] bs, int off) {
		int n = bs[off] << 24;
		n |= (bs[++off] & 0xff) << 16;
		n |= (bs[++off] & 0xff) << 8;
		n |= (bs[++off] & 0xff);
		return n;
	}

}
