//Josh McMahan
//C Programming
//Chapter 11 assignment 11
//Assignment11.cpp
//Using single dimension arrays

#include <iostream>
#include <fstream>


using namespace std;

void taskA(int data[], int size);
void taskB(ofstream & output, int array[], int length);
void taskC(ofstream & output, int array[], int length);
void taskD(ofstream & output, int array[], int length);
void taskE(ofstream & output, int array[], int length);
void taskF(ofstream & output, int array[], int length);
void taskG(ofstream & output, int array[], int length);
void taskH(ofstream & output, int array[], int length);
void taskI(ofstream & output, int array[], int length);

int main()
{
	
	ofstream output;
	output.open("output.txt");
	
	
	int sum;
	int length = 10;
	int index[10];

	taskA(index, length);
	taskB(output, index, length);
	taskC(output, index, length);
	taskD(output, index, length);
	taskE(output, index, length);
	taskF(output, index, length);
	taskG(output, index, length);
	taskH(output, index, length);
	taskI(output, index, length);
	return 0;
}
	//Read 10 integers in a 10 positon array
	void taskA(int index[], int length)
	{
		ifstream input;
		input.open("input.txt");
		for (int n = 0; n < length; n++)
		{
			input >> index[n];
		}
	}
	// output the 10 integers on the same line
	void taskB(ofstream & output, int index[], int length)
	{
		output << "The integers are: ";
		for (int n = 0; n < length; n++)

		{

			output << index[n] << ' ';
		}
	}
	// output the 4th integer in the array
	void taskC(ofstream & output, int index[], int length)
	{
		output << endl << "The fourth integer is: " << index[3] << endl;
	}
	// The sum and average of the last 6 integers in the array
	void taskD(ofstream & output, int index[], int length)
	{
		int sum = 0;
		sum = index[4] + index[5] + index[6] + index[7] + index[8] + index[9];
		output << "The sum of the last 6 integers is: " << sum << endl;
		output << "The average of the last 6 integers is: " << double(sum) / double(6) << endl;
	}

	//Finding the smallest integer in the array
	void taskE(ofstream & output, int index[], int length)
	{
		int smallest = index[0];
		for (int n = 1; n < 10; n++)
			if (smallest > index[n])
				smallest = index[n];
		output << "The smallest integer is: " << smallest << endl;
	}
	//Finding the largest integer in the array
	void taskF(ofstream & output, int index[], int length)
	{
		int largest = index[0];
		for (int n = 1; n < 10; n++)
			if (largest < index[n])
				largest = index[n];
		output << "The largest integer is: " << largest << endl;
	}
	//The first 4 integers in reverse order
	void taskG(ofstream & output, int index[], int length)
	{
		output << "The first 4 integers in reverse order are: ";
		for (int n = 3; n >= 0; n--)
		{
			output << index[n];
			output << ' ';
		}
	}
	// Sorting the integers in the array
	void taskH(ofstream& output,int index[], int length)
	{
		int temp, minIndx;

		for (int passCount = 0; passCount < length - 1; passCount++)
		{
			minIndx = passCount;

			for (int searchIndx = passCount + 1; searchIndx < length; searchIndx++)
				if (index[searchIndx] < index[minIndx])
					minIndx = searchIndx;

			temp = index[minIndx];
			index[minIndx] = index[passCount];
			index[passCount] = temp;
		}
	}
	void taskI(ofstream & output, int index[], int length)
	{
		output << endl << "The integers are: ";
		for (int n = 0; n < length; n++)

		{
			output << index[n] << ' ';
		}
	}