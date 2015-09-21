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
	char cat1, cat2, cat3;

	double pay1 = 19312.34;
	double pay2 = 26825.12;
	double pay3 = 28562.40;

	int num1 = 34;
	int num2 = 56;
	int num3 = 80;

	int avrgemp = (num1 + num2 + num3) / 3;
	int avrgemp2 = (num1 + num2 + num3);

	//Creating files for Payin and Payout
	Payinfile.open("Payinfile.txt");
	Payoutfile.open("Payoutfile.txt");

	Payinfile >> cat1, pay1, num1
		>> cat2, pay2, num2
		>> cat3, pay3, num3;
	//Calculating the average of each category
	Payoutfile << "The average pay for category X is " << pay1 / num1 << endl
		<< "The average pay for category Y is " << pay2 / num2 << endl
		<< "The average pay for category Z is " << pay3 / num3 << endl
		<< "The average number of employees is " << avrgemp << endl
		<< "The average pay for all employees is " << (pay1 + pay2 + pay3) / avrgemp2;
	
	return 0;
}

