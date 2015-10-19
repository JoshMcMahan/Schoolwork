//Josh McMahan
//C Programming
//Chapter 7 assignment 7A
//Assignment7A.cpp
//A program that gets the input from the user and outputs where it is on a phone's keypad using a switch statment.

#include <iostream>

using namespace std;

int main()
{
	char userinp;
	char keypad;

	do {

		numwords << "Enter a single letter and I will tell you what the corresponding digit is on the telephone keypad. " << endl;
		cin >> userinp;
		
		switch (userinp)
		{
			case 'A':
			case 'B':
			case 'C':
			case 'a':
			case 'b':
			case 'c': numwords << "The digit 2 corresponds to " << userinp << " on the telephone keypad! " << endl;
					break;
			case 'D':
			case 'E':
			case 'F':
			case 'd':
			case 'e':
			case 'f':  numwords << "The digit 3 corresponds to " << userinp << " on the telephone keypad! " << endl;
					break;
			case 'G':
			case 'H':
			case 'I':
			case 'g':
			case 'h':
			case 'i': numwords << "The digit 4 corresponds to " << userinp << " on the telephone keypad! " << endl;
					break;
			case 'J':
			case 'K':
			case 'L':
			case 'j':
			case 'k':
			case 'l':  numwords << "The digit 5 corresponds to " << userinp << " on the telephone keypad! " << endl;
					break;
			case 'M':
			case 'N':
			case 'O':
			case 'm':
			case 'n':
			case 'o':  numwords << "The digit 6 corresponds to " << userinp << " on the telephone keypad! " << endl;
					break;
			case 'P':
			case 'R':
			case 'S':
			case 'p':
			case 'r':
			case 's':  numwords << "The digit 7 corresponds to " << userinp << " on the telephone keypad! " << endl;
					break;
			case 'T':
			case 'U':
			case 'V':
			case 't':
			case 'u':
			case 'v':  numwords << "The digit 8 corresponds to " << userinp << " on the telephone keypad! " << endl;
					break;
			case 'W':
			case 'X':
			case 'Y':
			case 'w':
			case 'x':
			case 'y':  numwords << "The digit 9 corresponds to " << userinp << " on the telephone keypad! " << endl;
					break;
			default : numwords << "There is no digit on the telephone keypad that corresponds to " << userinp << endl;
					break;

		}
		

	} while (userinp != 'z' || userinp != 'Z');


	return 0;

}