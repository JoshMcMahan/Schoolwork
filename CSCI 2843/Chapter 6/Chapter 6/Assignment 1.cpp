//Josh McMahan
//CSCI 2843
//Assignment 1
//Using templates to sort multiple types of data

#include<iostream>
#include<fstream>
#include<string>

using namespace std;

template <typename unsortedData> void ArrayIn(ifstream & input, unsortedData * Unsorted, int numOf, int & counter);
template <typename T> void SelSort(T * data, int length);
template <typename filledArray> void ArrayOut(ofstream & fileOut, filledArray * arranged, int counter);

int main()
{
	ifstream intFileIn;
	intFileIn.open("IntFile.txt");

	ifstream floatFileIn;
	floatFileIn.open("FloatFile.txt");

	ifstream stringFileIn;
	stringFileIn.open("QUOTES.txt");

	ofstream sortedIntFile("sortedIntFileOut.txt");
	ofstream floatFileOut("FloatOutputFile.txt");
	ofstream stringFileOut("StringoutputFile.txt");

	int unsortedInts[100];
	double unsortedFloats[100];
	string unsortedStrings[100];

	int numOfInts;
	int numOfFloats;
	int numOfStrings;

	ArrayIn(intFileIn, unsortedInts, 100, numOfInts);
	ArrayIn(floatFileIn, unsortedFloats, 100, numOfFloats);
	ArrayIn(stringFileIn, unsortedStrings, 100, numOfStrings);

	SelSort(unsortedInts, numOfInts);
	SelSort(unsortedFloats, numOfFloats);
	SelSort(unsortedStrings, numOfStrings);

	ArrayOut(sortedIntFile, unsortedInts, numOfInts);
	ArrayOut(floatFileOut, unsortedFloats, numOfFloats);
	ArrayOut(stringFileOut, unsortedStrings, numOfStrings);
}


template <typename unsortedData> void ArrayIn(ifstream & input, unsortedData * unsorted, int numOf, int & counter)
{
	counter = 0;
	while (input)
	{
		input >> unsorted[(counter)];
		if (counter == numOf -1)
			break;
		counter++;
	}
}


template <typename T> void SelSort(T * data, int length)
{
	T temp;
	int minIndx;

	for (int passCount = 0; passCount < length - 1; passCount++)
	{
		minIndx = passCount;

		for (int searchIndx = passCount + 1; searchIndx < length; searchIndx++)
			if (data[searchIndx] < data[minIndx])
					minIndx = searchIndx;

		temp = data[minIndx];
		data[minIndx] = data[passCount];
		data[passCount] = temp;
	}
}

template <typename filledArray> void ArrayOut(ofstream & fileOut, filledArray * arranged, int counter)
{
	for (int n = 0; n < counter; n++)
	{
		fileOut << arranged[n] << endl << endl;
		
	}
	fileOut << "There are " << counter << " numbers/words in this file." << endl;
}