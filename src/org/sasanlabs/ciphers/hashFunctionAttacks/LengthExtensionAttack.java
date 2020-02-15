package org.sasanlabs.ciphers.hashFunctionAttacks;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @author preetkaran20@gmail.com KSASAN
 */
public class LengthExtensionAttack{

	public static final SHA HASH_ALGO = new SHA();

	// Secret for demonstration of Length extension attacks. should not be used in
	// applications.
	public static final String SECRET = "SasanCipher";

	
	public static final String DATA_FOR_HASHING = "POC to learn Length extension attacks";
	
	
	public static void lengthExtensionAttack() {
		
	}

	
	private static byte[] getMac(byte[] data) throws UnsupportedEncodingException {
		HASH_ALGO.engineReset();
		byte[] secretKeyByteArray = SECRET.getBytes(Charset.forName("UTF-8"));
		HASH_ALGO.engineUpdate(secretKeyByteArray, 0, secretKeyByteArray.length);
		HASH_ALGO.engineUpdate(data, 0, data.length);
		
			System.out.println(SECRET + DATA_FOR_HASHING);
			System.out.println(new String(HASH_ALGO.buffer, "UTF-8"));
		
		return HASH_ALGO.engineDigest();
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] macForData = getMac(DATA_FOR_HASHING.getBytes(Charset.forName("UTF-8")));
		//we want hash of DATA_FOR_HASHING + "SASAN" without knowing secret
		// Say below code is hackers code and he has acceees to macForData and DATA_FOR_HASHING
		
		for(int i=1;i<64;i++) {
			int length = DATA_FOR_HASHING.getBytes(Charset.forName("UTF-8")).length + i;
			
		}
		
		
		
	}

}
