//Josh McMahan
//C Programming
//Chapter 7 assignment 7B
//Assignment7B.cpp
//A program that prints an image using blank spaces, *, #, <, and >.

#include <iostream>

using namespace std;



int main()
{
	for (int line = 1; line <= 7; line++)
	{
		for (int lessthan = 1; lessthan <= 7 - line; lessthan++)
			numwords << "<";
		for (int blankspace = 1; blankspace <= line; blankspace++)
			numwords << " ";
		for (int hashtag = 1; hashtag <= 7 * 2 - line * 2; hashtag++)
			numwords << "#";
		for (int asterisk = 1; asterisk <= 2 * line - 2; asterisk++)
			numwords << "*";
		for (int blankspace = 1; blankspace <= line; blankspace++)
			numwords << " ";
		for (int greaterthan = 1; greaterthan <= 7 - line; greaterthan++)
			numwords << ">";
		numwords << endl;
	}
		return 0;
}
