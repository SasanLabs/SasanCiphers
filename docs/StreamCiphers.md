# Stream Ciphers #

As we know one time pad is a very good cipher but practically it is very difficult to use due to the issue of Key should be of same length as plain text.

## Truth table of XOR ##

Key Bit|PlainText Bit|CipherText Bit
-------|--------------|---------------
0|0|0
0|1|1
1|0|1
1|1|0

From above we can conclude following things:-
``` 
1. Say if Key bit is 0 then CipherText Bit is same as Plain Text Bit and 
2. if Key bit is 1 then CipherTest Bit is reverse of Plain Text Bit.
3. and same holds if PlainText is fixed to 0 or 1
3. and Cipher text has 50% chances of being 0 or 1
```

### More indepth analysis ###
Say Oscar got hold of CipherText which is 0101110 then if XOR is used then 0 has possibility of 50%, ie if both plain text and key bits are 0
or Both PlainText and cipherText are 1 so attacker cannot guess plain text as PlainText can be 0 or 1.

But say we have used AND or OR gate :-
```
AND gate :- we can deduce that plainText will be _1_111_
OR gate :- we can deduce that plainText will be 0_0___0
```

But as we can see XOR requires Key length equal to PlainText length so 
``` 
what is the solution ? 
```
we need somthing like a ``` Pseudo Random Number Generator(PRNG) ``` to generate Key bit length equal to Plain Text length from a Small key and then 
XOR plaintext with Key bits generated from PRNG.

Various ways of Generating Key bits using Pseudo Random Number Generator are :-
``` 
1. Linear Congruntials 
2. LFSR
3. others
```
