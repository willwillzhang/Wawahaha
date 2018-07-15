package com.designpattern;

/**
 * 
 * The Bridge pattern is a composite of the Template and Strategy patterns.
 * 
 * The bridge pattern is a design pattern used in software engineering which is meant to "decouple an abstraction from its implementation 
 * so that the two can vary independently". The bridge uses encapsulation, aggregation, and can use inheritance to separate responsibilities into different classes.
 * The class itself can be thought of as the abstraction and what the class can do as the implementation. 
 * The bridge pattern can also be thought of as two layers of abstraction.
 * 
 * Bridge vs Adapter
 * However, the intent of the Adapter pattern is to make one or more classes' interfaces look the same as that of a particular class. 
 * The Bridge pattern is designed to separate a class's interface from its implementation so you can vary or replace the implementation without changing the client code.
 * 
 */

//strategy pattern, decouple an abstraction from its implementation
/** "Implementor" */
interface DrawingAPI {
	public void drawCircle(double x, double y, double radius);
}

/** "ConcreteImplementor" 1/2 */
class DrawingAPI1 implements DrawingAPI {
	public void drawCircle(double x, double y, double radius) {
		System.out.printf("API1.circle at %f:%f radius %f\n", x, y, radius);
	}
}

/** "ConcreteImplementor" 2/2 */
class DrawingAPI2 implements DrawingAPI {
	public void drawCircle(double x, double y, double radius) {
		System.out.printf("API2.circle at %f:%f radius %f\n", x, y, radius);
	}
}

//template pattern
/** "Abstraction" */
abstract class Shape {
	protected DrawingAPI drawingAPI;

	protected Shape(DrawingAPI drawingAPI) {
		this.drawingAPI = drawingAPI;
	}

	public abstract void draw(); // low-level

	public abstract void resizeByPercentage(double pct); // high-level
}

/** "Refined Abstraction" */       
class CircleShape extends Shape {
	private double x, y, radius;

	public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
		super(drawingAPI);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	// low-level i.e. Implementation specific
	public void draw() {
		drawingAPI.drawCircle(x, y, radius);
	}

	// high-level i.e. Abstraction specific
	public void resizeByPercentage(double pct) {
		radius *= (1.0 + pct / 100.0);
	}
}

/** "Client" */
public class BridgePattern {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[] { new CircleShape(1, 2, 3, new DrawingAPI1()),
				new CircleShape(5, 7, 11, new DrawingAPI2()) };

		for (Shape shape : shapes) {
			shape.resizeByPercentage(2.5);
			shape.draw();
		}
	}
}