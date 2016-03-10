#include "rectangle.h"
#include <iostream>
#include <cmath>

using namespace std;

rectangle::rectangle()
{
	length = 1.0;
	width = 1.0;
}
rectangle::rectangle(double L)
{
	width = 1.0;
	if (L < 0.0 || L > 20.0)
	{
		length = 1.0;
		errorMsg();
	}
	else
		length = L;
}
rectangle::rectangle(double L, double W)
{
	if (L < 0.0 || L > 20.0)
		length = 1.0;
	else
		length = L;
	return;

	if (width < 0.0 || width > 20.0)
		width = 1.0;
	else
	{
		width = W;
		errorMsg();
	}
	return;
}
rectangle::~rectangle()
{
	cout << " The object has gone out of scope" << endl;
}

double rectangle::getPerimeter() const
{
	return ((2 * length) + (2 * width));
}

double rectangle::getArea() const
{
	return length * width;
}

void rectangle::setLength(double L)
{
	if (length > 0.0 & length <= 20.0)
	{

	}
	else
		length = 1.0;
}

void rectangle::setWidth(double W)
{
	if (width > 0.0 & width <= 20.0)
	{

	}
	else
		width = 1.0;
}

double rectangle::getLength() const
{
	return length;
}

double rectangle::getWidth() const
{
	return width;
}

bool rectangle::isSquare()
{
	return length - width < .0001;
}

void rectangle::errorMsg()
{
	cout << "Error: an attempt has been made to create an object with invalid parameters!" << endl;
}
