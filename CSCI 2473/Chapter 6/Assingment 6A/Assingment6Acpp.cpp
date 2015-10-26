//Josh McMahan
//C Programming
//Chapter 6 assignment 6A
//Assignment6A.cpp
//A program that dose a lot of stuff

#include <fstream>
#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

int main()
{
	ifstream datafile;
	ofstream answerfile;

	
	int num;
	int count = 0;
	double sum = 0.0;

	//task a: read the file and write all of the intergers to a single line
	datafile.open("DataFile2.txt");
	answerfile.open("ANSWERS.txt");
	answerfile << "The input file contains the following data: " << endl;
	datafile >> num;

		while (datafile)
		{
			answerfile << num << ' ';
			datafile >> num;

		}
		datafile.close();
		datafile.clear(); 
		

	//task b: compute the averages of all the intergers in DataFile2.
		datafile.open("DataFile2.txt");
	
		answerfile << endl << "The average of all numbers is: ";
		

		datafile >> num;
		while (datafile)
		{
			sum = sum + num;
			count++;
			datafile >> num;
		}

		answerfile << double(sum) / double(count);
			
		
		

		datafile.close();
		datafile.clear();
		datafile.open("DataFile2.txt");

	//task c: compute the average of the first 12 numbers
		datafile.open("DataFile2.txt");
		sum = 0;
		count = 1;

		datafile >> num;
		while (count <= 12)
		{
			sum += num;
			count++;
			datafile >> num;
		}

		answerfile << endl <<"The average of the first 12 numbers is:  ";
		answerfile << double(sum) / double(count - 1);

		datafile.close();
		datafile.clear();
	

	//task d: compute the sum of every third number
		datafile.open("DataFile2.txt");
		answerfile << endl << "The sum of ever third number is: ";
		
		sum = 0;
		count = 1;
		datafile >> num;

		while (datafile)
		{
			if (count % 3 == 0) 
			{
				sum = sum +  num;
			}
			count++;
			datafile >> num;
		}
		
		answerfile << sum;

		datafile.close();
		datafile.clear();
		

	//task e: determin the range of the numbers from DataFile2.txt
		datafile.open("DataFile2.txt");
		int smallest = INT_MAX;
		int largest = INT_MIN;
		

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
		
	//task f: find the number closest to 200
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
			if (diff < abs (closest - 200)) {
				closest = num1;
				
			}
			
			
		}
		answerfile << "The closest number to 200 is: " << closest << endl;

		datafile.close();
		datafile.clear();   
		

		//task g: compute the average of all numbers on the first two lines
		datafile.open("DataFile2.txt");

		count = 0;
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
		answerfile << "The sum of the first two lines is: " << double (numf);

		datafile.close();
		datafile.clear(); 
	

		//task h: compute the sum of the numbers in the file as long as the sum dose not exceed 1000 using a flag controlled loop structure
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
	
		
	return 0;
}