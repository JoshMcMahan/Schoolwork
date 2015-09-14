//Josh McMahan
//C Programming
//Chapter 3 assignment 3A
//Assignment3A.cpp
//A program that displays the volume of 3 cones

#include <iostream>
#include <iomanip>

using namespace std;

//setting pi to 3.1416
const double pi = 3.1416;

//Cones radius and height
const double first_radius = 10.10;
const double second_radius = 40.20;
const double third_radius = 80.30;

const double first_height = 20.10;
const double second_height = 60.20;
const double third_height = 90.30;

//setting half for volume formula
const double half = 1.0 / 3.0;

//formula for getting the volume is 1/3*pi*radius^2*height


int main()
{
	cout << fixed << showpoint << setprecision(2);
	// sets columes for radius height and volume
	cout << setw(15) << "Radius" << setw(9) << "Height" << setw(12) << "Volume" << endl;

	//Calcualtes the volume of each cone and displays the output in a organized fashion 
	cout << "Cone 1" << setw(11) << "10.10" << setw(10) << "20.10" << setw(13) << half * pi * first_radius * first_radius * first_height << endl;
	cout << "Cone 2" << setw(11) << "40.20" << setw(10) << "60.20" << setw(13) << half * pi * second_radius * second_radius * second_height << endl;
	cout << "Cone 3" << setw(11) << "80.30" << setw(10) << "90.30" << setw(13) << half * pi * third_radius  * third_radius  * third_height << endl;




	return 0;
}
