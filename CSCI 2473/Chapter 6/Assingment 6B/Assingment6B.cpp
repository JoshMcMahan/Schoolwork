//Josh McMahan
//C Programming
//Chapter 6 assignment 6B
//Assignment6B.cpp
//A program that counts all of the 3,4,5 and 6 letter words from a file

#include <iostream>
#include <fstream>

using namespace std;

int main()
{
	ifstream quotes;
	ofstream numwords;

	int count = 0;
	int numwords3 = 0;
	int numwords4 = 0;
	int numwords5 = 0;
	int numwords6 = 0;
	char inputchar;

	quotes.open("QUOTES.TXT");
	numwords.open("NUMWORDS.TXT");

	while (quotes)
	{

		quotes.get(inputchar);
		count = 0;
		while (inputchar >= 'a' && inputchar <= 'z' || inputchar >= 'A' && inputchar <= 'Z')
		{
			count++;
			quotes.get(inputchar);
		}
		if (count == 3)
			numwords3++;
		if (count == 4)
			numwords4++;
		if (count == 5)
			numwords5++;
		if (count == 6)
			numwords6++;
	}

	numwords << "3 letter words: " << numwords3 << endl;
	numwords << "4 letter words: " << numwords4 << endl;
	numwords << "5 letter words: " << numwords5 << endl;
	numwords << "6 letter words: " << numwords6 << endl;

	return 0;

}