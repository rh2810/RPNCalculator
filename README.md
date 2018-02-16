# RPNCalculator
Authors: Michele Ambrose and Ryan Hurst

Generates a calculator that can performs arithmetic operations in Reverse Polish Notation.

An RPN calculator perform arithmetic from a stack, which consists of data entered by the user. The calculator pops the next two numbers from the top of the stack, and then performs operations based on user input and relative order of the values recently popped.

For more info about RPN calculators, visit: http://hp15c.org/RPNHowTo.php

**Keypad:**

-'0-9': standard number pad

-'.': decimal point

-'+/-': switch between positive and negative number

-'+', '-', '*', '/': standard operations (add, subtract, multiply, divide)

-'pi': the mathematical constant pi (3.1415926...)

-'<': delete a character from the text field

-'^': enter the current value (onto the stack)


**Examples:**

In: 3 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; stack: []

In: ^ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; stack: [3.0]

In: 4 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

In: ^ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; stack: [3.0, 4.0]

In: + &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; stack: [7.0]

__Out__: 7.0

In: 6.0 

In: ^ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; stack: [7.0, 6.0]

In: 8.0

In: ^ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; stack: [7.0, 6.0, 8.0]

In: 5.0

In: - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; stack: [7.0, 6.0, 3.0]

__Out__: 3.0

In: * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; stack: [7.0, 18.0]

__Out__: 18.0

In: / &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; stack: [0.3888888888888889]

__Out__: 0.3888888888888889
