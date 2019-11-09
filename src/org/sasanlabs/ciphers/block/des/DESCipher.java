package org.sasanlabs.ciphers.block.des;

import org.sasanlabs.ciphers.ICipher;

/**
 * DES Cipher Implementation
 * 
 * @author preetkaran20@gmail.com KSASAN
 */
public class DESCipher implements ICipher {

	private void validateInput(byte[] clearText, byte[] key) {

	}

	@Override
	public byte[] encrypt(byte[] clearText, byte[] key) {
		this.validateInput(clearText, key);
		return null;
	}

	@Override
	public byte[] decrypt(byte[] cipherText, byte[] key) {
		this.validateInput(cipherText, key);
		return null;
	}

}
