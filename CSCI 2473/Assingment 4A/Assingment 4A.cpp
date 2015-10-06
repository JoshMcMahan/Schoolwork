//Josh McMahan
//C Programming
//Chapter 4 assignment 4A
//Assignment4A.cpp
//A program that takes input from the user and finds the 

#include <iostream>
#include <cmath>


using namespace std;

//declares variables for A, B, C,
double A;
double B;
double C;

int main()
{

	//Ask the user for input to be used in the quadratic equation
	cout << "Enter a value for A: ";
	cin >> A;
	cout << "Enter a value for B: ";
	cin >> B;
	cout << "Enter a value for C: ";
	cin >> C;

	//declares variables for quad, quad2
	double quad = (-B + sqrt(B * B - 4 * A * C)) / (2 * A);
	double quad2 = (-B - sqrt(B * B - 4 * A * C)) / (2 * A);

	//outputs the answer 
	cout << "x1 = " << quad << endl;
	cout << "x2 = " << quad2 << endl;



	return 0;



}