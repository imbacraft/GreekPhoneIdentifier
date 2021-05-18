# NaturalNumbersInterpretation

Project created for Omilia Ltd Academy.

It is a Java SE command prompt project that handles natural numbers interpretation.
It has the following features:

1. Application asks user for input.
For example, possible inputs may be:
input example: 30 2 5 58
input example: 2 10 69 30 6 60 4
input example: 6 97 400 23 7 40 5

2. Application identifies and prints the input number.
For example, if input is: 30 2 5 58, output should be: 302558

3. Application produces a series of possible interpretation, after checking ambiguities in number spelling.
For example if the input sequence contains ‘... 20 5...’ the result number may either be ‘...205...’ or ‘...25...’.
Also if the sequence contains ‘...75...’, the result number may be: ‘...705...’ or ‘...75...’

4. Application states which of the output numbers is a valid or invalid Greek telephone number, assuming the following:
Greek phone numbers may have 10 or 14 digits. If they have 10 digits, they must start with ‘2’ or ‘69’. If they have 14 digits, the must start with ‘00302’ or ‘003069’.


# Languages and Tech used
Project is built with Java SE on Intellij IDEA, Community Edition version: 2021.1.1.

Tests on methods that can break can be found in the src/test folder and they can be run.

# Installation
Load the project on preferred IDE and choose run main method or run the tests.

# Contact
jimbouzoukas@gmail.com


