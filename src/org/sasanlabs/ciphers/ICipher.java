package org.sasanlabs.ciphers;

/**
 * @author KSASAN preetkaran20@gmail.com
 *
 */
public interface ICipher {

	/**
	 * @param clearText
	 * @param key
	 * @return encrypted Text
	 */
	public byte[] encrypt(byte[] clearText, byte[] key);
	
	/**
	 * @param cipherText
	 * @param key
	 * @return clearText
	 */
	public byte[] decrypt(byte[] cipherText, byte[] key);
	
}
