//Joshua McMahan
//CSCI 2843
//Assignment 3
//Assignment3.cpp
//Dont forget to add this later

#include <iostream>
#include "SavingsAccount.h"


using namespace std;

int main()
{
	SavingsAccount Saver1("Margaret Olsen", 2000.00);
	SavingsAccount Saver2("Debra Baxter");
	SavingsAccount Saver3;


	Saver1.calculateNewBalance();

	Saver2.setBalance(5000.0);
	Saver2.calculateNewBalance();

	Saver3.setName("Arturo Ortiz");
	Saver3.setBalance(10000);
	Saver3.calculateNewBalance();

	Saver1.display();
	Saver2.display();
	Saver3.display();

	SavingsAccount::setInterestRate(10.0);

	Saver1.calculateNewBalance();
	Saver2.calculateNewBalance();
	Saver3.calculateNewBalance();

	Saver1.display();
	Saver2.display();
	Saver3.display();

	return 0;
}