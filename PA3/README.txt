Joe Campanelli and Ajith Vemuri
CISC 471/672 Programming Assignment 2
PA2 

Notes about make:
We run our code in a Linux environment, so there may need to be changes to the makefile depending on what testing environment you're using.

Test Cases for Part I

We created the following new test cases for part I:

For Illegal Tokens:
- illegal1.in / .in.OK
- illegal2.in / .in.OK
- illegal3.in / .in.OK

For Legal Tokens:
- tokens.in / .in.OK

Test Cases for Part II

We created the following new test cases for part II:

PA2Test1 - sequence of 3 setPixel statements on different cast bytes and different color literals.
PA2Test2 - the smallest possible MeggyJava program.
PA2Test3 - sequence of 12 setPixel statements on different cast bytes and different color literals (also makes a box).

One issue that we ran into while testing the following commands:

    java -jar MJ.jar PA2Test3.java
    java -jar MJSIM.jar PA2Test3.java.s > t1
    javac PA2Test3.java
    java PA2Test3 > t2
    diff t1 t2

is that t2 cuts off after the first 5 or so setPixel statements.  We aren't sure why this occurs, but our implementation of the PA2 compiler produces the correct number of statements.