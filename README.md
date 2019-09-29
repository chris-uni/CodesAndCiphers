# CodesAndCiphers
A collection of codes and ciphers implemented in Java.

# Caesars cipher:

Will shift all letters in the plaintext input by a set amount in the alphabet and then return the new word. For example, A -> D with a key of 3.

Therefore the example ATTACKATDAWN goes to XkkXZbXkBXne - in this implementation anyway. This implementation takes into account the ASCII values of both upper and lower case letters seperately. Meaning, a shift of A will result in a different value than a shift of a; upper and lower case letters are treated differrently.

# Vigenere cipher:

This is similar to the Caesar shift however the key changes letter to letter. Instead of a set shift value for every character in the plaintext input, there is also a key word provided at the beginning of the shift. The letters of the keyword are then used as the shifting amount for each letter in the plaintext input. If the key word is shorter than the provided plaintext input, the key word is repeated until its letter count is that of the plaintext input. 

For example, ATTACKATDAWN is the input plaintext, and LEMON is the key word. Because LEMON contains less characters than ATTACKATDAWN, LEMON is repeated to be LEMONLEMONLE. This results in the output -> LXFOPVEFRNHR.

# Rail Fence cipher:

For this cipher, a key is provided which represents the number of rails to be used. The letters of the plaintext input are then split along the rails in a pyramid shape, one letter for each rail row until the last one is reached, then the letters start going back up the rail rows, again one letter at a time, until the top is reached. This process is then repeated for the whole plaintext input.

For example:

key = 4

A------A-----------<br>
-T----K--T------N---<br>
--T--C-----D--W----<br>
---A--------A-----<br>

The letters are then concatinated row by row to form the ciphertext. In this example the ciphertext is -> AATKTNTCDWAA
