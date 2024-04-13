package telran.shapes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Canvas extends Shape implements Iterable<Shape>{
	public Shape [] shapes;

	public Canvas(long id, Shape[] shapes) {
		super(id);
		this.shapes = shapes;
	}
	
	public void addShape(Shape shape) {
		Shape [] tempArray = Arrays.copyOf(shapes, shapes.length+1);
		tempArray[shapes.length] = shape;
		shapes=Arrays.copyOf(tempArray,tempArray.length);
	}
	
	public void removeShape(long id) {
		Shape [] tempArray = new Shape [shapes.length-1];
		int index = 0;
		for(int i=0; i<shapes.length-1; i++){
			if(id != shapes[i].id) tempArray[index++] = shapes[i];
		}
		shapes=Arrays.copyOf(tempArray,tempArray.length);
	}

	@Override
	public int square() {
		int res=0;
		for(Shape shape : shapes) {
			res += shape.square();
		}
		return res;
	}

	@Override
	public int perimeter() {
		int res=0;
		for(Shape shape : shapes) {
			res += shape.perimeter();
		}
		return res;
	}

	@Override
	public Iterator<Shape> iterator() {
		return new ShapeIterator();
	}

private class ShapeIterator implements Iterator<Shape> {
    int currentIndex = 0;
	
	@Override
	public boolean hasNext() {
		return currentIndex <= shapes.length-1;
	}

	@Override
	public Shape next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		return shapes[currentIndex++];
	}
}
}