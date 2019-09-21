# Linear FeedBack Shift Register #

LFSR's is one of the Pseudo Random Number Generator and is the building block of A5|1 Cipher which is used in GSM. As Name suggests it is a
Shift and Feedback based System. 

## In-Depth Analysis of LFSR ##

-  ### Flip Flop ###

its basis is Register (Flip Flop) which saves the input at every clock pulse eg :-
initial value is say 0.

Clock Value |Input Value | Output Value
------------|-------------|-------------
0|1|0
1|1|1
0|0|1
0|1|1
1|0|0
0|1|0

from above we can conclude when ever Clock input is 1, input is stored in Register/Flip Flop and output is the stored value and it will 
remain same until Clock input becomes 1 and input value is changed.

-  ### Simple Attaching 3 Flip Flops and a FeedBack### 

Attaching 3 Flip Flops with Initial State specified in Brackets :-
```
___________________________
|                         |
|                         |
|                         |
--> [1] --> [0] --> [0] -->
```
In above case if we give Clock at each interval then output from 3rd flip flop will be 0 -> 0 -> 1 -> and then same cycle repeats.
From 3 Flip Flops we can get 8 outputs in combinations but from above we are getting a cycle of 3 ie number of flip flops and 
it is not very useful.

- ### Adding XOR Gate ###
```
       XOR      XOR
________^________^_________
|       |        |        |
|       |        |        |
|       |        |        |
--> [1] --> [0] --> [0] -->

Next State :-
[1] --> [0] --> [0]
[1] --> [1] --> [0]
[0] --> [1] --> [1]
[0] --> [0] --> [1]
[1] --> [0] --> [0]
[1] --> [1] --> [0]
[0] --> [1] --> [1]
[0] --> [0] --> [1]

```

In above state we got the cycle of 4 but it is not sufficient and as we know for 3 flipflops we can get more cycle.

- ### Adding XOR at proper position ###
```
                XOR
_________________^_________
|                |        |
|                |        |
|                |        |
--> [1] --> [0] --> [0] -->

Next State :-
[1] --> [0] --> [0]
[0] --> [1] --> [0]
[1] --> [0] --> [1]
[1] --> [1] --> [0]
[1] --> [1] --> [1]
[0] --> [1] --> [1]
[0] --> [0] --> [1]
[1] --> [0] --> [0]

```
- ### Theorm 1 ###
From m degree LFSR maximum cycle which is possible is 2^m -1 ie for m = 3 maximum cycle length we get is 7. 
- #### Which state is not there ####
State of all Zero's ie [0][0][0] is not possible and getting that state will never allow any other output.

- ### Therom 2 ###
only certain configuration of XOR or in mathematical terms certain configurations of multipliers or switches result in maximum length cycle for LFSR.

There is something called Primitive polynomials, so if XOR configuration is as per primitive polynomials then we get the maximum length cycle.

[Code for 3 Flip Flop Setup](https://github.com/SasanLabs/SasanCiphers/blob/master/src/org/sasanlabs/ciphers/stream/random/SimpleDegree3LFSR.java)

## Cryptanalysis of LFSR  ##
- Using large number of Flip Flops can give a Statistically Secure Pseudo Random Number sequence but it is not cryptographically secure.

