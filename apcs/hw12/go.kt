Aaron Li
APCS2 pd8
HW12 -- __+3R|\/|1|\|4|_  1|_|_|\|3$$__
2018-03-01

Q0) Java allows multiple classes to be in a single file, so long as the last class has
the "public" signature, and the preceding classes have a simple class declaration.

Q1) The command line arguments are processed by the main method of class Demo via
system input and try/catch exceptions. The user enters a number, which is then parsed
and the inputted information is used.

Q2) If no arguments are given, there is a default board size of 8 and time delay of
500ms.

Q3) The purpose of recursion is to be able to continue running the same function until
a base case or endpoint is determined. This makes code more robust and condensed than
if you did it with iteration.

Q4) A board with a moat of -1's, and a bunch of zeroes. Slowly, numbers will pop up,
and the cursor will move from place to place, and the board refreshes.

Q5) It depends on the size of the board, as well as the delay time. A larger board and
delay time causes a longer runtime.

Q6) ANSI: American National Standards Institute. It is good for setting international
standards on products, services, and personnel. It is important for us because it allows
the existence of universal code.

Q7) I observed that when a board is large, the numbers become very large and they merge with surrounding numbers,
which I didn't take into account for. I also only thought the outer moat would be one layer, but it is two.

Q8) I can use the system inputs, and ANSI code to refresh a board every time a knight makes a move so that
the user can see the moves in real time. The use of Thread.sleep(n) is also very helpful because it allows
us to see what is going on without the code finishing instantaneously.

Knight's Tour Algo:

Start at 1, 1, determine all the knight moves that knight can make, and make one of the moves. Keep repeating
this step for consecutive knights, and whenever one move doesn't lead to a solution, backtrack a move until
a valid solution presents itself. Repeat this step.
