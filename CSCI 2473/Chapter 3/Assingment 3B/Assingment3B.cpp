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
	cout << fixed << showpoint << setprecision(2);
	cout << setw(6) << "Payment # " << setw(22) << "Remaning balance" << endl;

	//outputs the balance after each months payment
	cout << setw(11) << "First payment" << setw(15) << baIN << setw(10) << endl;
	cout << setw(11) << "Second payment" << setw(14) << baIN2 << setw(10) << endl;
	cout << setw(11) << "Third payment" << setw(15) << baIN3 << setw(10) << endl;

	return 0;
}