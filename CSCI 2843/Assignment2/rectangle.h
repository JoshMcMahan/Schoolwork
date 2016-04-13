#ifndef rectangle_h
#define rectangle_h

class rectangle {
public:
	rectangle();
	rectangle(double L);
	rectangle(double L, double W);
	~rectangle();

	double getPerimeter() const;
	double getArea() const;
	void setLength(double L);
	void setWidth(double W);
	double getLength() const;
	double getWidth() const;
	bool isSquare();
	void errorMsg();

private:
	double length;
	double width;

};

#endif
