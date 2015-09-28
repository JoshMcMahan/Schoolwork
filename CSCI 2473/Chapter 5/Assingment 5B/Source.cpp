//Josh McMahan
//C Programming
//Chapter 5 assignment 5B
//Assignment5B.cpp
//A program that finds the median of three numbers inputed by the user

#include <iostream>


using namespace std;

int main()
{
	double userNum1, userNum2, userNum3, median; //variables waiting to be assinged by the user

	cout << "If you enter three numbers I can tell you the median. ";
	cout << "Enther your first number. " << endl;
	cin >> userNum1; // assining the users input to the three variables
	cout << "enter your second number. " << endl;
	cin >> userNum2;
	cout << "Enter your thrid number. " << endl;
	cin >> userNum3;

	if ((userNum1 >= userNum2 && userNum1 <= userNum3) || (userNum1 >= userNum3 && userNum1 <= userNum2)) //Checks to see if userNum1 is the median
		median = userNum1;
	else if ((userNum2 >= userNum1 && userNum2 <= userNum3) || (userNum2 >= userNum3 && userNum2 <= userNum1))//Checks to see if userNum2 is the median
		median = userNum2;
	else median = userNum3; //All other statments were false and assings userNum3 to median

	cout << "The median of your three numbers is " << median << "." << endl;

	return 0;
}

