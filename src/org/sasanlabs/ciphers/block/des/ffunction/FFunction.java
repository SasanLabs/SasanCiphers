package org.sasanlabs.ciphers.block.des.ffunction;

import org.sasanlabs.ciphers.BitManipulationUtils;
import org.sasanlabs.ciphers.block.des.exception.DESValidationException;

/**
 * F-Function {@see <a href=
 * "https://github.com/SasanLabs/SasanCiphers/blob/master/docs/DES.md">More
 * Information</a>}
 * 
 * @author preetkaran20@gmail.com KSASAN
 */
public class FFunction {

	/**
	 * TODO optimization can be done in this.
	 * 
	 * @param block
	 * @return expanded block of size 48 bits
	 * @throws DESValidationException
	 */
	private byte[] expansionBox(byte[] block) throws DESValidationException {
		byte[] expandedBlock = new byte[6];

		if (block.length != 4) {
			throw new DESValidationException("Block Size is expected to be 32 bit or 4 byte");
		}
		for (int i = 0; i < 6; i++) {
			byte expandedByte = 0x00;
			for (int j = 0; j < 8; j++) {
				int index = DESConfigurationBox.EXPANSION_BOX_CONFIGURATION[i][j] - 1;
				int blockByteIndex = index / 8;
				int blockBitIndex = index % 8;
				expandedByte = (byte) (expandedByte | (((block[blockByteIndex] >> blockBitIndex) & 0x01) << j));
			}
			expandedBlock[i] = expandedByte;
		}

		return expandedBlock;
	}

	public void computeFFunction(byte[] block, byte[] roundKey, byte[] out) throws DESValidationException {
		if (roundKey.length != 6) {
			throw new DESValidationException("RoundKey Size is expected to be 48 bit or 6 byte");
		}
		//Step 1
		byte[] expandedBlock = this.expansionBox(block);
		if (expandedBlock.length != 6) {
			throw new DESValidationException("Expanded Block size is expected to be 48 bit or 6 byte");
		}

		//Step 2
		int expandedIntBlock = BitManipulationUtils.byteArrayToInt(expandedBlock, 0);
		int roundKeyInt =  BitManipulationUtils.byteArrayToInt(roundKey, 0);
		expandedIntBlock = expandedIntBlock ^ roundKeyInt;
		
		//Step 3 S-BOX
		
		//Step 4 P-BOX
	}

	public static void main(String[] a) throws DESValidationException {
		// Output might be negative due to last signed bit.
		byte[] block = { (byte) 4, 0, 0, 127 };
		FFunction f = new FFunction();
		byte[] expandedBlock = f.expansionBox(block);
		for (int i = 0; i < 6; i++) {
			System.out.println(expandedBlock[i]);
		}
	}
}
