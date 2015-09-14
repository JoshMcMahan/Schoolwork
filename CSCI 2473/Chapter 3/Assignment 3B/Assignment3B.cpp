//Josh McMahan
//C Programming
//Chapter 3 assignment 3B
//Assignment3B.cpp
//A program that calculates the balance of a loan after the first, second, and third payment

#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

//intrest rate, length and monthly amount owed for the loan
const double monintrate = 0.0075;
const double payment = 165.25;
const double totnum = 36.0;

int month1 = 1;
int month2 = 2;
int month3 = 3;

//information on how to calulate the balance after each payment
double baIN = payment * (1 - pow(1 + monintrate, month1 - totnum)) / monintrate;
double baIN2 = payment * (1 - pow(1 + monintrate, month2 - totnum)) / monintrate;
double baIN3 = payment * (1 - pow(1 + monintrate, month3 - totnum)) / monintrate;




int main()
{	
	//outputs the balance after each months payment
	cout << "Your balance after your first payment will be $" << baIN << endl;
	cout << "Your balance after your second payment will be $"<< baIN2 << endl;
	cout << "Your balance after your third payment will be $" << baIN3 << endl;
	return 0;
}