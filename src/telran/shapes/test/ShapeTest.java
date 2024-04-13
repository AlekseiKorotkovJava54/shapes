package telran.shapes.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.shapes.*;

class ShapeTest { 

	Rectangle  rectangle1 = new Rectangle(1,5,20);
	Rectangle rectangle2 = new Rectangle(2,20,10);
	Square square1 = new Square(3,5,15);
	Square square2 = new Square(4,10,10);
	Canvas canvas1 = new Canvas(5, new Shape [] {rectangle1,square1});
	Canvas canvas2 = new Canvas(6, new Shape [] {rectangle2,square2});
	Canvas canvas3 = new Canvas(7, new Shape [] {rectangle1,square1,canvas2});
	
	@Test
	void addShapeTest() {
		Shape [] expected = new Shape [] {rectangle1,square1,rectangle2};
		canvas1.addShape(rectangle2);
		assertArrayEquals(expected,canvas1.shapes);
	}
	@Test
	void removeShape() {
		Shape [] expected = new Shape [] {rectangle1};
		canvas1.removeShape(3);
		assertArrayEquals(expected,canvas1.shapes);
	}
	@Test
	void squareTest() {
		assertEquals(75, square1.square());
		assertEquals(100, rectangle1.square());
		assertEquals(175, canvas1.square());
		assertEquals(475, canvas3.square());
	}
	@Test
	void perimeterTest() {
		assertEquals(40, square1.perimeter());
		assertEquals(50, rectangle1.perimeter());
		assertEquals(90, canvas1.perimeter());
		assertEquals(190, canvas3.perimeter());
	}
}
