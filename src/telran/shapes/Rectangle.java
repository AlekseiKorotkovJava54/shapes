package telran.shapes;

public class Rectangle extends Shape {
	public int width;
	public int height;

	public Rectangle(long id, int width, int height) {
		super(id);
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public int square() {
		return width*height;
	}

	@Override
	public int perimeter() {
		return (width+height)*2;
	}

}
