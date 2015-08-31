//Josh McMahan
//C Programming
//Chapter 2 assignment 2A
//Assignment2A.cpp
//A program that displays my school schedule

#include <iostream>
#include <string>

using namespace std;

// My courses for fall semester
const string math = "College Algebra ";
const string geol = "General Geology ";
const string japn = "Japanese I ";
const string c = "C Language ";
const string lab = "Geology Lab ";

// CS = times my classes start while ce = the time my classes end
const string cs1 = "3:30 - ";
const string cs2 = "4:00 - ";
const string cs3 = "5:30 - ";
const string cs4 = "6:00 - ";
const string cs5 = "7:00 - ";

const string ce1 = "4:50 pm ";
const string ce2 = "5:20 pm ";
const string ce3 = "6:50 pm ";
const string ce4 = "8:50 pm ";
const string ce5 = "9:50 pm ";

//These are the days of the week
const string mon = "Monday ";
const string tue = "Tuesday ";
const string wed = "Wednesday ";
const string thur = "Thursday ";
const string fri = "Friday ";


int main()
{	
	string mathLine = math + cs2 + ce2;
	string thurFull = japn + cs1 + ce1;
	string geolLine = geol + cs3 + ce3;

	cout << mon << endl; 
	cout << '\t' << mathLine << endl << '\t' << c + cs4 + ce4 << endl;
	cout << tue << endl;
	cout << '\t' << japn + cs1 + ce1 << endl << '\t' << geolLine << endl;
	cout << wed << endl;
	cout << '\t' << mathLine << endl;
	cout << thur << endl;
	cout << '\t' << thurFull << endl << '\t' << geolLine << '\t' << endl;
	cout << '\t' << lab + cs5 + ce5 << endl;
	cout << fri << endl
		<< '\t' << "Homework time!" << endl;
	return 0;

}