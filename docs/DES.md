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
