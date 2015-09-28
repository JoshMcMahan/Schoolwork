//Josh McMahan
//C Programming
//Chapter 5 assignment 5A
//Assignment5A.cpp
//A program that takes input from the user and finds the 

#include <iostream>

using namespace std;

int main()
{
	char userinp;
	char keypad;

	cout << "Enter a single letter, and I will tell you what the corresponding digit is on the telephone keypad. " << endl;
	cin >> userinp;

	if (userinp == 'A' || userinp == 'B' || userinp == 'C' || userinp == 'a' || userinp == 'b' || userinp == 'c')
		keypad = '2';
	else
		if (userinp == 'D' || userinp == 'E' || userinp == 'F' || userinp == 'd' || userinp == 'e' || userinp == 'f')
			keypad = '3';
		else
			if (userinp == 'G' || userinp == 'H' || userinp == 'I' || userinp == 'g' || userinp == 'h' || userinp == 'i')
				keypad = '4';
			else 
				if (userinp == 'J' || userinp == 'K' || userinp == 'L' || userinp == 'j' || userinp == 'k' || userinp == 'l')
					keypad = '5';
				else 
					if (userinp == 'M' || userinp == 'N' || userinp == 'O' || userinp == 'm' || userinp == 'n' || userinp == 'o')
						keypad = '6';
					else 
						if (userinp == 'P' || userinp == 'R' || userinp == 'S' || userinp == 'p' || userinp == 'r' || userinp == 's')
							keypad = '7';
						else 
							if (userinp == 'T' || userinp == 'U' || userinp == 'V' || userinp == 't' || userinp == 'u' || userinp == 'v')
								keypad = '8';
							else 
								if (userinp == 'W' || userinp == 'X' || userinp == 'Y' || userinp == 'w' || userinp == 'x' || userinp == 'y')
									keypad = '9';
								else
								{
									cout << "There is no digit on the telephone keypad that corresponds to " << userinp << endl;
									return 1;
								}
	cout << "The digit " << keypad << " corresponds to " << userinp << " on the telephone keypad! " << endl;




return 0;

}