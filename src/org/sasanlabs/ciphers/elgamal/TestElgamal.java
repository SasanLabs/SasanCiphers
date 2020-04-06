package org.sasanlabs.ciphers.elgamal;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;



/**
 * @author KSASAN preetkaran20@gmail.com
 * 
 * Elgamal Encryption testing.
 */
public class TestElgamal {
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
		//Alice and Bob are 2 parties
		//Bob generates "d" which is the private key, "beta" which is the public key
		//sends public key, alpha and p which are domain parameters
		BigInteger alpha = new BigInteger("2");
		BigInteger p = new BigInteger("227");
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
		int d = secureRandom.ints(2, p.intValue()-2).findAny().getAsInt();
		BigInteger beta = alpha.pow(d).mod(p);
		
		
		//Alice Generates "i" which is the private key, "Ke" which is public key names as Ephemeral key
		// sends X message encrypted with Km which is the masking key.
		int i = secureRandom.ints(2, p.intValue()-2).findAny().getAsInt();
		BigInteger Ke = alpha.pow(i).mod(p);
		//Alice generates Km
		int Km = beta.pow(i).mod(p).intValue(); 
		System.out.println("Masking Key=" + Km);
		
		//"Make Sure p is greater than X"
		
		int X = 123;
		System.out.println("Actual Value=" + X);
		int Y = (X*Km)%p.intValue();
		System.out.println("Encrypted Value=" + Y);
		
		
		
		//Bob recieves Ke and then computes the Km 
		//decrypts it.
		int Kmbob = Ke.pow(d).mod(p).intValue();
		if(Kmbob != Km) {
			System.out.printf("Masking Key for Bob and Alice doesn't match Bob's Masking Key = %d , Alice's Masking Key = %d", Kmbob, Km);
		}
		//Using Fermats little theorem
		int decryptedMessage = Y*(Ke.pow(p.intValue()-1-d).mod(p).intValue()) % p.intValue();
		System.out.println("Decrypted Value=" + decryptedMessage);
	}
}
