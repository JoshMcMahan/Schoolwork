#ifndef SavingsAccount_h
#define SavingsAccount_h
#include <string>

using namespace std;

class SavingsAccount {
public:
	SavingsAccount();
	SavingsAccount(string name);
	SavingsAccount(string name, double beginningBalance);
	~SavingsAccount();

	void setName(string name);
	string getName() const;
	void setBalance(double);
	double getBalance() const;
	void static setInterestRate(double);
	static double getInterestRate();
	double getNumber() const;
	void display();
	void calculateNewBalance();



private:
	string firstName;
	string lastName;
	double savingBalance;
	int objectnum;
	static double annualinterestRate;
	double monthlyRate;
	const int objectnumber;
	static int objectID;


};

#endif