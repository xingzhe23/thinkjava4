package com.think4;

//test overlap function 

class Shape1 {
	int size() {
		System.out.println("Shape.size");
		return 0;
	}
	
	int nameId() {
		System.out.println("Shape.nameId");
		return 0;
	}
}

class Rectangle extends Shape1 {
	int size() {
		System.out.println("Rectangle.size");
		return 1;
	}
	
	double nameId(int i) {
		System.out.println("Rectangle.nameId");
		return 1.0;
	}
}

class Circle extends Shape1 {
	int size() {
		System.out.println("circle.size");
		return 2;
	}
	
	void nameId(int i) {
		System.out.println("Circle.nameId");
		return;
	}
}

class OverlapFunc {
	static void main(String[] args) {
		
		System.out.println("^^^begin Overlap function");
		
		Shape1 rect = new Rectangle();
		Shape1 cir = new Circle();
		Shape1 absShape = new Shape1();	
		rect.size();
		cir.size();
		absShape.size();
		System.out.println("___end overlap function");
	}
}

class OverrideFunc {
	static void main(String[] args) {
		System.out.println("^^^begin Override function");
		Shape1 rect = new Rectangle();
		Shape1 cir = new Circle();
		Shape1 absShape = new Shape1();	
		rect.nameId();
		cir.nameId();
		absShape.nameId();
		
		//Todo: don't support downcast???
		//Rectangle subRect = rect;
		
		Rectangle subRect = new Rectangle();
		subRect.nameId();
		subRect.nameId(1);
		
		
		//Todo: super class handle cann't see the method defined in derived class, 
		//even super class handle point to derived class object.
		//rect.nameId(1);
		//cir.nameId(1);
		
		System.out.println("___end Override function");
	}
}

//abstract class, method
//abstract class Shape2 {
abstract class Shape2 {
	
	//abstract methonds does not specify body.
	//abstract int size() {
		//System.out.println("Shape2.size");
		//return 0;
	//}
	int size;
	abstract int size();
	
	int nameId() {
		System.out.println("Shape2.nameId");
		return 0;
	}
}

abstract class AbstractShape extends Shape2 {
	
	int nameId() {
		System.out.println("Shape2.nameId");
		return 0;
	}
}

class Rectangle2 extends Shape2 {
	int size() {
		System.out.println("Rectangle.size");
		return 0;
	}
	
	int nameId() {
		System.out.println("Shape2.nameId");
		return 0;
	}
}

class Cricle2 extends Shape2 {
	int size() {
		System.out.println("Cricle2.size");
		return 0;
	}
	
	int nameId() {
		System.out.println("Cricle2.nameId");
		return 0;
	}
}

class AbstraceTest {
	static void main(String[] args) {
		System.out.println("^^^begin Abstrac test");
		
		//Shape2 is abstract, cann't create an instance.
		//Shape2 base = new Shape2();		
		Shape2 base = new Rectangle2();
		base.size();
		
		System.out.println("___end Abstrac test");
	}
}

class InterMember {
	static int i = 0;
	InterMember() {
		i++;
		System.out.println("InterMember^^^");
	}
	
	int getSize() {
		System.out.println("InterMember i=" + i);
		return i;
	}
}

interface Shape3 {
	//Todo: should initialize data member here.
	//final int size
	//int size
	final int size=1;
	static int width=2;
	InterMember m = new InterMember();
	int size();
	int width();
	int whatis();
}

interface Shape3Int extends Shape3 {
	int height();
}

class Rectangle3 implements Shape3Int {
	public int width() { return width; }
	public int whatis() { return 1; }
	public int size() { return 1; }
	public int height() { return 1;}
}

class Rectangel3_1 extends Rectangle3 implements Shape3Int {
	static  void main(String[] args) {
		System.out.println("^^^begin Rectangel3_1 test");
		Rectangel3_1 rect = new Rectangel3_1();
		rect.size();
		rect.m.getSize();
		
		Rectangle3 rect3 = new Rectangle3();
		rect3.m.getSize();
		System.out.println("___end Rectangel3_1 test");
	}
}

//Constructor
class Shape4 {
	Shape4() {
		System.out.println("Shap4.Shap4()");
	}
	Shape4(int i) {
		System.out.println("Shape4.Shape4(int)");
	}
}

public class Polymorphy {
	public static void main() {
			//overlap function test
		OverlapFunc.main(null);
		OverrideFunc.main(null);
		
		//abstract test
		AbstraceTest.main(null);
		Rectangel3_1.main(null);
	}
}
