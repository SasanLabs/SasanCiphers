# DES Internals #

## Introduction ##

### Shanon theory ###
For building secure Block cipher, Encryption algorithm needs two basic operations :
```
  1. Confusion - Substitution
  2. Diffusion - Permutation ie impact is on more than one bits.
```

### DES basics ###
DES (Data Encryption Standard) is an block cipher originally implemented by IBM researchers in 1970. it is a Symmetric encryption algorithm based on **Fiestle Networks**. 

Block Size : 64 bits
Key Size : 56 bits (it takes input as 64 bits and shred every 8th bit)
Rounds : 16

### Fiestle Networks ###
![Fiestle Networks](https://github.com/SasanLabs/SasanCiphers/blob/master/docs/FiestleNetworks.png)

if you look into Fiestle network, you will find that it divides the block into 2 parts say Left and Right part. In a round only one part is encrypted/decrypted and other part remains same and in next round other part is encrypted and vice-versa. 

Many algorithms are based on Fiestle networks.

### DES High level block diagram ###
![DES High Level](https://github.com/SasanLabs/SasanCiphers/blob/master/docs/HighLevel%20DES.png)

### F Function Internals ###
![F Function Internals](https://github.com/SasanLabs/SasanCiphers/blob/master/docs/FFunction%20HighLevel%20Diagram.png)
