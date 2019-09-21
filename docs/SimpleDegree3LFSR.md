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

-  ### Simple Attaching 3 Flip Flops ### 

Attaching 3 Flip Flops with Initial State specified in Brackets :-
```
--------------------------|
|                         |
|                         |
|                         |
--> [1] --> [0] --> [0] -->
```
In above case if we give Clock at each interval then output from 3rd flip flop will be 0 -> 0 -> 1 -> and then same cycle repeats.
