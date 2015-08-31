//Josh McMahan
//C Programming
//Chapter 2 assignment 2B
//Assignment2B.cpp
//A program that displays my business cards

#include <iostream>
#include <string>

using namespace std;

//Business card information
const string Name = "Joshua McMahan";
const string Address = "10300 E 81st St, Tulsa, OK 74133";
const string Telephone = "(918) 867-5309";
const string Company = "Pain in the Glass";
const string WorkEmail = "jmcmahan@painintheglass.com";

//Creates two evenly spaced coloums
const string Me = Name + "\t\t\t\t" + Name;
const string Street = Address + '\t' + Address;
const string Number = Telephone + "\t\t\t\t" + Telephone;
const string Work = Company + "\t\t\t" + Company;
const string Email = WorkEmail + "\t\t" + WorkEmail;

int main()
{

	cout << Me << endl;
	cout << Work << endl;
	cout << Number << endl;
	cout << Email << endl; 
	cout << Street << endl << endl; //Adds a space between each business card

	cout << Me << endl;
	cout << Work << endl;
	cout << Number << endl;
	cout << Email << endl;
	cout << Street << endl << endl;

	
	cout << Me << endl;
	cout << Work << endl;
	cout << Number << endl;
	cout << Email << endl;
	cout << Street << endl << endl;

	cout << Me << endl;
	cout << Work << endl;
	cout << Number << endl;
	cout << Email << endl;
	cout << Street << endl << endl;


	return 0;

}