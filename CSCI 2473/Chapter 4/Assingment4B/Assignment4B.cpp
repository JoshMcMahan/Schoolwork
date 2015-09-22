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

	int numEmp1;
	int numEmp2;
	int numEmp3;


	
	Payinfile.open("input.txt");
	//Creating files for Payout
	Payoutfile.open("Payoutfile.txt");

	Payinfile >> cat1 >> pay1 >> numEmp1
		>> cat2 >> pay2 >> numEmp2
		>> cat3 >> pay3 >> numEmp3;

	int avgemp = (numEmp1 + numEmp2 + numEmp3) / 3;
	int totEmp = (numEmp1 + numEmp2 + numEmp3);


	//Calculating the average of each category
	Payoutfile << "The average pay for category " cat1 "is " << pay1 / numEmp1 << endl
		<< "The average pay for category " cat2 "is " << pay2 / numEmp2 << endl
		<< "The average pay for category " cat3 "is " << pay3 / numEmp3 << endl
		<< "The average number of employees is " << avgemp << endl
		<< "The average pay for all employees is " << (pay1 + pay2 + pay3) / totEmp;

	return 0;
}

