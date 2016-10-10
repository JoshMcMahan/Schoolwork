#include "SavingsAccount.h"
#include <iostream>
#include <cmath>

using namespace std;

double SavingsAccount::annualinterestRate = 0.0;
int SavingsAccount::objectID = 1;

SavingsAccount::SavingsAccount() : objectnumber(objectID)
{
	firstName = " ";
	lastName = " ";
	savingBalance = 0.0;
	
}

SavingsAccount::SavingsAccount(string name) : objectnumber(objectID + 1)
{
	firstName = name;
	savingBalance = 0;
	
}

SavingsAccount::SavingsAccount(string name, double beginningBalance) : objectnumber(objectID + 2)
{
	firstName = name;
	savingBalance = beginningBalance;
	
}

SavingsAccount::~SavingsAccount()
{
	cout << endl << objectID << "no longer exist!" << endl;
}

void SavingsAccount::setName(string name)
{
	firstName = name;
}

string SavingsAccount::getName() const
{
	return firstName + lastName;
}

void SavingsAccount::setBalance(double balance)
{
	savingBalance = balance;
}

double SavingsAccount::getBalance() const
{
	return savingBalance;
}

void  SavingsAccount::setInterestRate(double rate)
{
	annualinterestRate = rate / 100.0;
}

double  SavingsAccount::getInterestRate()
{
	return annualinterestRate * 100.0;
}

double SavingsAccount::getNumber() const
{
	return objectnumber;
}



void SavingsAccount::calculateNewBalance()
{
	savingBalance = savingBalance + annualinterestRate / 12.0 * savingBalance;
}

void SavingsAccount::display()
{
	cout << "Name: " << getName();
	cout << endl << "Balance: " << getBalance() << endl;
	cout << "Account number " << getNumber() << endl << endl;

}