//Josh McMahan
//C Programming
//Chapter 8 assignment 8A
//Assignment8A.cpp
//Assigment from chapter 6 redone using functions

#include <fstream>
#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

void taskA(ifstream& datafile, ofstream& answerfile);
void taskB(ifstream& datafile, ofstream& answerfile);
void taskC(ifstream& datafile, ofstream& answerfile);
void taskD(ifstream& datafile, ofstream& answerfile);
void taskE(ifstream& datafile, ofstream& answerfile);
void taskF(ifstream& datafile, ofstream& answerfile);
void taskG(ifstream& datafile, ofstream& answerfile);
void taskH(ifstream& datafile, ofstream& answerfile);

int main()
{
	ifstream datafile;
	ofstream answerfile;

	int num;
	int sum;
	int count;
		

	 taskA(datafile, answerfile);
	 taskB(datafile, answerfile);
	 taskC(datafile, answerfile);
	 taskD(datafile, answerfile);
	 taskE(datafile, answerfile);
	 taskF(datafile, answerfile);
	 taskG(datafile, answerfile);
	 taskH(datafile, answerfile);

	return 0;
}

	//task a: read the file and write all of the intergers to a single line
	void taskA(ifstream& datafile, ofstream& answerfile)
	{
		datafile.open("DataFile2.txt");
		answerfile.open("PROCOUT.txt");

		int num;

		answerfile << "The input file contains thes following data: " << endl;
		datafile >> num;

		while (datafile)
		{
			answerfile << num << ' ';
			datafile >> num;

		}
		datafile.close();
		datafile.clear();
	}


	//task b: compute the averages of all the intergers in DataFile2.
	void taskB(ifstream& datafile, ofstream& answerfile)
	{
		int num = 0;
		int sum = 0;
		int count = 0;

		datafile.open("DataFile2.txt");

		

		datafile >> num;
		while (datafile)
		{
			sum = sum + num;
			count++;
		datafile >> num;
		}

	answerfile << endl << "The average of all numbers is: ";
	answerfile << double(sum) / double(count);

	datafile.close();
	datafile.clear();
	}

		//task c: compute the average of the first 12 numbers
	void taskC(ifstream& datafile, ofstream& answerfile)
	{
		datafile.open("DataFile2.txt");
		int sum = 0;
		int count = 1;
		int num = 0;

		datafile >> num;
		while (count <= 12)
		{
			sum += num;
			count++;
			datafile >> num;
		
		}

	answerfile << endl << "The average of the first 12 numbers is:  ";
	answerfile << double(sum) / double(count - 1);

	datafile.close();
	datafile.clear();
	}

		//task d: compute the sum of every third number
	void taskD(ifstream& datafile, ofstream& answerfile)
	{
	datafile.open("DataFile2.txt");
	answerfile << endl << "The sum of ever third number is: ";

	int sum = 0;
	int count = 1;
	int num = 0;

	datafile >> num;

	while (datafile)
	{
		if (count % 3 == 0)
		{
			sum = sum + num;
		}
		count++;
		datafile >> num;
	}

	answerfile << sum;

	datafile.close();
	datafile.clear();
	}

		//task e: determin the range of the numbers from DataFile2.txt
	void taskE(ifstream& datafile, ofstream& answerfile)
	{
	datafile.open("DataFile2.txt");
	int smallest = INT_MAX;
	int largest = INT_MIN;
	int num = 0;

	datafile >> num;
	while (datafile)
	{
		if (num < smallest)
			smallest = num;
		if (num > largest)
			largest = num;

		datafile >> num;

	}
	answerfile << endl << "The smallest number is: " << smallest << endl;
	answerfile << "the largest number is: " << largest << endl;

	datafile.close();
	datafile.clear();
	}

		//task f: find the number closest to 200
	void taskF(ifstream& datafile, ofstream& answerfile)
	{
	datafile.open("DataFile2.txt");
	int closest;
	int diff;
	int	num1;


	datafile >> num1;
	closest = num1;
	while (datafile)
	{
		datafile >> num1;
		diff = abs(num1 - 200);
		if (diff < abs(closest - 200)) {
			closest = num1;

		}


	}
	answerfile << "The closest number to 200 is: " << closest << endl;

	datafile.close();
	datafile.clear();
	}

		//task g: compute the average of all numbers on the first two lines
	void taskG(ifstream& datafile, ofstream& answerfile)
	{
	datafile.open("DataFile2.txt");

	int count = 0;
	int sumf = 0;
	int loopcount = 1;
	int numf;

	datafile >> numf;
	char inchar = ' ';
	while (inchar <= 2)
	{

		if (loopcount == '\n')
			loopcount++;

		sumf = sumf + numf;
		count++;
		datafile.get(inchar);



	}
	answerfile << "The sum of the first two lines is: " << double(numf);

	datafile.close();
	datafile.clear();
	}


		//task h: compute the sum of the numbers in the file as long as the sum dose not exceed 1000 using a flag controlled loop structure
	void taskH(ifstream& datafile, ofstream& answerfile)
	{
	datafile.open("DataFile2.txt");

	bool lessthan1000 = true;
	int numH;
	int sumH = 0;



	datafile >> numH;
	while (lessthan1000)
	{

		if (sumH + numH > 1000)
			lessthan1000 = false;
		else
			sumH = sumH + numH;
	}


	answerfile << endl << "The sum of the numbers without going over 1000 is: " << sumH; 
	}



