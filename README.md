
# Infix Calculator App

## Overview

A Java application for evaluating infix mathematical expressions without parentheses, supporting basic arithmetic operations (+, -, *, /, ^) with proper operator precedence.


## Features

* Arithmetic Operations: Supports +, -, *, /, and ^.
* Order of Operations: Respects arithmetic precedence and associativity.
* Division by Zero: Outputs 'undef' for division by zero cases.
* Negative Numbers & Exponentiation: Correctly handles negative numbers and evaluates exponentiation with right-to-left associativity.


## Usage

Compile with javac Calculator.java and run with java Calculator. Enter an infix expression and receive the evaluated result.


## Skills and Concepts 
* Algorithm Design: Implementation of the "train yard" algorithm for infix to postfix conversion.
* Data Structures: Usage of a custom stack (BCLinkStack) for managing operations and operands.
* Problem Solving: Handling edge cases like division by zero and negative numbers accurately.

## Limitations 
* Does not support parentheses.
* Requires spaces between operators and operands in input.
