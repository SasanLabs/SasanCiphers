package org.sasanlabs.ciphers.hashFunctionAttacks;

import java.util.Arrays;

/**
 * Copied Class from Sun code for POC and Learning.
 */
public final class SHA extends DigestBase {

	// Buffer of int's and count of characters accumulated
	// 64 bytes are included in each hash block so the low order
	// bits of count are used to know how to pack the bytes into ints
	// and to know when to compute the block and start the next one.
	private int[] W;

	// state of this
	public int[] state;

	/**
	 * Creates a new SHA object.
	 */
	public SHA() {
		super("SHA-1", 20, 64);
		state = new int[5];
		W = new int[80];
		resetHashes();
	}

	/*
	 * Clones this object.
	 */
	public Object clone() throws CloneNotSupportedException {
		SHA copy = (SHA) super.clone();
		copy.state = copy.state.clone();
		copy.W = new int[80];
		return copy;
	}

	/**
	 * Resets the buffers and hash value to start a new hash.
	 */
	public void implReset() {
		// Load magic initialization constants.
		resetHashes();
		// clear out old data
		Arrays.fill(W, 0);
	}

	public void resetHashes() {
		state[0] = 0x67452301;
		state[1] = 0xefcdab89;
		state[2] = 0x98badcfe;
		state[3] = 0x10325476;
		state[4] = 0xc3d2e1f0;
	}

	/**
	 * Computes the final hash and copies the 20 bytes to the output array.
	 */
	public void implDigest(byte[] out, int ofs) {
		long bitsProcessed = bytesProcessed << 3;

		int index = (int) bytesProcessed & 0x3f;
		int padLen = (index < 56) ? (56 - index) : (120 - index);
		engineUpdate(padding, 0, padLen);

		ByteArrayAccess.i2bBig4((int) (bitsProcessed >>> 32), buffer, 56);
		ByteArrayAccess.i2bBig4((int) bitsProcessed, buffer, 60);
		implCompress(buffer, 0);

		ByteArrayAccess.i2bBig(state, 0, out, ofs, 20);
	}

	// Constants for each round
	private final static int round1_kt = 0x5a827999;
	private final static int round2_kt = 0x6ed9eba1;
	private final static int round3_kt = 0x8f1bbcdc;
	private final static int round4_kt = 0xca62c1d6;

	/**
	 * Compute a the hash for the current block.
	 *
	 * This is in the same vein as Peter Gutmann's algorithm listed in the back of
	 * Applied Cryptography, Compact implementation of "old" NIST Secure Hash
	 * Algorithm.
	 */
	public void implCompress(byte[] buf, int ofs) {
		ByteArrayAccess.b2iBig64(buf, ofs, W);

		// The first 16 ints have the byte stream, compute the rest of
		// the buffer
		for (int t = 16; t <= 79; t++) {
			int temp = W[t - 3] ^ W[t - 8] ^ W[t - 14] ^ W[t - 16];
			W[t] = (temp << 1) | (temp >>> 31);
		}

		int a = state[0];
		int b = state[1];
		int c = state[2];
		int d = state[3];
		int e = state[4];

		// Round 1
		for (int i = 0; i < 20; i++) {
			int temp = ((a << 5) | (a >>> (32 - 5))) + ((b & c) | ((~b) & d)) + e + W[i] + round1_kt;
			e = d;
			d = c;
			c = ((b << 30) | (b >>> (32 - 30)));
			b = a;
			a = temp;
		}

		// Round 2
		for (int i = 20; i < 40; i++) {
			int temp = ((a << 5) | (a >>> (32 - 5))) + (b ^ c ^ d) + e + W[i] + round2_kt;
			e = d;
			d = c;
			c = ((b << 30) | (b >>> (32 - 30)));
			b = a;
			a = temp;
		}

		// Round 3
		for (int i = 40; i < 60; i++) {
			int temp = ((a << 5) | (a >>> (32 - 5))) + ((b & c) | (b & d) | (c & d)) + e + W[i] + round3_kt;
			e = d;
			d = c;
			c = ((b << 30) | (b >>> (32 - 30)));
			b = a;
			a = temp;
		}

		// Round 4
		for (int i = 60; i < 80; i++) {
			int temp = ((a << 5) | (a >>> (32 - 5))) + (b ^ c ^ d) + e + W[i] + round4_kt;
			e = d;
			d = c;
			c = ((b << 30) | (b >>> (32 - 30)));
			b = a;
			a = temp;
		}
		state[0] += a;
		state[1] += b;
		state[2] += c;
		state[3] += d;
		state[4] += e;
	}

}
