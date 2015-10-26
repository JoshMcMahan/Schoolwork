//Josh McMahan
//C Programming
//Chapter 8 assignment 8B
//Assignment8B.cpp
//A program used by an insurance agent to check if the user is avaliable for a loan

#include <iomanip>
#include <iostream>


using namespace std;

void Getinput(int& Loantype, double& Income, double& Totaldebt, double& Loanamount);
void Autoloan(double& Income, double& Totaldebt, double& Loanamount, bool& Eligible);
void Mortgageloan(double& Income, double& Totaldebt, double& Loanamount, bool& Eligible);
void Printreport(double& Loanamount, int Loantype, bool& Eligible);

int main()
{
	bool Eligible;
	int Loantype;
	double Income;
	double Loanamount;
	double Totaldebt;

	
	do
	{
		Getinput(Loantype, Income, Totaldebt, Loanamount);


		if (Loantype == 1);
		Autoloan(Income, Totaldebt, Loanamount, Eligible);
		if (Loantype == 2)
			Mortgageloan(Income, Totaldebt, Loanamount, Eligible);
		if (Loantype == 1 || Loantype == 2)
			Printreport(Loanamount, Loantype, Eligible);

	} while (Loantype != 3);
	return 0;
}


void Getinput(int& Loantype, double& Income, double& Totaldebt, double& Loanamount)
{
	cout << "SELECT ONE OF THE FOLLWOING OPTION: " << endl << endl;
	cout << "	1	AUTO LOAN " << endl;
	cout << "	2	HOME MORTGAGE LOAN " << endl;
	cout << "	3	STOP PROGRAM " << endl << endl;

	cout << " ENTER A NUMBER ";
	cin >> Loantype;
	if (Loantype == 1 || Loantype == 2)
	{
		cout << "ENTER INCOME, TOTAL DEBT AND LOAN AMOUNT" << endl;
		cin >> Income >> Totaldebt >> Loanamount;
	}
}

void Autoloan(double& Income, double& Totaldebt, double& Loanamount, bool& Eligible)
{
	if ((Income - Totaldebt) >= .5 * Loanamount)
		Eligible = true;
	else
		Eligible = false;
}

void Mortgageloan(double& Income, double& Totaldebt, double& Loanamount, bool& Eligible)
{
	if ((Income - Totaldebt) >= .3 * Loanamount)
		Eligible = true;
	else
		Eligible = false;
}

void Printreport(double& Loanamount, int Loantype, bool& Eligible)
{
	cout << "Loan Type: ";
	if (Loantype == 1)
		cout << "Auto " << endl;
	if (Loantype ==2)
		cout << "Mortgage " << endl;
	cout << "Loan Amount: " << Loanamount << endl;

	cout << "Eligibl: ";
	if (Eligible)
		cout << " YES "<< endl;
	else cout << " NO" << endl;
	
}