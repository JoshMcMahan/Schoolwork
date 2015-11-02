//Josh McMahan
//C Programming
//Chapter 9 assignment 9
//Assignment9.cpp
//This program computes the area, circumference, and volume of various shapes 

#include <iostream>
#include <cmath>
#include <fstream>


using namespace std;

const double pi = 3.1416;

int Getinput();
double areaofSquare(double side);
double areaofRectangle(double length, double width);
double hypotenuseofRightTriangle(double side1, double side2);
double areaofRightTriangle(double side1, double side2);
double areaofIsoscelesTriangle(double height, double base);
double circumferenceofCircle(double radius);
double areaofCircle(double radius);
double volumeofSphere(double radius);

int main()
{
	ofstream answers;
	answers.open("Assignment9Answers.txt");

	int option = 0;
	double side, length, width, side1, side2, height, base, radius;

	do
	{
		option = Getinput();

		if (option == 1)
		{
			cout << "Enter the length of the side: ";
			cin >> side;
			cout << "The area of the square is: " << areaofSquare(side) << endl << endl;
			answers << "The area of the square is: " << areaofSquare(side) << endl << endl;
		}
		else if (option == 2)
		{
			cout << "Enter the length then the width: " << endl;
			cout << "Enter the length: ";
			cin >> length;
			cout << "Enter the width: ";
			cin	>> width;
			cout << "The are of the rectangle is: " << areaofRectangle(length, width) << endl << endl;
			answers << "The are of the rectangle is: " << areaofRectangle(length, width) << endl << endl;
		}
		else if (option == 3)
		{
			cout << "Enter side 1 then side 2: " << endl;
			cout << "Enter the first side: ";
			cin >> side1;
			cout << "Enter the second side: ";
			cin >> side2;
			cout << "The hypotenuse of the right triangle is: " << hypotenuseofRightTriangle(side1, side2) << endl << endl;
			answers << "The hypotenuse of the right triangle is: " << hypotenuseofRightTriangle(side1, side2) << endl << endl;
		}
		else if (option == 4)
		{
			cout << "Enter side 1 then side 2: " << endl;
			cout << "Enter the first side: ";
			cin >> side1;
			cout << "Enter the second side: ";
			cin >> side2;
			cout << "The area of the right triangle is: " << areaofRightTriangle(side1, side2) << endl << endl;
			answers << "The area of the right triangle is: " << areaofRightTriangle(side1, side2) << endl << endl;
		}
		else if (option == 5)
		{
			cout << "Enter the height then the base: " << endl;
			cout << "Enter the height: ";
			cin >> height;
			cout << "Enter the base: ";
			cin >> base;
			cout << "The area of the isosceles triange is: " << areaofIsoscelesTriangle(height, base) << endl << endl;
			answers << "The area of the isosceles triange is: " << areaofIsoscelesTriangle(height, base) << endl << endl;
		}
		else if (option == 6)
		{
			cout << "Enter the  radius: ";
			cin >> radius;
			cout << "The circumfrence of the circle is: " << circumferenceofCircle(radius) << endl << endl;
			answers << "The circumfrence of the circle is: " << circumferenceofCircle(radius) << endl << endl;
		}
		else if (option == 7)
		{
			cout << "Enter the radius: ";
			cin >> radius;
			cout << "The area of the circle is: " << areaofCircle(radius) << endl << endl;
			answers << "The area of the circle is: " << areaofCircle(radius) << endl << endl;
		}
		else if (option == 8)
		{
			cout << "Enter the radius: ";
			cin >> radius;
			cout << "The volume of the sphere is: " << volumeofSphere << endl << endl;
			answers << "The volume of the sphere is: " << volumeofSphere << endl << endl;
		}
	}
	while (option != 99);
	return 0;
}

int Getinput()
{
	int option;
	cout << " PLEASE SELECT ONE OF THE FOLLOWING OPTIONS: " << endl;
	cout << "  1  Area of a square " << endl;
	cout << "  2  Area of a rectangle " << endl;
	cout << "  3  Hypotenuse of a right triangle " << endl;
	cout << "  4  Area of a right triangle " << endl;
	cout << "  5  Area of a isoscelese triangle " << endl;
	cout << "  6  Circumfrense of a circle " << endl;
	cout << "  7  Area of a circle " << endl;
	cout << "  8  Volume of a sphere " << endl;
	cout << " To exit the program enter 99 " << endl;
	cin >> option;
	return option;
}
double areaofSquare(double side)
{
	return side * side;
}

double areaofRectangle(double length, double width)
{
	return length * width;
}

double hypotenuseofRightTriangle(double side1, double side2)
{
	return sqrt (side1 * side1 + side2 *side2);
}

double areaofRightTriangle(double side1, double side2)
{
	return (side1 * side2) / 2;
}

double areaofIsoscelesTriangle(double height, double base)
{
	return (height * base) / 2;
}

double circumferenceofCircle(double radius)
{
	return (2 * radius) * pi;
}

double areaofCircle(double radius)
{
	return (radius * radius) * pi;
}

double volumeofSphere(double radius)
{
	return (4.0 / 3.0) * pi * (radius * radius * radius);
}