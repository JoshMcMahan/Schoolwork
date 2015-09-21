//Josh McMahan
//C Programming
//Chapter 4 assignment 4B
//Assignment4B.cpp
//A program that takes input from the user and finds the 

#include <iostream>
#include <fstream>


using namespace std;



int main()
{
	ifstream Payinfile;
	ofstream Payoutfile;

	//Assigning variables
	char cat1;
	char cat2;
	char cat3;

	double pay1;
	double pay2;
	double pay3;

	int num1;
	int num2;
	int num3;


	
	Payinfile.open("input.txt");
	//Creating files for Payout
	Payoutfile.open("Payoutfile.txt");

	Payinfile >> cat1 >> pay1 >> num1
		>> cat2 >> pay2 >> num2
		>> cat3 >> pay3 >> num3;

	int avgemp = (num1 + num2 + num3) / 3;
	int totEmp = (num1 + num2 + num3);


	//Calculating the average of each category
	Payoutfile << "The average pay for category X is " << pay1 / num1 << endl
		<< "The average pay for category Y is " << pay2 / num2 << endl
		<< "The average pay for category Z is " << pay3 / num3 << endl
		<< "The average number of employees is " << avgemp << endl
		<< "The average pay for all employees is " << (pay1 + pay2 + pay3) / totEmp;

	return 0;
}

